/*
Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number.

Input Format:
First line contains the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL. Second line contains the number k.

Output Format:
Display the root to leaf path whose sum is equal to k.

Explanation:
The given tree is in pre order traversal. So convert it into binary tree and check root to leaf path sum.


 */




import java.util.*;
public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        BinaryTree bt = m.new BinaryTree();
        int k = scn.nextInt();
        bt.path(k);
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {

            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

            // left
            boolean hlc = scn.nextBoolean();

            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            // right
            boolean hrc = scn.nextBoolean();

            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            // return
            return child;
        }

        public void path(int sum) {

            // write your code here
            Stack<Integer> s = new Stack<>();
            this.path(this.root, sum, s);
            while(!s.isEmpty())
            {
                int n = s.pop();
                System.out.print(n+" ");
            }
        }
        private boolean path(Node n, int sum, Stack<Integer> s)
        {
            if(sum==0 && n==null)
                return true;
            if(n==null)
                return false;
            if(sum<0)
                return false;
            boolean ans= false;
            ans = path(n.left, sum-n.data, s);
            if(ans){
                s.push(n.data);
                // System.out.print(n.data+" ");
                return ans;}
            ans =path(n.right, sum-n.data, s);
            if(ans)
                s.push(n.data);
            //System.out.print(n.data+ " ");
            return ans;
        }

    }

}
