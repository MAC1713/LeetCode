package Linklist.TestRewrite;

import org.w3c.dom.Node;

public interface List<E> {
    int size();

    boolean isEmpty();

    boolean contains(E element);

    void add(E element);

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(E element);

    void clear();
}

