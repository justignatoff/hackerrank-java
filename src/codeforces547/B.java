package codeforces547;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        list.addAll(list);

        int max = -1;
        int length = 0;

        for (Integer i : list) {
            if (i == 1) {
                length++;
            } else {
                max = Math.max(max, length);
                length = 0;
            }
        }
        System.out.println(max);
    }
}
