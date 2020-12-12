package sec05.exam01_asynchronous_filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousFileChannelWriteExample {
    public static void main(String[] args) throws IOException {
        // Thread Pool Create
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );

        for (int i=0; i<10; i++) {
            Path path = Paths.get("Temp/file" + i + ".txt");
            Files.createDirectories(path.getParent());

            // Asynchronous FileChannel Create
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                path,
                EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE),
                executorService
            );

            // ByteBuffer
            Charset charset = Charset.defaultCharset();
            ByteBuffer byteBuffer = charset.encode("안녕하세요");

            // Attachment Object Create
            class Attachment {
                Path path;
                AsynchronousFileChannel fileChannel;
            }

            Attachment attachment = new Attachment();
            attachment.path = path;
            attachment.fileChannel = fileChannel;

            // CompletionHandler Object Create
            CompletionHandler<Integer, Attachment> completionHandler = new CompletionHandler<>() {
                public void completed(Integer result, Attachment attachment) {
                    System.out.println(
                        attachment.path.getFileName() + " : " +
                        result + " bytes written : " +
                        Thread.currentThread().getName());
                    try {
                        attachment.fileChannel.close();
                    } catch (Exception e) {}
                };
                public void failed(Throwable exc, Attachment attachment) {
                    exc.printStackTrace();
                    try {
                        attachment.fileChannel.close();
                    } catch (Exception e) {}
                };
            };

            // write
            fileChannel.write(byteBuffer, 0, attachment, completionHandler);
        }

        // Thread Pool Close
        executorService.shutdown();
    }
}
