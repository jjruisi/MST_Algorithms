package edu.ncsu.csc316.transportation_manager.list;

public class ArrayList<E> {
	
	/** Initial size of the array */
	private static final int RESIZE = 10;
	/** Array of generic objects*/
	private E[] list;
	/** size of the array */
	private int size;
	
	/**
	 * Constructor initalizes the list and sets the size to zero
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		list = (E[]) (new Object[RESIZE]);
		size = 0;
	}
	
	/**
	 * Creates array list with a specific size
	 * @param size the size of the list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int size) {
		list = (E[]) (new Object[size]);
		this.size = size;
	}
	
	/**
	 * Adds a generic object to the end of the list
	 * @param o the object to be added
	 */
	public void add(E o) {
		if (size() == list.length) {
			growArray();
		}
		list[size()] = o;
		size++;
	}
	
	/**
	 * Gets the object at the specific index
	 * @param idx the specific index
	 * @return the object at that index
	 */
	public E get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		
		return list[idx];
	}
	
	/**
	 * Grows the array if it reaches max capacity
	 */
	@SuppressWarnings("unchecked")
	public void growArray() {
		E[] temp = (E[]) (new Object[list.length * 2]);
		for (int i = 0; i < list.length; i++) {
			temp[i] = list[i];
		}
		list = temp;
	}
	
	/**
	 * Returns the size of the array
	 * @return size the size of the array
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Determins if the array is empty
	 * @return true if the array is empty
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (list[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

}
