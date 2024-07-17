package duermes.collection;

public class Hashtable<K, V> {
    private Node<K, V>[] table;
    private int size;
    private static final double LOAD_FACTOR = 0.75;
    private int itemCount;

    public Hashtable(int size) {
        this.size = size;
        this.table = new Node[size];
        this.itemCount = 0;
    }
    public Hashtable() {
        this(11);
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % size);
    }

    public void put(K key, V value) {
        if ((double)itemCount / size >= LOAD_FACTOR) {
            resize();
        }

        int index = hash(key);

        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + 1) % size; // Linear probing
        }

        if (table[index] == null) {
            itemCount++;
        }

        table[index] = new Node(key, value);
    }

    public V get(K key) {
        int index = hash(key);

        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                return table[index].getValue();
            }
            index = (index + 1) % size;
        }

        return null;
    }

    private void resize() {
        int newSize = size * 2;
        Node<K, V>[] newTable = new Node[newSize];
        Node<K, V>[] oldTable = table;

        table = newTable;
        size = newSize;
        itemCount = 0;

        for (Node<K, V> node : oldTable) {
            if (node != null) {
                put(node.getKey(), node.getValue());
            }
        }
    }

    public String display() {
        String answer = "";
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                answer += "Index " + i + ": " + table[i].getKey() + " -> " + table[i].getValue() + "\n";
            } else {
                answer += "Index " + i + ": null\n";
            }
        }

        return answer;
    }

    public int getSize() {
        return size;
    }

    public Node<K, V>[] getTable() {
        return table;
    }
}

