/*
Take as input N, a number. N is the size of a snakes and ladders board. There are no snakes but we’ve ladders from 1st prime number to last prime number in range, 2nd prime number to 2nd from last prime number and so-on.

a. Write a recursive function which returns the count of different distinct ways this board can be crossed with a normal dice. Print the value returned.

b. Write a recursive function which prints all valid paths (void is the return type for function).


Input Format:
Enter the size of the snake and ladders board N


Output Format:
Display the number of ways in which the board can be crossed and also display all the possible ways to cross the board in a comma separated manner




 */
import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner scn  = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> lisp = new ArrayList<>();
        for(int i = 2; i<=n; i++)
        {
            if(isPrime(i))
                lisp.add(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<lisp.size()/2; i++)
        {
            int a = lisp.get(i);
            int b = lisp.get(lisp.size()-1-i);
            map.put(a, b);
        }
        System.out.println(PPC(0, n,map));
        PP(0,n, map, "");

    }

    public static boolean isPrime(int n)
    {
        int i = 2;
        while(i<=n/2)
        {
            if(n%i==0)
                return false;
            i++;
        }
        return true;
    }

    public static int PPC(int curr, int end, HashMap<Integer, Integer> map)
    {
        if(curr==end)
        {
            return 1;
        }
        int ans =0;
        if(curr<end)
        {
            for(int dice =1; dice<=6; dice++)
            {
                if(map.containsKey(curr+dice))
                    ans = ans + PPC(map.get(curr+dice), end, map);
                else
                    ans = ans + PPC(curr+dice, end, map);
            }
        }
        return ans;
    }

    public static void PP(int curr, int end, HashMap<Integer, Integer> map, String s)
    {
        if(curr==end)
        {
            System.out.print(s + "END , ");
        }
        if(curr<end)
        {
            for(int dice =1; dice<=6; dice++)
            {
                if(map.containsKey(curr+dice))
                    PP(map.get(curr+dice), end, map, s+curr+" "+(curr+dice)+" ");
                else
                    PP(curr+dice, end, map, s+curr+" ");
            }
        }
    }
}
