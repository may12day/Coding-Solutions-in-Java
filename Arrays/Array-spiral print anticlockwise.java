/*TTake as input a 2-d array. Print the 2-D array in spiral form anti-clockwise.


Explanation:
For spiral level anti-clockwise traversal, Go for first column-> last row ->last column-> first row and then do the same traversal for the remaining matrix .
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

        int top,bottom,left,right,count,dir;
        top=0;
        bottom=r-1;
        left=0;
        right=c-1;
        dir=1;
        count=(bottom+1)*(right+1);

        while(left<=right && top<=bottom)
        {
            if(count>0)
            {
                if(dir==1)
                {
                    for(int i=top;i<=bottom;i++)
                    {
                        System.out.print(a[i][left]+", ");
                        count--;
                    }
                    dir=2;
                    left++;
                }
            }
            if(count>0)
            {
                if(dir==2)
                {
                    for(int i=left;i<=right;i++)
                    {
                        System.out.print(a[bottom][i]+", ");
                        count--;
                    }
                    dir=3;
                    bottom--;
                }
            }
            if(count>0)
            {
                if(dir==3)
                {
                    for(int i=bottom;i>=top;i--)
                    {
                        System.out.print(a[i][right]+", ");
                        count--;
                    }
                    dir=4;
                    right--;
                }
            }
            if(count>0)
            {
                if(dir==4)
                {
                    for(int i=right;i>=left;i--)
                    {
                        System.out.print(a[top][i]+", ");
                        count--;
                    }
                    dir=1;
                    top++;
                }
            }
        }
        System.out.println("END");



    }
}