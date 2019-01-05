/*
FFind the length of the longest subsequence in a given array of integers such that all elements of the subsequence are sorted in strictly ascending order.

Input Format:
The first line contains a single integer n. Next line contains n space separated numbers which are 0<a<10^5

Output Format:
Print a single line containing a single integer denoting the length of the longest increasing subsequence.

Explanation:
The longest subsequence in test case is - 3,7,40,80


 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a= new int[n];
        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();
        sub(a, n);

    }
    public static void sub(int[] a, int n)
    {
        int[] b = new int[n];
        b[0] =1;
        for(int i=1; i<n; i++)
        {
            for(int j =0; j<i; j++)
            {
                if(a[i]>a[j] && b[i]< b[j]+1)
                    b[i] = b[j]+1;
                if(j==i-1 && b[j]==0)
                    b[j]=1;
            }
        }
        int max =0;
        for(int i=0; i<n; i++)
        {
            if(b[i]>max)
                max = b[i];
        }
        System.out.println(max);
    }
}