package algorithms.Implementation;

import java.io.*;

public class SumVsXOR {
    static long sumXor(long n) {
        if (n == 0) {
            return 1;
        }
        return 1L << (Long.toBinaryString(n).chars().filter(i -> i == 48).count());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
