package regex;

import java.util.Scanner;
import java.util.Stack;

public class BalancedPatterns {

    public static boolean isBalanced(String expression) {
        return eatTillEnd(expression);
    }

    public static boolean eatTillEnd(String b) {
        Stack<String> stack = new Stack();

        for (int i = 0; i < b.length(); i++) {
            char cur = b.charAt(i);
            if (opening(cur)) {
                stack.add(String.valueOf(cur));
            } else {
                char curOp = getOposite(cur);
                if (curOp == 'n') {
                    return false;
                }
                if (stack.isEmpty()) {
                    return false;
                }
                String elem = stack.pop();


                if (!elem.equals(String.valueOf(curOp))) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static char getOposite(char c) {
        if (c == '}') return '{';
        if (c == ']') return '[';
        if (c == ')') return '(';
        if (c == '{') return '}';
        if (c == '[') return ']';
        if (c == '(') return ')';
        return 'n';
    }

    public static boolean opening(char c) {
        if (c == '{' || c == '[' || c == '(')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
