/*
Write an efficient function for extracting characters from a given string.

Input Format:
Enter a string

Output Format:
Display all the characters in a space separated manner


 */



import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception {
        Scanner s= new Scanner(System.in);
        String str= s.nextLine();
        //	uniqueChars( str);
        HashMap<Character, Boolean> map = new HashMap<>();
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(!map.containsKey(ch))
                map.put(ch, true);
        }
        Set<Character> keys = map.keySet();
        for(Character k :keys)
            System.out.print(k +" ");
    }
}