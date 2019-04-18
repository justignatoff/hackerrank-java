package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FairRations {
    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        int res = 0;
        int pos = B.length - 1;
        while (pos > 0) {
            if (B[pos] % 2 == 1) {
                B[pos] = B[pos] + 1;
                B[pos - 1] = B[pos - 1] + 1;
                res += 2;
            }
            pos--;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int countOdd = 0;
        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
            if (BItem % 2 == 1) {
                countOdd++;
            }
        }

        if (countOdd % 2 == 1) {
            bufferedWriter.write("NO");
        } else {
            int result = fairRations(B);

            bufferedWriter.write(String.valueOf(result));
        }
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
