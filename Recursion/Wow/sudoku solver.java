/*You are given an N*N sudoku grid (N is a multiple of 3). Solve the sudoku and print the solution.
To learn more about sudoku, go to this link Sudoku-Wikipedia.



Input Format:
First line contains a single integer N. Next N lines contains N integers each, where jth integer int ith line denotes the value at ith row and jth column in sudoku grid. This value is 0, if the cell is empty.



Output Format:
Print N lines containing N integers each, where jth integer int ith line denotes the value at ith row and jth column in sudoku grid, such that all cells are filled.




 */

import java.util.*;
public class Main {
    static int N =9;

    static int [][]MAZE;
    public static void main(String[] args) {


        Scanner sc = new Scanner (System.in);
        int testcase = sc.nextInt();


        MAZE = new int[N][N];

        for (int i =0 ; i < 9 ; i++){

            for (int j =0 ; j < 9 ; j++){

                MAZE[i][j]=sc.nextInt();

            }

        }


        solveSudoku();


        for (int i =0 ; i < 9 ; i++){

            for (int j =0 ; j < 9 ; j++){


                System.out.print(MAZE[i][j]+" ");
            }
            System.out.println();
        }

    }



    public static boolean solveSudoku(){


        int row =10;
        int col =10;


        for (int i =0 ; i < 9 ; i++){

            for (int j =0 ; j < 9 ; j++){


                if(MAZE[i][j]==0){
                    row = i;
                    col = j;

                    break;
                }

            }

            if(row!=10 && col!=10){
                break;
            }
        }

        if(row==10 && col==10){
            return true;
        }


        for (int i =1 ; i <=9 ; i++){

            if(issafe(row, col, i)){
                MAZE[row][col]=i;
                //visited[row][col]=true;

                if(solveSudoku()){

                    return true;
                }

                MAZE[row][col]=0;
                //visited[row][col]=false;
            }


        }



        return false;


    }



    public static boolean issafe(int i , int j , int num){

        if (MAZE[i][j]!=0){
            return false;
        }
        for (int x= 0 ; x <9 ; x++){

            if(MAZE[i][x]==num || MAZE[x][j]==num){

                return false;
            }
        }

        for (int x = 0 ; x < 3 ; x++){

            for (int y=0; y < 3 ; y++){

                if(MAZE[x+i-i%3][y+j-j%3]==num){

                    return false;
                }
            }
        }

        return true;
    }



}
