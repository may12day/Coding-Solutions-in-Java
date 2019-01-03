/*Take as input N, a number. N represents the size of a chess board. We’ve a piece standing in top-left corner and it must reach the bottom-right corner. The piece moves as follows –

a. In any cell, the piece moves like a knight. But out of the possible 8 moves for a knight, only the positive ones are valid i.e. both row and column must increase in a move.

b. On the walls (4 possible walls), the piece can move like a rook as well (in addition of knight moves). But, only the positive moves are allowed i.e. as a rook, piece can move any number of steps horizontally or vertically but in a manner, such that row or column must increase.

c. On the diagonals (2 possible diagonals), the piece can move like a bishop as well (in addition to the knight and possibly rook moves). But, only the positive moves are allowed i.e. as a bishop, piece can move in a way such that row and column must increase.

You are supposed to write the following functions

a. Write a recursive function which returns the count of different distinct ways this board can be crossed. Print the value returned.

b. Write a recursive function which prints all valid paths (void is the return type for function).


Input Format:
Enter the size of the chessboard N



 */

import java.util.*;
public class Main {
    static int count=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        chess2(0, 0, n-1, "");
        int m=count();
        System.out.println(m);
        chess1(0, 0, n-1, "");

    }

    public static void chess1(int cr, int cc, int n, String asf) {
        if (cr == n && cc == n) {
            System.out.print(asf + "{" + n + "-" + n + "}"+" ");
            return;
        }
        if (cr > n || cc > n)
            return;


        //knights
        chess1(cr + 2, cc + 1, n, asf + "{" + cr + "-" + cc + "}K");

        chess1(cr + 1, cc + 2, n, asf + "{" + cr + "-" + cc + "}K");

        //rook
        if (cr == 0 || cr == n || cc == 0 || cc == n) {
            //horizontal
            for (int col = 1; col <= n; col++) {
                chess1(cr, cc + col, n, asf + "{" + cr + "-" + cc + "}R");
            }

            //vertical
            for (int row = 1; row <= n; row++) {
                chess1(cr + row, cc, n, asf + "{" + cr + "-" + cc + "}R");
            }
        }

        //bishop
        if (cr == cc || cr + cc == n) {
            for (int i = 1; i <= n; i++) {
                chess1(cr + i, cc + i, n, asf + "{" + cr + "-" + cc + "}B");
            }
        }

    }
    public static void chess2(int cr, int cc, int n, String asf) {
        if (cr == n && cc == n) {
            // System.out.print(asf + "{" + n + "-" + n + "}"+" ");
            count();
            return;
        }
        if (cr > n || cc > n)
            return;


        //knights
        chess2(cr + 2, cc + 1, n, asf + "{" + cr + "-" + cc + "}K");
        chess2(cr + 1, cc + 2, n, asf + "{" + cr + "-" + cc + "}K");


        //rook
        if (cr == 0 || cr == n || cc == 0 || cc == n) {
            //horizontal
            for (int col = 1; col <= n; col++) {
                chess2(cr, cc + col, n, asf + "{" + cr + "-" + cc + "}R");
            }

            //vertical
            for (int row = 1; row <= n; row++) {
                chess2(cr + row, cc, n, asf + "{" + cr + "-" + cc + "}R");
            }
        }

        //bishop
        if (cr == cc || cr + cc == n) {
            for (int i = 1; i <= n; i++) {
                chess2(cr + i, cc + i, n, asf + "{" + cr + "-" + cc + "}B");
            }
        }

    }

    public static int count() {

        int r=count++;
        return r;
    }
}