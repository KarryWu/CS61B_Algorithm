public class ArrayDeque<Item> implements Deque<Item> {
	private Item[] items;
	private int size;
	private int nextFirst;
	private int nextLast;

	public ArrayDeque() {
		this.items = (Item []) new Object[8];
		this.size = 0;
		this.nextFirst = 4;
		this.nextLast = 5;
	}

	@Override
	public void resize(int Capacity) {
		Item[] a = (Item []) new Object[Capacity];
		for (int i = this.nextFirst + 1; i < this.nextLast; i++) {
			a[i] = this.items[i];
		}
		this.items = a;
	}

	@Override
	public void addFirst(Item item) {
		if (this.items.length == this.size) {
			resize(this.size * 2);
		}
		this.items[this.nextFirst] = item;
		this.nextFirst--;
		this.size++;
	}

	@Override
	public void addLast(Item item) {
		if (this.items.length == this.size) {
			resize(this.size * 2);
		}
		this.items[this.nextLast] = item;
		this.nextLast++;
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
		for (int i = this.nextFirst + 1; i < this.nextLast; i++) {
			System.out.print(items[i] + " ");
		}
	}

	@Override
	public Item removeFirst() {
		if (this.size == 0) {
			return null;
		}
		Item element = items[this.nextFirst + 1];
		this.items[this.nextFirst + 1] = null; 
		this.nextFirst = this.nextFirst + 1;
		size--;
		return element;
	}

	@Override
	public Item removeLast() {
		if (this.size == 0) {
			return null;
		}
		Item element = items[this.nextLast - 1];
		this.items[this.nextLast - 1] = null; 
		this.nextLast = this.nextLast - 1;
		size++;
		return element;
	}

	@Override
	public Item get(int index) {
		if (index > this.size) {
			return null;
		}
		return this.items[index + nextFirst];
	}

}