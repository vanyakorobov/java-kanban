package Core;

import Enum.Status;
import Storage.Task;
import Storage.Epic;
import Storage.SubTask;

import java.util.HashMap;


public class Manager {
    private int newTaskId = 1;
    private int newEpicId = 1;
    private int newSubTaskId = 1;

    HashMap<Integer, Task> taskMap = new HashMap<>();
    HashMap<Integer, SubTask> subTaskMap = new HashMap<>();
    HashMap<Integer, Epic> epicMap = new HashMap<>();

    // набор методов для Task

    public int createTask(Task task) {
        task.setId(newTaskId++);
        taskMap.put(task.getId(), task);

        return task.getId();
    }


    public String printAllTasks() {

        return taskMap.toString();
    }

    public void updateTask(int id, Task task) {
        task.setId(id);
        taskMap.put(task.getId(), task);
    }

    public void clearTasks() {
        taskMap.clear();
    }

    public Task removeTask(int id) {
        return taskMap.remove(id);

    }

    public Task getTaskId(int id) {
        return taskMap.get(id);
    }




    //набор методов для SubTask
    public int createSubTask(SubTask subTask) {
        subTask.setId(newSubTaskId++);
        subTaskMap.put(subTask.getId(), subTask);

        return subTask.getId();
    }


    public void printAllSubTasks() {

        subTaskMap.toString();
    }

    public void updateSubTask(SubTask subTask) {
        subTaskMap.put(subTask.getId(), subTask);
    }

    public void clearSubTasks() {
        subTaskMap.clear();
    }

    public void removeSubTask(SubTask subTask) {
        subTaskMap.remove(subTask.getId());

    }

    public Task getSubTaskId(int id) {
        return subTaskMap.get(id);
    }








//набор методов для Epic
    public int createEpic(Epic epic) {
        epic.setId(newEpicId++);
        epicMap.put(epic.getId(), epic);

        return epic.getId();
    }

    public Status updateEpic(Epic epic, int epicId) {
        epicMap.put(epic.getId(), epic);
        epic = epicMap.get(epicId);
            if (epic == null) {
                return Status.NEW; // если эпик пустой вернуть статус new
        }

        boolean allDone = true;
        boolean anyInProgress = false;

        for (int subTaskId : epic.getSubTaskId()) {
            SubTask subTask = subTaskMap.get(subTaskId); // получаем сабтаск по id
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

    public void printAllEpic() {

        epicMap.toString();
    }



    public void clearEpic() {
        epicMap.clear();
    }

    public void removeEpic(Epic epic) {
        epicMap.remove(epic.getId());

    }

    public Task getSubEpicId(int id) {
                return epicMap.get(id);
    }
}