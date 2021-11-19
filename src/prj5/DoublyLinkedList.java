package prj5;

import javax.xml.crypto.Data;

/**
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 */
public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     *
     * @param <D>
     */
    public static class Node<D> {
        private Data data;
        private Node<D> next;
        private Node<D> previous;

        public Node(Data d) {
            data = d;
        }


        public void setNext(Node<D> node) {
            next = node;
        }


        public void setPrevious(Node<D> node) {
            previous = node;
        }


        public Node<D> next() {
            return next;
        }


        public Node<D> previous() {
            return previous;
        }


        public Data getData() {
            return data;
        }
    }

    /**
     * New LinkedList object is being created
     */
    public DoublyLinkedList() {
        head = new DoublyLinkedList.Node<T>(null);
        tail = new DoublyLinkedList.Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(T object) {
        if (head == null) {
            return false;
        }
        Node currentElement = head;
        while (currentElement.next != null) {
            currentElement = currentElement.next;
            if (currentElement.getData().equals(object)) {
                return true;
            }
        }
        return false;
    }


    public void add(T object) {
        add(size, object);
    }


    public void add(int index, T object) {
        // How would I create a Node with object?

    }


    public boolean remove(T object) {
        boolean objectFound = false;
        if (object == null) {
            return objectFound;
        }

        Node<T> currentNode = this.head;
        while (!objectFound) {
            if (currentNode.getData().equals(object)) {
                Node<T> previousNode = currentNode.previous();
                Node<T> nextNode = currentNode.next();
                if (previousNode != null) {
                    previousNode.setNext(nextNode);
                }
                else {
                    this.head = nextNode;
                }
                if (nextNode != null) {
                    nextNode.setPrevious(previousNode);
                }
                objectFound = true;
            }
            else {
                currentNode = currentNode.next();
            }
        }
        size--;
        return objectFound;
    }


    public boolean remove(int index) {

        if (this.head == null) {
            return false;
        }
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Not a valid index");
        }
        if (index == 0) {
            Node<T> nextNode = this.head.next();
            if (nextNode != null) {
                nextNode.setPrevious(null);
            }
            this.head = nextNode;
        }
        else if (index == this.size - 1) {
            Node<T> lastNode = getLastNode(this.head);
            Node<T> secondLastNode = lastNode.previous();
            secondLastNode.setNext(null);
        }

        else {
            Node<T> nodeToBeDelete = getNodeAtIndex(index);
            Node<T> next = nodeToBeDelete.next();
            Node<T> previous = nodeToBeDelete.previous();
            next.setPrevious(previous);
            previous.setNext(next);
        }
        size--;
        return true;
    }


    private Node<T> getLastNode(Node<T> node) {
        if (node != null) {
            Node<T> lastNode = node;
            if (lastNode.next() != null) {
                return getLastNode(lastNode.next());
            }
            else {
                return lastNode;
            }
        }
        return null;
    }


    public int getPosition(T object) {
        if (head == null) {
            return -1;
        }
        int i =0;
        Node currentElement = head;
        while (currentElement.next != null) {
            currentElement = currentElement.next;
            i++;
            if (currentElement.getData().equals(object)) {
                return i;
            }
        }
        return -1;
    }


    public T getEntry(int index) {
        if (index <=0 ) {
            return null;
        }
        int i =0;
        Node currentElement = head;
        while (currentElement.next != null) {
            currentElement = currentElement.next;
            i++;
            if (i == index) {
                return currentElement.getData();
            }
        }
        return null;
    }


    public void clear() {

    }


    public Object[] toArray() {

    }


    public String toString() {

    }

    //@Jeffrey please implement these.
    //I don't know the difference between the methods
    public void insertionSortAlpha() {

    }


    public void insertionToSortedAlpha() {

    }


    public void insertionSortCFR() {

    }


    public void insertionToSortedCFR() {

    }

    /**
     * Private iterator class is being implemented
     */
    private class DLListIterator<A> implements Iterator<E> {

        private Node<E> next;
        private boolean calledNext;

        /**
         * Creates a new DLListIterator
         */
        public DLListIterator() {
            next = head;
            calledNext = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return next.next.next != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            next = next.next;
            calledNext = true;
            return next.data;
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (!calledNext) {
                throw new IllegalStateException("next has not been called yet");
            }
            else {
                next.previous.setNext(next.next);
                next.next.setPrevious(next.previous);
                size--;
                calledNext = false;
            }
        }
    }

    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> iterator() {
        return new DLListIterator<E>();
    }


    /**
     * This private method gets the node at a specific index
     * 
     * @param index
     *            is the specified one
     * @return the current node within the index
     */
    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<T> curr = head.next();
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        return curr;
    }

    /**
     * private class Node {
     * T element;
     * Node previous;
     * Node next;
     * 
     * public Node(T element, Node next, Node previous) {
     * this.element = element;
     * this.next = next;
     * this.previous = previous;
     * }
     * }
     * 
     * Node head;
     * Node tail;
     * int size;
     * 
     * public int size() {
     * return size;
     * }
     * 
     * 
     * public boolean isEmpty() {
     * return size == 0;
     * }
     * public void addFirst(T element) {
     * Node temp = new Node(element, head, null);
     * if(head != null) {
     * head.previous = temp;
     * }
     * head = temp;
     * if(tail == null) {
     * tail = temp;
     * }
     * size++;
     * }
     * 
     * public void addLast(T element) {
     * Node temp = new Node (element, null, tail);
     * if(tail != null) {
     * tail.next = temp;
     * }
     * tail = temp;
     * if(head == null) {
     * head = temp;
     * }
     * size++;
     * }
     * 
     * /*
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
