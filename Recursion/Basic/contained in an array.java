/*Take as input N, the size of array. Take N more inputs and store that in an array. Take as input M, a number. Write a recursive function which returns true if M is contained in the array and false otherwise. Print the value returned

Input Format:
Enter a number N and add N numbers in an array, then input a number M




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
        System.out.println(isContain(arr, 0,m));
    }

    public static boolean isContain(int[] arr, int si,int m) {
        if (si == arr.length) {
            return false;
        }
        if (arr[si] ==m) {
            return true;
        } else {
            boolean restAns = isContain(arr, si+1, m);
            return restAns;
        }
    }
}
