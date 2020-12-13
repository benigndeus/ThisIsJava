package sec06.exam03_chatting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerExample extends Application {
    ExecutorService executorService;            // Thread Pool
    ServerSocketChannel serverSocketChannel;    // for Connect&Accept
    List<Client> connections = new Vector<>();  // Manage Client, Multi-Thread 환경에서 사용해야 하므로 Vector로 생성

    // Server Start
    void startServer() {
        // CPU Core의 수에 맞게 Thread를 생성해서 관리하는 ExecutorService(Thread-pool) 객체 생성
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
        // Server 열기: 블로킹 방식, 포트번호 5001
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);            // 블로킹 방식을 사용
            serverSocketChannel.bind(new InetSocketAddress(5001));
        } catch (Exception e) {
            if (serverSocketChannel.isOpen()) { stopServer(); }
            return;
        }

        // Task
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Platform.runLater(()->{ // fx Thread가 UI를 변경할 수 있도록 Platform으로 넘겨줌
                    displayText("[서버 시작]");
                    btnStartStop.setText("stop");   // 서버가 시작되었으므로 버튼의 글자를 start에서 stop으로 바꿈
                });

                // 서버가 시작되고부터 계속해서 다수의 Client의 연결을 수락해주어야 하므로 무한루프 생성
                while (true) {
                    try {
                        // 연결 수락
                        SocketChannel socketChannel = serverSocketChannel.accept(); // Client의 연결 요청을 수락
                        String message = "[연결 수락 : " + socketChannel.getRemoteAddress() + " : " + Thread.currentThread().getName() + "]";
                        Platform.runLater(()->displayText(message));

                        // Client 객체 저장
                        Client client = new Client(socketChannel);
                        connections.add(client);

                        Platform.runLater(()->displayText("[연결 개수 : " + connections.size() + "]"));
                    } catch (Exception e) {
                        if (serverSocketChannel.isOpen()) { stopServer(); }
                        break;
                    }
                }
            }
        };

        // Thread Pool에서 작업(runnable)을 처리
        executorService.submit(runnable);
    }

    // Server Close
    void stopServer() {
        try {
            // 1. 모든 Client(SocketChannel) 닫기
            Iterator<Client> iterator = connections.iterator();
            while (iterator.hasNext()) {
                Client client = iterator.next();
                client.socketChannel.close();
                iterator.remove();
            }

            // 2. Server(ServerSocketChannel) 닫기
            if (serverSocketChannel != null && serverSocketChannel.isOpen()) {
                serverSocketChannel.close();
            }

            // 3. Thread-pool(ExecutorService) 종료
            if (executorService != null && !executorService.isShutdown()) {
                executorService.shutdown();
            }

            // UI 처리
            Platform.runLater(()->{
                displayText("[서버 멈춤]");
                btnStartStop.setText("start");
            });
            
        } catch (Exception e) {}
    }

    // Server에서 사용하기 위한 Client 객체
    class Client {
        // 데이터 통신 코드
        SocketChannel socketChannel;

        Client(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
            receive();
        }

        // 데이터 받기 코드
        void receive() {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    while (true) {  // 지속적으로 Client의 데이터를 받아야 하므로 무한루프 생성
                        try {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                            // 클라이언트가 비정상 종료를 했을 경우 IOException 발생
                            int readByteCount = socketChannel.read(byteBuffer); // 데이터 받기

                            // 클라이언트가 정상적으로 SocketChannel의 close()를 호출했을 경우
                            if (readByteCount == -1) {
                                throw new IOException();
                            }

                            // UI 처리
                            String message = "[요청 처리 : " + socketChannel.getRemoteAddress() + " : " + Thread.currentThread().getName() + "]";
                            Platform.runLater(()->displayText(message));

                            // 받은 데이터를 문자열로 변환
                            byteBuffer.flip(); // 읽기 모드로 전환
                            Charset charset = Charset.forName("UTF-8");
                            String data = charset.decode(byteBuffer).toString();

                            // 변환된 문자열을 모든 클라이언트에게 보냄
                            for (Client client : connections) {
                                client.send(data);
                            }
                        } catch (Exception e) {
                            try {
                                connections.remove(Client.this); // 현재 this는 Runnable 객체를 가리키므로 명시적으로 Client.this로 해야 Client 객체가 지워진다.
                                String message = "[클라이언트 통신 안 됨 : " + socketChannel.getRemoteAddress() + " : " + Thread.currentThread().getName() + "]";
                                Platform.runLater(()->displayText(message));
                                socketChannel.close();
                            } catch (Exception e2) {}
                            break;  // 클라이언트가 통신이 안 되므로 무한루프를 빠져나감
                        }
                    }
                }
            };

            // Thread-pool에 작업(runnable)을 제출
            executorService.submit(runnable);
        }

        // 데이터 전송 코드
        void send(String data) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Charset charset = Charset.forName("UTF-8");
                        ByteBuffer byteBuffer = charset.encode(data);
                        socketChannel.write(byteBuffer);
                    } catch (Exception e) {
                        try {
                            String message = "[클라이언트 통신 안 됨 : " + socketChannel.getRemoteAddress() + " : " + Thread.currentThread().getName() + "]";
                            Platform.runLater(()->displayText(message));
                            connections.remove(Client.this);  // 현재 this는 Runnable 객체를 가리키므로 명시적으로 Client.this로 해야 Client 객체가 지워진다.
                            socketChannel.close();
                        } catch (Exception e2) {}
                    }
                }
            };

            // Thread-pool에 작업(runnable)을 제출
            executorService.submit(runnable);
        }
    }

    /** UI 생성코드 **/
    TextArea txtDisplay;
    Button btnStartStop;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        txtDisplay = new TextArea();
        txtDisplay.setEditable(false);
        BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
        root.setCenter(txtDisplay);

        btnStartStop = new Button("start");
        btnStartStop.setPrefHeight(30);
        btnStartStop.setMaxWidth(Double.MAX_VALUE);
        btnStartStop.setOnAction(e->{
            if (btnStartStop.getText().equals("start")) {
                startServer();
            } else if (btnStartStop.getText().equals("stop")) {
                stopServer();
            }
        });
        root.setBottom(btnStartStop);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Server");
        primaryStage.setOnCloseRequest(event->stopServer());
        primaryStage.show();
    }

    void displayText(String text) {
        txtDisplay.appendText(text + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
