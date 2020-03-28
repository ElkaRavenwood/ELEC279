public class Pair <T extends Comparable> {
	private T elem1;
	private T elem2;

	public Pair (T elem1, T elem2) {
		this.elem1 = elem1;
		this.elem2 = elem2;
	}

	public boolean equals (Pair otherPair) {
		return (this.elem1.equals(otherPair.getElem1()) && this.elem2.equals(otherPair.getElem2()));
	}

	public String toString () {
		return "Elem1: " + elem1 + "\nElem2: " + elem2;
	}

	public T getElem1 () {
		return elem1;
	}

	public void setElem1 (T newElem) {
		elem1 = newElem;
	}

	public T getElem2 () {
		return elem2;
	}
	
	public void setElem2 (T newElem) {
		elem2 = newElem;
	}

}