/*Take as input N. N is the number of rows and columns on a square board. Our player starts in top-left corner of the board and must reach bottom-right corner. In one move the player can move 1 step horizontally (right) or 1 step vertically (down) or 1 step diagonally (south-east). But the diagonal step is allowed only when the player is currently on one of the diagonals (there are two diagonals)

a. Write a recursive function which returns the count of different ways the player can travel across the board. Print the value returned.

b. Write a recursive function which prints moves for all valid paths across the board (void is the return type for function).

Input Format:
Enter the number N.



 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        System.out.println(count(N, 0, 0));
        print(N, 0, 0, "");
    }
    public static int count(int N, int r, int c){
        if(r == N -1 && c == N - 1)
            return 1;

        if(r >= N || c >= N || r < 0 || c < 0)
            return 0;

        if(r == c || r == N - c - 1)
            return count(N, r + 1, c) + count(N, r, c + 1) + count(N, r + 1, c + 1);

        else return count(N, r + 1, c) + count(N, r, c + 1);
    }

    public static void print(int N, int r, int c, String pathSoFar){
        if((r == N - 1) && (c == N - 1)){
            System.out.print(pathSoFar +  " " );
            return;
        }

        if(r == N || c == N)
            return;


        print(N, r + 1, c, pathSoFar + "V");
        print(N, r, c + 1, pathSoFar + "H");
        if(r == c || r == N - 1 - c)
            print(N, r + 1, c + 1, pathSoFar + "D");

    }

}