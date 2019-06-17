package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndAnagrams {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length() - i; j++) {
                char[] first = new char[j];
                for (int k = 0; k < j && i + k < s.length(); k++) {
                    first[k] = s.charAt(i + k);
                }
                Arrays.sort(first);
                for (int k = i + 1; k < s.length(); k++) {
                    char[] second = new char[j];
                    for (int l = 0; l < j && l + k < s.length(); l++) {
                        second[l] = s.charAt(l + k);
                    }
                    Arrays.sort(second);
                    if (Arrays.equals(first, second)) res++;
                }
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
