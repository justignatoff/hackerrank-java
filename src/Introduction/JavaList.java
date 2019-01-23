package Introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            String command = in.next();
            if (command.equals("Insert")) {
                int pos = in.nextInt();
                int num = in.nextInt();
                list.add(pos, num);
            } else {
                int pos = in.nextInt();
                list.remove(pos);
            }
        }
        for(Integer el : list) {
            System.out.print(el + " ");
        }
    }
}
