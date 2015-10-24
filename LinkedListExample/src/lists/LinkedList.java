package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

	private int size;
	private ListNode<T> head;
	private ListNode<T> tail;

	private static class ListNode<T> {
		private T element;
		private ListNode<T> next;
	}
	
	public LinkedList() {
		size = 0;
		head = tail = null;
	}
	
	public void addToFront(T e) {
		ListNode<T> newNode = new ListNode<T>();
		newNode.element = e;
		newNode.next = head;
		head = newNode;
		size ++;
		if (size == 1) {
			tail = head;
		}
	}
	
	public void addToRear(T e) {
		if (isEmpty()) {
			addToFront(e);
		}
		else {
			ListNode<T> newNode = new ListNode<T>();
			newNode.element = e;
			newNode.next = null;
			tail.next = newNode;
			tail = newNode;
		}
		size ++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size <= 0);
	}

	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		T ret = head.element;
		head = head.next;
		size --;
		if (isEmpty()) {
			tail = null;
		}
		if (size == 1) {
			tail = head;
		}
		return ret;
	}
	
	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		T ret = tail.element;
		if (size == 1) {
			ret = removeFirst();
		}
		else {
			ListNode<T> newLast = head;
			while (newLast.next != tail) {
				newLast = newLast.next;
			}
			tail = newLast;
			tail.next = null;
			size --;
		}
		return ret;
	}
	
	public String toString() {
		String ret = "head -> ";
		ListNode<T> current = head;
		while (current != null) {
			ret += current.element + " -> ";
			current = current.next;
		}
		return ret + "tail";
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
		return new ListIterator<T>(head);
	}
	
	private class ListIterator<E> implements Iterator<E> {
		private ListNode<E> current;
		
		public ListIterator(ListNode<E> start) {
			current = start;
		}
		
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No more elements");
			}
			E ret = current.element;
			current = current.next;
			return ret;
		}

		@Override
		public void remove() {
			// Do Nothing			
		}
		
	}
}
