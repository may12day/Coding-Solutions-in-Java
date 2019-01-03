/*Given a binary tree print all nodes that don’t have a sibling

Input Format:
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL






 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class tree {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        tree m = new tree();
        BinaryTree bt = m.new BinaryTree();
        bt.sibling();
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

        public void sibling() {
            this.sibling(this.root);
        }

        private void sibling(Node node) {
            // write your code here
            if (node == null)
                return;

            // If this is an internal node, recur for left
            // and right subtrees
            if (node.left != null && node.right != null)
            {
                sibling(node.left);
                sibling(node.right);
            }

            // If left child is NULL and right is not, print right child
            // and recur for right child
            else if (node.right != null)
            {
                System.out.print(node.right.data + " ");
                sibling(node.right);
            }

            // If right child is NULL and left is not, print left child
            // and recur for left child
            else if (node.left != null)
            {
                System.out.print( node.left.data + " ");
                sibling(node.left);
            }

        }

    }

}