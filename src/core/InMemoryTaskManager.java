package core;

import model.Status;
import model.Task;
import model.Epic;
import model.SubTask;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {

    private int newTaskId = 1;
    private int newEpicId = 1;
    private int newSubTaskId = 1;

    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    HistoryManager inMemoryHistoryManager = Managers.getDefaultHistory();
    // набор методов для Task
    @Override
    public int createTask(Task task) {
        task.setId(newTaskId++);
        tasks.put(task.getId(), task);
        return task.getId();
    }

    @Override
    public ArrayList<Task> getTasks(){

        return new ArrayList<>(tasks.values());
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void clearTasks() {
        tasks.clear();
    }

    @Override
    public Task removeTask(int id) {
        return tasks.remove(id);

    }

    @Override
    public Task getTaskId(int id) {
        if (inMemoryHistoryManager.history.size() == 10) {
            inMemoryHistoryManager.history.remove(0);
        }
        inMemoryHistoryManager.add(tasks.get(id));
        return tasks.get(id);
    }

    //набор методов для SubTask
    @Override
    public int createSubTask(SubTask subTask) {
        subTask.setId(newSubTaskId++);
        subTasks.put(subTask.getId(), subTask);

        return subTask.getId();
    }

    @Override
    public ArrayList<SubTask> getSubtaskTasks(){

        return new ArrayList<>(subTasks.values());
    }

    @Override
    public void updateSubTask(SubTask subTask) {
        subTasks.put(subTask.getId(), subTask);
    }

    @Override
    public void clearSubTasks() {
        subTasks.clear();
    }

    @Override
    public void removeSubTask(SubTask subTask) {
        subTasks.remove(subTask.getId());
    }

    @Override
    public Task getSubTaskId(int id) {
        if (inMemoryHistoryManager.history.size() == 10) {
            inMemoryHistoryManager.history.remove(0);
        }
        inMemoryHistoryManager.add(subTasks.get(id));

        return subTasks.get(id);
    }

    //набор методов для Epic
    @Override
    public int createEpic(Epic epic) {
        epic.setId(newEpicId++);
        epics.put(epic.getId(), epic);

        return epic.getId();
    }

    @Override
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

    @Override
    public ArrayList<Epic> getEpics(){
        return new ArrayList<>(epics.values());
    }

    @Override
    public void clearEpics() {
        epics.clear();
    }

    @Override
    public void removeEpic(Epic epic) {
        epics.remove(epic.getId());

    }

    @Override
    public Task getSubEpicId(int id) {
        if (inMemoryHistoryManager.history.size() == 10) {
            inMemoryHistoryManager.history.remove(0);
        }
        inMemoryHistoryManager.add(epics.get(id));
        return epics.get(id);
    }

    @Override
    public ArrayList<Task> getHistory() {
        System.out.println("ИСТОРИЯ: " + inMemoryHistoryManager.history);
        return inMemoryHistoryManager.history;
    }
}