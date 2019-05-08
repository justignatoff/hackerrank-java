package algorithms.Implementation;

import java.util.Scanner;

public class SeparateTheNumbers {
    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        if (s.startsWith("0")) {
            System.out.println("NO");
            return;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            long firstNum = Long.parseLong(s.substring(0, i));
            long curNum = firstNum;
            StringBuilder idealString = new StringBuilder();
            while(idealString.length() < s.length()) {
                idealString.append(curNum);
                curNum++;
            }
            if (idealString.toString().equals(s)) {
                System.out.println("YES " + firstNum );
                return;
            }
        }
        System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
