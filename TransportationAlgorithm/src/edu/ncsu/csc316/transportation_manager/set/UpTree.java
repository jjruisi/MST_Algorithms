package edu.ncsu.csc316.transportation_manager.set;

import edu.ncsu.csc316.transportation_manager.list.ArrayList;

public class UpTree {

	public class Node {
		
		public int city;
		public Node parent;
		public int count;
		
		public Node(int city) {
			this.city = city;
			this.count = 1;
			this.parent = null;
		}
		
		public int count() {
			return count;
		}
	}
	
	public ArrayList<Node> sets;
	
	public UpTree() {
		sets = new ArrayList<Node>();
	}
	
	public int size() {
		return sets.size();
	}
	
	public Node add(int city) {
		Node n = new Node(city);
		sets.add(n);
		return n;
	}
	
	public void union(Node a, Node b) {
		Node x = find(a);
		Node y = find(b);
		
		if(x != y) {
			if (x.count() > y.count()) {
				y.parent = x;
				x.count += y.count;
				y.count = 0;
			} else {
				x.parent = y;
				y.count += x.count;
				x.count = 0;
			}
		}
	}
	
	public Node find(Node n) {
		if (n.parent != null) {
			return find(n.parent);
		} else {
			return n;
		}
	}
	
	public Node get(int n) {
		for (int i = 0; i < sets.size(); i++) {
			if (sets.get(i).city == n) {
				return sets.get(i);
			}
		}
		return null;
	}
}
