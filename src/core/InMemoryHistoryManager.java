package core;

import model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryHistoryManager implements HistoryManager{
    protected CustomLinkedList<Task> history = new CustomLinkedList<>();
    protected Map<Integer, Node<Task>> historyMap = new HashMap<>();
    private static final int MAX_SIZE = 10;

    @Override
    public  Map<Integer, Node<Task>> getHistoryMap(){
        return historyMap;
    }
    @Override
    public void add(Task task) {
        Node<Task> node = historyMap.get(task.getId());
        if (node != null) {
            history.removeNode(node);
        }
        history.linkLast(task);
        historyMap.put(task.getId(), history.tail);
        if (history.size > MAX_SIZE) {
            Task removed = history.head.data;
            history.removeNode(history.head);
            historyMap.remove(removed.getId());
        }
    }

    @Override
    public void remove(int id) {
        Node<Task> node = historyMap.get(id);
        if (node != null) {
            history.removeNode(node);
            historyMap.remove(id);
        }
    }

    @Override
    public List<Task> getHistory() {
        return history.getTasks();
    }

    private class CustomLinkedList<T> { // Этот класс отвечает за связный лист, который используется для сохранения истории
        // просмотров, проходила по нему, и удаляла повторяющиеся элементы.
        private Node<T> head;
        private Node<T> tail;
        private int size = 0; // я согласен, что метод getSize нигде нее используется, но переменная size учавствует в
        // алгоритме добавления и удаления узлов.

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

    }
}