/*Take N (number in octal format). Write a function that converts it to binary format. Print the value returned.

Explanation:
Both input and output are integers

*/
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int val=0;
        int m=0;
        int s=0;
        int f=0;
        while(n!=0)
        {
            int rem=n%10;
            val=(int) (val+(rem*(Math.pow(8, m))));
            m++;
            n=n/10;
        }
        int k=val;
        while(k!=0)
        {
            int rem=k%2;
            f=(int) (f+(rem*(Math.pow(10,s))));
            s++;
            k=k/2;
        }
        System.out.println(f);
    }
}