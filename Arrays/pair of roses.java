/*TDeepak has limited amount of money which he can spend on his girlfriend. So he decided to buy two roses for her. Since roses are of varying sizes, their prices are different. Deepak wishes to completely spend that fixed amount of money on buying roses. As he wishes to spend all the money, he should choose a pair of roses whose prices when summed up are equal to the money that he has. Help Deepak choose such a pair of roses for his girlfriend.
NOTE: If there are multiple solutions print the solution that minimizes the difference between the prices i and j. After each test case you must print a blank line.

Explanation:
Find two such kind of price of roses which has sum up equal to Deepak's Money.




*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=0;i<N;i++)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int k=0;k<n;k++)
            {
                a[k]=sc.nextInt();
            }
            int val=sc.nextInt();

            Arrays.sort(a);
            int m =0;
            int j = n-1;
            int c=0, b=0;
            while(m<j)
            {
                if(a[m] +a[j] > val)
                    j--;
                else if(a[m] + a[j] < val)
                    m++;
                else if(a[m] + a[j] == val)
                {
                    b = a[m];
                    c = a[j];
                    m++;
                    j--;

                }
            }
            System.out.println("Deepak should buy roses whose prices are " +b+ " and " +c+".");
            System.out.println();
            n=0;
            Arrays.fill(a, 0);

        }


    }
}