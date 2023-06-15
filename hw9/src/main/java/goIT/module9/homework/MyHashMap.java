package goIT.module9.homework;

public class MyHashMap {
    private Node[] nodes;
    private int size;
    private static final int DEFAULT_CAPACITY = 15;

    private class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        nodes = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        Node newNode = new Node(key, value);

        if (nodes[index] == null) {
            nodes[index] = newNode;
            size++;
        } else {
            Node currentNode = nodes[index];
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
            } else {
                currentNode.next = newNode;
                size++;
            }
        }
    }

    public void remove(Object key) {
        int index = getIndex(key);
        Node currentNode = nodes[index];
        Node previousNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (previousNode == null) {
                    nodes[index] = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        nodes = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = getIndex(key);
        Node currentNode = nodes[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    private int getIndex(Object key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % nodes.length);
    }
}
