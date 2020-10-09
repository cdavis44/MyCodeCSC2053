//@author Clay Davis
public class RecursiveLinkedCollection<T> implements CollectionInterface<T> {
	LLNode<T> front;
	int size;
	RecursiveLinkedCollection(){
		front = null;
		size = 0;
	}
	
	private LLNode<T> recAdd(LLNode<T> node, T element){
		if(node != null) {
			node.setLink(recAdd(node.getLink(), element));
		}else {
			node = new LLNode<>(element);
			
		}
		front = node;
		return node;
	}	
	private LLNode<T> recRemove(LLNode<T> node, T element){
		
		if(node.getInfo().equals(element)) {
			node = node.getLink();
			size--;
			return node;
		}
		else {
			return recRemove(node.getLink(), element);
		}
	}

	private boolean recContains(LLNode<T> node, T target) {
		if(node == null) {
			return false;
		}
		if(node.getInfo().equals(target)) {
			return true;
		}
		else {
			return recContains(node.getLink(), target);
		}
		
	}
	
	private T recGet(LLNode<T> node, T element){
		if(node == null)
			return null;
		if(node.getInfo().equals(element))
			return node.getInfo();
		return recGet(node.getLink(), element);
	}
	
	private int recSize(LLNode<T> node) {
		if(node == null) {
			return 0;
		}
		return 1 + recSize(node.getLink());
	}
	
	public String toString() {
		if (front==null) {
			return "";
		}
		String ret = front.getInfo().toString();
		LLNode<T> temp = front.getLink();
		while(temp!=null) {
			ret += "," + temp.getInfo().toString();
			temp=temp.getLink();
		}
		return ret;
	}
	
	@Override
	
	public boolean add(T element) {
		recAdd(front, element);
		size++;
		return true;
	}

	@Override
	public T get(T target) {
		return recGet(front, target);

	}

	@Override
	public boolean remove(T element) {
		recRemove(front, element);
		return true;
	}

	@Override
	public boolean contains(T target) {
		return(recContains(front, target));
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		return recSize(front);
	}
	

}
