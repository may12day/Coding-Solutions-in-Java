/*Take as input N, the size of array. Take N more inputs and store that in an array. Take as input M, a number. Write a recursive function which returns an array containing indices of all items in the array which have value equal to M. Print all the values in the returned array.

Input Format:
Enter a number N(size of the array) and add N more numbers to the array Enter number M to be searched in the array





 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int m=sc.nextInt();
        int[] ans = allIndices(arr, 0, m, 0);
        display(ans);
    }

    public static int[] allIndices(int[] arr, int si, int data, int count) {
        if (si == arr.length) {
            int[] base = new int[count];
            return base;
        }
        int[] indices = null;
        if (arr[si] == data) {
            indices = allIndices(arr, si + 1, data, count + 1);
        } else {
            indices = allIndices(arr, si + 1, data, count);

        }
        if (arr[si] == data) {
            indices[count] = si;
        }
        return indices;
    }
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}