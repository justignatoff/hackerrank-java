package Strings;

import java.util.Scanner;

public class Anagrams {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        int[] aChars = a.toUpperCase().chars().sorted().toArray();
        int[] bChars = b.toUpperCase().chars().sorted().toArray();
        if (aChars.length != bChars.length) {
            return false;
        }
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
