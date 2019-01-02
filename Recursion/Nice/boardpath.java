/*Take as input N, a number. N is the size of a snakes and ladder board (without any snakes and ladders). Take as input M, a number. M is the number of faces of the dice.

a. Write a recursive function which returns the count of different ways the board can be traveled using the dice. Print the value returned.

b. Write a recursive function which prints dice-values for all valid paths across the board (void is the return type for function).

Input Format:
Enter a number N (size of the board) and number M(number of the faces of a dice)



 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int c = countBoardPath(0, n,m);
        System.out.println(c);
        printBoardPath(0, n, "",m);
    }


    public static void printBoardPath(int curr, int end, String ans,int face) {

        if (curr == end) {
            System.out.print(ans+" ");
            return;
        }

        if (curr > end) {
            return;
        }

        for (int dice = 1; dice <= face; dice++) {
            printBoardPath(curr + dice, end, ans + dice,face);
        }
    }
    public static int countBoardPath(int curr, int end,int face) {

        if (curr == end) {
            return 1;
        }

        if (curr > end) {
            return 0;
        }

        int count = 0;
        for (int dice = 1; dice <= face; dice++) {
            count += countBoardPath(curr + dice, end,face);
        }

        return count;
    }
}