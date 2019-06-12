package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {
    // Complete the encryption function below.
    static String encryption(String s) {
        int rowCount = (int) Math.sqrt(s.length());
        int rowLength = (int) Math.ceil(Math.sqrt(s.length()));
        if (rowCount * rowLength < s.length()) {
            rowCount++;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < rowCount && i + j * rowLength < s.length(); j++) {
                res.append(s.charAt(i + j * rowLength));
            }
            res.append(" ");
        }
        return res.toString().trim();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
