package goIT.module9.homework;

import java.util.NoSuchElementException;

public class MyStack {
    private Object[] elements;
    private int size;

    public MyStack() {
        elements = new Object[10];
        size = 0;
    }

    public void push(Object value) {
        if (size == elements.length) {
            resizeArray(elements.length * 2);
        }
        elements[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public void clear() {
        elements = new Object[15];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return elements[size - 1];
    }

    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        Object value = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return value;
    }

    private void resizeArray(int newCapacity) {
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}