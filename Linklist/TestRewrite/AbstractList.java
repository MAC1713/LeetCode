package Linklist.TestRewrite;

public abstract class AbstractList<E> implements List<E> {
    protected int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public void add(E element) {
        add(size, element);
    }
}
