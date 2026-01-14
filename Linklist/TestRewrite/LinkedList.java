package Linklist.TestRewrite;

public class LinkedList<E> extends AbstractList<E> {
    public Node<E> first;

    private static class Node<E> {
        Node<E> next;
        Node<E> pre;
        E element;

        public Node(Node<E> next, E element, Node<E> pre) {
            this.next = next;
            this.element = element;
            this.pre = pre;
        }
    }

    private Node<E> node(int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        checkPostionIndex(index);
    }

    private void checkPostionIndex(int index) {
        if(!isPositionIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        Node<E> node = first;
        if (index == 0) {
            first = node.next;

        } else {
            Node<E> pre = node(index - 1);
            node = pre.next;
            pre.next = node.next;
        }
        return null;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public int indexOf(E element) {
        Node x = first;
        int index = 0;
        if (element == null) {
            for (Node i = first; i != null; i = i.next) {
                if (element == i.element) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node i = first; i != null; i = i.next) {
                if (element.equals(i.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }
}
