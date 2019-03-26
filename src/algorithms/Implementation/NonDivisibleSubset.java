package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class NonDivisibleSubset {
    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] numSet) {
        HashMap<Integer, Integer> countOfROD = new HashMap<>();
        for (int num : numSet) {
            countOfROD.put(num % k, countOfROD.getOrDefault(num % k, 0) + 1);
        }
        int res = 0;
        for (int i = 1; i <= k / 2; i++) {
            if (i < k /2 || k % 2 != 0) {
                res += countOfROD.getOrDefault(i, 0) > countOfROD.getOrDefault(k - i, 0) ?
                        countOfROD.getOrDefault(i, 0) :
                        countOfROD.getOrDefault(k - i, 0);
            } else if (countOfROD.getOrDefault(k / 2, 0) != 0) {
                res++;
            }
        }
        if (countOfROD.getOrDefault(0, 0) != 0) {
            res++;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
