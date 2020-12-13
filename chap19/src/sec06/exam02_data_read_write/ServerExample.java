package sec06.exam02_data_read_write;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerExample {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;

        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);
            serverSocketChannel.bind(new InetSocketAddress(5001));

            while (true) {
                System.out.println("[연결 기다림]");
                SocketChannel socketChannel = serverSocketChannel.accept(); // 연결 수락, 블로킹 되는 시점

                // 어떤 Client가 접속했는지 알아내기 위해 InetSocketAddress 받기
                InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
                System.out.println("[연결 수락함] " + isa.getHostName());

            // Client로부터 데이터 받기
                // C로부터 읽은 데이터를 저장할 버퍼, 문자셋 생성
                ByteBuffer byteBuffer = null;
                Charset charset = Charset.forName("UTF-8");

                // C->S Data Receive
                byteBuffer = ByteBuffer.allocate(100);
                int byteCount = socketChannel.read(byteBuffer); // SocketChannel로부터 데이터 일기
                byteBuffer.flip(); // 읽기 모드로 전환
                String message = charset.decode(byteBuffer).toString();
                System.out.println("[데이터 받기 성공] " + message);

            // Server에서 Client로 데이터 전송
                byteBuffer = charset.encode("Hello Client");
                socketChannel.write(byteBuffer);
                System.out.println("[데이터 보내기 성공]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 어차피 아래 코드는 실행되지 않으나, ServerSocketChannel을 닫아주기는 하자라는 의미에서 작성
        if (serverSocketChannel.isOpen()) {
            try {
                serverSocketChannel.close();
            } catch (IOException e) {}
        }
    }
}