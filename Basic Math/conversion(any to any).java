/*Take sb (source number system base), db (destination number system base) and sn (number in source format). Write a function that converts sn to its counterpart in destination number system. Print the value returned.

Explanation:
All input output is as integers and in separate lines.
*/
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int sb=sc.nextInt();
        int db=sc.nextInt();
        int sn=sc.nextInt();
        int val=0;
        int m=0;
        int s=0;
        int f=0;
        int k=0;
        if(sb!=10)
        {
            while(sn!=0)
            {
                int rem=sn%10;
                val=(int) (val+(rem*(Math.pow(sb, m))));
                m++;
                sn=sn/10;
            }
        }
        if(db==10)
        {
            System.out.println(val);
        }
        else {
            if(sb==10)
            {
                k=sn;
            }
            else {
                k=val;
            }
            while(k!=0)
            {
                int rem=k%db;
                f=(int) (f+(rem*(Math.pow(10,s))));
                s++;
                k=k/db;
            }
            System.out.println(f);
        }

    }
}