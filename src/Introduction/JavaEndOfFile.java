package Introduction;

import java.util.Scanner;

public class JavaEndOfFile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.printf("%d %s\n", ++count, s);
        }
    }
}
