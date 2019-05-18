package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    // Complete the anagram function below.
    static int anagram(String s) {
        if (s.length() % 2 == 1) return -1;
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        HashMap<Character, Integer> counts1 = new HashMap<>();
        HashMap<Character, Integer> counts2 = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            counts1.put(ch, counts1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s2.toCharArray()) {
            counts2.put(ch, counts2.getOrDefault(ch, 0) + 1);
        }

        return s1.length() - counts1.keySet().stream()
                .map(ch -> Math.min(counts1.get(ch), counts2.getOrDefault(ch, 0)))
                .reduce(Integer::sum).get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);


            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
