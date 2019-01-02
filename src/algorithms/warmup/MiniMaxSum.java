package algorithms.warmup;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long totalSum = IntStream.of(arr).asLongStream().sum();
        System.out.print((totalSum - IntStream.of(arr).max().getAsInt()));
        System.out.print(" ");
        System.out.println(totalSum - IntStream.of(arr).min().getAsInt());
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
