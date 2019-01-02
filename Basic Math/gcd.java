/* Take the following as input.

        A number (N1)
        A number (N2)
        Write a function which returns the GCD of N1 and N2. Print the value returned.

Explanation:
The largest number that divides both N1 and N2 is called the GCD of N1 and N2.



*/
import java.util.*;
public class Main {
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int divi=sc.nextInt();
        int div=sc.nextInt();
        int rem=0;

        while(divi%div!=0)
        {
            rem=divi%div;
            divi=div;
            div=rem;
        }
        System.out.println(div);
    }
}