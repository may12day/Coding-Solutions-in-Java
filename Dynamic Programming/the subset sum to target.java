/*
Given a set of "n" non-negative integers, and a value "sum", determine if there is a subset of the given set with sum equal to given sum.

Input Format:
1st Line: n sum 2nd Line: a1 a2……an (Array Values)

Output Format:
Yes, if sum exist No, it sum does not exist




 */
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for(int i =0; i<n; i++)
            a[i] = sc.nextInt();
        sub(a, n, x);
    }
    public static void sub(int[] a, int n, int x)
    {
        int[][] b = new int[n+1][x+1];
        for(int i =0; i<=n; i++)
            b[i][0] = 1;
        for(int i =1; i<=n; i++)
        {
            for(int j =1; j<=x; j++)
            {
                if(b[i-1][j]==1 ||(a[i-1]<=j && b[i-1][j-a[i-1]]==1))
                    b[i][j]=1;
                else
                    b[i][j] =0;
            }
        }
        if(b[n][x]==1)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}