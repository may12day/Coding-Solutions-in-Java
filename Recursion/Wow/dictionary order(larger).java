/*Take as input str, a string. Write a recursive function which prints all the words possible by rearranging the characters of this string which are in dictionary order larger than the given string


Input Format:
Enter a string

 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        dict(s,"", s);
    }

    public static void dict(String s, String ans, String so)
    {
        if(s.length()==0)
        {
            if(so.compareTo(ans)<0)
                System.out.println(ans);
            return;
        }

        for(int i =0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            String ss = s.substring(0,i)+s.substring(i+1);
            String re = ans+ ch;
            dict(ss,re, so);
        }

    }
}