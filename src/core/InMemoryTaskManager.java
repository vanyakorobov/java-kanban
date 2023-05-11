package core;

import model.Status;
import model.Task;
import model.Epic;
import model.SubTask;

import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager { // Класс InMemoryTaskManager отвечает за реализацию методов,
    // для создания задач
    private int id = 1;
    private HashMap<Integer, Task> tasks = new HashMap<>(); // Хранение данных задач
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HistoryManager historyManager = Managers.getDefaultHistory();

    @Override
    public int createTask(Task task) { // Создание задачи
        task.setId(id++);
        tasks.put(task.getId(), task);

        return task.getId();
    }

    @Override
    public void updateTask(Task task) { // Обновление задач
        tasks.put(task.getId(), task);
    }

    @Override
    public void clearTasks() { // Удаление всех задач
        tasks.clear();
    }

    @Override
    public void removeTask(int id) { // Удаление задач по ID
        tasks.remove(id);
    }

    @Override
    public Task getTask(int id) { // Получение задачи по ID
        historyManager.add(tasks.get(id));
        return tasks.get(id);
    }

    @Override
    public int createEpic(Epic epic) { // Создание Эпика
        epic.setId(id++);

        epics.put(epic.getId(), epic);

        return epic.getId();
    }

    @Override
    public void updateEpic(Epic epic) { // Обновление Эпика
        epics.put(epic.getId(), epic);

    }

    @Override
    public Epic getEpic(int id) { // Получение Эпика по ID
        historyManager.add(epics.get(id));

        return epics.get(id);
    }

    @Override
    public void clearEpics() { // Удаление Эпика и всех его подзадач
        epics.clear();
        subTasks.clear();
    }

    @Override
    public void removeEpic(int id) { // Удаление Эпика по ID
        Epic epic = epics.remove(id);

        for (Integer toRemove : epic.getSubTaskId()) {
            subTasks.remove(toRemove);
        }
    }

    @Override
    public int createSubTask(SubTask subTask) { // Создание подзадачи
        subTask.setId(id++);
        subTasks.put(subTask.getId(), subTask);

        int epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);
        epic.getSubTaskId().add(subTask.getId());
        statusCreator(subTask);

        return subTask.getId();
    }


    @Override
    public SubTask getSubTask(int id) {// Получение подзадачи по ID
        historyManager.add(subTasks.get(id));
        return subTasks.get(id);
    }

    @Override
    public void clearSubTasks() { // Удаление всех подзадач
        subTasks.clear();
        for (Epic epic : epics.values()) {
            if (epic.getSubTaskId().isEmpty()) {
                epic.setStatus(Status.NEW);
            }
        }
    }


    @Override
    public List<Task> getHistory() { // Просмотр истории
        System.out.println(historyManager.getHistory());
        return historyManager.getHistory();
    }

    @Override
    public void updateSubTask(SubTask subTask) { // Обновление подзадачи
        subTasks.put(subTask.getId(), subTask);
        statusCreator(subTask);
    }

    @Override
    public void removeSubs(int id) { // Удаление подзадачи
        SubTask subTask = subTasks.remove(id);
        statusCreator(subTask);
    }

    private void statusCreator(SubTask subTask) {
        int epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);

        Status status = null;

        for (Integer subTaskId : epic.getSubTaskId()) {
            SubTask anyStat = subTasks.get(subTaskId);
            if (anyStat != null && !anyStat.equals(subTask)) {
                status = anyStat.getStatus();
                if (status.equals(Status.IN_PROGRESS)) {
                    epic.setStatus(status);
                    break;
                } else if (status.equals(Status.DONE)) {
                    epic.setStatus(status);
                }
            }
        }
        if (epic.getSubTaskId().size() == 1) {
            epic.setStatus(Status.NEW);
        }
    }

}