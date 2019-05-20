package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MakingAnagrams {
    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        HashMap<Character, Integer> count1 = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            count1.put(ch, count1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s2.toCharArray()) {
            count2.put(ch, count2.getOrDefault(ch, 0) + 1);
        }

        return s1.length() + s2.length() - (count1.keySet().stream()
                .map(ch -> Math.min(count1.get(ch), count2.getOrDefault(ch, 0) * 2))
                .reduce(Integer::sum)).get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
