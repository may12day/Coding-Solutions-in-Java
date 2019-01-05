/*
You are provided an integers N. You need to count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Input Format:
First line contains integer t which is number of test case. For each test case, it contains an integer n which is the the length of Binary String.

Output Format:
Print the number of all possible binary strings.

Explanation:
1st test case : 00, 01, 10 2nd test case : 000, 001, 010, 100, 101



 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            t--;
            int n = sc.nextInt();
            bin(n);
        }
    }
    public static void bin(int n)
    {
        int[] a= new int[n+1];
        a[0] =0;
        if(n>=1)
            a[1]= 2;
        if(n>=2)
            a[2] = 3;
        for(int i=3; i<=n; i++)
        {
            a[i] = a[i-2]+ a[i-1];
        }
        System.out.println(a[n]);
    }
}