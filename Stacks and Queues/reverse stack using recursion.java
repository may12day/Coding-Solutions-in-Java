/*Reverse a Stack using Recursion.

Input Format:
First line contains an integer N (size of the stack). Next N lines follow each containing an integer to be stored in the stack where the last integer is at the top of the stack.




 */


import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Stack<Integer> s = new Stack<Integer>();
        for(int i=1;i<=n;i++) {
            int number=sc.nextInt();
            s.push(number);
        }
        revertStack(s);
        while(!s.isEmpty())
        {
            System.out.println(s.pop());
        }
    }

    public static void revertStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        } else {
            Integer a = s.pop();
            revertStack(s);
            appendStack(s, a);
        }
    }

    public static void appendStack(Stack<Integer> s, Integer a) {
        if (s.isEmpty()) {
            s.push(a);
            return;
        } else {
            Integer o = s.pop();
            appendStack(s, a);
            s.push(o);
        }
    }

}