/*Take as input str, a string. We are concerned with all possible permutations of characters in str. E.g. “abc” can produce following words “abc”, “acb”, “bac”, “bca”, “cab”, “cba”

a. Write a recursive function which returns the count of different permutations for a given string. Print the value returned.

b. Write a recursive function which prints all possible permutations for a given string in the lexicographical order (void is the return type for function).

Input Format:
Enter the String


 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(tcount(s,""));
        printPermutation(s,"");

    }

    public static int tcount(String m, String s1) {

        if (m.length() == 0) {

            return 1;
        }
        int c=0;

        for (int i = 0; i < m.length(); i++) {

            char ch1 = m.charAt(i);
            String roq1 = m.substring(0, i) + m.substring(i + 1);

            c= c+ tcount(roq1, s1 + ch1);
        }
        return c;
    }



    public static void printPermutation(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.print(ans+" ");
            return;
        }

        for (int i = 0; i < ques.length(); i++) {

            char ch = ques.charAt(i);
            String roq = ques.substring(0, i) + ques.substring(i + 1);

            printPermutation(roq, ans + ch);
        }
    }

}