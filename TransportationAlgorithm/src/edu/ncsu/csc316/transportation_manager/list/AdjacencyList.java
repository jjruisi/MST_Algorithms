package edu.ncsu.csc316.transportation_manager.list;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

public class AdjacencyList {

	private int V;
	private int E;
	private Highway[][] adj;
	
	public AdjacencyList(int v) {
		this.V = v;
		this.E = 0;
		this.adj = new Highway[V][V];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(int v, int w, Highway h) {
		if (adj[v][w] == null) {
			E++;
			adj[v][w] = h;
			adj[w][v] = h;
		}
	}
	
	public boolean contains(int v, int w) {
		if (adj[v][w] != null) {
			return true;
		}
		return false;
	}
	
	public Highway getEdge(int v, int w) {
		return adj[v][w];
	}
}
