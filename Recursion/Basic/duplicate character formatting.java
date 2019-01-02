/*Take as input str, a string. Write a recursive function which returns a new string in which all duplicate consecutive characters are separated by a ‘ * ’. E.g. for “hello” return “hel*lo”. Print the value returned

Input Format:
Enter a String




 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scn  = new Scanner(System.in);
        String s = scn.next();
        dup(s,1);

    }
    public static void dup(String s, int i)
    {
        if(i==s.length())
        {
            System.out.println(s);
            return;
        }
        if(s.charAt(i)==s.charAt(i-1))
            s= s.substring(0,i) +"*"+s.substring(i);
        dup(s, i+1);
    }

}