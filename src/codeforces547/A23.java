package codeforces547;

import java.util.Scanner;

public class A23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        if (m < n || m % n != 0) {
            System.out.println(-1);
            return;
        }

        int d = m / n;
        int count = 0;
        while (d % 2 == 0) {
            d /= 2;
            count++;
        }

        while (d % 3 == 0) {
            d /= 3;
            count++;
        }
        if (d != 1) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
