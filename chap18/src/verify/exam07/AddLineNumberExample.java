package verify.exam07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddLineNumberExample {
    public static void main(String[] args) throws IOException {
        String filePath = "src/sec05/exam04_bufferedreader/BufferedReaderExample.java";

        // 작성 위치
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        int rowNumber = 0;
        String rowData;
        while ((rowData = br.readLine()) != null) {
            System.out.println(++rowNumber + ": " + rowData);
        }

        br.close(); fr.close();
    }
}
