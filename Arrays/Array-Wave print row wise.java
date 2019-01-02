/*Take as input a two-d array. Wave print it row-wise.



*/


import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
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

        for(int i=0;i<r;i++)
        {
            if(i%2==0)
            {
                for(int j=0;j<c;j++)
                {
                    System.out.print(a[i][j]+", ");
                }
            }
            else {
                for(int j=c-1;j>=0;j--)
                {
                    System.out.print(a[i][j]+", ");
                }
            }
        }
        System.out.println("END");

    }
}
