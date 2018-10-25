package edu.ncsu.csc316.transportation_manager.heap;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

public class MinHighwayHeap {

	private Highway[] Heap;
	private int size;
	private String type;
	
	private static final int START = 1;
	
	public MinHighwayHeap(String type) {
		this.size = 0;
		this.type = type;
		Heap = new Highway[100];
		Highway h = new Highway(0, 0, 0 ,0);
		Heap[0] = h;
	}
	
	public Highway deleteMin() {
		if (type.equals("COST")) {
			Highway removed = Heap[START];
			Heap[START] = Heap[size--];
			minHeapifyCost(START);
			return removed;
		} else {
			Highway removed = Heap[START];
			Heap[START] = Heap[size--];
			minHeapifyAsphalt(START);
			return removed;
		}
		
	}
	
	public void insert(Highway e) {
		Heap[++size] = e;
		int cur = size;
		
		if (type.equals("COST")) {
			while (Heap[cur].getCost() < Heap[parent(cur)].getCost()) {
				swap(cur, parent(cur));
				cur = parent(cur);
			}
		} else {
			while (Heap[cur].getAsphalt() < Heap[parent(cur)].getAsphalt()) {
				swap(cur, parent(cur));
				cur = parent(cur);
			}
		}
		
	}
	
	private void swap (int first, int second) {
		Highway temp;
		temp = Heap[first];
		Heap[first] = Heap[second];
		Heap[second]= temp;
	}
	
	private int parent(int idx) {
		return idx / 2;
	}
	
	private int rightChild(int idx) {
		return (2 * idx) + 1;
	}
	
	private int leftChild(int idx) {
		return (2 * idx);
	}
	
	private boolean isLeaf(int idx) {
		if (idx >= (size / 2) && idx <= size) {
			return true;
		} else {
			return false;
		}
	}
	
	private void minHeapifyCost(int idx) {
		
		if (!isLeaf(idx)) {
			
			if (Heap[idx].getCost() > Heap[leftChild(idx)].getCost() || Heap[idx].getCost() > Heap[rightChild(idx)].getCost()) {
				
				if (Heap[leftChild(idx)].getCost() < Heap[rightChild(idx)].getCost()) {
					swap(idx, leftChild(idx));
					minHeapifyCost(leftChild(idx));
				} else {
					swap(idx, rightChild(idx));
					minHeapifyCost(rightChild(idx));
				}
			}
		}
	}
	
	private void minHeapifyAsphalt(int idx) {
		
		if (!isLeaf(idx)) {
			
			if (Heap[idx].getAsphalt() > Heap[leftChild(idx)].getAsphalt() || Heap[idx].getAsphalt() > Heap[rightChild(idx)].getAsphalt()) {
				
				if (Heap[leftChild(idx)].getAsphalt() < Heap[rightChild(idx)].getAsphalt()) {
					swap(idx, leftChild(idx));
					minHeapifyAsphalt(leftChild(idx));
				} else {
					swap(idx, rightChild(idx));
					minHeapifyAsphalt(rightChild(idx));
				}
			}
		}
	}
	
	/**
	 * Returns a string representation of the level-order traversal 
	 * of the heap in the following format:
	 * 
	 * Heap[
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 *
	 * @return the string representation of the minheap
	 */
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("Heap[\n");
		
		for (int i = 1; i <= size; i++) {
			
			if (i == size) {
				s.append("   " + Heap[i].toString() + "\n");
			} else {
				s.append("   " + Heap[i].toString() + ",\n");
			}
		}
		
		s.append("]");
		return s.toString();
	}
}
