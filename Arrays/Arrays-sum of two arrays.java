/*Take as input N, the size of array. Take N more inputs and store that in an array. Take as input M, the size of second array and take M more inputs and store that in second array. Write a function that returns the sum of two arrays. Print the value returned.

Explanation:
Sum of [1, 0, 2, 9] and [3, 4, 5, 6, 7] is [3, 5, 5, 9, 6] and the first digit represents carry over , if any (0 here ) .





*/

import java.util.*;
public class Main {
    public static void printSum(int[] arr1 , int[] arr2){
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int carry = 0;

        while(i >= 0 && j >= 0){
            int digit = arr1[i] + arr2[j] + carry;
            ans.add( 0, digit % 10);
            carry = digit / 10;
            i--;
            j--;
        }

        while(i >= 0){
            int digit = arr1[i] + carry;
            ans.add(0 , digit % 10);
            carry = digit / 10;
            i--;
        }

        while(j >= 0){
            int digit = arr2[j] + carry;
            ans.add(0 , digit % 10);
            carry = digit / 10;
            j--;
        }

        if(carry != 0)
            ans.add(0,carry);

        for(int k = 0 ; k < ans.size() ; k++){
            System.out.print(ans.get(k) + ", ");
        }
        System.out.println("END");
    }
    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr1[i] = scn.nextInt();

        int m = scn.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0 ; i < m ; i++)
            arr2[i] = scn.nextInt();

        printSum(arr1 , arr2);

    }
}