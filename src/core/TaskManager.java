package core;

import model.Status;
import model.Task;
import model.Epic;
import model.SubTask;
import java.util.ArrayList;


public interface TaskManager {

    // набор методов для Task
    int createTask(Task task);

    ArrayList<Task> getTasks();

    void updateTask(Task task);

    void clearTasks();

    Task removeTask(int id);

    Task getTaskId(int id);

    //набор методов для SubTask
    int createSubTask(SubTask subTask);

    ArrayList<SubTask> getSubtaskTasks();

    void updateSubTask(SubTask subTask);

    void clearSubTasks();

    void removeSubTask(SubTask subTask);

    Task getSubTaskId(int id);

    //набор методов для Epic
    int createEpic(Epic epic);

    Status updateEpic(Epic epic, int epicId);

    ArrayList<Epic> getEpics();

    void clearEpics();

    void removeEpic(Epic epic);

    Task getSubEpicId(int id);
    ArrayList<Task> getHistory();

}