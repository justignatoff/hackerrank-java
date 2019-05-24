package algorithms.Implementation;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SherlockAndArray {
    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        long allSum = arr.stream().reduce(Integer::sum).get();
        long curSum = 0;
        boolean res = false;
        for (int i = 0; i < arr.size() && !res; i++) {
            res = allSum - arr.get(i) - curSum == curSum;
            curSum += arr.get(i);

        }
        return res ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
