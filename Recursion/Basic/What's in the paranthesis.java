/*Take as input str, a string. The string contains a single pair of parenthesis “(..)”. Write a recursive function which returns the contents between the parenthesis. E.g. for “xyz(abc)def” return “abc”. Print the value returned.


Input Format:
Enter the string


 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scn  = new Scanner(System.in);
        String s = scn.next();
        ob(s,0);

    }
    public static void ob(String s, int i)
    {
        if(s.length()==i)
            return;
        if(s.charAt(i)!='(')
            ob(s, i+1);
        else
        {
            String sp = new String();
            sp = par(s, i+1, sp);
            System.out.println(sp);
        }
    }
    public static String par(String s, int i, String sp)
    {
        if(s.charAt(i)==')' || s.length()==i)
            return sp;
        sp = sp + s.charAt(i);
        return par(s, i+1, sp);
    }

}