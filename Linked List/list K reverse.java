/*Given a head to Linked List L, write a function to reverse the list taking k elements at a time. Assume k is a factor of the size of List.

You need not have to create a new list. Just reverse the old one using head.



Input Format:
The first line contains 2 space separated integers N and K

The next line contains N space separated integral elements of the list.

Explanation:
N = 9 & K = 3

Original LL is : 9 -> 4 -> 1 -> 7 -> 8 -> 3 -> 2 -> 6 -> 5

After k Reverse : 1 -> 4 -> 9 -> 3 -> 8 -> 7 -> 5 -> 6 -> 2


 */


import java.util.*;

public class LinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    // O(1)
    public int size() {
        return this.size;
    }

    // O(1)
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // O(1)
    public int getFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty.");
        }

        return this.head.data;
    }

    // O(1)
    public int getLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty.");
        }

        return this.tail.data;
    }

    // O(N)
    public int getAt(int idx) throws Exception {
        Node temp = this.getNodeAt(idx);
        return temp.data;
    }

    // O(N)
    private Node getNodeAt(int idx) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        if (idx < 0 || idx >= this.size()) {
            throw new Exception("Invalid arguments");
        }

        Node retVal = this.head;
        for (int i = 0; i < idx; i++) {
            retVal = retVal.next;
        }

        return retVal;
    }

    // O(1)
    public void addFirst(int data) {
        Node node = new Node(data, this.head);

        if (this.size() == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.head = node;
        }

        this.size++;
    }

    // O(1)
    public void addLast(int data) {
        Node node = new Node(data, null);

        if (this.size() == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }

        this.size++;
    }

    // O(n)
    public void addAt(int idx, int data) throws Exception {
        if (idx < 0 || idx > this.size()) {
            throw new Exception("Invalid arguments");
        }

        if (idx == 0) {
            this.addFirst(data);
        } else if (idx == this.size()) {
            this.addLast(data);
        } else {
            Node nm1 = this.getNodeAt(idx - 1);
            Node n = nm1.next;

            Node node = new Node(data, n);
            nm1.next = node;

            this.size++;
        }
    }

    // O(1)
    public int removeFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        int retVal = this.head.data;

        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }

        this.size--;
        return retVal;
    }

    // O(n)
    public int removeLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        int retVal = this.tail.data;

        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node sm2 = this.getNodeAt(this.size() - 2);
            sm2.next = null;
            this.tail = sm2;
        }

        this.size--;
        return retVal;
    }

    // O(n)
    public int removeAt(int idx) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        if (idx < 0 || idx >= this.size()) {
            throw new Exception("Invalid arguments");
        }

        if (idx == 0) {
            return this.removeFirst();
        } else if (idx == this.size() - 1) {
            return this.removeLast();
        } else {
            Node nm1 = this.getNodeAt(idx - 1);
            Node n = nm1.next;
            Node np1 = n.next;

            nm1.next = np1;
            this.size--;

            return n.data;
        }
    }

    // O(n)
    public void display(Node head) {
        Node node = head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        //System.out.println("END");
    }

    public Node mid(){

        Node slow = this.head;
        Node fast = this.head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public Node reveseGrps(Node head, int k){
        int x = k;
        Node head_next=null;
        Node h = head;
        Node head_prev = null;
        while(h!=null && x>0){
            head_next = h.next;
            h.next = head_prev;
            head_prev = h;
            h = head_next;
            x--;
        }
        if(head_next!=null){
            head.next = reveseGrps(head_next,k);
        }
        return head_prev;

    }


    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int k=scn.nextInt();

        LinkedList listA = new LinkedList();

        for (int i = 0; i < N; i++) {
            listA.addLast(scn.nextInt());
        }


        Node mm=listA.reveseGrps(listA.head,k);


        listA.display(mm);



    }
}


