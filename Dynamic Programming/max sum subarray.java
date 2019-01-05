/*
Find the maximum sum subarray in the given 2D array.

Input Format:
First line of every test case consists of 2 integers R and C , denoting number of rows and columns.
Second line consists of R*C spaced integers denoting number of elements in array.

Output Format:
Print the maximum possible sum of any rectangle which can be formed in that 2D matrix.


Explanation:
1 2 -1 -4 -20
-8 -3 4 2 1
3 8 10 1 3
-4 -1 1 7 -6
The maximum sum rectangle which can be formed in this subarray has coordinates leftTop(2,2) and rightBottom(4,4) according to 1-based indexing.



 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        for(int i =0; i<m; i++)
        {
            for(int j=0; j<n; j++)
                a[i][j] = sc.nextInt();
        }
        sub(a, m, n);
    }
    public static void sub(int[][] a, int m, int n)
    {
        int max = Integer.MIN_VALUE;
        //  int pmax = Integer.MIN_VALUE;
        for(int col =0; col<n; col++)
        {
            // int max = Integer.MIN_VALUE;
            int[] s = new int[m];
            for(int c=col; c<n; c++)
            {
                for(int i=0; i<m; i++)
                {
                    s[i] += a[i][c];
                }
                int[] k = new int[m];
                k[0] = s[0];
                for(int i=1; i<m; i++)
                {
                    if(s[i]> k[i-1]+s[i])
                        k[i] = s[i];
                    else
                        k[i] = s[i]+k[i-1];
                }
                for(int i=0; i<m; i++)
                {
                    if(max<k[i])
                        max = k[i];
                }
            }
            //      if(max>pmax)
            //    pmax = max;
        }
        System.out.println(max);
    }
}