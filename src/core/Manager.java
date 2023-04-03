package core;

import Enum.Status;
import model.Task;
import model.Epic;
import model.SubTask;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private int newTaskId = 1;
    private int newEpicId = 1;
    private int newSubTaskId = 1;

    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, SubTask> subTasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();

    // набор методов для Task
    public int createTask(Task task) {
        task.setId(newTaskId++);
        tasks.put(task.getId(), task);

        return task.getId();
    }

    public ArrayList<Task> getTasks(){
        return new ArrayList<>(tasks.values());
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void clearTasks() {
        tasks.clear();
    }

    public Task removeTask(int id) {
        return tasks.remove(id);

    }

    public Task getTaskId(int id) {
        return tasks.get(id);
    }

    //набор методов для SubTask
    public int createSubTask(SubTask subTask) {
        subTask.setId(newSubTaskId++);
        subTasks.put(subTask.getId(), subTask);

        return subTask.getId();
    }

    public ArrayList<SubTask> getSubtaskTasks(){
        return new ArrayList<>(subTasks.values());
    }

    public void updateSubTask(SubTask subTask) {
        subTasks.put(subTask.getId(), subTask);
    }

    public void clearSubTasks() {
        subTasks.clear();
    }

    public void removeSubTask(SubTask subTask) {
        subTasks.remove(subTask.getId());
    }

    public Task getSubTaskId(int id) {
        return subTasks.get(id);
    }

//набор методов для Epic
    public int createEpic(Epic epic) {
        epic.setId(newEpicId++);
        epics.put(epic.getId(), epic);

        return epic.getId();
    }

    public Status updateEpic(Epic epic, int epicId) {
        epics.put(epic.getId(), epic);
        epic = epics.get(epicId);
            if (epic == null) {
                return Status.NEW; // если эпик пустой вернуть статус new
        }

        boolean allDone = true;
        boolean anyInProgress = false;

        for (int subTaskId : epic.getSubTaskId()) {
            SubTask subTask = subTasks.get(subTaskId); // получаем сабтаск по id
            if (subTask != null && subTask.getStatus() == Status.IN_PROGRESS) {
                anyInProgress = true; // если хотя бы один сабтаск ин прогресс, то статус эпика будет ин прогресс
                allDone = false;
                break;
            } else if (subTask != null && subTask.getStatus() != Status.DONE) {
                allDone = false; // если есть сабтаск, который не в статусе done, статус эпика будет new
            }
        }

            if (allDone) {
            return Status.DONE; // все сабтаски выполнены, статус эпика done
            } else if (anyInProgress) {
            return Status.IN_PROGRESS; // хотя бы один сабтаск в прогрессе, статус эпика ин прогрес
            } else {
                return Status.NEW; // еще есть невыполненные сабтаски, статус эпика new
        }
    }

    public ArrayList<Epic> getEpic(){
        return new ArrayList<>(epics.values());
    }

    public void clearEpic() {
        epics.clear();
    }

    public void removeEpic(Epic epic) {
        epics.remove(epic.getId());

    }

    public Task getSubEpicId(int id) {
                return epics.get(id);
    }
}