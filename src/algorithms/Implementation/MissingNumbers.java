package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static List<Integer> missingNumbers(int[] arr, int[] brr) {
        HashMap<Integer, Integer> counts1 = new HashMap<>();
        HashMap<Integer, Integer> counts2 = new HashMap<>();
        for (int i : arr) {
            counts1.put(i, counts1.getOrDefault(i, 0) + 1);
        }

        for (int i : brr) {
            counts2.put(i, counts2.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : counts2.keySet()) {
            if (!counts2.get(i).equals(counts1.getOrDefault(i, 0))) {
                res.add(i);
            }
        }
        res.sort(Integer::compareTo);
        return res;
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        List<Integer> result = missingNumbers(arr, brr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
