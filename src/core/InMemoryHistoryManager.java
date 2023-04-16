package core;

import model.Task;

import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager {

    ArrayList<Task> history = new ArrayList<>();

    @Override
    public void add(Task task) {
        history.add(task);
    }
    @Override
    public ArrayList<Task> getHistory() {
        System.out.println("ИСТОРИЯ: " + history);
        return history;
    }

}
