package core;

import model.Task;

import java.util.ArrayList;

public interface HistoryManager {

   default void add(Task task) {

   }

    default ArrayList<Task> getHistory() {

        return null;
    }

}
