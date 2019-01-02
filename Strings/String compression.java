/*Take as input S, a string. Write a function that does basic string compression. Print the value returned. E.g. for input “aaabbccds” print out a3b2c2ds.

Explanation:
In the given sample test case 'a' is repeated 3 times consecutively, 'b' is repeated twice, 'c' is repeated twice. But, 'd' and 's' occurred only once that's why we do not write their occurrence.





*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String temp=sc.next();
        int count = 1;

        char last = temp.charAt(0);

        StringBuilder output = new StringBuilder();
        for(int i = 1; i < temp.length(); i++){
            if(temp.charAt(i) == last){
                count++;
            }else{
                if(count > 1){
                    output.append(""+last+count);
                }else{
                    output.append(last);
                }
                count = 1;
                last = temp.charAt(i);
            }
        }
        if(count > 1){
            output.append(""+last+count);
        }else{
            output.append(last);
        }
        System.out.println(output.toString());
    }
}