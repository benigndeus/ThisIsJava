package sec04.exam02_file_copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopyExample {
    public static void main(String[] args) throws IOException {
        Path from = Paths.get("Temp/totoro.jpg");
        Path to = Paths.get("Temp/totoro-copy.jpg");

        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("파일 복사 성공");
    }
}
