package binaryTree;

public class TreeReceiver {
	private Tree tree;
	private String binary;

	public TreeReceiver(Tree t) {
		tree = t;
	}

	public String decode(String bin2) {
		String dec = "";
		String bin = bin2;
		Tree cur = tree;
		while (bin.length() > 0) {
			if (cur instanceof Node) {
				// System.out.println("-");
				if (bin.charAt(0) == '0')
					cur = ((Node) cur).getL();
				else if (bin.charAt(0) == '1')
					cur = ((Node) cur).getR();
				bin = bin.substring(1);
			} else if (cur instanceof Leaf) {
				dec += ((Leaf) cur).getValue();
				cur = this.tree;
			}
		}
		if (cur instanceof Leaf) {
			dec += ((Leaf) cur).getValue();
			cur = this.tree;
		}
		return dec;
	}
}
