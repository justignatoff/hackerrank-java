package codeforces547;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s1 = in.next();
        String s2 = in.next();

        HashMap<Character, LinkedList<Integer>> chInPos1 = new HashMap<>();
        HashMap<Character, LinkedList<Integer>> chInPos2 = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++){
            chInPos1.put(ch, new LinkedList<>());
            chInPos2.put(ch, new LinkedList<>());
        }
        chInPos1.put('?', new LinkedList<>());
        chInPos2.put('?', new LinkedList<>());

        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            chInPos1.get(ch).add(i + 1);

            ch = s2.charAt(i);
            chInPos2.get(ch).add(i + 1);
        }

        int count = 0;
        StringBuilder res = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (chInPos1.get(ch).size() > 0 && chInPos2.get(ch).size() > 0) {
                res.append(chInPos1.get(ch).get(0) + " " + chInPos2.get(ch).get(0) + "\n");
                chInPos1.get(ch).remove(0);
                chInPos2.get(ch).remove(0);
                count++;
            }
        }


        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (chInPos2.get(ch).size() > 0 && chInPos1.get('?').size() > 0) {
                res.append(chInPos1.get('?').get(0) + " " + chInPos2.get(ch).get(0) + "\n");
                chInPos1.get('?').remove(0);
                chInPos2.get(ch).remove(0);
                count++;
            }
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (chInPos1.get(ch).size() > 0 && chInPos2.get('?').size() > 0) {
                res.append(chInPos1.get(ch).get(0) + " " + chInPos2.get('?').get(0) + "\n");
                chInPos2.get('?').remove(0);
                chInPos1.get(ch).remove(0);
                count++;
            }
        }

        while (chInPos1.get('?').size() > 0 && chInPos2.get('?').size() > 0) {
            res.append(chInPos1.get('?').get(0) + " " + chInPos2.get('?').get(0) + "\n");
            chInPos2.get('?').remove(0);
            chInPos1.get('?').remove(0);
            count++;
        }
        System.out.println(count);
        System.out.println(res);
    }
}
