package test;

public class HashMap<K, V> implements Map<K, V> {

	private static int DEFAULT_LENGTH = 16;
	private static double DEFAULT_LOADER = 0.75;
	private Entry[] table = null;
	private int size = 0;

	public HashMap() {
		this(DEFAULT_LENGTH, DEFAULT_LOADER);
	}

	public HashMap(int length, double loader) {
		DEFAULT_LENGTH = length;
		DEFAULT_LOADER = loader;
		table = new Entry[DEFAULT_LENGTH];
	}

	@Override
	public V put(K k, V v) {
		size++;
		int index = hash(k);
		Entry<K, V> entry = table[index];
		if (entry == null) {
			table[index] = newEntry(k, v, null);
		} else {
			table[index] = newEntry(k, v, entry);
		}
		return (V) table[index].getValue();
	}

	private Entry newEntry(K k, V v, Entry<K, V> next) {
		return new Entry<K, V>(k, v, next);
	}

	public int hash(K k) {
		int m = DEFAULT_LENGTH;
		int i = k.hashCode() % m;
		return i >= 0 ? i : -i;
	}

	@Override
	public V get(K k) {
		int index = hash(k);
		if (table[index] == null)
			return null;
		return (V) table[index].getValue();
	}

	/*private V find(K k, Entry entry) {
		if (k == entry.getKey() || k.equals(entry.getKey())) {
			return (V) entry.getValue();
		} else {
			if (entry.next != null) {
				return find(k, entry.next);
			}
		}
		return null;
	}*/

	@Override
	public int size() {
		return size;
	}

	static class Entry<K, V> implements Map.Entry<K, V> {
		K k;
		V v;
		Entry<K, V> next;

		public Entry(K k, V v, Entry<K, V> next) {
			super();
			this.k = k;
			this.v = v;
			this.next = next;
		}

		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}

	}

}
