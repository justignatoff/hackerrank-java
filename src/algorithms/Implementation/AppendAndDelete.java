package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendAndDelete {
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int pos = 0;
        while (pos < s.length() && pos < t.length() && s.charAt(pos) == t.charAt(pos)) {
            pos++;
        }
        return (s.length() + t.length() - pos * 2) == k ? "Yes" : "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
