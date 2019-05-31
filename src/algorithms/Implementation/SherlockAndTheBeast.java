package algorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class SherlockAndTheBeast {
    // Complete the decentNumber function below.
    static void decentNumber(int n) {
        for (int i = n / 3; i >=0; i--) {
            int j = (n - i * 3) / 5;
            if (i * 3 + j * 5 == n) {
                for (int k = 0; k < i * 3; k++) {
                    System.out.print(5);
                }
                for (int k = 0; k < j * 5; k++) {
                    System.out.print(3);
                }
                System.out.println();
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
