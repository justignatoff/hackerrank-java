package algorithms.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifiedKaprekarNumbers {
    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        List<Integer> res = new ArrayList<>();
        for (int i = p; i <= q; i++) {
            long sqrNum = (long)i * i;
            int splitPos = Long.toString(sqrNum).length() - Integer.toString(i).length();
            int leftPart = Integer.parseInt(
                    Long.toString(sqrNum).substring(0, splitPos).replaceAll("^", "0"));
            int rightPart = Integer.parseInt(Long.toString(sqrNum).substring(splitPos));
            if (leftPart + rightPart == i) {
                res.add(i);
            }
        }
        if (res.size() == 0) {
            System.out.println("INVALID RANGE");
        } else {
            for (int resNum : res) {
                System.out.print(resNum + " ");
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
