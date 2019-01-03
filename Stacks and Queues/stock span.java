/*The stock span problem is a financial problem where we have a series of N daily price quotes for a stock and we need to calculate span of stock’s price for all N days. You are given an array of length N, where ith element of array denotes the price of a stock on ith. Find the span of stock's price on ith day, for every 1<=i<=N.
A span of a stock's price on a given day, i, is the maximum number of consecutive days before the (i+1)th day, for which stock's price on these days is less than or equal to that on the ith day.

Input Format:
Enter the size of the array N and add N more numbers and store in the array.

Explanation:
For the given case
for day1 stock span =1 for day2 stock span =2 (as 35>30 so both days are included in it) for day3 stock span =3 (as 40>35 so 2+1=3) for day4 stock span =1 (as 38<40 so only that day is included) for day5 stock span =1 (as 35<38 so only that day is included) hence output is 1 2 3 1 1 END




 */


import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int[] ans=stockSpan(arr);

        for(int val:ans)
            System.out.print(val+" ");
        System.out.println("END");
    }
    public static int[] stockSpan(int[] prices) throws Exception{
        int[] span=new int[prices.length];
        Stack<Integer> stack=new Stack<Integer>();

        for (int i=0;i<prices.length;i++){
            while (!stack.isEmpty() && prices[stack.peek()]<prices[i])
            {
                stack.pop();
            }

            if(stack.isEmpty())
                span[i]=i+1;
            else
                span[i]=i-stack.peek();

            stack.push(i);
        }
        return span;

    }


}
