/* Take the following as input.

A number (X)
A number (N)
Write a function which returns Log of X to the base N. Print the value returned.

Explanation:
Assume that X and N are such that Log of X to the base N will be a whole number.

*/
import java.util.*;
public class Main {
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        double m= logb(x,y);
        int n=(int)m;
        System.out.println(n);

    }
    public static double logb(double a,double b) {
        return (Math.round(Math.log(a)/Math.log(b)));
    }
}