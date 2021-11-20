package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
     * New LinkedList object is being created
     */
    public DoublyLinkedList() {
        head = new DoublyLinkedList.Node<T>(null);
        tail = new DoublyLinkedList.Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    /**
     * gets the number of items in the list
     * @return number of items
     */
    public int getSize() {
        return size;
    }

    /**
     * tells whether or not the list is empty.
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(T object) {
        if (head == null) {
            return false;
        }
        Node<T> currentElement = head;
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
        Node<T> currentElement = head;
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
        Node<T> currentElement = head;
        while (currentElement.next != null) {
            currentElement = currentElement.next;
            i++;
            if (i == index) {
                return currentElement.getData();
            }
        }
        return null;
    }
    
    /**
     * Iterator method creates an Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new DLListIterator<T>();
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
    private class DLListIterator<A> implements Iterator<T> {

        private Node<T> next;
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
        public T next() {
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
     * internal private class for a node which makes up
     * the doubly linked list and stores data
     * @param <T> the type of object to be stored.
     * @version 2021.11.16
     * @author lane wills (lane20)
     * @author Jeffrey Zheng (jeffreyz)
     * @author Ananya Chilakamarthi (ananyac)
     */
    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T d) {
            data = d;
        }


        public void setNext(Node<T> node) {
            next = node;
        }


        public void setPrevious(Node<T> node) {
            previous = node;
        }


        public Node<T> next() {
            return next;
        }


        public Node<T> previous() {
            return previous;
        }


        public T getData() {
            return data;
        }
    }
}
