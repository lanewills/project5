package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import doublylinkedlist.DLList.Node;

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


    public boolean contains(T obj) {
        return lastIndexOf(obj) != -1;
    }


    public void add(T object) {
        add(size, object);
    }


    public void add(int index, T object) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (object == null) {
            throw new IllegalArgumentException("Cannot add null "
                    + "objects to a list");
        }

        Node<T> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        } 
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<T> addition = new Node<T>(object);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;
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
     * @param index is the specified one index
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
     * gets the position of the last occurrence of an item
     * @param obj the item to find
     * @return index of the item, if not found -1
     */
    public int lastIndexOf(T obj) {
        Node<T> current = tail.previous();
        for (int i = this.getSize() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1;
    }
    
    /**
     * This method clears the list of all objects
     */
    public void clear() {
        head = new DoublyLinkedList.Node<T>(null);
        tail = new DoublyLinkedList.Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    /**
     * This public method represents the array list
     * @return the array representation
     */
    public Object[] toArray() {
        Object[] array = new Object[getSize()];
        Node<T> curr = head.next;
        int count = 0;
        while (curr != tail){
            array[count] = curr.getData();
            curr = curr.next;
            count++;
        }
        return array;
    }


    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");

        Node<T> curr = head.next;
        while (curr != tail) {
            builder.append(curr.data);
            curr = curr.next;
            if (curr != tail) {
                builder.append(", ");
            }
        }
        builder.append(")");
        return builder.toString();
    }

    /**
     * This method sorts the list by using the Alpha Comparator.
     */
    public void insertionSortByAlpha() {
        if (size <= 1){
            reuturn;
        }
        Node<T> curr = head.next.next;
        head.next.setNext(null);
        while (curr != tail) {
            Node<T> temp = curr.next;
            insertionToSortedAlpha(curr);
            curr = temp;
        }
        curr = curr.previous;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        curr.setNext(tail);
        tail.setPrevious(curr);

    }

    /**
     * This helper method is used to insert a node into a specified location
     * @param node that is being inserted to sorted section of list
     */
    public void insertionToSortedAlpha(Node<T> node) {
        Node<T> curr = head.next;
        Node<T> prev = null;
        while (curr != null && Race.compareAlpha(
                (Race)node.data, (Race)curr.data) > 0) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) {
            prev.setNext(node);
            node.setNext(curr);
        }
        else {
            node.setNext(curr);
            head.setNext(node);
        }
    }

    /**
     * This method sorts the list by using CFR comparator
     */
    public void insertionSortByCFR() {
        if (size <= 1) {
            return;
        }
        Node<T> curr = head.next.next;
        head.next.setNext(null);
        while (curr != tail) {
            Node<T> temp = curr.next;
            insertionToSortedCFR(curr);
            curr = temp;
        }
        curr = curr.previous;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        curr.setNext(tail);
        tail.setPrevious(curr);
    }

    /**
     * This helper method is used to insert a node into a specified location
     * @param node that is being inserted to sorted section of list
     */
    public void insertionToSortedCFR(Node<T> node) {
        Node<T> curr = head.next;
        Node<T> prev = null;
        while (curr != null && Race.compareCFR(
                (Race)node.data, (Race)curr.data) > 0) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) {
            prev.setNext(node);
            node.setNext(curr);
        }
        else {
            node.setNext(curr);
            head.setNext(node);
        }
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
