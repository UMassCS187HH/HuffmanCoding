package binaryTree;

public class Leaf extends Tree {
	private char value;
	public Leaf(char c, int f) {
		super(f);
		value = c;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}

}
