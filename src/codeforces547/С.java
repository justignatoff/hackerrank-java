package codeforces547;


import java.util.*;
import java.util.stream.Collectors;

public class С{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<Integer> diff = Arrays.stream(in.nextLine().split(" "))
                .map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        int sum = 0;
        List<Integer> partSums = new ArrayList<>(diff.size());
        partSums.add(0);
        for (int i : diff) {
            sum += i;
            partSums.add(sum);
        }
        HashSet<Integer> set = new HashSet<>(partSums);
        if (set.size() != n ) {
            System.out.println(-1);
            return;
        }
        int startValue = 1 - Collections.min(set);
        if (startValue + Collections.max(set) > n) {
            System.out.println(-1);
            return;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = startValue;;) {
            res.clear();
            res.add(i);
            HashSet<Integer> used = new HashSet<>();
            used.add(i);
            for (int j = 0; j < n - 1; j++) {
                int num = res.get(j) + diff.get(j);
                if (num < 1 || num > n || used.contains(num)) {
                    break;
                } else {
                    used.add(num);
                    res.add(num);
                }
            }
            if (res.size() == n) {
                for (int qq : res) {
                    System.out.print(qq + " ");
                }
                return;
            }
        }
    }
}
