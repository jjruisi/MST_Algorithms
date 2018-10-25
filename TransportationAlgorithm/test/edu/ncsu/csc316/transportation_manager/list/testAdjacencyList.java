package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.io.HighwayReader;

public class testAdjacencyList {
	
	@Test
	public void test() {
		
		ArrayList<Highway> list = HighwayReader.readHighways("input/highways_small.txt");
		
		AdjacencyList adj = new AdjacencyList(4);
		
		for (int i = 0; i < list.size(); i++) {
			adj.addEdge(list.get(i).getCity1(), list.get(i).getCity2(), list.get(i));
		}
		
		adj.V();
		adj.E();
		adj.contains(0, 1);
		adj.contains(2, 0);
		adj.contains(0, 0);
		adj.getEdge(0, 1);
		
		assertNotNull(adj);
	}
}
