package goIT.module9.homework;

public class MyArrayList {
    private Object[] array;
    private int size = 0;

    public MyArrayList(){
        array = new Object[15];
    }

    public void add(Object value){
        // in case array is full
        if (array.length == size) {
            Object[] biggerArray = new Object[array.length * 2];
            // assign existing data to new array
            for(int i = 0; i < array.length; i++){
                biggerArray[i] = array[i];
            }
            array = biggerArray;
        }
        array[size] = value;
        size++;
    }
    public void remove(int index){
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        for(int i = index; i < size-1; i++){
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }
    public void clear(){
        array = new Object[15];
        size = 0;
    }
    public int size(){
        return size;
    }
    public Object get(int index){
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return array[index];
    }
}
