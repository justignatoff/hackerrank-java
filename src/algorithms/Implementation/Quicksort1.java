package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort1 {
    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equals = new ArrayList<>();
        ArrayList<Integer> more = new ArrayList<>();

        for (int value : arr) {
            if (value == arr[0]) {
                equals.add(value);
            } else if (value < arr[0]) {
                less.add(value);
            } else {
                more.add(value);
            }
        }
        less.addAll(equals);
        less.addAll(more);

        int[] res = new int[arr.length];
        for (int i = 0; i < less.size(); i++) {
            res[i] = less.get(i);
        }
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

        int[] result = quickSort(arr);

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
