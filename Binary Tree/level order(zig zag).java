/*Given a binary tree. Print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even levels should be printed from right to left. Each level should be printed at a new line.

Input Format:
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL



 */


import java.util.*;
import java.util.LinkedList;

public class tree {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        tree m = new tree();
        BinaryTree bt = m.new BinaryTree();
        bt.levelOrderZZ();
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

        public void levelOrderZZ() {

            // write your code here
            if (root == null) {
                return;
            }

            // declare two stacks
            Stack<Node> currentLevel = new Stack<>();
            Stack<Node> nextLevel = new Stack<>();

            // push the root
            currentLevel.push(root);
            boolean leftToRight = true;

            // check if stack is empty
            while (!currentLevel.isEmpty()) {

                // pop out of stack
                Node node = currentLevel.pop();

                // print the data in it
                System.out.print(node.data + " ");

                // store data according to current
                // order.
                if (leftToRight) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }

                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                }
                else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }

                    if (node.left!= null) {
                        nextLevel.push(node.left);
                    }
                }

                if (currentLevel.isEmpty()) {
                    leftToRight = !leftToRight;
                    Stack<Node> temp = currentLevel;
                    currentLevel = nextLevel;
                    nextLevel = temp;
                }
            }
        }
    }

}

}