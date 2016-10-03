package binaryTree;

public class Node extends Tree{
	private Tree left, right;

	public Node(Tree l, Tree r) {
		super(l.getFreq() + r.getFreq());
		left = l;
		right = r;
	}
	public Tree getL() {
		return left;
	}
	public void setL(Tree l) {
		this.left = l;
	}
	public Tree getR() {
		return right;
	}
	public void setR(Tree r) {
		this.right = r;
	}

}
