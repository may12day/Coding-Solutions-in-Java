/*
Given a Binary Tree Print all the leaf nodes.

Input Format:
Level order input of the binary tree

Output Format:
All leaf nodes from left to right in single line


 */


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Bin b = new Bin();
        b.create();
        b.leaf();

    }
    public static class Bin{
        class Node{
            int data;
            Node left;
            Node right;
        }
        Node root = null;
        public void create()
        {
            Scanner sc = new Scanner(System.in);
            LinkedList<Node> l = new LinkedList<>();
            boolean rootn = true;
            while (sc.hasNextLine())
            {
                if(rootn==true)
                {
                    int d = sc.nextInt();
                    if(d!= -1)
                    {
                        Node n = new Node();
                        n.data= d;
                        this.root = n;
                        l.add(this.root);
                        rootn = false;
                    }
                }
                else{
                    Node t = l.removeFirst();
                    int d1 = sc.nextInt();
                    if(d1!=-1){
                        Node n = new Node();
                        n.data = d1;
                        l.addLast(n);
                        t.left = n;
                    }
                    else
                        t.left = null;

                    int d2 = sc.nextInt();
                    if(d2!=-1)
                    {
                        Node n2 = new Node();
                        n2.data = d2;
                        l.addLast(n2);
                        t.right = n2;
                    }
                    else
                        t.right= null;
                }
            }
        }
        public void leaf()
        {
            this.leaf(this.root);
        }
        private void leaf(Node n)
        {
            if(n==null)
                return;
            if(n.left==null && n.right==null)
            {
                System.out.print(n.data + " ");
                return;
            }
            leaf(n.left);
            leaf(n.right);
        }
    }
}