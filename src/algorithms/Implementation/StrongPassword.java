package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StrongPassword {
    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-+";
        int res = 0;
        if (Arrays.stream(numbers.split("")).noneMatch(password::contains)) {
            res++;
        }
        if (Arrays.stream(lowerCase.split("")).noneMatch(password::contains)) {
            res++;
        }
        if (Arrays.stream(upperCase.split("")).noneMatch(password::contains)) {
            res++;
        }
        if (Arrays.stream(specialCharacters.split("")).noneMatch(password::contains)) {
            res++;
        }
        return res + (6 - n - res > 0 ? 6 - n - res : 0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
