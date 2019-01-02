/*Write a program that works as a simple calculator.

1.It reads a character (ch)
2.If ch is among '+', '-', '*', '/' or '%' it furthur takes two numbers (N1 and N2 as input). It then performs appropriate appropriate operation between numbers and print the number. 3.If ch is 'X' or 'x', the program terminates.
4.If ch is any other character, the program should print 'Invalid operation. Try again.' and seek inputs again (starting from character).

Write code to achieve above functionality.

Explanation:
Maybe use a do-while.

*/


import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            char ch = sc.next().charAt(0);
            if(ch== 'x' || ch=='X')
                System.exit(0);
            else if(ch!='+' && ch!='-' && ch!='%' && ch!='/' && ch!='*')
            {
                System.out.println("Invalid operation. Try again.");
            }
            else
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                int val=0;
                switch(ch)
                {
                    case '+':
                        val = n1+n2;
                        break;
                    case '-':
                        val = n1-n2;
                        break;
                    case '/':
                        val = n1/n2;
                        break;
                    case '*':
                        val = n1*n2;
                        break;
                    case '%':
                        val = n1%n2;
                        break;
                }
                System.out.println(val);
            }

        }
    }
}
