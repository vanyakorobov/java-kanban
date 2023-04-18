package core;

import model.Task;

import java.util.ArrayList;

public interface HistoryManager {
    ArrayList<Task> history = new ArrayList<>();

    void add(Task task);

    ArrayList<Task> getHistory();

}
