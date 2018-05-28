public class LinkedListDeque<Item> implements Deque<Item> {
	public class Node {
		public Item item;
		public Node prev;
		public Node next;
		public Node(Node p, Item i, Node n) {
			this.prev = p;
			this.item = i;
			this.next = n;
		}
	}

	private int size;
	
	private Node sentinel;


	public LinkedListDeque() {
		this.sentinel = new Node(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
		this.size = 0;
	}

	@Override
	public void addFirst(Item i) {
		Node front = new Node(this.sentinel, i, this.sentinel.next);
		this.sentinel.next.prev = front;
		this.sentinel.next = front;
		this.size++;
	}

	@Override
	public void addLast(Item i) {
		Node last = new Node(this.sentinel.prev, i ,this.sentinel);
		this.sentinel.prev.next = last;
		this.sentinel.prev = last;
		this.size++;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void printDeque() {
		Node p = this.sentinel.next;
		while (p != sentinel) {
			System.out.print(p.item + " ");
			p = p.next;
		}
	}

	@Override
	public Item removeFirst() {
		Node remove = this.sentinel.next;
		if (remove == this.sentinel) {
			return null;
		}
		this.sentinel.next = this.sentinel.next.next;
		this.sentinel.next.prev = this.sentinel;
		remove.prev = null;
		remove.next = null;
		this.size--;
		return remove.item;
	}

	@Override
	public Item removeLast() {
		Node remove = this.sentinel.prev;
		if (remove == this.sentinel) {
			return null;
		}
		this.sentinel.prev = this.sentinel.prev.prev;
		this.sentinel.prev.next = this.sentinel;
		remove.prev = null;
		remove.next = null;
		this.size--;
		return remove.item;
	}

	@Override
	public Item get(int index) {
		if (index >= this.size) {
			return null;
		}
		Node p = this.sentinel;
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		return p.item;
	}


	public Item getRec(int index, Node p) {
		if (index == 0) {
			return p.item;
		}
		if (index >= this.size) {
			return null;
		}
		return getRec(index - 1, p.next);
	}


	public Item getRecursive(int index) {
		return getRec(index, sentinel.next);
	}

}