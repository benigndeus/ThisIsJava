package sec03.exam01_direct_buffer;

import java.nio.ByteBuffer;

public class BufferSizeExample {
    public static void main(String[] args) {
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(200*1024*1024); // 200 MB
        System.out.println("다이렉트 버퍼가 생성되었습니다.");

        ByteBuffer nondirectBuffer = ByteBuffer.allocate(200*1024*1024); // 200 MB
        System.out.println("넌다이렉트 버퍼가 생성되었습니다."); // 생성되지 않을 수도 있음
    }
}
