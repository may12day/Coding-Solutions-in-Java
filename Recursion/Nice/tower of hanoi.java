/*Google Tower of Hanoi.

a. Write a recursive function which prints the steps required to solve the tower of Hanoi problem for N discs.

b. Write a recursive function which returns number of steps required to solve the tower of Hanoi problem for N discs.

Input Format:
Enter the number of discs



 */

import java.util.*;
public class Main {
    static int c=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nDisks = sc.nextInt();
        doTowers(nDisks, "T1", "T3", "T2");
        //System.out.println(steps(nDisks,"T1","T3","T2"));
        int z=(int) Math.pow(2,nDisks)-1;
        System.out.println(z);
    }
    public static void doTowers(int topN, String from, String inter, String to) {
        if (topN == 1) {
            System.out.println("Move 1th disc from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Move " + topN+"th disc " + "from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
   /* public static int steps(int topN, String from, String inter, String to) {
        if (topN == 1) {
            //System.out.println("Move 1th disc from " + from + " to " + to);
            return 1;
        }
        else{
            c=c+steps(topN - 1, from, to, inter);
           // System.out.println("Move " + topN+"th disc " + "from " + from + " to " + to);
           c=c+ steps(topN - 1, inter, from, to);
        }
        return c;
    }*/
}
