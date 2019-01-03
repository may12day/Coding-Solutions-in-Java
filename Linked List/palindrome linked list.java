/*Check if a linked list is a palindrome.( Boolean return type )

Input Format:
Add N space separated elements in the list




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
    public void display() {
        Node node = this.head;

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

    public static boolean checkPalindrome (LinkedList list)
    {
        // Find middle node using slow and fast pointer
        Node middleNode=list.mid();
        // we got head of second part
        Node secondHead=middleNode.next;
        // It is end of first part of linked list
        middleNode.next=null;
        // get reversed linked list for second part
        Node reverseSecondHead=reverseLinkedList(secondHead);

        while(list.head!=null && reverseSecondHead!=null)
        {
            if(list.head.data==reverseSecondHead.data)
            {
                list.head=list.head.next;
                reverseSecondHead=reverseSecondHead.next;
                continue;
            }
            else
            {
                return false;
            }
        }

        return true;


    }
    public static Node reverseLinkedList(Node currentNode)
    {
        // For first node, previousNode will be null
        Node previousNode=null;
        Node nextNode;
        while(currentNode!=null)
        {
            nextNode=currentNode.next;
            // reversing the link
            currentNode.next=previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return previousNode;
    }

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();


        LinkedList listA = new LinkedList();

        for (int i = 0; i < N; i++) {
            listA.addLast(scn.nextInt());
        }

        System.out.println(checkPalindrome(listA));


    }
}


