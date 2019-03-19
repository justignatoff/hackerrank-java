package codeforces547;

import java.util.*;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long h = in.nextLong();
        int n = in.nextInt();

        in.nextLine();

        List<Integer> diffs = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Long> partSums = new ArrayList<>(diffs.size());
        long sum = 0;
        partSums.add(sum);
        for (int i : diffs) {
            sum += i;
            partSums.add(sum);
        }

        long min = Collections.min(partSums);

        if (h + min > 0 && h + partSums.get(n) >= h) {
            System.out.println(-1);
        } else {
            if (h + min <= 0) {
                for (int i = 0; i < partSums.size(); i++) {
                    h += partSums.get(i);
                    if (h <= 0) {
                        System.out.println(i);
                        return;
                    }
                }
            } else {
                long time = ((h + min) / Math.abs(partSums.get(n)) + (h + min) % Math.abs(partSums.get(n)) != 0 ? 1 : 0) * n;
                h = h - time / n * partSums.get(n);
                for (int i = 0; i < partSums.size(); i++) {
                    h += partSums.get(i);
                    if (h <= 0) {
                        System.out.println(time + i);
                        return;
                    }
                }
            }
        }
    }
}
