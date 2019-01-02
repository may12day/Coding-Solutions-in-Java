/*Take as input str, a string. str represents keys pressed on a nokia phone keypad. We are concerned with all possible words that can be written with the pressed keys.

Assume the following alphabets on the keys: 1 -> abc , 2 -> def , 3 -> ghi , 4 -> jkl , 5 -> mno , 6 -> pqrs , 7 -> tuv , 8 -> wx , 9 -> yz

E.g. “12” can produce following words “ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf”

a. Write a recursive function which returns the count of words for a given keypad string. Print the value returned.

b.Write a recursive function which prints all possible words for a given keypad string (void is the return type for function).

Input Format:
Enter a number




 */

import java.util.*;
public class Main {
    static int count=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st=sc.next();
        Keypad1(st,"");
        int m=count();
        System.out.println(m);
        Keypad(st, "");
    }


    public static String code(char ch) {
        if (ch == '1')
            return "abc";
        else if (ch == '2')
            return "def";
        else if (ch == '3')
            return "ghi";
        else if (ch == '4')
            return "jkl";
        else if (ch == '5')
            return "mno";
        else if (ch == '6')
            return "pqrs";
        else if (ch == '7')
            return "tuv";
        else if (ch == '8')
            return "wx";
        else if (ch == '9')
            return "yz";
        else
            return "";
    }

    public static void Keypad(String str, String ans) {

        if (str.length() == 0) {
            System.out.print(ans+ " ");
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        String code = code(ch);
        for (int i = 0; i < code.length(); i++) {
            Keypad(ros, ans + code.charAt(i));
        }

    }
    public static void Keypad1(String str, String ans) {

        if (str.length() == 0) {
            // System.out.print(ans+ " ");
            count();
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        String code = code(ch);
        for (int i = 0; i < code.length(); i++) {
            Keypad1(ros, ans + code.charAt(i));
        }

    }

    public static int count(){
        int r=count++;
        return r;
    }



}
