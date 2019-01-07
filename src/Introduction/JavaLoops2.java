package Introduction;

import java.util.Scanner;

public class JavaLoops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                long res = a + b * ((1 << (j + 1)) - 1);
                System.out.print(res + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
