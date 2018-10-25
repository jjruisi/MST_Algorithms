package edu.ncsu.csc316.transportation_manager.util;

import edu.ncsu.csc316.transportation_manager.heap.MinHighwayHeap;
import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.ArrayList;
import edu.ncsu.csc316.transportation_manager.set.UpTree;
import edu.ncsu.csc316.transportation_manager.set.UpTree.Node;

public class MinHighwayFinder {
	
	private ArrayList<Highway> list;
	private int vert;
	private String type;
	
	public MinHighwayFinder(ArrayList<Highway> list, String type) {
		this.list = list;
		this.vert = vertCount();
		this.type = type;
	}

	public ArrayList<Highway> KruskalMST(AdjacencyList G) {
		
		ArrayList<Highway> way = new ArrayList<Highway>();
		UpTree E = new UpTree();
		MinHighwayHeap H = new MinHighwayHeap(type);
		
		for (int i = 0; i < vert; i++) {
			for (int j = i; j < vert; j++) {
				if (G.contains(i, j)) {
					H.insert(G.getEdge(i, j));
				}
			}
		}
		
		for (int i = 0; i < vert; i++) {
			E.add(i);
		}
		
		while (vert > 1) {
			
			Highway h = H.deleteMin();
			int x = h.getCity1();
			int y = h.getCity2();
			
			Node a = E.find(E.get(x));
			Node b = E.find(E.get(y));
			
			if (a != b) {
				way.add(h);
				E.union(a, b);
				vert--;
			}
		}
		return way;
	}
	
	public int vertCount() {
		
		ArrayList<Integer> count = new ArrayList<Integer>();
		int unique = 0;
		
		for (int i = 0; i < list.size(); i++) {
			
			if (!count.contains(list.get(i).getCity1())) {
				count.add(list.get(i).getCity1());
				unique++;
			} else if (!count.contains(list.get(i).getCity2())) {
				count.add(list.get(i).getCity1());
				unique++;
			}
		}
		
		return unique;
	}
}
