package Introduction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class JavaComparator implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        if (player1.score != player2.score) {
            return player2.score - player1.score;
        }
        return player1.name.compareTo(player2.name);
    }

    @Override
    public Comparator<Player> reversed() {
        return null;
    }

    @Override
    public Comparator<Player> thenComparing(Comparator<? super Player> other) {
        return null;
    }

    @Override
    public <U> Comparator<Player> thenComparing(Function<? super Player, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Player> thenComparing(Function<? super Player, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Player> thenComparingInt(ToIntFunction<? super Player> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Player> thenComparingLong(ToLongFunction<? super Player> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Player> thenComparingDouble(ToDoubleFunction<? super Player> keyExtractor) {
        return null;
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class SolutionComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        JavaComparator checker = new JavaComparator();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (Player value : player) {
            System.out.printf("%s %s\n", value.name, value.score);
        }
    }
}
