package algorithms.Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();

        int a = in.nextInt();
        int b = in.nextInt();

        int m = in.nextInt();
        int n = in.nextInt();

        in.nextLine();

        System.out.println(Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt).map(i -> i + a).filter(i -> s <= i && i <= t).count());
        System.out.println(Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt).map(i -> i + b).filter(i -> s <= i && i <= t).count());
    }
}
