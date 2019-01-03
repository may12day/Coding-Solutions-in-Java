/*Given a Binary tree, write code to create a separate array list for each level. You should return an arraylist of arraylist.


Input Format:
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL





 */


import java.util.*;
public class Main4 {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main4 m = new Main4();
        BinaryTree bt1 = m.new BinaryTree();
        System.out.println(bt1.levelArrayList());
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

        public ArrayList<ArrayList<Integer>> levelArrayList() {

            // write your code here
            LinkedList<Node> queue = new LinkedList<Node>();
            LinkedList<Node> queueHelper = new LinkedList<Node>();

            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> currentLevel = new ArrayList<Integer>();

            queue.addLast(this.root);

            while(queue.size() != 0){
                Node val = queue.removeFirst();
                currentLevel.add(val.data);

                if(val.left != null)
                    queueHelper.addLast(val.left);
                if(val.right != null)
                    queueHelper.addLast(val.right);

                if(queue.size() == 0){
                    queue = queueHelper;
                    queueHelper = new LinkedList<Node>();
                    ans.add(currentLevel);
                    currentLevel = new ArrayList<Integer>();
                }
            }

            return ans;
        }

    }

}
