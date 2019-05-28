package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {
    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {

        String[] sorted = Arrays.stream(grid)
                .map(s -> s.chars().sorted().mapToObj(ch -> String.valueOf((char) ch)).reduce((s1, s2) -> s1 + s2).get()).toArray(String[]::new);
        boolean res = true;
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted[i].length(); j++) {
                res = res && sorted[i].charAt(j) <= sorted[i + 1].charAt(j);
            }
        }
        return res ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
