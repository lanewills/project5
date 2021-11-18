package prj5;

/**
 * @version 2021.11.16
 */
public class DoublyLinkedList<T> {
    private class Node {
        T element;
        Node previous;
        Node next;

        public Node(T element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

    Node head;
    Node tail;
    int size;

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }
    public void addFirst(T element) {
        Node temp = new Node(element, head, null);
        if(head != null) {
            head.previous = temp;
        }
        head = temp;
        if(tail == null) {
            tail = temp;
        }
        size++;
    }
    
    public void addLast(T element) {
        Node temp = new Node (element, null, tail);
        if(tail != null) {
            tail.next = temp;
        }
        tail = temp;
        if(head == null) {
            head = temp;
        }
        size++;
    }

    /*
     * public void addNode(int data) {
     * Node newNode = new Node(data);
     * 
     * if (head == null) {
     * head = newNode;
     * tail = newNode;
     * 
     * head.previous = null;
     * tail.next = null;
     * 
     * }
     * else {
     * tail.next = newNode;
     * newNode.previous = tail;
     * tail = newNode;
     * tail.next = null;
     * }
     * }
     */
}
