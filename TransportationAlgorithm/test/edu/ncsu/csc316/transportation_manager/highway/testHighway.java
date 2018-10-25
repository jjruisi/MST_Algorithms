package edu.ncsu.csc316.transportation_manager.highway;

import static org.junit.Assert.*;

import org.junit.Test;

public class testHighway {

	@Test
	public void test() {
		Highway h = new Highway(1, 2, 3, 4);
		h.getAsphalt();
		h.getCity1();
		h.getCity2();
		h.getCost();
		h.toString();
		assertNotNull(h);
	}

}
