/*Print "lowercase" if user enters a character between 'a-z' , Print "UPPERCASE" is character lies between 'A-Z' and print "Invalid" for all other characters like $,.^# etc.



*/


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char c=sc.nextLine().charAt(0);


        if(c >= 97 && c <= 122)
        {
            System.out.println("lowercase");
        }
        else if(c >= 65 && c <= 90)
        {
            System.out.println("uppercase");
        }
        else if((c>=0 && c<=47) || (c>=58&& c<=64) || (c>=91 && c<=96) || (c>=123 && c<=127) || (c>=48 && c<=57))
        {
            System.out.println("invalid");
        }
    }
}