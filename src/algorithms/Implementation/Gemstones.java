package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Gemstones {
    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        Set<String> characters = Arrays.stream(arr[0].split("")).collect(Collectors.toSet());
        for(String s : arr) {
            Set<String> toRemove = new HashSet<>();
            for (String ch : characters) {
                if (!s.contains(ch)) {
                    toRemove.add(ch);
                }
            }
            characters.removeAll(toRemove);
        }
        return characters.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
