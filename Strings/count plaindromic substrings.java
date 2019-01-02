/*Take as input S, a string. Write a program that gives the count of substrings of this string which are palindromes and Print the ans.

Explanation:
For the given sample case , the palindromic substrings of the string abc are "a","b" and "c".So, the ans is 3.




*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count =0;

        for(int i =0; i<s.length(); i++)
        {
            for(int j = i+1; j<=s.length(); j++)
            {
                String st = s.substring(i,j);
                int k = 0;
                int m = st.length()-1;
                while(k!=m && k<m)
                {
                    if(st.charAt(k)!=st.charAt(m))
                        break;
                    else
                    {
                        k++;
                        m--;
                    }
                }
                if(k>=m)
                    count++;
            }
        }

        System.out.println(count);
    }
}
