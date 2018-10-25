package edu.ncsu.csc316.transportation_manager.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayList;

public class testHighwayReader {

	@Test
	public void test() {
		HighwayReader h = new HighwayReader();
		ArrayList<Highway> list = HighwayReader.readHighways("input/highways_small.txt");
		assertNotNull(h);
		assertNotNull(list);
	}
	
}
