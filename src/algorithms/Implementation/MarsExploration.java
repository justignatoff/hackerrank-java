package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarsExploration {
    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 3 == 1 && s.charAt(i) != 'O' || i % 3 != 1 && s.charAt(i) != 'S') res++;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
