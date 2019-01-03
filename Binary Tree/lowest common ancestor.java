/*Find LCA(Lowest Common Ancestor) of two elements in a Binary Tree.

Input Format:
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

 */





import java.util.Scanner;

public class tree {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        tree m = new tree();
        BinaryTree bt = m.new BinaryTree();
        System.out.println(bt.LCA().data);
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
        public int height(Node node){
            if(node==null)
                return 0;
            return 1+Math.max(height(node.left),height(node.right));
        }

        public Node LCA() {
            int n1=scn.nextInt();
            int n2=scn.nextInt();
            return this.LCA(this.root,n1,n2);
        }

        private Node LCA(Node node,int a,int b) {
            // write your code here
            // Base case
            if (node == null)
                return null;

            // If either n1 or n2 matches with root's key, report
            // the presence by returning root (Note that if a key is
            // ancestor of other, then the ancestor key becomes LCA
            if (node.data == a || node.data == b)
                return node;

            // Look for keys in left and right subtrees
            Node left_lca = LCA(node.left, a, b);
            Node right_lca = LCA(node.right, a, b);

            // If both of the above calls return Non-NULL, then one key
            // is present in once subtree and other is present in other,
            // So this node is the LCA
            if (left_lca!=null && right_lca!=null)
                return node;

            // Otherwise check if left subtree or right subtree is LCA
            return (left_lca != null) ? left_lca : right_lca;

        }

    }
}

}