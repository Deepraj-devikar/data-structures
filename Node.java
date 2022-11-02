public class Node <Type>{
	Type item;
	Node next;
	
	public Node(Type item) {
		this.item = item;
		next = null;
	}
	
	@Override
	public String toString() {
		return "["+item.toString()+(next == null ? "" : "->"+next )+"]";
	}
}
