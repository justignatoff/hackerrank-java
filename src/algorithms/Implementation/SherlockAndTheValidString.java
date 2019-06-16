package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndTheValidString {
    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0 ) + 1);
        }
        if (map.values().stream().distinct().count() == 1) return "YES";
        int max = map.values().stream().max(Integer::compareTo).get();
        int min = map.values().stream().min(Integer::compareTo).get();
        if (map.values().stream().distinct().count() == 2 &&
                (map.values().stream().filter(i -> i == max).count() == 1 &&
        map.values().stream().distinct().reduce((i, j) -> Math.abs(i - j)).get() == 1
                        || map.values().stream().filter(i -> i == min).count() == 1)) return "YES";
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
