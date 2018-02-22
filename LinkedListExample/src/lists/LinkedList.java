package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

	private ListNode<T> head;
	private ListNode<T> tail;
	private int size;
	
	private class ListNode<E> {
		private E element;
		private ListNode<E> next;
		
		public ListNode(E element, ListNode<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	public LinkedList() {
		size = 0;
		head = tail = null;
	}
	
	public void addToFront(T e) {
		
		// Create a new node that has the old head as its next
		ListNode<T> newNode = new ListNode<T>(e, head);
		
		// If the list was empty, this is the first node so set the tail
		if (size == 0) {
			tail = newNode;
		}
		
		// The head should refer to the new node (which is now the first node)
		head = newNode;
		
		size ++;
	}
	
	public void addToRear(T e) {
		if (isEmpty()) {
			addToFront(e);
		}
		else {
			ListNode<T> newTail = new ListNode<T>(e, null);
			tail.next = newTail;
			tail = newTail;
		}
		size++;
	}
	
	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		
		// Get the element from the head node
		T ret = head.element;
		
		// Set the head to the old head's next
		head = head.next;
		size --;
		
		// If there is only one thing left in the list, set the tail to the head
		if (size == 1) {
			tail = head;
		}
		
		return ret;
	}
	
	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		
		// Get the element from the head node
		T ret = tail.element;
		
		if (size == 1) {
			removeFirst();
		}
		else {
			// Find the new tail, traverse from the head
			ListNode<T> newTail = head;
			while (newTail.next != tail) {
				newTail = newTail.next;
			}
			tail = newTail;
			tail.next = null;
			size --;
		}

		return ret;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public String toString() {
		String ret = "head -> ";
		
		// Traverse the lis
		ListNode<T> current = head;
		while (current != null) {
			ret += current.element + " -> ";
			current = current.next;
		}
		return ret += "tail";
	}

	
	public T first() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		return head.element;
	}	
	public T last() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		return tail.element;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(head);
	}
	
	private class LinkedListIterator<E> implements Iterator<E> {

		private ListNode<E> current;

		public LinkedListIterator(ListNode<E> start) {
			this.current = start;
		}

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("Empty list");
			}
			E ret = current.element;
			current = current.next;
			return ret;
		}
	}
}
