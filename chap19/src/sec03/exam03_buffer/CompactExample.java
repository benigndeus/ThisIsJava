package sec03.exam03_buffer;

import java.nio.ByteBuffer;

public class CompactExample {
    public static void main(String[] args) {
        System.out.println("[7바이트 크기로 버퍼 생성]");
        ByteBuffer buffer = ByteBuffer.allocateDirect(7);

        buffer.put((byte) 10);
        buffer.put((byte) 11);
        buffer.put((byte) 12);
        buffer.put((byte) 13);
        buffer.put((byte) 14);
        buffer.flip();
        printState(buffer);

        buffer.get(new byte[3]);
        System.out.println("[3바이트 읽음]");

        buffer.compact();
        System.out.println("[compact() 실행 후]");
        printState(buffer);
    }

    private static void printState(ByteBuffer buffer) {
        System.out.println("\t    data: " + buffer.get(0) + ", " + buffer.get(1) + ", " + buffer.get(2) + ", " + buffer.get(3) + ", " + buffer.get(4));
        System.out.println("\tposition: " + buffer.position());
        System.out.println("\t   limit: " + buffer.limit());
        System.out.println("\tcapacity: " + buffer.capacity());
    }
}
