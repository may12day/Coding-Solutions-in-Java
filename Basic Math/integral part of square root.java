/* Take the following as input.

A number (N)
Write a function which returns the integral part of square root of N. Print the value returned.

Explanation:
Just print the integral part of square root of number.

*/
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        double n=sc.nextDouble();
        double sqr;

        sqr=Math.sqrt(n);
        double frac=sqr%1;
        double i=sqr-frac;

        int value=(int)i;
        System.out.println(value);



    }
}