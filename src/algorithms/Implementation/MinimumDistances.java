package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MinimumDistances {
    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> lastPos = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (lastPos.containsKey(a[i])) {
                res = Math.min(res, Math.abs(i - lastPos.get(a[i])));
            }
            lastPos.put(a[i], i);
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
