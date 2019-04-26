package algorithms.Implementation;

import java.util.Scanner;

public class InsertionSort1 {
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int temp = arr[n - 1];
        int i = n - 2;
        while(i >= 0 && arr[i] > temp) {
            arr[i + 1] = arr[i];
            i--;
            for (int item : arr) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        if (i < 0) {
            arr[0] = temp;
        } else {
            arr[i + 1] = temp;
        }
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
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

        insertionSort1(n, arr);

        scanner.close();
    }
}
