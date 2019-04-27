package algorithms.Implementation;

import java.io.*;

public class TwoCharacters {
    // Complete the alternate function below.
    static int alternate(String s) {
        int res = 0;
        int[] usedChars = s.chars().distinct().toArray();

        if (usedChars.length < 2) {
            return 0;
        }
        for (int i = 0; i < usedChars.length - 1; i++) {
            for (int j =  i + 1; j < usedChars.length; j++) {
                String twoCharString = s.replaceAll(
                        String.format("[^%s%s]", (char) usedChars[i], (char) usedChars[j]), "");
                boolean flag = true;
                for (int k = 0; k < twoCharString.length() - 1; k++) {
                    flag = flag && (twoCharString.charAt(k) != twoCharString.charAt(k + 1));
                }
                if (flag && twoCharString.length() > res) {
                    res = twoCharString.length();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
