// Simplified singly linked list class

package Lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>{

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

	public LinkedList(T e) {
		size = 1;
		head = new ListNode<T>();
		head.element = e;
		tail = head;
	}

	public void addToFront(T e) {
		ListNode<T> newNode = new ListNode<T>();
		newNode.element = e;
		newNode.next = head;
		head = newNode;
		size++;
		if (size == 1) {
			tail = head;
		}
	}

	public void addToRear(T e) {
		ListNode<T> newNode = new ListNode<T>();
		if (isEmpty()) {
			addToFront(e);
		} else {
			newNode.element = e;
			newNode.next = null;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
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
		size--;
		if (isEmpty()) {
			tail = null;
		}
		return ret;
	}

	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		T ret = tail.element;
		ListNode<T> newLast = head;
		while (newLast.next != tail) {
			newLast = newLast.next;
		}
		tail = newLast;
		tail.next = null;
		return ret;
	}

	public Iterator<T> iterator() {
		return new ListIterator<T>(head);
	}

	private class ListIterator<E> implements Iterator<E> {
		private ListNode<E> current;

		public ListIterator(ListNode<E> start) {
			current = start;
		}

		public boolean hasNext() {
			return (current != null);
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E ret = current.element;
			current = current.next;
			return ret;
		}

		public void remove() {
		}

	}
}
