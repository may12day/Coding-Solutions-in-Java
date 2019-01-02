/*Take as input N, the size of array. Take N more inputs and store that in an array. Take as input M, a number. Write a recursive function which returns the last index at which M is found in the array and -1 if M is not found anywhere. Print the value returned.


Input Format:
Enter a number N and add N more numbers to an array, then enter number M to be searched


 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int data=sc.nextInt();
        System.out.println(lastIndex(arr, 0,data));
    }

    public static int lastIndex(int[] arr, int si, int data) {
        if (si == arr.length) {
            return -1;
        }
        int index = lastIndex(arr, si + 1, data);
        if (index == -1) {
            if (arr[si] == data) {
                return si;
            } else {
                return -1;
            }
        } else {
            return index;
        }
    }
}