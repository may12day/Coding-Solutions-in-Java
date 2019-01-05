/*
You are given 2 strings s1 and s2. You can perform the following operations on them:

Insert a character at any position.
Remove a character from any position.
Replace a character with any other character.
Find the minimum number of these operations required to convert s1 to s2.

Input Format:
First line contains string s1. Second line contains string s2.


Output Format:
Print a single integer denoting the minimum number of operations required.


Explanation:
First delete 'a' from position 1 in s1 and then insert 'a' at position 4.

 */


import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        edit(a, b);
    }
    public static void edit(String a, String b)
    {
        int m = a.length();
        int n = b.length();
        int[][] c = new int[a.length()+1][b.length()+1];
        for(int i=n; i>=0; i--)
        {
            c[m][i] = n-i;
        }
        for(int i=m; i>=0; i--)
        {
            c[i][n] = m-i;
        }
        for(int i=m-1; i>=0; i--)
        {
            for(int j = n-1; j>=0; j--)
            {
                if(a.charAt(i)==b.charAt(j))
                    c[i][j] = c[i+1][j+1];
                else
                    c[i][j] = 1+Math.min(c[i+1][j+1], Math.min(c[i+1][j], c[i][j+1]));
            }
        }
        System.out.println(c[0][0]);
    }
}
