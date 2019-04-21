package algorithms.Implementation;


import java.io.*;
import java.util.*;

public class BigSorting {
    // Complete the bigSorting function below.
    static List<String> bigSorting(List<String> unsorted) {
        unsorted.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
        return unsorted;
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<String> unsorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String unsortedItem = reader.readLine();
            unsorted.add(unsortedItem);
        }

        List<String> result = bigSorting(unsorted);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        reader.close();
    }
}
