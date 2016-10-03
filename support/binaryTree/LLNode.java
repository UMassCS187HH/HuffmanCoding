package binaryTree;

public class LLNode<T> {
	private T data;
	private int freq;
	private LLNode<T> pointer;

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LLNode(T t, LLNode<T> lln) {
		this();
		data = t;
		pointer = lln;
		freq = 0;
	}

	public LLNode(T t) {
		this();
		data = t;
	}

	public LLNode() {
		freq = 1;
	}

	public LLNode(T t, int f) {
		data = t;
		freq = f;
	}

	public LLNode(LLNode<T> lln) {
		this();
		data = lln.getData();
		pointer = lln.getLink();
		freq = lln.getFreq();

	}

	public LLNode<T> getLink() {
		return pointer;
	}

	public void setLink(LLNode<T> lln) {
		pointer = lln;
	}

	public void addChar(T t) {
		this.addLLN(new LLNode<T>(t));
	}

	public boolean isEmpty() {
		if (data == null)
			return true;
		return false;
	}

	public LLNode<T> getThis() {
		return this;
	}

	public void addLLN(LLNode<T> lln) {
		LLNode<T> curr = getThis();
		if (curr.getData() == null) {
			curr.setData(lln.getData());
			curr.setFreq(lln.getFreq());
		} else {
			while (curr.getLink() != null) {
				curr = curr.getLink();
			}
			curr.setLink(new LLNode<T>(lln.getData(), lln.getFreq()));
		}
	}

	private LLNode<T> find(T t) {
		if (this.data == t)
			return this;
		if (this.pointer == null)
			return null;
		else {
			return this.getLink().find(t);
		}
	}

	public boolean contains(T t) {
		if (find(t) == null)
			return false;
		return true;
	}

	public int getMaxFreq(LLNode<T> t) {
		LLNode<T> pos = t;
		int max = 0;
		while (true) {
			if (pos.getFreq() > max)
				max = pos.getFreq();
			if (pos.getLink() == null)
				break;
			pos = pos.getLink();
		}
		return max;
	}

	public void incrementFreq(T t) {
		if (find(t) != null)
			find(t).incrementFreq();
	}

	public void incrementFreq() {
		freq++;
	}
	
	public LLNode<T> sort(LLNode<T> lln){
		int i = 1;
		int max = lln.getMaxFreq(lln);
		LLNode<T> sorted = new LLNode<T>();
		while(i <= max){
			LLNode<T> pos = lln;
			while(true){
				if(pos.getFreq()==i)
					sorted.addLLN(pos);
				if(pos.getLink()!=null)
					pos = pos.getLink();
				else
					break;
			}
			i++;
		}
		return sorted;
	}
	
	public int getSize(){
		LLNode<T> pos = this;
		if(pos.isEmpty())
			return 0;
		if(pos.getLink() == null)
			return 1;
		int i = 0;
		if(pos.getData() != null){
			i++;
		}
		while(true){
			if(pos.getLink()!=null)
				pos = pos.getLink();
			else
				break;
			i++;
		}
		return i;
	}
}
