package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FunnyString {
    // Complete the funnyString function below.
    static String funnyString(String s) {
        List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            diffs.add(Math.abs(s.charAt(i) - s.charAt(i + 1)));
        }
        List<Integer> reverseDiffs = new ArrayList<>(diffs);
        Collections.reverse(reverseDiffs);
        return diffs.equals(reverseDiffs) ? "Funny" : "Not Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
