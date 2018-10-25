package edu.ncsu.csc316.transportation_manager.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.io.HighwayReader;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.ArrayList;

public class testMinHighwayFinder {

	@Test
	public void test() {
		ArrayList<Highway> list = HighwayReader.readHighways("input/highways_small.txt");
		
		MinHighwayFinder m = new MinHighwayFinder(list, "COST");
		
		int n = m.vertCount();
		
		AdjacencyList adj = new AdjacencyList(n);
		for (int i = 0; i < list.size(); i++) {
			adj.addEdge(list.get(i).getCity1(), list.get(i).getCity2(), list.get(i));
		}
		
		ArrayList<Highway> mst = m.KruskalMST(adj);
		
		assertNotNull(mst);
	}
}
