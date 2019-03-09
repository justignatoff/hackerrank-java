package algorithms.Implementation;

import java.io.*;

public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        if( year == 1918 ) return "26.09.1918";
        if( isLeap( year ) ) return "12.09." + year;
        else return "13.09." + year;

    }

    static boolean isLeap( int year ) {

        if( year % 4 != 0 ) return false;
        if( year > 1918 && year % 100 == 0 && year % 400 != 0 ) return false;
        return true;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
