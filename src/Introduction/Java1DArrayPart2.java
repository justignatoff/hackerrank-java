package Introduction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Java1DArrayPart2 {
    public static boolean checkPos(int pos, int[] game) {
        return pos >= 0 && game[pos] != 1;
    }
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        HashSet<Integer> current = new HashSet<>(Arrays.asList(0));
        HashSet<Integer> used = new HashSet<>();
        while (!current.isEmpty()) {
            int pos = current.stream().findAny().get();
            if (pos == game.length - 1 || pos + leap >= game.length)
                return true;
            current.remove(pos);
            used.add(pos);
            if (checkPos(pos - 1, game) && !used.contains(pos - 1)) {
                current.add(pos - 1);
            }
            if (checkPos(pos + 1, game) && !used.contains(pos + 1)) {
                current.add(pos + 1);
            }
            if (checkPos(pos + leap, game) && !used.contains(pos + leap)) {
                current.add(pos + leap);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
