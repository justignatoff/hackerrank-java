package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class BeautifulTriplets {
    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int elem : arr) {
            numCount.put(elem, numCount.getOrDefault(elem, 0) + 1);
        }
        int res = 0;
        for (int i = arr[0]; i <= arr[arr.length - 1] - 2 * d; i++) {
            res += (numCount.getOrDefault(i, 0)
                    * numCount.getOrDefault(i + d, 0)
            * numCount.getOrDefault(i + 2 * d, 0));
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
