/*You are given a one dimensional array that may contain both positive and negative integers, find the sum of contiguous subarray of numbers which has the largest sum. For example, if the given array is {-2, -5, 6, -2, -3, 1, 5, -6}, then the maximum subarray sum is 7.



*/

import java.util.*;
public class Main {
    public static void maxSubarraySum(int[] arr){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            sum = 0;
            for(int j = i ; j < arr.length ; j++){
                sum = sum + arr[j];
                if(sum > maxSum)
                    maxSum = sum;
            }
        }
        System.out.println(maxSum);
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

            maxSubarraySum(arr);
            t--;
        }
    }
}