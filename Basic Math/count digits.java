/*Take the following as input.
A number
A digit
Write a function that returns the number of times digit is found in the number. Print the value returned.

Explanation:
The digit can be from 0 to 9. Assume decimal numbers


*/
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int digit=sc.nextInt();
        int count=0;
        while(n!=0) {
            int rem=n%10;
            if(rem==digit) {
                count++;
            }
            n=n/10;
        }
        System.out.println(count);
    }
}