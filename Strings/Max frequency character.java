/*Take as input S, a string. Write a function that returns the character with maximum frequency. Print the value returned.eir difference is -1. So the ans is a2c-1b.


Explanation:
For the given input string, a appear 4 times. Hence, it is the most frequent character.



*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String temp=sc.next();
        int l=temp.length();
        int count[]=new int[256];

        for(int i=0;i<l;i++)
        {
            count[temp.charAt(i)]++;
        }
        int max=-1;
        char result=' ';

        for(int i=0;i<l;i++)
        {
            if(max<count[temp.charAt(i)])
            {
                max=count[temp.charAt(i)];
                result=temp.charAt(i);
            }
        }
        System.out.println(result);
    }
}
