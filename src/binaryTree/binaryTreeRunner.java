package binaryTree;

import java.util.HashMap;

public class binaryTreeRunner<T> {
	private String str;
	private Tree t;
	private LLNode<Character> head;
	private HashMap<Character, String> map;
	
	public binaryTreeRunner(String s){
		map = new HashMap<Character, String>();
		str = s.toLowerCase();
		char[] arr = str.toCharArray();
		head = new LLNode<Character>();
		for(char c: arr)
			head.addChar(c);
		head = cleanUp(head);
		head = head.sort(head);
		t = this.buildTree();
		this.createMap(t, new StringBuffer());

	}
	public String getCompression(){
		char[] ca = str.toCharArray();
		String cmp = "";
		for(char c: ca){
			cmp += map.get(c);
		}
		return cmp;
	}
	public HashMap<Character, String> getMap(){
		return map;
	}
	public Tree getTree(){
				return t;
	}
	/*
	private LLNode<Character> breakDown(String s, LLNode<Character> l){
		LLNode<Character> temp = l;
		LLNode<Character> lln = new LLNode<Character>();
		for(int i = 0; i < str.length(); i++)
			temp.addChar(str.charAt(i));
		return lln;
	}
	*/
	
	private LLNode<Character> cleanUp(LLNode<Character> lln){
		LLNode<Character> pos = lln;
		LLNode<Character> dup = new LLNode<Character>();
		while(true){
			if(!dup.contains(pos.getData()))
				dup.addChar(pos.getData());
			else
				dup.incrementFreq(pos.getData());;
			if(pos.getLink() == null)
				return dup;
			pos = pos.getLink();
		}
	}
	

	
	public LLNode<Character> getHead(){
		return head;
	}
	
	public Tree buildTree(){
		Tree huffman = new Tree(0);
		LLNode<Tree> leaves = new LLNode<Tree>();
		LLNode<Character> pos = head;
		while(true){
			leaves.addLLN(new LLNode<Tree>(new Leaf(pos.getData(), pos.getFreq())));
			if(pos.getLink() != null){
				pos = pos.getLink();
			}
			else
				break;
		}
		assert !leaves.isEmpty();
		while(leaves.getSize() >= 0){
			Tree a = leaves.getData();
			leaves = leaves.getLink();
			Tree b = leaves.getData();
			leaves = leaves.getLink();
			Node n = new Node(a,b);
			if(leaves == null){
				huffman = n;
				break;
			}
			leaves.addLLN(new LLNode<Tree>(n, a.getFreq()+b.getFreq()));
			leaves = leaves.sort(leaves);
		}
		return huffman;
	}
	
	public void createMap(Tree tree, StringBuffer binary){
		if (tree instanceof Leaf) {
            Leaf leaf = (Leaf) tree;
            System.out.println(leaf.getValue() + "\t" + binary);
            map.put(leaf.getValue(), binary.toString());
        } else if (tree instanceof Node) {
        	Node node = (Node) tree;
            binary.append('0');
            createMap(node.getL(), binary);
            binary.deleteCharAt(binary.length()-1);
            
            binary.append('1');
            createMap(node.getR(), binary);
            binary.deleteCharAt(binary.length()-1);
        }
	}
}
