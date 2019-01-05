/*
Given a tree and a node of tree, print all nodes which are at distance k from the given node.

Input Format:
Enter the number of nodes N and add N more numbers to the BST. Then enter the target number and value of k.

Output Format:
Display all the nodes which are at a distance k


 */




import java.util.*;
public class BST {
    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void add(int data) {
        this.add(data, this.root);
    }

    private void add(int data, Node node) {
        if (this.isEmpty()) {
            Node n = new Node(data, null, null);
            this.size++;
            this.root = n;
            return;
        } else {
            if (data > node.data && node.right == null) {
                Node n = new Node(data, null, null);
                this.size++;
                node.right = n;
            } else if (data < node.data && node.left == null) {
                Node n = new Node(data, null, null);
                this.size++;
                node.left = n;
            } else if (data > node.data) {
                add(data, node.right);
            } else if (data < node.data) {
                add(data, node.left);
            }
        }
    }

  /*     public void remove(int data) {
		this.root = this.remove(this.root, data);
	}

	private Node remove(Node node, int data) {
		if (node == null) {
			return null;
		}
		if (data < node.data) {
			node.left = this.remove(node.left, data);
			return node;
		} else if (data > node.data) {
			node.right = this.remove(node.right, data);
			return node;
		} else {
			if (node.left == null && node.right == null) {
				this.size--;
				return null;
			} else if (node.left == null) {
				this.size--;
				return node.right;
			} else if (node.right == null) {
				this.size--;
				return node.left;
			} else {
				int lmax = this.max(node.left);
				node.data = lmax;
				node.left = this.remove(node.left, lmax);
				return node;
			}
		}
	} */

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        if (node.left != null) {
            System.out.print(node.left.data + " => ");
        } else {
            System.out.print("END => ");
        }
        System.out.print(node.data);
        if (node.right != null) {
            System.out.print(" <= " + node.right.data);
        } else {
            System.out.print(" <= END");
        }
        System.out.println();
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public void printKFar(int tar, int k) {
        this.printKFar(this.root, tar, k);
    }

    private int printKFar(Node node, int tar, int k) {
        //Your Code Goes Here
        if(node==null)
            return -1;
        if(node.data==tar){
            printKDown(node, k);
            return 0;
        }
        int ld = printKFar(node.left, tar, k);
        if(ld!=-1){
            if(ld==k-1){
                System.out.print(node.data + " ");

            }
            else
                printKDown(node.right, k-ld-2);
            return ld+1;
        }

        int rd = printKFar(node.right,  tar, k);
        if(rd!=-1){
            if(rd==k-1){
                System.out.print(node.data + " ");

            }
            else
                printKDown(node.left, k-rd-2);
            return rd+1;
        }
        return -1;
    }

    private void printKDown(Node node, int k) {
        //Your Code Goes Here
        if(node==null || k<0)
            return;
        if(k==0){
            System.out.print(node.data + " ");
            return;
        }
        printKDown(node.left, k-1);
        printKDown(node.right, k-1);
    }

    public static void main (String[] args) {
        BST bst=new BST();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            bst.add(s.nextInt());
        }
        int tar=s.nextInt();
        int k=s.nextInt();
        bst.printKFar(tar,k);
    }
}
