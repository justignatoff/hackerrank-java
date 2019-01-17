package Introduction;

import java.util.Scanner;

public class BigInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        java.math.BigInteger a = new java.math.BigInteger(in.next());
        java.math.BigInteger b = new java.math.BigInteger(in.next());
        in.close();

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
