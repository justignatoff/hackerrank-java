package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pangrams {
    static String pangrams(String s) {
        String alphabet = "abcdefghijklmnopqstuvwxyz";
        s = s.toLowerCase();
        boolean flag = true;
        for (Character ch: alphabet.toCharArray()) {
            flag = flag && (s.contains(ch.toString()));
        }
        return flag ? "pangram" : "not pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
