public class Triple <T extends Comparable, E extends Comparable> {

	private T elem1;
	private E elem2;
	private T elem3;

	public Triple (T elem1, E elem2, T elem3) {
		this.elem1 = elem1;
		this.elem2 = elem2;
		this.elem3 = elem3;
	}

	public boolean equals (Triple otherTriple) {
		return (this.elem1.equals(otherTriple.getElem1()) && this.elem2.equals(otherTriple.getElem2()) && this.elem3.equals(otherTriple.getElem3()));
	}

	public T getElem1 () {
		return elem1;
	}

	public void setElem1 (T newElem) {
		elem1 = newElem;
	}

	public E getElem2 () {
		return elem2;
	}

	public void setElem2 (E newElem) {
		elem2 = newElem;
	}

	public T getElem3 () {
		return elem3;
	}
	
	public void setElem3 (T newElem) {
		elem3 = newElem;
	}

}