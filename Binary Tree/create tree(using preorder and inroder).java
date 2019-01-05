/*

Given preorder and inorder create the tree


Input Format:
Enter the size of the preorder array N then add N more elements and store in the array, then enter the size of the inorder array M and add M more elements and store in the array

Output Format:
Display the tree using the display function



 */


import java.util.*;
public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        int[] pre = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(pre, in);
        bt.display();
    }

    public static int[] takeInput() {
        int n = scn.nextInt();

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
            // write your code here
            if(plo>phi)
                return null;
            Node n = new Node();
            n.data = pre[plo];

            int si = ilo;
            while(si<ihi && in[si]!=pre[plo])
            {
                si++;
            }

            int ele = si-ilo;
            n.left = construct(pre, plo+1, plo+ele, in, ilo, si-1);
            n.right = construct(pre, plo+ele+1, phi, in, si+1, ihi);
            return n;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";

            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);

            this.display(node.left);
            this.display(node.right);
        }

    }

}
