package Introduction;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        scanner.close();

        BigInteger number = new BigInteger(n);
        if (number.isProbablePrime(10)) System.out.println("prime");
        else System.out.println("not prime");
    }
}
