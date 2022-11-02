public class UnorderedList <Type>{
	Node head;
	Node tail;
	
	public UnorderedList() {
		head = null;
		tail = null;
	}
	
	public void add(Type item) {
		Node newNode = new Node(item);
		if(isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void remove(Type item) {
		if(!isEmpty()) {
			if(head.item.equals(item)) {
				head = head.next;
				return;
			}
			Node currentNode = head;
			while(currentNode.next != null) {
				if(currentNode.next.item.equals(item)) {
					currentNode.next = currentNode.next.next;
					if(currentNode.next == null) {
						tail = currentNode;
					}
					return;
				}	
				currentNode = currentNode.next;
			}
		}
	}
	
	public boolean search(Type item) {
		Node currentNode = head;
		while(currentNode != null) {
			if(currentNode.item == item) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}
	
	public int size() {
		int count = 0;
		Node currentNode = head;
		while(currentNode != null) {
			count++;
			currentNode = currentNode.next;
		}
		return count;
	}
	
	public void append(Type item) {
		Node newNode = new Node(item);
		if(isEmpty()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public int index(Type item) {
		int count = 0;
		Node currentNode = head;
		while(currentNode != null) {
			if(currentNode.item.equals(item)) {
				return count;
			}
			count++;
			currentNode = currentNode.next;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void insert(int position, Type item) {
		if(isEmpty() || position == 0) {
			add(item);
		} else if(position >= size()) {
			append(item);
		} else {
			Node newNode = new Node(item);
			Node currentNode = head;
			for(int i = 1; i < position; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}
	
	public Type pop() {
		Type resultItem = null;
		if(!isEmpty()) {
			resultItem = (Type) tail.item;
			if(head == tail) {
				head = tail = null;
			} else {
				Node currentNode = head;
				while(currentNode.next != tail) {
					currentNode = currentNode.next;
				}
				currentNode.next = null;
				tail = currentNode;
			}
		}
		return resultItem;
	}
	
	public Type popPos(int position) {
		Type resultItem = null;
		if(!isEmpty()) {
			if(position == 0) {
				resultItem = (Type) head.item;
				head = head.next;
				if(head == null) {
					tail = null;
				}
			} else {
				Node currentNode = head;
				for(int i = 1; i < position && currentNode.next != null; i++) {
					currentNode = currentNode.next;
				}
				if(currentNode.next != null) {
					resultItem = (Type) currentNode.next.item;
					currentNode.next = currentNode.next.next;
					if(currentNode.next == null) {
						tail = currentNode;
					}
				}
			}
		}
		return resultItem;
	}
	
	@Override
	public String toString() {
		return isEmpty() ? "null" : head.toString();
	}

	public static void main(String[] args) {
		UnorderedList unorderdList = new UnorderedList();
		unorderdList.insert(2, 5);
		unorderdList.insert(2, "8");
		unorderdList.append(11);
		unorderdList.insert(1, 6);
		unorderdList.add(2);
		unorderdList.insert(1, 4);
		System.out.println(unorderdList);
		System.out.println(unorderdList.popPos(3));
		System.out.println(unorderdList);
	}

}
