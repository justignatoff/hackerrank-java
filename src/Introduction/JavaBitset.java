package Introduction;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BitSet a = new BitSet(n);
        BitSet b = new BitSet(n);

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            String command = in.next();
            int set = in.nextInt();
            int secondArg = in.nextInt();
            switch (command) {
                case "AND":
                    if (set == 1) {
                        a.and(b);
                    } else {
                        b.and(a);
                    }
                    break;
                case "OR":
                    if (set == 1) {
                        a.or(b);
                    } else {
                        b.or(a);
                    }
                    break;
                case "XOR":
                    if (set == 1) {
                        a.xor(b);
                    } else {
                        b.xor(a);
                    }
                    break;
                case "SET":
                    if (set == 1) {
                        a.set(secondArg);
                    } else
                        b.set(secondArg);
                    break;
                case "FLIP":
                    if (set == 1) {
                        a.flip(secondArg);
                    } else
                        b.flip(secondArg);
                    break;
                    default:
                        break;
            }
            System.out.println(a.cardinality() + " " + b.cardinality());
        }
    }
}
