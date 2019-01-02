/*Take as input N1 and N2, both numbers. N1 and N2 is the number of rows and columns on a rectangular board. Our player starts in top-left corner of the board and must reach bottom-right corner. In one move the player can move 1 step horizontally (right) or 1 step vertically (down).

a. Write a recursive function which returns the count of different ways the player can travel across the board. Print the value returned.

b. Write a recursive function which returns an ArrayList of moves for all valid paths across the board. Print the value returned.

e.g. for a board of size 3,3; a few valid paths will be “HHVV”, “VVHH”, “VHHV” etc. c. Write a recursive function which prints moves for all valid paths across the board (void is the return type for function).


Input Format:
Enter the number of rows N and columns M


 */

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(countMazePath(1, 1, n1, n2));
        printMazePath(1,1,n1,n2,"");

    }


    public static void printMazePath(int cr, int cc, int er, int ec, String ans) {

        if (cr == er && cc == ec) {
            System.out.print(ans+" ");
            return;
        }

        if (cr > er || cc > ec) {
            return;
        }

        printMazePath(cr + 1, cc, er, ec, ans + "V");
        printMazePath(cr, cc + 1, er, ec, ans + "H");


    }
    public static int countMazePath(int cr, int cc, int er, int ec) {

        if (cr == er && cc == ec) {
            return 1;
        }

        if (cr > er || cc > ec) {
            return 0;
        }

        int ch = countMazePath(cr, cc + 1, er, ec);
        int cv = countMazePath(cr + 1, cc, er, ec);

        return ch + cv;
    }

}