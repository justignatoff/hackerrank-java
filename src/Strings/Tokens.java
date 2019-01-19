package Strings;

import java.util.Scanner;
import java.util.stream.Stream;

public class Tokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        if (s.length() == 0) {
            System.out.println(0);
        } else {
            String[] res = s.split("[ !,?._'@]+");
            System.out.println(res.length);
            Stream.of(res).forEach(System.out::println);
            scan.close();
        }
    }
}