package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RunningTimeOfAlgorithms {
    // Complete the runningTime function below.
    static int insertionSort1(int pos, int[] arr) {
        int count = 0;
        int temp = arr[pos];
        int i = pos - 1;
        while(i >= 0 && arr[i] > temp) {
            arr[i + 1] = arr[i];
            count++;
            i--;
        }
        if (i < 0) {
            arr[0] = temp;
        } else {
            arr[i + 1] = temp;
        }
        return count;
    }

    static int runningTime(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += insertionSort1(i, arr);
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

        int result = runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
