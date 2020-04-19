package ule.edi.doubleLinkedList;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

import ule.edi.exceptions.EmptyCollectionException;

public class DoubleLinkedImplTest {
	DoubleLinkedListImpl<String> lv;
	DoubleLinkedListImpl<String> listaConElems;
	
@Before
public void antesDe() {
	lv=new DoubleLinkedListImpl<String>();
	listaConElems=new DoubleLinkedListImpl<String>();
	listaConElems.insertFirst("D");
	listaConElems.insertFirst("B");
	listaConElems.insertFirst("A");
	listaConElems.insertFirst("C");
	listaConElems.insertFirst("B");
	listaConElems.insertFirst("A");
	
}


	
	@Test
	public void isEmptyTest() {
		Assert.assertTrue(lv.isEmpty());
		Assert.assertTrue(lv.size()==0);
		Assert.assertFalse(listaConElems.isEmpty());
		Assert.assertTrue(listaConElems.size()==6);
		
	}
	
	@Test
	public void clearTest() {
		lv.clear();
		Assert.assertTrue(lv.isEmpty());
		Assert.assertTrue(lv.size()==0);
		
		listaConElems.clear();
		Assert.assertTrue(listaConElems.isEmpty());
		Assert.assertTrue(listaConElems.size()==0);
		Assert.assertEquals(listaConElems.toString(),listaConElems.toStringReverse());
		
	}
	
	@Test
	public void containsTest() {
		Assert.assertFalse(lv.contains("A"));
		Assert.assertTrue(listaConElems.contains("A"));
		Assert.assertTrue(listaConElems.contains("B"));
		Assert.assertTrue(listaConElems.contains("B"));
		Assert.assertTrue(listaConElems.contains("D"));
		Assert.assertFalse(listaConElems.contains("Z"));
		
	}
	
	@Test
	public void removeAllTest() throws EmptyCollectionException {
        Assert.assertEquals(2, listaConElems.removeAll("A"));
    	Assert.assertEquals(listaConElems.toString(),"(B C B D )");
    	
        listaConElems.removeAll("B");
		Assert.assertFalse(listaConElems.contains("A"));
		Assert.assertFalse(listaConElems.contains("B"));
		Assert.assertEquals(listaConElems.toString(),"(C D )");
		listaConElems.removeAll("C");
		
		Assert.assertTrue(listaConElems.contains("D"));
		Assert.assertFalse(listaConElems.contains("C"));
        listaConElems.removeAll("D");
		
		Assert.assertFalse(listaConElems.contains("D"));
		Assert.assertTrue(listaConElems.isEmpty());
		Assert.assertTrue(listaConElems.size()==0);
		Assert.assertEquals(listaConElems.toString(),listaConElems.toStringReverse());
		
	}
	
	@Test
	public void isSubListTest() throws EmptyCollectionException {
		 Assert.assertTrue(listaConElems.isSubList(lv));
	    	Assert.assertTrue(listaConElems.isSubList(new DoubleLinkedListImpl<String>("A", "B", "C")));
	      	Assert.assertEquals(listaConElems.toString(),"(A B C A B D )");
	      	Assert.assertEquals(new DoubleLinkedListImpl<String>("A", "C").toString(),"(A C )");   
	     	Assert.assertFalse(listaConElems.isSubList(new DoubleLinkedListImpl<String>("A", "C")));
	     	Assert.assertEquals(listaConElems.maxRepeated(),2);
	     	listaConElems.insertBefore("A", "D");
	    	Assert.assertEquals(listaConElems.toString(),"(A B C A B A D )");
	    	Assert.assertTrue(listaConElems.maxRepeated()==3);
	        	  
	}
	
	@Test (expected = NullPointerException.class)
	public void testInstertFirstNullExcep() {
		lv.insertFirst(null);
	}
	
	@Test
	public void testInsertFirst() {
		lv.insertFirst("A");
		lv.insertFirst("A");
		Assert.assertEquals("(A A )", lv.toString());
	}
	
	@Test (expected = NullPointerException.class)
	public void testInstertLastNullExcep() {
		lv.insertLast(null);
	}
	
