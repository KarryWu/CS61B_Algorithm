public class ArrayDeque<Item> implements Deque<Item> {
	private Item[] items;
	private int size;
	private int nextFirst;
	private int nextLast;

	public ArrayDeque() {
		this.items = (Item []) new Object[8];
		this.size = 0;
		this.nextFirst = 0;
		this.nextLast = 1;
	}

	public void resize(int Capacity) {
		Item[] a = (Item []) new Object[Capacity];
		for (int i = 0; i < this.size; i++) {
			a[i] = this.get(i);
		}
		this.items = a;
		this.nextLast = this.size;
		this.nextFirst = MinusOne(0);
	}

	public int PlusOne(int x) {
	    if (x == this.items.length - 1) {
	        return ((x + 1) % (this.items.length));
        }

        return x + 1;
    }

    public int MinusOne(int x) {
	    if (x == 0) {
	        return this.items.length -1;
        }
        return x - 1;
    }

	@Override
	public void addFirst(Item item) {
		if (this.items.length == this.size) {
			resize(this.size * 2);
		}
		this.items[this.nextFirst] = item;
		this.nextFirst = MinusOne(this.nextFirst);
		this.size++;
	}

	@Override
	public void addLast(Item item) {
		if (this.items.length == this.size) {
			resize(this.size * 2);
		}
		this.items[this.nextLast] = item;
		this.nextLast = PlusOne(this.nextLast);
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
		Item element = items[PlusOne(this.nextFirst)];
		this.items[PlusOne(this.nextFirst)] = null;
		this.nextFirst = PlusOne(this.nextFirst);
		this.size--;
		return element;
	}


	@Override
	public Item removeLast() {
		if (this.size == 0) {
			return null;
		}
		Item element = items[MinusOne(this.nextLast)];
		this.items[MinusOne(this.nextLast)] = null;
		this.nextLast = MinusOne(this.nextLast);
		this.size--;
		return element;
	}

	@Override
    public Item get(int index) {
        if (index >= this.size || index < 0) {
            return null;
        }

        int firstIndex = PlusOne(nextFirst);
        int requiredIndex = (firstIndex + index) % this.items.length;

        return this.items[requiredIndex];
    }



}
