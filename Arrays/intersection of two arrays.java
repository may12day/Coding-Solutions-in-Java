/*Take as input N, the size of array. Take N more inputs and store that in an array. Take N more inputs and store that in another array. Write a function which gives the intersection of two arrays in an ArrayList of integers and Print the ArrayList.

Explanation:
Check which integer is present in both the arrays and add them in an Arraylist .Print ArrayList as the ans.


 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];

        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            b[i]=sc.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);

        ArrayList<Integer> list = new ArrayList<>();
        int m=0,p=0;
        while(m<n &&p<n)
        {
            if(a[m]<b[p])
                m++;
            else
            if(b[p]<a[m])
                p++;
            else
            {
                list.add(a[m]);
                m++;
                p++;
            }
        }
        System.out.println(list);


    }
}