	@Test
	public void testInsertLast() {
		lv.insertLast("A");
		lv.insertLast("A");
		Assert.assertEquals("(A A )", lv.toString());
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testRemoveFirstEmptyExcep() throws EmptyCollectionException {
		lv.removeFirst();
	}
	
	@Test
	public void testRemoveFirst() throws EmptyCollectionException {
		lv.insertFirst("A");
		lv.insertFirst("A");
		Assert.assertEquals("A", lv.removeFirst());
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testRemoveLastEmptyExcep() throws EmptyCollectionException {
		lv.removeLast();
	}
	
	@Test
	public void testRemoveLast() throws EmptyCollectionException {
		lv.insertLast("A");
		lv.insertLast("A");
		Assert.assertEquals("A", lv.removeLast());
	}
	
	@Test (expected = NullPointerException.class)
	public void testInsertPosNullExcep() {
		lv.insertPos(null, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInsertPosIllegalExcep() {
		lv.insertPos("A", 0);
	}
	
	@Test
	public void testInsertPosSizeMenor() {
		lv.insertPos("W", 2);
		Assert.assertEquals("(W )", lv.toString());
		lv.insertPos("A",1);
		Assert.assertEquals("(A W )", lv.toString());
		lv.insertPos("B", 2);
		Assert.assertEquals("(A B W )", lv.toString());
		lv.insertPos("B", 3);
		Assert.assertEquals("(A B B W )", lv.toString());
	}
	
	@Test (expected = NullPointerException.class)
	public void testInsertBeforeBothNullExcep() {
		lv.insertBefore(null, null);
	}
	
	@Test (expected = NullPointerException.class)
	public void testInsertBeforeElemNullExcep() {
		lv.insertFirst("A");
		lv.insertBefore(null, "A");
	}
	
	@Test (expected = NullPointerException.class)
	public void testInsertBeforeTargetNullExcep() {
		lv.insertFirst("A");
		lv.insertBefore("A", null);
	}
	
	@Test (expected = NoSuchElementException.class)
    public void testInsertBeforeNoSuchElemExcep() {
		lv.insertFirst("A");
		lv.insertBefore("A", "B");
	}
	
	@Test
    public void testInsertBefore() {
		lv.insertFirst("A");
		lv.insertFirst("A");
		lv.insertBefore("B", "A");
		lv.insertBefore("C", "A");
		Assert.assertEquals("(B C A A )", lv.toString());
	}
	
	@Test (expected = IllegalArgumentException.class)
    public void testGetElemPosIllegalExcepExceso() {
		listaConElems.getElemPos(50);
	}
	
	@Test (expected = IllegalArgumentException.class)
    public void testGetElemPosIllegalExcepDefecto() {
		listaConElems.getElemPos(0);
	}
	
	@Test
    public void testGetElemPos() {
		lv.insertFirst("A");
		Assert.assertEquals("A", lv.getElemPos(1));
		lv.insertFirst("B");
		Assert.assertEquals("B", lv.getElemPos(1));
		lv.insertFirst("Q");
		Assert.assertEquals("B", lv.getElemPos(2));
	}
    
	@Test (expected = NullPointerException.class)
    public void testGetPosFirstNullExcep() {
		lv.getPosFirst(null);
	}
	
	@Test (expected = NoSuchElementException.class)
    public void testGetPosFirstNoSuchElemExcep() {
		lv.insertFirst("A");
		lv.getPosFirst("B");
	}
    
	@Test
    public void testGetPosFirst() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("B");
		lv.insertFirst("A");
		Assert.assertEquals(1, lv.getPosFirst("A"));
		Assert.assertEquals(2, lv.getPosFirst("B"));
	}
	
	@Test (expected = NullPointerException.class)
    public void testGetPosLastNullExcep() {
		lv.getPosLast(null);
	}
	
	@Test (expected = NoSuchElementException.class)
    public void testGetPosLastNoSuchElemExcep() {
		lv.insertLast("A");
		lv.getPosLast("B");
	}
    
	@Test
    public void testGetPosLast() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("B");
		lv.insertFirst("A");
		Assert.assertEquals(4, lv.getPosLast("A"));
		Assert.assertEquals(3, lv.getPosLast("B"));
	}
	
	@Test (expected = IllegalArgumentException.class)
    public void testRemovePosIllegalExcepDefecto() {
		lv.insertFirst("A");
		lv.removePos(0);
	}
	
	@Test (expected = IllegalArgumentException.class)
    public void testRemovePosIllegalExcepExceso() {
		lv.insertFirst("A");
		lv.removePos(3);
	}
	
	@Test
    public void testRemovePos() {
		lv.insertFirst("A");
		lv.removePos(1);
		Assert.assertEquals("()", lv.toString());
		lv.insertFirst("A");
		lv.insertFirst("A");
		lv.removePos(1);
		Assert.assertEquals("(A )", lv.toString());
		lv.insertFirst("B");
		lv.removePos(2);
		Assert.assertEquals("(B )", lv.toString());
		lv.insertFirst("B");
		lv.insertFirst("B");
		lv.removePos(2);
		Assert.assertEquals("(B B )", lv.toString());		
	}
    
	@Test (expected = NullPointerException.class)
    public void testRemoveAllNullExcep() {
		lv.removeAll(null);
	}
	
	@Test (expected = NoSuchElementException.class)
    public void testRemoveAllNoSuchElemExcep() {
		lv.insertFirst("A");
		lv.removeAll("B");
	}
	
	@Test
    public void testRemoveAll() {
		int removeCounter;
		lv.insertFirst("A");
		removeCounter = lv.removeAll("A");
		Assert.assertEquals("()", lv.toString());
		Assert.assertEquals(1, removeCounter);
		lv.insertFirst("A");
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("A");
		removeCounter = lv.removeAll("A");
		Assert.assertEquals("(B )", lv.toString());
		Assert.assertEquals(3, removeCounter);
	}
    
	@Test (expected = NullPointerException.class)
    public void testContainsNullExcep() {
		lv.contains(null);
	}
	
	@Test
    public void testContains() {
		lv.insertFirst("A");
		Assert.assertTrue(lv.contains("A"));
		Assert.assertFalse(lv.contains("B"));
	}
	
	@Test
	public void testSize() {
		Assert.assertEquals(0, lv.size());
		lv.insertFirst("A");
		lv.insertFirst("A");
		Assert.assertEquals(2, lv.size());
	}
	
	@Test
	public void testToStringReverse() {
		Assert.assertEquals("()", lv.toStringReverse());
		lv.insertFirst("C");
		lv.insertFirst("B");
		lv.insertFirst("A");
		Assert.assertEquals("(C B A )", lv.toStringReverse());
	}
	
	@Test
	public void testReverse() {
		lv.insertLast("D");
		lv.insertLast("B");
		lv.insertLast("A");
		lv.insertLast("C");
		lv.insertLast("B");
		lv.insertLast("A");
		Assert.assertEquals(lv.toString(), listaConElems.reverse().toString());
	}
	
	@Test
    public void testMaxRepeated() {
        lv.insertFirst("A");
        lv.insertLast("B");
        lv.insertLast("C");
        lv.insertLast("D");
        lv.insertLast("E");
        lv.insertLast("F");
        lv.insertLast("G");
        lv.insertLast("H");
        lv.insertLast("I");
        lv.insertLast("J");
        lv.insertLast("K");
        lv.insertLast("L");
        lv.insertLast("M");
        lv.insertLast("N");
        lv.insertLast("A");
        lv.insertLast("B");
        lv.insertLast("A");
        lv.insertLast("P");
        lv.insertLast("O");
        lv.insertLast("Q");
        lv.insertLast("A");
        Assert.assertEquals(4,lv.maxRepeated());
    }
	
	@Test (expected = NullPointerException.class)
	public void testIsEqualsNullExcep() {
		lv=null;
		listaConElems.isEquals(lv);
	}
	
	@Test
	public void testIsEquals() {
		lv.insertFirst("D");
		Assert.assertFalse(lv.isEquals(listaConElems));
		lv.insertFirst("B");
		lv.insertFirst("A");
		lv.insertFirst("C");
		lv.insertFirst("B");
		lv.insertFirst("A");
		Assert.assertTrue(lv.isEquals(listaConElems));
	}
	
	@Test (expected = NullPointerException.class)
	public void testContainsAllsNullExcep() {
		lv=null;
		listaConElems.containsAll(lv);
	}
	
	@Test
	public void testContainsAll() {
		lv.insertFirst("A");
		lv.insertFirst("D");
		Assert.assertTrue(listaConElems.containsAll(lv));
		lv.insertFirst("W");
		Assert.assertFalse(listaConElems.containsAll(lv));
	}
	
	@Test (expected = NullPointerException.class)
	public void testIsSubListNullExcep() {
		lv=null;
		listaConElems.isSubList(lv);
	}
	
	@Test
	public void testIsSubList() {
		lv.insertFirst("D");
		lv.insertFirst("B");
		lv.insertFirst("A");
		Assert.assertTrue(listaConElems.isSubList(lv));
		lv.insertFirst("B");
		Assert.assertFalse(listaConElems.isSubList(lv));
		Assert.assertTrue(listaConElems.isSubList(listaConElems));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testToStringFromUntilFromIllegalExcep() {
		listaConElems.toStringFromUntil(-1, 2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testToStringFromUntilUntilIllegalExcep() {
		listaConElems.toStringFromUntil(2, -7);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testToStringFromUntilUntilMayor() {
		listaConElems.toStringFromUntil(3, 1);
	}
	
	@Test
	public void testToStringFromUntil() {
		Assert.assertEquals("(A B C )", listaConElems.toStringFromUntil(1, 3));
		Assert.assertEquals("(B C A )", listaConElems.toStringFromUntil(2, 4));
		Assert.assertEquals("(B D )", listaConElems.toStringFromUntil(5, 6));
		Assert.assertEquals("(A )", listaConElems.toStringFromUntil(1, 1));
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals("(A B C A B D )", listaConElems.toString());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testIteratorNextNoSuchElemExcep() {
		lv.insertFirst("A");
		Iterator <String> lista = lv.iterator();
		lista.next();
		lista.next();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testReverseIteratorNextNoSuchElemExcep() {
		lv.insertFirst("A");
		Iterator <String> lista = lv.reverseIterator();
		lista.next();
		lista.next();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testEvenPosIteratorNextNoSuchElemExcep() {
		lv.insertFirst("A");
		lv.insertFirst("A");
		lv.insertFirst("A");
		Iterator <String> lista = lv.evenPositionsIterator();
		lista.next();
		lista.next();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testProgressIteratorNextNoSuchElemExcep() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("C");
		lv.insertFirst("D");
		lv.insertFirst("E");
		lv.insertFirst("F");
		lv.insertFirst("G");
		Iterator <String> lista = lv.progressIterator();
		lista.next();
		lista.next();
		lista.next();
		lista.next();
		lista.next();
	}
	
	@Test
	public void testIteratorNext() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("C");
		Iterator <String> lista = lv.iterator();
		Assert.assertEquals("C", lista.next());
		Assert.assertEquals("B", lista.next());
		Assert.assertEquals("A", lista.next());
	}
	
	@Test
	public void testReverseIteratorHasNext() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("C");
		Iterator <String> lista = lv.reverseIterator();
		Assert.assertTrue(lista.hasNext());
		lista.next();
		lista.next();
		lista.next();
		Assert.assertFalse(lista.hasNext());
	}
	
	@Test
	public void testReverseIteratorNext() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("C");
		Iterator <String> lista = lv.reverseIterator();
		Assert.assertEquals("A", lista.next());
		Assert.assertEquals("B", lista.next());
		Assert.assertEquals("C", lista.next());
	}
	
	@Test
	public void testEvenPosIteratorHasNext() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("C");
		lv.insertFirst("D");
		lv.insertFirst("E");
		Iterator <String> lista = lv.evenPositionsIterator();
		Assert.assertTrue(lista.hasNext());
		lista.next();
		Assert.assertTrue(lista.hasNext());
		lista.next();
		Assert.assertFalse(lista.hasNext());
	}
	
	@Test
	public void testEvenPosIteratorNext() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("C");
		lv.insertFirst("D");
		lv.insertFirst("E");
		lv.insertFirst("F");
		Iterator <String> lista = lv.evenPositionsIterator();
		Assert.assertEquals("E", lista.next());
		Assert.assertEquals("C", lista.next());
		Assert.assertEquals("A", lista.next());
	}
	
	@Test
	public void testProgressIteratorHasNext() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("C");
		lv.insertFirst("D");
		lv.insertFirst("E");
		lv.insertFirst("F");
		lv.insertFirst("G");
		Iterator <String> lista = lv.progressIterator();
		Assert.assertTrue(lista.hasNext());
		lista.next();
		lista.next();
		lista.next();
		Assert.assertTrue(lista.hasNext());
		lista.next();
		Assert.assertFalse(lista.hasNext());
	}
	
	@Test
	public void testProgressIteratorNext() {
		lv.insertFirst("A");
		lv.insertFirst("B");
		lv.insertFirst("C");
		lv.insertFirst("D");
		lv.insertFirst("E");
		lv.insertFirst("F");
		lv.insertFirst("G");
		Iterator <String> lista = lv.progressIterator();
		Assert.assertEquals("G", lista.next());
		Assert.assertEquals("F", lista.next());
		Assert.assertEquals("D", lista.next());
		Assert.assertEquals("A", lista.next());
	}
}
