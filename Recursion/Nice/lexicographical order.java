/*Take as input N, a number. Write a recursive function which prints counting from 1 to N in lexicographical order. In lexicographical (dictionary) order 10, 100 and 109 will be printed before 11.


Input Format:
Enter a number N.





 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        System.out.print("0" + " ");
        lexico(f, 1);
    }

    public static void lexico(int n, int k) {
        if(k>n)
            return;

        for(int i=0;i<10;i++)
        {
            if(k<=n)
                System.out.print(k+" ");
            k=k*10;
            lexico(n,k);
            k=k/10;
            k++;
            if(k%10==0)
                return;
        }
    }
}
