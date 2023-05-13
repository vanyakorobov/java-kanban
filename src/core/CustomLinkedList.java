package core;

import java.util.ArrayList;
import java.util.List;

    class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void linkLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public List<T> getTasks() {
        List<T> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            result.add(current.data);
            current = current.next;
        }
        return result;
    }

    public void removeNode(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
    }

    public Node<T> addNode(T data) {
        Node<T> node = new Node<>(data);
        linkLast(data);
        return node;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }
}
//