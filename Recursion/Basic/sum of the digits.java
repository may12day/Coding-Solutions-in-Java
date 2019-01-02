/*Take as input str, a number in form of a string. Write a recursive function to find the sum of digits in the string. Print the value returned.

Input Format:
Enter the Number.





 */

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(sum_of_digit(n));
    }


    public static int sum_of_digit(int n)
    {
        if (n == 0)
            return 0;
        return (n % 10 + sum_of_digit(n / 10));
    }

}