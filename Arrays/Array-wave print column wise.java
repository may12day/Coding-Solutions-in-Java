/*Take as input a two-d array. Wave print it column-wise.

Explanation:
For spiral level clockwise traversal, Go for first row-> last column ->last row -> first column and then do the same traversal for the remaining matrix .

*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int a[][]=new int[r][c];

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
//	       for(int i=0;i<r;i++)
//	        {
//	        	for(int j=0;j<c;j++)
//	        	{
//	        		System.out.print(a[i][j]+" ");
//	        	}
//	        	System.out.println();
//	        }

        for(int j=0;j<c;j++)
        {
            if(j%2==0)
            {
                for(int i=0;i<r;i++)
                {
                    System.out.print(a[i][j]+", ");
                }
            }
            else {
                for(int i=r-1;i>=0;i--)
                {
                    System.out.print(a[i][j]+", ");
                }
            }
        }
        System.out.println("END");

    }
}