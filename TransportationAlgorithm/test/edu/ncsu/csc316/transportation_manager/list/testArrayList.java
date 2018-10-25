package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class testArrayList {

	/**
	 * Tests the constructor
	 */
	@Test
	public void test() {
		ArrayList<String> a = new ArrayList<String>();
		assertEquals(a.size(), 0);
	}

	/**
	 * Tests the add method
	 */
	@Test
	public void testAdd() {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>(100);
		
		b.isEmpty();
		
		a.isEmpty();
		
		a.add("0");
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		a.add("5");
		a.add("6");
		a.add("7");
		a.add("8");
		a.add("9");
		a.add("10");
		a.get(0);
		a.contains("2");
		a.contains("13");
		a.isEmpty();
		
		assertEquals(a.size(), 11);
	}
}
