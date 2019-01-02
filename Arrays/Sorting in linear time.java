/*You will be given an array containing only 0s, 1s and 2s. you have sort the array in linear time that is O(N) where N is the size of the array.

Time Limit: 1 sec




*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int count0=0,count1=0,count2=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]==0)
                count0++;
            else if(a[i]==1)
                count1++;
            else if(a[i]==2)
                count2++;
        }
        for (int i = 0; i < count0; i++)
            a[i] = 0;

        for (int i = count0; i < (count0 + count1); i++)
            a[i] = 1;

        for (int i = (count0 + count1);i < n; i++)
            a[i] = 2;

        for(int j=0;j<n;j++)
            System.out.println(a[j]);
    }
}
