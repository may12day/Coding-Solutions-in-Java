/*
A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. For example, the sequence {A,B,D} is a subsequence of {A,B,C,D,E,F}, obtained after removal of elements C, E and F.

Given two strings A and B of size n and m respectively, you have to find the length of Longest Common Subsequence(LCS) of strings A and B, where LCS is the longest sequence present in both A and B.

Input Format:
Two strings A and B.

Output Format:
Output the LCS of A and B.

 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        lcs(a, b);
    }
    public static void lcs(String a, String b)
    {
        int m = a.length();
        int n = b.length();
        int[][] c = new int[a.length()+1][b.length()+1];
        for(int i=n; i>=0; i--)
        {
            c[m][i] = 0;
        }
        for(int i=m; i>=0; i--)
        {
            c[i][n] = 0;
        }
        for(int i=m-1; i>=0; i--)
        {
            for(int j = n-1; j>=0; j--)
            {
                if(a.charAt(i)==b.charAt(j))
                    c[i][j] =1+c[i+1][j+1];
                else
                    c[i][j] = Math.max(c[i+1][j], c[i][j+1]);
            }
        }
        System.out.println(c[0][0]);
    }
}
