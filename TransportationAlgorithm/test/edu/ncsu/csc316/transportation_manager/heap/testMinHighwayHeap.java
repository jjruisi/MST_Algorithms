package edu.ncsu.csc316.transportation_manager.heap;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.io.HighwayReader;
import edu.ncsu.csc316.transportation_manager.list.ArrayList;

public class testMinHighwayHeap {

	@Test
	public void test() {
		MinHighwayHeap h1 = new MinHighwayHeap("COST");
		ArrayList<Highway> list = HighwayReader.readHighways("input/highways_small.txt");
		
		for (int i = 0; i < list.size(); i++) {
			h1.insert(list.get(i));
		}
		
		h1.deleteMin();
		
		h1.toString();
		
		assertNotNull(h1);
		
		MinHighwayHeap h = new MinHighwayHeap("ASPHALT");
		
		for (int i = 0; i < list.size(); i++) {
			h.insert(list.get(i));
		}
		
		h.deleteMin();
		
		h.toString();
		
		assertNotNull(h);
	}
}
