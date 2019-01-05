/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.

Input Format:
First line contains a single integer N, denoting the number of bars in th histogram. Next line contains N integers, ith of which, denotes the height of ith bar in the histogram.

Output Format:
Output a single integer denoting the area of the required rectangle.



 */



import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i=0; i<n; i++)
            a[i]= sc.nextLong();
        hist(a, n);
    }
    public static void hist(long[] a, int n)
    {
        Stack<Integer> s = new Stack<>();
        long area =0;
        long max =0;
        s.push(0);
        int i =1;
        for(; i<=n; i++){
            while(!s.isEmpty() && i<n && a[i]>a[s.peek()])
            {
                s.push(i);
                i++;
            }
            while(!s.isEmpty() && ((i<n && a[i]<a[s.peek()]) || i==n))
            {
                int temp = s.pop();
                if(s.isEmpty())
                    area = a[temp]*i;
                else
                    area = a[temp]*(i-s.peek()-1);
                // System.out.println(area);
                if(max<area)
                    max = area;
            }
            if(i<n)
                s.push(i);
        }
        System.out.print(max);
    }
}
