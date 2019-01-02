/*Take as input str, a number in form of a string. Write a recursive function to convert the number in string form to number in integer form. E.g. for “1234” return 1234. Print the value returned.

Input Format:
Enter a number in form of a String




 */

import java.util.*;
public class Main {
    static int x = 0;
    static int counter = 0;

    // input
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(recursive(s));

    }

    // recursive method
    public static int recursive(String s) {
        if (s.length() == 1) {
            x = (x * 10) + Integer.parseInt(s.substring(0, 1));
            return x;
        } else {
            x = (x * 10) + Integer.parseInt(s.substring(0, 1));
            counter++;
            return recursive(s.substring(1, s.length()));

        }

    }
}