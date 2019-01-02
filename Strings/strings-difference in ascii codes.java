/*Take as input S, a string. Write a program that inserts between each pair of characters the difference between their ascii codes and print the ans.

Explanation:
For the sample case, the Ascii code of a=97 and c=99 ,the difference between c and a is 2.Similarly ,the Ascii code of b=98 and c=99 and their difference is -1. So the ans is a2c-1b.


*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String temp=sc.next();
        int l=temp.length();
        StringBuilder temp1=new StringBuilder(temp);
        int a=0;
        int b=0;
        int c=0;
        int count=0;
        int j=0;

        if(l>=2)
        {
            for(int i=0;i<l-1;i++)
            {
                a=temp.charAt(i);
                b=temp.charAt(i+1);
                c=b-a;
                temp1.insert(j+1, c);
                j=j+Integer.toString(c).length()+1;
            }
            System.out.println(temp1.toString());
        }
    }
}
