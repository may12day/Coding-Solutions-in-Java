/*Take as input str, a string. We are concerned with all the possible subsequences of str. E.g.

a. Write a recursive function which returns the count of subsequences for a given string. Print the value returned.

b. Write a recursive function which prints all possible subsequences for a “abcd” has following subsequences “”, “d”, “c”, “cd”, “b”, “bd”, “bc”, “bcd”, “a”, “ad”, “ac”, “acd”, “ab”, “abd”, “abc”, “abcd”.given string (void is the return type for function).

Input Format:
Enter a string




 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        order(s);
        printSS(s, "");

    }

    private static void order(String str) {
        int len=str.length();
        int ans=(int)(Math.pow(2,len));
        System.out.println(ans);

    }

    public static void printSS(String str, String result) {

        if (str.length() == 0) {
            System.out.print(result+" ");
            return;
        }

        char cc = str.charAt(0);
        String ros = str.substring(1);

        printSS(ros, result);
        printSS(ros, result + cc);
    }


}
