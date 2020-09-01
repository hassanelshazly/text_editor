/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
//			System.out.print(i);
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
//		int b = list1.remove(0);
//		assertEquals("Remove: check size is correct ", 1, list1.size());
//		
//		int c = list1.remove(0);
//		assertEquals("Remove: check size is correct ", 0, list1.size());
		try {
			int d = list1.remove(-5);
			fail("Test remove() -> check bounds");
		} catch (Exception IndexOutOfBoundsException) {
			
		}
		try {
			shortList.remove(20);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		// Done: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // Done: implement this test
		
		shortList.add("C");
		assertEquals("Add End: check adding is correct ", "C" ,shortList.get(2));
		assertEquals("Add End: check size is correct ", shortList.size(), shortList.size());
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// Done: implement this test
		assertEquals("Size: check short list", shortList.size(), 2);
		assertEquals("Size: check long list", longerList.size(), 10);
		assertEquals("Size: check list1", list1.size(), 3);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // Done: implement this test
		try {
			list1.add(-4, 5);
			fail("Test remove() -> check bounds");
		} catch (Exception IndexOutOfBoundsException) {
			
		}
		try {
			list1.add(20, 6);
			fail("Test remove() -> check bounds");
		} catch (Exception NullPointerException) {
			
		}
		try {
			boolean d = list1.add(null);
			fail("Test remove() -> check bounds");
		} catch (Exception IndexOutOfBoundsException) {
			
		}
		shortList.add(0, "1");
		assertEquals("AddAtIndex: check at the beginning", shortList.get(0), "1");
		assertEquals("AddAtIndex: check size", shortList.size(), 3);
		
		shortList.add(1, "2");
		assertEquals("AddAtIndex: check at the middle", shortList.get(1), "2");
		assertEquals("AddAtIndex: check size", shortList.size(), 4);
		
		shortList.add(4, "3");
		assertEquals("AddAtIndex: check at the last", "3", shortList.get(4));
		assertEquals("AddAtIndex: check size", shortList.size(), 5);
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // Done: implement this test
		try {
			int g = list1.set(20, 5);
			fail("Not Vaild index");
		} catch (Exception IndexOutOfBoundsException) {
				
		}
		try {
			int d = list1.set(-1, 5);
			fail("Test set() -> check bounds");
		} catch (Exception IndexOutOfBoundsException) {
			
		}
		
		try {
			int d = list1.set(1, null);
			fail("Test set() -> check bounds");
		} catch (Exception NullPointerException) {
			
		}
		try {
			shortList.set(20, "g");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		list1.set(0, 10);
		assertEquals("Set: check at the beginning", list1.get(0), Integer.valueOf(10));
		assertEquals("Set: check size", list1.size(), 3);
		
		list1.set(1, 20);
		assertEquals("Set: check at the middle", list1.get(1), Integer.valueOf(20));
		assertEquals("Set: check size", list1.size(), 3);
		
		list1.set(2, 30);
		assertEquals("Set: check at the last", list1.get(2), Integer.valueOf(30));
		assertEquals("Set: check size", list1.size(), 3);
	    
	}
	
	
	// Done: Optionally add more test methods.
	
}
