package sec05.exam01_asynchronous_filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousFileChannelReadExample {
    public static void main(String[] args) throws IOException {
        // Thread Pool Create
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );

        for (int i=0; i<10; i++) {
            Path path = Paths.get("Temp/file" + i + ".txt");

            // Asynchronous FileChannel Create
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                path,
                EnumSet.of(StandardOpenOption.READ),
                executorService
            );

            // ByteBuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());

            // Attachment Object Create
            class Attachment {
                Path path;
                AsynchronousFileChannel fileChannel;
                ByteBuffer byteBuffer;
            }
            Attachment attachment = new Attachment();
            attachment.path = path;
            attachment.fileChannel = fileChannel;
            attachment.byteBuffer = byteBuffer;

            // CompletionHandler Object Create
            CompletionHandler<Integer, Attachment> completionHandler = new CompletionHandler<>() {
                public void completed(Integer result, Attachment attachment) {
                    attachment.byteBuffer.flip();

                    Charset charset = Charset.defaultCharset();
                    String data = charset.decode(attachment.byteBuffer).toString();

                    System.out.println(
                        attachment.path.getFileName() + " : " +
                        data + " : " + Thread.currentThread().getName()
                    );

                    try {
                        attachment.fileChannel.close();
                    } catch (IOException e) {}
                };
                public void failed(Throwable exc, Attachment attachment) {
                    exc.printStackTrace();
                    try {
                        attachment.fileChannel.close();
                    } catch (IOException e) {}
                };
            };

            // file read
            fileChannel.read(byteBuffer, 0, attachment, completionHandler);
        }

        // Thread Pool Shutdown
        executorService.shutdown();
    }
}
