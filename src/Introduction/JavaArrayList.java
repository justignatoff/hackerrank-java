package Introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Stream.of(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        int d = in.nextInt();
        for (int i = 0; i < d; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt();
            if (y >= list.get(x).size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(list.get(x).get(y));
            }
        }
    }
}
