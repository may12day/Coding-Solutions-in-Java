/*Take as input N, a number. N represents the size of a chess board. The cells in board are numbered. The top-left cell is numbered 1 and numbering increases from left to right and top to bottom. E.g. The following is the chessboard for a value of n=4.

1     2    3    4

5     6    7    8

9     10   11   12

13    14   15   16
Prime numbers act as mines and ports alternately i.e. first prime number is a mine while second is a port and so on. Piece can go over a mine but cannot stop on it. Piece can directly move from a port to the destination (but may not chose to).

We’ve a piece standing in top-left corner and it must reach the bottom-right corner. The piece moves as follows –

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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] arr = makesPrimeArray(n*n);
        int[] mnp=makePortMines(arr);
        chess3(0, 0, n-1, "",mnp);
        int m=count();
        System.out.println(m);
        chess1(0,0,n-1,"",mnp);
    }

    public static void chess1(int cr, int cc, int n, String asf,int[] mnp) {
        if (cr == n && cc == n) {
            System.out.print(asf + "{" + n + "-" + n + "}" + " ");
            return;
        }
        if (cr > n || cc > n)
            return;

        int val = ((n + 1) * cr + (cc + 1));

        //mine
        if(mnp[val]==1)
            return;
            //port
        else if(mnp[val]==2)
            chess1(n,n,n,asf+ "{" + cr + "-" + cc + "}P",mnp);


        //knights
        chess1(cr + 2, cc + 1, n, asf + "{" + cr + "-" + cc + "}K",mnp);

        chess1(cr + 1, cc + 2, n, asf + "{" + cr + "-" + cc + "}K",mnp);

        //rook
        if (cr == 0 || cr == n || cc == 0 || cc == n) {
            //horizontal
            for (int col = 1; col <= n; col++) {
                chess1(cr, cc + col, n, asf + "{" + cr + "-" + cc + "}R",mnp);
            }

            //vertical
            for (int row = 1; row <= n; row++) {
                chess1(cr + row, cc, n, asf + "{" + cr + "-" + cc + "}R",mnp);
            }
        }

        //bishop
        if (cr == cc || cr + cc == n) {
            for (int i = 1; i <= n; i++) {
                chess1(cr + i, cc + i, n, asf + "{" + cr + "-" + cc + "}B",mnp);
            }
        }

    }

    public static boolean[] makesPrimeArray(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i < primes.length; i++) {
            int divisor = 2;
            boolean flag = true;

            while (divisor <= i - 1) {
                if (i % divisor == 0) {
                    flag = false;
                }
                divisor = divisor + 1;
            }
            if (flag == true)
                primes[i] = true;
            else
                primes[i] = false;
        }
        return primes;
    }

    public static int[] makePortMines(boolean[] primes) {
        int[] mnp = new int[primes.length];
        int count = 1;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                if (count % 2 == 0) {
                    mnp[i] = 2;
                } else {
                    mnp[i] = 1;
                }
                count++;
            }
        }
        return mnp;
    }
    public static void chess3(int cr, int cc, int n, String asf, int[] mnp) {
        if (cr == n && cc == n) {
            //System.out.print(asf + "{" + n + "-" + n + "}" + " ");
            count();
            return;
        }
        if (cr > n || cc > n)
            return;

        int val = ((n + 1) * cr + (cc + 1));

        //mine
        if(mnp[val]==1)
            return;
            //port
        else if(mnp[val]==2)
            chess3(n,n,n,asf+ "{" + cr + "-" + cc + "}P",mnp);


        //knights
        chess3(cr + 2, cc + 1, n, asf + "{" + cr + "-" + cc + "}K",mnp);

        chess3(cr + 1, cc + 2, n, asf + "{" + cr + "-" + cc + "}K",mnp);

        //rook
        if (cr == 0 || cr == n || cc == 0 || cc == n) {
            //horizontal
            for (int col = 1; col <= n; col++) {
                chess3(cr, cc + col, n, asf + "{" + cr + "-" + cc + "}R",mnp);
            }

            //vertical
            for (int row = 1; row <= n; row++) {
                chess3(cr + row, cc, n, asf + "{" + cr + "-" + cc + "}R",mnp);
            }
        }

        //bishop
        if (cr == cc || cr + cc == n) {
            for (int i = 1; i <= n; i++) {
                chess3(cr + i, cc + i, n, asf + "{" + cr + "-" + cc + "}B",mnp);
            }
        }

    }
    public static int count() {

        int r=count++;
        return r;
    }



}