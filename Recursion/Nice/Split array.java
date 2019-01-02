/*Take as input N, a number. Take N more inputs and store that in an array.

a. Write a recursive function which counts the number of ways the array could be split in two groups, so that the sum of items in both groups is equal. Each number in the array must belong to one of the two groups. Print the value returned.

b. Write a recursive function which keeps track of ways an array could be split in two groups, so that the sum of items in both groups is equal. Each number in the array must belong to one of the two groups. Return type of function should be void. Print the two groups, each time you find a successful split.

Input Format:
Take as input N, a number. Take N more inputs and store that in an array.



 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(steps(a, 0, 0, "", 0, ""));
        SplitArray(a, 0, 0, "", 0, "");

    }

    public static void SplitArray(int[] arr, int vidx, int p1sum, String p1asf, int p2sum, String p2asf) {
        if (vidx == arr.length) {
            if (p1sum == p2sum)
                System.out.println(p1asf + " and " + p2asf);
            return;
        }

        SplitArray(arr, vidx + 1, p1sum + arr[vidx], p1asf + " " + arr[vidx], p2sum, p2asf);
        SplitArray(arr, vidx + 1, p1sum, p1asf, p2sum + arr[vidx], p2asf + " " + arr[vidx]);

    }

    public static int steps(int[] arr, int vidx, int p1sum, String p1asf, int p2sum, String p2asf) {
        if (vidx == arr.length) {
            if (p1sum == p2sum)
                // System.out.println(p1asf + " and " + p2asf);
                return 1;
            else
                return 0;
        }
        int c=0;
        c = c + steps(arr, vidx + 1, p1sum + arr[vidx], p1asf + " " + arr[vidx], p2sum, p2asf);
        c = c + steps(arr, vidx + 1, p1sum, p1asf, p2sum + arr[vidx], p2asf + " " + arr[vidx]);

        return c;
    }
}

