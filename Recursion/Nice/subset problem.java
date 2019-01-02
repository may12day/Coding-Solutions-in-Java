/*Take as input N, a number. Take N more inputs and store that in an array. Take as input target, a number

a. Write a recursive function which counts the number of subsets of the array which sum to target. Print the value returned.

b. Write a recursive function which prints subsets of the array which sum to target. Return type of functions is void.


Input Format:
Take as input N, a number. Take N more inputs and store that in an array.Take as input target, a number




 */

import java.util.*;
public class Main {
    public static int count(int[] arr , int sum , int vidx){

        if(vidx == arr.length){
            if(sum == 0)
                return 1;
            else return 0;
        }

        return count(arr , sum , vidx + 1) + count(arr , sum - arr[vidx] , vidx + 1);
    }
    public static void printSubset(int[] arr , int sum , int vidx , String subsetSoFar){


        if(vidx == arr.length){
            if(sum == 0){
                System.out.print(subsetSoFar + " ");
            }
            return;
        }

        printSubset(arr , sum - arr[vidx] , vidx + 1 , subsetSoFar + arr[vidx] + " ");
        printSubset(arr , sum , vidx + 1 , subsetSoFar);

    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();
        int sum = scn.nextInt();
        System.out.println(count(arr , sum , 0));
        printSubset(arr , sum , 0 , "");
    }
}