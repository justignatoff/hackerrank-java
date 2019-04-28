package algorithms.Implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort2 {
    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {
        List<Integer> sortedPart = new ArrayList<>();
        sortedPart.add(arr[0]);
        LinkedList<Integer> unsortedPart = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            unsortedPart.add(arr[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            sortedPart.add(unsortedPart.pollFirst());
            sortedPart.sort(Integer::compareTo);
            for (Integer item : sortedPart) {
                System.out.print(item + " ");
            }
            for (Integer unsortedItem : unsortedPart) {
                System.out.print(unsortedItem + " ");
            }
            System.out.println();
        }
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

        insertionSort2(n, arr);

        scanner.close();
    }
}
