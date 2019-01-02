/*It is Alex’s birthday and she wants to go shopping. She only has ‘A’ units of money and she wants to spend all of her money. However, she can only purchase one kind of item. She goes to a shop which has ‘n’ types items with prices A0,A1,A2,…,An-1. The shopkeeper claims that he has atleast ‘k’ items she can choose from. Help her find out if the shopkeeper is correct or not.

Input Format:
The first line contains an integer ‘n’ denoting the number of items in the shop. The second line contains ‘n’ space-separated integers describing the respective price of each item. The third line contains an integer ‘q’ denoting the number of queries. Each of the subsequent lines contains two space-separated integers ‘A’ and ‘k’

Explanation:
In query 1, Alex hai 100 units of money. The shopkeeper claims that she can choose to buy from 2 kinds of items ie item 1 and item 4 each priced at 100.

In query 2, The shopkeeper claims that she can choose to buy from 3 kinds of items ie item 1 and item 4 each priced at 100(she can buy 1 from either of the two) or item 2 priced at 200(she can buy one)

In query 3, she has 500 units of money. She can either buy item 1 or item 4 ( 5 of each kind respectively). Thus, she has only 2 kinds of items to choose from.

In query 5, she has 800 units of money. She can either buy item 1 or item 4 ( 8 of each kind respectively) or item 2(she can buy 4 of these) or item 3(2 of these). Thus, she has 4 kinds of items to choose from.



*/

import java.util.*;
public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++)
        {
            a[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        while(q>0)
        {
//	        for(int i =0; i<q; i++)
//	        {
            int am = sc.nextInt();
            int k = sc.nextInt();
            int count = 0;
//	            for(int j = 0; j<n; j++)
//	            {
//	                if((am%a[j]) == 0)
//	                count++;
//	               // System.out.println(a[j] + " : "+count);
//	            }
            int j=0;
            while(j<n)
            {
                if(am % a[j]==0)
                    count++;
                j++;
            }

            if(count >= k)
                System.out.println("Yes");
            else
                System.out.println("No");
            q--;
        }

    }
}