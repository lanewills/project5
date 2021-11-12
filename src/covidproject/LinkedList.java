package covidproject;
import list.ListInterface;
/**
 * A class that implements the ADT list by using a chain of linked nodes that
 * has a head reference. First element is at entry 0.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author maellis1
 * @version Aug 2020
 */
public class LinkedList<T> implements ListInterface<T> {
	private Node firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public LinkedList() {
		initializeDataFields();
	}

	public void clear() {
		initializeDataFields();
	}

	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	
	public void add(T newEntry) // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else // Add to end of non-empty list
		{
			Node lastNode = getNodeAt(numberOfEntries - 1);
			lastNode.setNext(newNode); // Make last node reference new node
		}

		numberOfEntries++;
	}

	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 0) && (newPosition <= numberOfEntries)) {
			Node newNode = new Node(newEntry);

			if (newPosition == 0) // Case 1
			{
				newNode.setNext(firstNode);
				firstNode = newNode;
			} else // Case 2: list is not empty
			{ // and newPosition > 0
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNext();
				newNode.setNext(nodeAfter);
				nodeBefore.setNext(newNode);
			}

			numberOfEntries++;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
	}

	public T remove(int givenPosition) {
		T result = null; // Return value

		if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {

			if (givenPosition == 0) // Case 1: Remove first entry
			{
				result = firstNode.getData(); // Save entry to be removed
				firstNode = firstNode.getNext(); // Remove entry
			} else // Case 2: Not first entry
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNext();
				result = nodeToRemove.getData(); // Save entry to be removed
				Node nodeAfter = nodeToRemove.getNext();
				nodeBefore.setNext(nodeAfter); // Remove entry
			} // end if

			numberOfEntries--; // Update count
			return result; // Return removed entry
		} else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}

	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	public T getEntry(int givenPosition) {
		if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
			return getNodeAt(givenPosition).getData();
		} else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	}

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNext();
			index++;
		}

		return result;
	}

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNext();
		}

		return found;
	}

	public int getLength() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}

	// Returns a reference to the node at a given position.
	// Precondition: The chain is not empty;
	// 0 <= givenPosition <= numberOfEntries - 1.
	private Node getNodeAt(int givenPosition) {
		Node currentNode = firstNode;
		// Traverse the chain to locate the desired node
		// (skipped if givenPosition is 0)
		for (int counter = 0; counter < givenPosition; counter++)
			currentNode = currentNode.getNext();
		return currentNode;
	}

	private class Node {
		private T data;
		private Node next;

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNext() {
			return next;
		}

		private void setNext(Node nextNode) {
			next = nextNode;
		}
	}
}
