package algorithms.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String[] parts = s.split(":");
        int hours = Integer.parseInt(parts[0]) % 12;
        int minuts = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(new StringBuilder().append(parts[2].charAt(0))
                .append(parts[2].charAt(1)).toString());
        if (parts[2].charAt(2) == 'P') {
            hours += 12;
        }
        StringBuilder result = new StringBuilder();
        if (hours < 10) {
            result.append("0");
        }
        result.append(hours).append(":");
        if (minuts < 10) {
            result.append("0");
        }
        result.append(minuts).append(":");
        if (seconds < 10) {
            result.append("0");
        }
        result.append(seconds);
        return result.toString();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
