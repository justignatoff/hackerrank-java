package algorithms.warmup;

import java.util.Scanner;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int countPos, countNeg, countZero = countNeg = countPos = 0;
        for (int el : arr) {
            if (el > 0) {
                countPos++;
            } else if (el < 0) {
                countNeg++;
            } else {
                countZero++;
            }
        }
        int totalCount = arr.length;
        System.out.println((double)countPos / totalCount);
        System.out.println((double)countNeg / totalCount);
        System.out.println((double)countZero / totalCount);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

