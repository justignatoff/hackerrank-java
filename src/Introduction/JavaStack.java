package Introduction;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    private static boolean check(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else if (ch == '[') {
                stack.push(1);
            } else if (ch == '{') {
                stack.push(2);
            } else if (ch == ')') {
                if (stack.empty()) {
                    return false;
                }
                int c = stack.pop();
                if (c != 0) {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.empty()) {
                    return false;
                }
                int c = stack.pop();
                if (c != 1) {
                    return false;
                }
            } else {
                if (stack.empty()) {
                    return false;
                }
                int c = stack.pop();
                if (c != 2) {
                    return false;
                }
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            System.out.println(check(input));
        }

    }
}
