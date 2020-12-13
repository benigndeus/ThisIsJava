package sec06.exam02_data_read_write;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClientExample {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;

        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(true); // 블로킹 방식으로 통신
            System.out.println("[연결 요청]");
            socketChannel.connect(new InetSocketAddress("localhost", 5001)); // 연결될 때까지 블로킹되는 시점
            System.out.println("[연결 성공]");

            ByteBuffer byteBuffer = null;
            Charset charset = Charset.forName("UTF-8");

            // C->S Data Transport
            byteBuffer = charset.encode("Hello Server");
            socketChannel.write(byteBuffer);
            System.out.println("[데이터 보내기 성공]");

        // Server로부터 받은 데이터 처리
            byteBuffer = ByteBuffer.allocate(100);
            int byteCount = socketChannel.read(byteBuffer); // 데이터 받기
            byteBuffer.flip(); // 읽기 모드로 전환
            String message = charset.decode(byteBuffer).toString(); // 받은 데이터 문자열로 변환
            System.out.println("[데이터 받기 성공] " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (socketChannel.isOpen()) {
            try {
                socketChannel.close();
            } catch (IOException e) {}
        }
    }
}