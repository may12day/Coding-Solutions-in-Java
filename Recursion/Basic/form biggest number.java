/*You are provided an array of numbers. You need to arrange them in a way that yields the largest value.


Input Format:
First line contains integer t which is number of test case. For each test case, it contains an integer n which is the size of array A[] and next line contains n space separated integers A[i] .





 */

import java.util.*;
public class Main {
    public static int compare(String x , String y){
        String a = x + y;
        String b = y + x;

        int result = a.compareTo(b) > 0 ? -1 : 1;
        return result;
    }

    public static void sort(String[] arr , int n){
        for(int i = 0 ; i < n -1; i++){
            for(int j = 0 ; j < n - i - 1 ; j++){
                if(compare(arr[j] , arr[j + 1]) == 1){
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i = 0 ; i < n ; i++)
            System.out.print(arr[i]);
    }
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t > 0){
            int n = scn.nextInt();
            String[] arr = new String[n];
            for(int i = 0 ; i < n ; i++)
                arr[i] = scn.next();
            sort(arr , n);
            System.out.println();

            t--;
        }
    }
}