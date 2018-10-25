package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;

public class testUpTree {

	@Test
	public void test() {
		
		UpTree u = new UpTree();
		u.add(0);
		u.add(1);
		u.add(2);
		u.add(3);
		
		u.union(u.sets.get(0) , u.sets.get(1));
		u.union(u.sets.get(2), u.sets.get(3));
		u.union(u.sets.get(1), u.sets.get(3));
		u.size();
		u.get(1);
		
		assertNotNull(u);
	}
}
