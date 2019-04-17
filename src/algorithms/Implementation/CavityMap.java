package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CavityMap {
    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid, int n) {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(grid[i].split("")).mapToInt(Integer::parseInt).toArray();
        }
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder raw = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == (n - 1) || j == 0 || j == (n - 1)) {
                    raw.append(map[i][j]);
                } else if (map[i - 1][j] < map[i][j] && map[i + 1][j] < map[i][j] && map[i][j - 1] < map[i][j] && map[i][j + 1] < map[i][j]) {
                    raw.append("X");
                } else {
                    raw.append(map[i][j]);
                }
            }
            res[i] = raw.toString();
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid, n);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
