/*You are given a Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.

Explanation:
For first test case largest subarray lies between index 0 to 5.




*/

import java.util.*;
public class Main {
    public static void maxSubarraySum(int[] arr,int n){
        int sum = 0;
        int maxSize = -1;
        int startindex=0;int endindex=0;
        for (int i = 0; i < n - 1; i++)
        {
            sum = (arr[i] == 0) ? -1 : 1;

            for (int j = i + 1; j < n; j++)
            {
                if(arr[j] == 0)
                    sum += -1;
                else
                    sum += 1;

                if (sum == 0 && maxSize < j - i + 1)
                {
                    maxSize = j - i + 1;
                    startindex = i;
                }
            }
        }
        endindex = startindex+maxSize-1;
        if (maxSize == -1)
            System.out.println("None");
        else
            System.out.println(startindex+" "+endindex);

        return;
    }
    public static void main(String args[]) {
        Scanner scn  = new Scanner(System.in);
        int t = scn.nextInt();
        while(t > 0){

            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++)
                arr[i] = scn.nextInt();

            maxSubarraySum(arr,n);
            t--;
        }
    }
}