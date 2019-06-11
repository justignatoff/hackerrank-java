package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class QueensAttack2 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        HashSet<Pair> obstaclesSet = new HashSet<>();
        for (int i = 0; i < k; i++) {
            obstaclesSet.add(new Pair(obstacles[i][0], obstacles[i][1]));
        }

        int res = 0;

        for (int i = c_q + 1; i <= n; i++) {
            if (obstaclesSet.contains(new Pair(r_q, i))) {
                break;
            }
            res++;
        }

        for (int i = c_q - 1; i > 0; i--) {
            if (obstaclesSet.contains(new Pair(r_q, i))) {
                break;
            }
            res++;
        }

        for (int i = r_q + 1; i <= n; i++) {
            if (obstaclesSet.contains(new Pair(i, c_q))) {
                break;
            }
            res++;
        }

        for (int i = r_q - 1; i > 0; i--) {
            if (obstaclesSet.contains(new Pair(i, c_q))) {
                break;
            }
            res++;
        }

        for (int i = 1; c_q + i <= n && r_q + i <= n; i++) {
            if (obstaclesSet.contains(new Pair(r_q + i, c_q + i))) {
                break;
            }
            res++;
        }

        for (int i = 1; r_q + i <= n && c_q - i > 0; i++) {
            if (obstaclesSet.contains(new Pair(r_q + i, c_q - i))) {
                break;
            }
            res++;
        }

        for (int i = 1; r_q - i > 0 && c_q + i <= n; i++) {
            if (obstaclesSet.contains(new Pair(r_q - i, c_q + i))) {
                break;
            }
            res++;
        }


        for (int i = 1; c_q - i > 0 && r_q - i > 0; i++) {
            if (obstaclesSet.contains(new Pair(r_q - i, c_q - i))) {
                break;
            }
            res++;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
