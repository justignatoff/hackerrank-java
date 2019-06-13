package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BiggerIsGreater {
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        StringBuilder res = new StringBuilder(w);
        for (int i = res.length() - 1; i > 0; i--) {
            if (res.charAt(i) > res.charAt(i - 1)) {
                char temp = res.charAt(i - 1);
                char min = 'z';
                int minPos = i;
                for (int j = i; j < res.length(); j++) {
                    if (res.charAt(j) > temp && res.charAt(j) <= min) {
                        min = res.charAt(j);
                        minPos = j;
                    }
                }
                res.setCharAt(i - 1, min);
                res.setCharAt(minPos, temp);
                res = new StringBuilder(res.substring(0, i) +
                        res.substring(i).chars().sorted()
                                .mapToObj(ch -> String.valueOf((char)ch))
                                .reduce((a, b) -> a + b).get());
                break;
            }
        }
        return res.toString().equals(w) ? "no answer" : res.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
