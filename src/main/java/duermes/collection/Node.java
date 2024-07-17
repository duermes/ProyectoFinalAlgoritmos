package duermes.collection;

import java.time.Month;

public class Node<K, V> {
    private K key;
    private V value;
    private Node next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node <K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}
