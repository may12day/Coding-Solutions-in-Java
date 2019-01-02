/*Take as input str, a string. Assume that value of a=1, b=2, c=3, d=4, …. z=26. Write a recursive function (return type Arraylist) to print all possible codes for the string. E.g. for “1123” possible codes are aabc, kbc, alc, aaw, kw.

Input Format:
Enter a number



 */

import java.util.*;
public class Main {
    public static char getCodeForDigit(int digit){
        return (char)(digit + 96);
    }

    public static ArrayList<String> getCodeForString(String str){
        if(str.length() == 0)
        {
            ArrayList<String> baseResult = new ArrayList<String>();
            baseResult.add("");
            return baseResult;
        }

        ArrayList<String> myResult = new ArrayList<String>();

        String d1 = str.substring(0,1);
        String ros1 = str.substring(1);
        char c1 = getCodeForDigit(Integer.parseInt(d1));
        ArrayList<String> returnList1 = getCodeForString(ros1);

        for(String s : returnList1){
            myResult.add(c1 + s);
        }

        if(str.length() > 1){
            String d2 = str.substring(0,2);
            String ros2 = str.substring(2);
            char c2 = getCodeForDigit(Integer.parseInt(d2));
            if(c2 >= 97 && c2 <= 122){
                ArrayList<String> returnList2 = getCodeForString(ros2);
                for(String s : returnList2){
                    myResult.add(c2 + s);
                }
            }
        }

        return myResult;
    }

    public static void main(String args[]) {
        // Your Code Here
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(getCodeForString(str));

    }
}

