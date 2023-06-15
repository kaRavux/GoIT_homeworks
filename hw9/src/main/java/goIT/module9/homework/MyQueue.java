package goIT.module9.homework;

import java.util.NoSuchElementException;

public class MyQueue {
    private Object[] elements;
    private int size;
    private int head;
    private int tail;

    public MyQueue() {
        elements = new Object[15];
        size = 0;
        head = 0;
        tail = 0;
    }
    public void add(Object value) {
        if (size == elements.length) {
            resizeArray(elements.length * 2); // Увеличиваем размер массива вдвое, если он заполнен
        }

        elements[tail] = value;
        tail = (tail + 1) % elements.length;
        size++;
    }

    private void resizeArray(int newCapacity) {
        Object[] newElements = new Object[newCapacity];
        int index = 0;
        for (int i = head; i != tail; i = (i + 1) % elements.length) {
            newElements[index] = elements[i];
            index++;
        }
        elements = newElements;
        head = 0;
        tail = size;
    }
    public void clear() {
        elements = new Object[15];
        size = 0;
        head = 0;
        tail = 0;
    }
    public int size(){
        return size;
    }
    public Object peek(){
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements[head];
    }
    public Object poll() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        Object value = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return value;
    }
}
