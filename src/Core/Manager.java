package Core;
import Storage.Task;
import Storage.Epic;
import Storage.Subtask;

import java.util.ArrayList;
import java.util.HashMap;


public class Manager {

    private int newId = 1;
    HashMap<Integer, Task> taskMap = new HashMap<>();
    HashMap<Integer, Subtask> subtaskMap = new HashMap<>();
    HashMap<Integer, Epic> epicMap = new HashMap<>();

    public int createTask(Task task) {
        task.setId(newId++);

        taskMap.put(task.getId(), task);

        return task.getId();
    }

    public Task getTaskById(int id) {
        return taskMap.get(id);
    }

    public void printAllTasks() {
        for (Task task : taskMap.values()) {

           task.getTitle();
        }
    }

    public void updateTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void clearTasks() {
        taskMap.clear();
    }

    public void  clearTaskId(Task task) {
        taskMap.remove(task.getId());
    }

    public int createSubtask(Subtask subTask) {
        subTask.setId(newId++);
        subtaskMap.put(subTask.getId(), subTask);

        return subTask.getId();
    }

    public void updateSubtask(Subtask subTask) {
        subtaskMap.put(subTask.getId(), subTask);
        String status = subTask.getEpicStatus();
        Epic epic = epicMap.get(status);
        ArrayList<String> subtaskStatuses = epic.getSubtaskStatus();
        String newStatus = "";
        if (subTask == null) {
            epic.setStatus(new String[]{"NEW"});
        } else if (subtaskStatuses.contains("IN_PROGRESS")) {
            newStatus = "IN_PROGRESS";
        } else if (subtaskStatuses.contains("NEW")) {
            newStatus = "NEW";
        } else {
            newStatus = "DONE";
        }
        epic.setStatus(new String[]{newStatus});
    }


    public int createEpic(Epic epic) {
        epic.setId(newId++);
        epicMap.put(epic.getId(), epic);
        return epic.getId();
    }


}
