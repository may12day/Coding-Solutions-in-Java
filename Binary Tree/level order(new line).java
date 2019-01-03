/*Given a binary tree. Print the level order traversal, make sure each level start at a new line.

Input Format:
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL





 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tree {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        tree m = new tree();
        BinaryTree bt = m.new BinaryTree();
        bt.levelOrderNewLine();
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

        public void levelOrderNewLine() {

            // write your code here
            Queue q = new LinkedList();
            int levelNodes =0;
            if(root==null) return;
            q.add(root);
            while(!q.isEmpty()){
                levelNodes = q.size();
                while(levelNodes>0){
                    Node n = (Node)q.remove();
                    System.out.print(" " + n.data);
                    if(n.left!=null) q.add(n.left);
                    if(n.right!=null) q.add(n.right);
                    levelNodes--;
                }
                System.out.println();
            }
        }

    }

}