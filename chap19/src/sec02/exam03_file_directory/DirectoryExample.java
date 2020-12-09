package sec02.exam03_file_directory;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryExample {
    public static void main(String[] args) throws Exception {
        Path path1 = Paths.get("Temp/subdir");
        Path path2 = Paths.get("Temp/file.txt");

        if (Files.notExists(path1)) {
            Files.createDirectories(path1);
         // Files.createDirectory(path1); -> path1에 있는 중간 경로가 존재하지 않을 경우 예외 발생
        }

        if (Files.notExists(path2)) {
            Files.createFile(path2);
        }

        Path path3 = Paths.get("Temp");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3); // "Temp" 하위 모든 경로를 받음
        for (Path path : directoryStream) {
            if (Files.isDirectory(path)) {
                System.out.println("[디렉토리] " + path.getFileName());
            } else {
                System.out.println("[파일] " + path.getFileName() + " (크기: " + Files.size(path) + ")");
            }
        }
    }
}
