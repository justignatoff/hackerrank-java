package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HappyLadybugs {
    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        HashMap<Character, Integer> charsCount = new HashMap<>();
        for(char ch : b.toCharArray()) {
            charsCount.put(ch, charsCount.getOrDefault(ch, 0) + 1);
        }
        if (charsCount.keySet().stream().filter(character -> character != '_')
                .map(charsCount::get).anyMatch(i -> i < 2)) {
            return "NO";
        } else {
            boolean flag = true;
            for (int i = 1; i < b.length() - 1; i++) {
                if (b.charAt(i) != '_' && b.charAt(i) != b.charAt(i - 1) && b.charAt(i) != b.charAt(i + 1)) {
                    flag = false;
                }
            }
            if (flag || charsCount.containsKey('_')) {
                return "YES";
            } else {
                return "NO";
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
