package goIT.module9.homework;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        Object value;
        Node next;
        Node prev;

        Node(Node prev, Object value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public void add(Object value) {
        Node l = tail;
        Node newNode = new Node(l, value, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        if (temp.prev == null) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }

        if (temp.next == null) {
            tail = temp.prev;
        } else {
            temp.next.prev = temp.prev;
        }

        size--;
    }

    public void clear() {
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.value;
    }

}
