/*You are given a postfix expression . You need to evaluate the value of that Postfix Expression. Numbers would from 0 to 9 and operators are (+, -, *, /) ;

Input Format:
First line contains integer t which is number of test case. For each test case, It contains a postfix expression.

Explanation:
Infix Expression = 2 + 3 * 1 - 9


 */


import java.util.*;
public class Main {
    static int evaluatePostfix(String exp) {
        //create a stack
        Stack<Integer> stack = new Stack<>();

        // Scan all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if (Character.isDigit(c))
                stack.push(c-'0');

                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n>0){
            String exp = sc.next();
            System.out.println(evaluatePostfix(exp));
            n--;
        }}
}