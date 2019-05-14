package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {
    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
        int[] count = new int[2 * 10_000_000 + 1];
        for (int i : arr) {
            count[i + 10_000_000] = count[i + 10_000_000] + 1;
        }
        int[] sorted = new int[arr.length];
        int pos = 0;
        int minDiff = Integer.MAX_VALUE;
        int resCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                sorted[pos] = i - 10_000_000;
                if (pos != 0) {
                    if (minDiff == sorted[pos] - sorted[pos - 1]) {
                        resCount += 2;
                    } else if (minDiff > sorted[pos] - sorted[pos - 1]){
                        minDiff = sorted[pos] - sorted[pos - 1];
                        resCount = 2;
                    }
                }
                pos++;
            }
        }
        int[] res = new int[resCount];
        pos = 0;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] - sorted[i - 1] == minDiff) {
                res[pos] = sorted[i - 1];
                pos++;
                res[pos] = sorted[i];
                pos++;
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arrItems = scanner.nextLine().split(" ");
        int[] arr = new int[arrItems.length];
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrItems.length; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = closestNumbers(arr);
        System.out.println(Arrays.toString(result));

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
