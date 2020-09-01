package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// Done: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// Done: Implement this method
		add(size, element);;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// Done: Implement this method.
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("get -> check index");
		if(index < size/2) {
			LLNode<E> currNode = head.next;
			while(index != 0) {
				currNode = currNode.next;
				index--;
			}
			return currNode.data;
		} else {
			index = size - index - 1;
			LLNode<E> currNode = tail.prev;
			while(index != 0) {
				currNode = currNode.prev;
				index--;
			}
			return currNode.data;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// Done: Implement this method
		if(element == null)
			throw new NullPointerException("add -> element == null");
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Add -> check index");
		
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> currNode;
		if(index <= size/2) {
			currNode = head.next;
			while(index != 0) {
				currNode = currNode.next;
				index--;
			}
			
		} else {
			index = size - index - 1;
			if (index == -1) {
				currNode = tail;
			} else {
				currNode = tail.prev;
				while(index != 0) {
					currNode = currNode.prev;
					index--;
				}
			}
		}
		currNode.prev.next = newNode;
		newNode.prev = currNode.prev;
		currNode.prev = newNode;
		newNode.next = currNode;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// Done: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// Done: Implement this method
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("remove -> check index");
		size--;
		if(index <= size/2) {
			LLNode<E> currNode = head.next;
			while(index != 0) {
				currNode = currNode.next;
				index--;
			}
			currNode.prev.next = currNode.next;
			currNode.next.prev = currNode.prev;
			return currNode.data;
		} else {
			index = size - index - 1;
			LLNode<E> currNode = tail.prev;
			while(index != 0) {
				currNode = currNode.prev;
				index--;
			}
			currNode.prev.next = currNode.next;
			currNode.next.prev = currNode.prev;
			return currNode.data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// Done: Implement this method
		if(element == null)
			throw new NullPointerException("set -> element == null");
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("set -> check index");
		E returnVal;
		if(index < size/2) {
			LLNode<E> currNode = head.next;
			while(index != 0) {
				currNode = currNode.next;
				index--;
			}
			returnVal = currNode.data;
			currNode.data = element;
		} else {
			index = size - index - 1;
			LLNode<E> currNode = tail.prev;
			while(index != 0) {
				currNode = currNode.prev;
				index--;
			}
			returnVal = currNode.data;
			currNode.data = element;
		}
		return returnVal;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// Done: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> pre, LLNode<E> nxt) 
	{
		this.data = e;
		this.prev = pre;
		this.next = nxt;
	}

}
