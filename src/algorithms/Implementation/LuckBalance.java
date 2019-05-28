package algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        List<Integer> list1;
        List<Integer> list0;
        list1 = Arrays.stream(contests).filter(i -> i[1] == 1).map(i->i[0]).collect(Collectors.toList());
        list1.sort(Integer::compare);

        list0 = Arrays.stream(contests).filter(i -> i[1] == 0).map(i->i[0]).collect(Collectors.toList());

        int res = list0.stream().reduce(Integer::sum).orElse(0);
        for (int i = 0; i < list1.size() - k && i < list1.size(); i++) {
            res -= list1.get(i);
        }


        for (int i = Math.max(list1.size() - k, 0) ; i < list1.size(); i++) {
            res += list1.get(i);
        }
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
