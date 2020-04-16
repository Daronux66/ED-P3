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
		return (front==null && last==null);
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
		if(isEmpty()) last=front=obj;
		else {
			obj.next=front;
			front.prev=obj;
			front=obj;
			front.prev=null;
		}
	}


	@Override
	public void insertLast(T elem) {
		if(elem==null) throw new NullPointerException();
		DoubleNode<T> obj = new DoubleNode<T>(elem); 
		if(isEmpty()) last=front=obj;
		else {
			obj.prev=last;
			last.next=obj;
			last=obj;
			last.next=null;
		}		
	}


	@Override
	public T removeFirst() throws EmptyCollectionException{
		if(isEmpty()) throw new EmptyCollectionException("COLA VACIA");
		DoubleNode<T> obj = new DoubleNode<T>(front.elem);
		front=front.next;
		front.prev=null;
		return obj.elem;
	}


	@Override
	public T removeLast()  throws EmptyCollectionException{
		if(isEmpty()) throw new EmptyCollectionException("COLA VACIA");
		DoubleNode<T> obj = new DoubleNode<T>(front.elem);
		last=last.prev;
		last.next=null;		
		return obj.elem;
	}


	@Override
	public void insertPos(T elem, int position) {
		if(elem==null) throw new NullPointerException();
		if(position<=0) throw new IllegalArgumentException();
		if (position>size()) insertLast(elem);
		else {
			DoubleNode<T> aux = front;
			int posCounter=1;
			while(aux!=null) {
				if(posCounter==position) {
					DoubleNode<T> obj = new DoubleNode<T>(elem);
					aux.prev=obj;
					obj.next=aux;
					obj.prev=aux.prev;
					aux.prev.next=obj;
					aux=last;
				}
				posCounter++;
				aux=aux.next;
			}
		}
	}


	@Override
	public void insertBefore(T elem, T target) {
		if(elem==null || target==null) throw new NullPointerException();
		if(!contains(target)) throw new NoSuchElementException();
		DoubleNode<T> aux = front;
		while(aux!=null) {
			if(aux.elem==target) {
				DoubleNode<T> obj = new DoubleNode<T>(elem);
				aux.prev=obj;
				obj.next=aux;
				obj.prev=aux.prev;
				aux.prev.next=obj;
				aux=last;
			}
			aux=aux.next;
		}

	}


	@Override
	public T getElemPos(int position) {
		if(position<1 || position>size()) throw new IllegalArgumentException();
		DoubleNode<T> obj = new DoubleNode<T>(null);
		DoubleNode<T> aux = front;
		int posCounter=1;
		while(aux!=null) {
			if(posCounter==position) {
				obj.elem = aux.elem;
				aux=last;
			}
			aux=aux.next;
		}
		return obj.elem;
	}


	@Override
	public int getPosFirst(T elem) {
		if(elem==null) throw new NullPointerException();
		if(!contains(elem)) throw new NoSuchElementException();
		int pos=0;
		DoubleNode<T> aux = front;
		while(aux!=null) {
			pos++;
			if(elem==aux.elem) aux=last;
			aux=aux.next;
		}
		return pos;
	}


	@Override
	public int getPosLast(T elem) {
		if(elem==null) throw new NullPointerException();
		if(!contains(elem)) throw new NoSuchElementException();
		int pos=0;
		DoubleNode<T> aux = last;
		while(aux!=null) {
			pos++;
			if(elem==aux.elem) aux=front;
			aux=aux.prev;
		}
		return pos;
	}


	@Override
	public T removePos(int pos) {
		if(pos<1 || pos>size()) throw new IllegalArgumentException();
		int posCounter=0;
		DoubleNode<T> obj = new DoubleNode<T>(null);
		DoubleNode<T> aux = front;
		while(aux!=null) {
			posCounter++;
			if(pos==posCounter) {
				obj=aux;
				aux.prev.next=aux.next;
				aux.next.prev=aux.prev;
				aux=last;
			}
			aux=aux.next;
		}
		return obj.elem;
	}


	@Override
	public int removeAll(T elem) {
		if(elem==null) throw new NullPointerException();
		if(!contains(elem)) throw new NoSuchElementException();
		int removeCounter=0;
		DoubleNode<T> aux = front;
		while(aux!=null) {
			if(elem==aux.elem) {
				aux.prev.next=aux.next;
				aux.next.prev=aux.prev;
				removeCounter++;
			}
			aux=aux.next;
		}
		return removeCounter;
	}


	@Override
	public boolean contains(T elem) {
		if(elem==null) throw new NullPointerException();
		DoubleNode<T> aux = front;
		while(aux!=null) {
			if(elem==aux.elem) return true;
			aux=aux.next;
		}
		return false;
	}


	@Override
	public int size() {
		int size=0;
		DoubleNode<T> aux = front;
		while(aux!=null) {
			size++;
			aux=aux.next;
		}
		return size;
	}


	@Override
	public String toStringReverse() {
		StringBuffer output = new StringBuffer("(");
		DoubleNode<T> aux = last;
		while(aux!=null) {
			output.append(aux.elem.toString() + " ");
			aux=aux.prev;
		}
		output.append(")");
		return output.toString();
	}

	@Override
	public DoubleList<T> reverse() {
		DoubleList<T> reverse = new DoubleLinkedListImpl<T>();
		DoubleNode<T> aux = front;
		while(aux!=null) {
			reverse.insertFirst(aux.elem);
			aux=aux.next;
		}
		return reverse;
	}


	@Override
	public int maxRepeated() {
		int counter=0,max=0;
		DoubleNode<T> aux = front;
		DoubleNode<T> aux2 = front;
		T elemPivote;
		while(aux!=null) {
			aux2=aux;
			elemPivote=aux.elem;
			while(aux2!=null) {
				if(elemPivote==aux2.elem) counter++;
				aux2=aux2.next;
			}
			if(counter>max) max=counter;
			counter=0;
			aux=aux.next;
		}
		return max;
	}


	@Override
	public boolean isEquals(DoubleList<T> other) {
		if(other==null) throw new NullPointerException();
		return (this.toString().equals(other.toString()));
	}


	@Override
	public boolean containsAll(DoubleList<T> other) {
		if(other==null)throw new NullPointerException();
		DoubleNode<T> aux = front;
		T elemPivote;
		while(aux!=null) {
			elemPivote=aux.elem;
			if(!(other.contains(elemPivote))) return false;
			aux=aux.next;
		}
		return true;
	}


	@Override
	public boolean isSubList(DoubleList<T> other) {
		if(other==null)throw new NullPointerException();
		if (this.toString().contains(other.toString())) return true;
		return false;
	}


	@Override
	public String toStringFromUntil(int from, int until) {
		if(from<=0||until<=0||until<from)throw new IllegalArgumentException();
		int posCounter=1;
		StringBuffer output= new StringBuffer("(");
		DoubleNode<T> aux = front;
		while(aux!=null) {
			if(posCounter>=from && posCounter<=until) output.append(aux.elem.toString() + " ");
			aux=aux.next;
		}
		output.append(")");
		return output.toString();
	}
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer("(");
		DoubleNode<T> aux = front;
		while(aux!=null) {
			output.append(aux.elem.toString() + " ");
			aux=aux.next;
		}
		output.append(")");
		return output.toString();
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
