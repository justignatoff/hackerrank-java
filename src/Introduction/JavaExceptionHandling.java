package Introduction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int x = Integer.parseInt(in.next());
            int y = Integer.parseInt(in.next());
            System.out.println(x / y);
        } catch (NumberFormatException ex) {
            System.out.println(new InputMismatchException());
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        }
    }
}
