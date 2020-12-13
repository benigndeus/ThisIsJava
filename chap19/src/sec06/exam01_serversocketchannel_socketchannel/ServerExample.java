package sec06.exam01_serversocketchannel_socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

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