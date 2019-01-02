/*Take as input str, a string. Write a recursive function which returns a new string in which all duplicate consecutive characters are reduced to a single char. E.g. for “hello” return “helo”. Print the value returned.

Input Format:
Enter the string





 */

import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(consec(s));


    }


    public static String consec(String s)
    {
        if ( s.length() <= 1 )
            return s;
        if( s.substring(1,2).equals(s.substring(0,1)) )
            return consec(s.substring(1));
        else
            return s.substring(0,1) + consec(s.substring(1));
    }
}