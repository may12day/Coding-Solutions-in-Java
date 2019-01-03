/*You are given given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.

Input Format:
First line contains integer t as number of test cases. Each test case contains two lines. First line contains two integers n and k where n is length of the array and second line contains n space separated integer.

Explanation:
For test case 1 :

Subarrays of size 4 are :

{2, 5, -1, 7}, min + max = -1 + 7 = 6

{5, -1, 7, -3}, min + max = -3 + 7 = 4

{-1, 7, -3, -1}, min + max = -3 + 7 = 4

{7, -3, -1, -2}, min + max = -3 + 7 = 4

Sum of all min & max = 6 + 4 + 4 + 4 = 18


 */


import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nm = sc.nextInt();
        while (nm>0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            printMaxMin(arr,arr.length,k);
            nm--;
        }
    }

    private static void printMaxMin(int[] arr, int length, int k) {
        int max = 0, min = 0;
        int newsum=0;
        for (int i = 0; i <= length - k; i++) {
            max = arr[i];
            min=arr[i];
            for (int j = 1; j < k; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
                if (arr[i + j] < min)
                    min = arr[i + j];
            }
            newsum=newsum+(max+min);
        }
        System.out.println(newsum);
    }
}