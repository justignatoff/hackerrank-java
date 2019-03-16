package algorithms.Implementation;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class PickingNumbers {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        HashMap<Integer, Integer> numberCount = new HashMap<>();
        for (Integer i : a) {
            numberCount.put(i , numberCount.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Integer key : numberCount.keySet()) {
            if (numberCount.containsKey(key - 1) && numberCount.get(key) + numberCount.get(key - 1) > res) {
                res = numberCount.get(key) + numberCount.get(key - 1);
            }
            if (numberCount.containsKey(key + 1) && numberCount.get(key) + numberCount.get(key + 1) > res) {
                res = numberCount.get(key) + numberCount.get(key + 1);
            }
            if (numberCount.get(key) > res) {
                res = numberCount.get(key);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = PickingNumbers.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
