package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CaesarCipher {
    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder res = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            if (alphabet.contains(ch.toString().toLowerCase())) {
                char elem = alphabet.charAt((alphabet.indexOf(ch.toString().toLowerCase()) + k) % 26);
                if (ch.toString().toUpperCase().equals(ch.toString())) {
                    elem = Character.toString(elem).toUpperCase().charAt(0);
                }
                res.append(elem);
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
