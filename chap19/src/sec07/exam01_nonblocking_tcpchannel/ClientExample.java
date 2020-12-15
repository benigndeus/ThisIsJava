package sec07.exam01_nonblocking_tcpchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientExample extends Application {
    SocketChannel socketChannel;

    void startClient() {
        // Thread Create -> socketChannel이 connect()를 실행하는데 블로킹이 되고, Server에서 언제 데이터를 받을지 모르므로 Thread로 생성한다.
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    socketChannel = SocketChannel.open();
                    socketChannel.configureBlocking(true);
                    socketChannel.connect(new InetSocketAddress("localhost", 5001));

                    Platform.runLater(()->{
                        try {
                            displayText("[연결 완료 : " + socketChannel.getRemoteAddress() + "]"); // Server IP 출력
                            btnConn.setText("stop");
                            btnSend.setDisable(false);
                        } catch (Exception e) {}
                    });
                } catch (Exception e) {
                    Platform.runLater(()->displayText("[서버 통신 안 됨]"));
                    if (socketChannel.isOpen()) { stopClient(); }
                    return;
                }

                // 정상적으로 연결되었을 경우 Server에서 보낸 데이터를 받을 준비
                receive();
            }
        };

        thread.start();
    }

    void stopClient() {
        try {
            Platform.runLater(()->{
                displayText("[연결 끊음]");
                btnConn.setText("start");
                btnSend.setDisable(true);
            });

            if (socketChannel != null && socketChannel.isOpen()) {
                socketChannel.close();
            }
        } catch (Exception e) {}
    }

    void receive() {
        while (true) { // 서버에서 언제 데이터를 보낼지 모르기 때문에 무한루프 생성
            try {
                ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                // 서버가 비정상적으로 종료했을 경우 IOException 발생
                int readByteCount = socketChannel.read(byteBuffer); // Blocking! 데이터 읽기

                // 서버가 정상적으로 Socket의 close()를 호출했을 경우
                if (readByteCount == -1) {
                    throw new IOException();
                }

                // 받은 데이터 문자열로 변환
                byteBuffer.flip(); // 읽기 모드로 전환
                Charset charset = Charset.forName("UTF-8");
                String data = charset.decode(byteBuffer).toString();

                Platform.runLater(()->displayText("[받기 완료] " + data));
            } catch (Exception e) {
                Platform.runLater(()->displayText("[서버 통신 안 됨]"));
                stopClient();
                break; // Server와 통신이 안 되므로 무한루프 빠져나감
            }
        }
    }

    void send(String data) {
        // Thread Create -> socketChannel이 write()를 실행하는데 블로킹이 되고, Server에서 언제 데이터를 받을지 모르므로 Thread로 생성한다.
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Charset charset = Charset.forName("UTF-8");
                    ByteBuffer byteBuffer = charset.encode(data);
                    socketChannel.write(byteBuffer); // 서버로 데이터 전송

                    Platform.runLater(()->displayText("[보내기 완료]"));

                    /** Jiho plus **/
                    // 데이터를 썼으면 TextField를 비워주자
                    txtInput.clear();
                } catch (Exception e) {
                    Platform.runLater(()->displayText("[서버 통신 안 됨]"));
                    stopClient();
                }
            }
        };

        thread.start();
    }

    /****************
     * UI 생성 코드 */
    TextArea txtDisplay;
    TextField txtInput;
    Button btnConn, btnSend;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        txtDisplay = new TextArea();
        txtDisplay.setEditable(false);
        BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
        root.setCenter(txtDisplay);

        BorderPane bottom = new BorderPane();
            txtInput = new TextField();
            txtInput.setPrefSize(60, 30);
            BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));

            btnConn = new Button("start");
            btnConn.setPrefSize(60, 30);
            btnConn.setOnAction(e->{
                if (btnConn.getText().equals("start")) {
                    startClient();
                } else if (btnConn.getText().equals("stop")) {
                    stopClient();
                }
            });

            btnSend = new Button("send");
            btnSend.setPrefSize(60, 30);
            btnSend.setDisable(true);
            btnSend.setOnAction(e->send(txtInput.getText()));

            bottom.setCenter(txtInput);
            bottom.setLeft(btnConn);
            bottom.setRight(btnSend);
        root.setBottom(bottom);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Client");
        primaryStage.setOnCloseRequest(event->stopClient());
        primaryStage.show();
    }

    void displayText(String text) {
        txtDisplay.appendText(text + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}