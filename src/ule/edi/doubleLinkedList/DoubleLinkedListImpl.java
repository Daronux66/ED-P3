package ule.edi.doubleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;

public class DoubleLinkedListImpl<T> implements DoubleList<T> {
	
	
	//	referencia al primer nodo de la lista
	private DoubleNode<T> front;
	
	//	referencia al Último nodo de la lista
	private DoubleNode<T> last;
	
	
	private class DoubleNode<T> {
		
		DoubleNode(T element) {
			this.elem = element;
			this.next = null;
			this.prev = null;
		}
		
		T elem;
		
		DoubleNode<T> next;
	    DoubleNode<T> prev;
	}

///// ITERADOR normal //////////

	@SuppressWarnings("hiding")
	private class DobleLinkedListIterator<T> implements Iterator<T> {
		  // añadir atributos
	 
		
       	
		public DobleLinkedListIterator(DoubleNode<T> nodo) {
			// todo
			
				}
		
		@Override
		public boolean hasNext() {
			
			// todo
			return false;
		}

		@Override
		public T next() {
			// todo

			return null;
			
				}

		
	}
	
	////// FIN ITERATOR
	
	
	
	/// TODO :  AÑADIR OTRAS CLASES PARA LOS OTROS 3 ITERADORES
	
	
    /////
	
	@SafeVarargs
	public DoubleLinkedListImpl(T...v ) {
		for (T elem:v) {
			this.insertLast(elem);
		}
	}


	@Override
	public boolean isEmpty() {
		return (front.prev==null && last.next==null);
	}


	@Override
	public void clear() {
		front.prev=null;
		last.next=null;
	}


	@Override
	public void insertFirst(T elem) {
		if(elem==null) throw new NullPointerException();
		DoubleNode<T> obj = new DoubleNode<T>(elem); 
		if(isEmpty()) {
			front=obj;
			obj.next=last;
		}
		else {
			obj.next=front;
			front.prev=obj;
			front=obj;
		}
		obj.prev=null;
	}


	@Override
	public void insertLast(T elem) {
		if(elem==null) throw new NullPointerException();
		DoubleNode<T> obj = new DoubleNode<T>(elem); 
		if(isEmpty()) {
			last=obj;
			obj.prev=front;
		}
		else {
			last.next=obj;
			obj.prev=last;
			last=obj;
		}
		obj.next=null;
		
	}


	@Override
	public T removeFirst() throws EmptyCollectionException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T removeLast()  throws EmptyCollectionException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertPos(T elem, int position) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertBefore(T elem, T target) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public T getElemPos(int position) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getPosFirst(T elem) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getPosLast(T elem) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public T removePos(int pos) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int removeAll(T elem) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean contains(T elem) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String toStringReverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoubleList<T> reverse() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int maxRepeated() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isEquals(DoubleList<T> other) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(DoubleList<T> other) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isSubList(DoubleList<T> other) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String toStringFromUntil(int from, int until) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
     return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> reverseIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterator<T> evenPositionsIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterator<T> progressIterator() {
		// TODO Auto-generated method stub
		return null;
	}


}
