/* Take the following as input.

A number (N1)
A number (N2)
Write a function which returns the LCM of N1 and N2. Print the value returned.

Explanation:
The smallest number that is divisible by both N1 and N2 is called the LCM of N1 and N2.



*/
import java.util.*;
public class Main {
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int divi=sc.nextInt();
        int div=sc.nextInt();
        int rem=0,gcd=0,a,b;
        int lcm=0;

        a=divi;
        b=div;

        while(a%b!=0)
        {
            rem=a%b;
            a=b;
            b=rem;
        }

        gcd=b;

        lcm=(div*divi)/gcd;
        System.out.println(lcm);

    }
}