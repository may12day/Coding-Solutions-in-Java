/*Take as input str, a string. Write a recursive function which moves all ‘x’ from the string to its end. E.g. for “abexexdexed” return “abeedeedxxx”. Print the value returned


Input Format:
Enter the string



 */

import java.util.*;
public class Main {

    static char ch='x';


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        System.out.println(chrToLast(s));


    }


    public static String chrToLast(String str) {

        if(str.length() < 1) {
            return "";
        }

        String newString = str.substring(1);
        if(str.indexOf(ch) == 0) {
            return chrToLast(newString) + ch;
        } else {
            return str.charAt(0) + chrToLast(newString);
        }

    }
}