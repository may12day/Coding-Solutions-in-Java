/*Given a binary tree find sum of all the nodes.


Input Format:
Enter the value of the node then the Boolean choice i.e whether the node has a left child , then enter the left child's data . The input acts in a recursive manner i.e when the left child's children are made only then we move onto the parent's right child


Explanation:
If we enter the following values

50 true 25 true 12 false false false true 75 true 62 false false false

the tree would look like :

25 => 50 <= 75

12 => 25 <= END

END => 12 <= END

62 => 75 <= END

END => 62 <= END





 */


import java.util.*;

// end class ArrayBub
////////////////////////////////////////////////////////////////
public class subsequences {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        //subsequences m = new subsequences();
        BinaryTree bt = new BinaryTree();
        System.out.println(bt.sumOfNodes());
    }
}

class BinaryTree {
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

        int cdata = subsequences.scn.nextInt();
        Node child = new Node();
        child.data = cdata;
        this.size++;

        // left
        boolean hlc = subsequences.scn.nextBoolean();

        if (hlc) {
            child.left = this.takeInput(child, true);
        }

        // right
        boolean hrc = subsequences.scn.nextBoolean();

        if (hrc) {
            child.right = this.takeInput(child, false);
        }

        // return
        return child;
    }

    public int sumOfNodes() {
        return this.sumOfNodes(this.root) ;
    }

    private int sumOfNodes(Node node) {

        // write your code here
        int mySum,leftSum,RightSum;
        if(node==null) {
            mySum = 0;
            return mySum;
        }
        else {
            leftSum=sumOfNodes(node.left);
            RightSum=sumOfNodes(node.right);
            mySum=node.data+leftSum+RightSum;
            return mySum;
        }

    }
}