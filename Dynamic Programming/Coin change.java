/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, In how many ways can we make the change? The order of coins doesn’t matter.


Input Format:
First line of input contain two space separated integers N and M. Second line of input contains M space separated integers - value of coins.


Output Format:
Output a single integer denoting the number of ways to make the given change using given coin denominations.



 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a= new int[m];
        for(int i=0; i<m; i++)
            a[i]=sc.nextInt();
        coin(n, m, a);
    }
    public static void coin(int n, int m, int[] a)
    {
        int[] b = new int[n+1];
        b[0]=1;
        for(int i=0; i<m; i++)
        {
            for(int j=a[i]; j<=n; j++)
            {
                b[j] += b[j-a[i]];
            }
        }
        System.out.println(b[n]);
    }
}
