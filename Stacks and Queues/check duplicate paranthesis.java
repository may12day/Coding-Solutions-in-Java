/*Check for duplicate parenthesis in an expression e.g. ((a + b) + ((c+d))) has duplicate parenthesis


Input Format:
Enter a string str

Explanation:
A set of parenthesis are duplicate if same sub expression is surrounded by multiple parenthesis. In the given sample input, ((a+b)+((c+d))), the subexpression "c+d" is surrounded by two pairs of brackets.




 */

import java.util.*;
public class Main {
    public static boolean isDuplicate(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ')') {
                stack.push(str.charAt(i));
            } else {
                if (stack.peek() == '(') {
                    return true;
                }
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        System.out.println(isDuplicate(expr));
    }
}