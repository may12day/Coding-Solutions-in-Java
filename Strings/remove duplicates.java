/*Take as input S, a string. Write a function that removes all consecutive duplicates. Print the value returned.

Explanation:
For the given example, "aabccba", Consecutive Occurrence of a is 2, b is 1, and c is 2.

After removing all of the consecutive occurences, the Final ans will be : - "abcba".




*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String temp=sc.next();

        String result="";
        char ch1,ch2;
        temp=temp+" ";
        int l=temp.length();

        for(int i=0;i<l-1;i++)
        {
            ch1=temp.charAt(i);
            ch2=temp.charAt(i+1);
            if(ch1!=ch2)
                result=result+ch1;
        }
        System.out.println(result);
    }
}
