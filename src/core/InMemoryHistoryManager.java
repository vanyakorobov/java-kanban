package core;

import model.Task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryManager implements HistoryManager {
    private CustomLinkedList<Task> history = new CustomLinkedList<>();
    private Map<Integer, Node<Task>> historyMap = new HashMap<>();
    private static final int MAX_SIZE = 10;

    @Override
    public void add(Task task) {
        Node<Task> node = historyMap.get(task.getId());
        if (node != null) {
            history.removeNode(node);
        }
        Node<Task> newNode = history.addNode(task);
        historyMap.put(task.getId(), newNode);
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
}
