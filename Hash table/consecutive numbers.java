/*
You are given with an array of integer contain number in no particular order. Write a program find the longest possible sequence of consecutive numbers using the numbers from the array. Best solution takes O(n) time.

Input Format:
Enter the size of the array N and take N more inputs and store in the array

Output Format:
Display the consecutive numbers in a space separated manner

Explanation:
Input = [2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6] Output = [8, 9, 10, 11, 12] Input = [15, 13, 23, 21, 19, 11, 16] Output = [15, 16]


 */



import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer, Boolean> map = new HashMap<>();
        int[] a = new int[n];
        for(int i =0; i<n; i++)
            a[i] = scn.nextInt();
        for(int i =0; i<n; i++)
        {
            if(map.containsKey(a[i]-1))
            {
                map.put(a[i], false);
            }
            else
                map.put(a[i],true);
            if(map.containsKey(a[i]+1))
            {
                map.put(a[i]+1, false);
            }
        }
        int count=0;
        int max=0;
        int val =0;
        for(Integer k : map.keySet())
        {
            if(map.get(k)){
                while(map.get(k+count)!= null)
                {
                    count++;
                }
                if(max<count){
                    max= count;
                    val = k;
                }
                count =0;
            }
        }
        while(max>0)
        {
            System.out.print(val++ + " ");

            max--;
        }
    }
}
	