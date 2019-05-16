package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindTheMedian {
    // Complete the findMedian function below.
    static int findMedian(int[] arr) {
        int[] count = new int[20001];
        for (int i : arr) {
            count[i + 10000] = count[i + 10000] + 1;
        }

        int[] res = new int[arr.length];
        int pos = 0;
        for (int i = 0; i < 20001; i++) {
            for (int j = 0; j < count[i]; j++) {
                res[pos] = i - 10000;
                pos++;
            }
        }
        return res[res.length / 2 + 1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
