package algorithms.Implementation;

import java.io.*;

public class SuperReducedString {
    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        int pos = 0;
        while (pos < s.length() - 1){
            if (s.charAt(pos) == s.charAt(pos + 1)) {
                s = s.substring(0, pos) + (pos + 2 < s.length() ? s.substring(pos + 2) : "");
                pos = 0;
            } else {
                pos++;
            }
        }
        return s.equals("") ? "Empty String" : s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
