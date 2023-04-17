package core;


import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;

import java.util.ArrayList;

public class Managers {

    public static TaskManager getDefault() {
        // здесь должна быть реализация, которая возвращает нужный объект-менеджер

        return new DefaultTaskManager() {
            @Override
            public ArrayList<Task> getHistory() {
                return null;
            }
        };
    }

    public static HistoryManager getDefaultHistory(){

        return new InMemoryHistoryManager();
    }

}

abstract class DefaultTaskManager implements TaskManager {


    @Override
    public int createTask(Task task) {
        return 0;
    }

    @Override
    public ArrayList<Task> getTasks() {
        return null;
    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void clearTasks() {

    }

    @Override
    public Task removeTask(int id) {
        return null;
    }

    @Override
    public Task getTaskId(int id) {
        return null;
    }

    @Override
    public int createSubTask(SubTask subTask) {
        return 0;
    }

    @Override
    public ArrayList<SubTask> getSubtaskTasks() {
        return null;
    }

    @Override
    public void updateSubTask(SubTask subTask) {

    }

    @Override
    public void clearSubTasks() {

    }

    @Override
    public void removeSubTask(SubTask subTask) {

    }

    @Override
    public Task getSubTaskId(int id) {
        return null;
    }

    @Override
    public int createEpic(Epic epic) {
        return 0;
    }

    @Override
    public Status updateEpic(Epic epic, int epicId) {
        return null;
    }

    @Override
    public ArrayList<Epic> getEpics() {
        return null;
    }

    @Override
    public void clearEpics() {

    }

    @Override
    public void removeEpic(Epic epic) {

    }

    @Override
    public Task getSubEpicId(int id) {
        return null;
    }

    // здесь реализуем все методы, определенные в интерфейсе TaskManager

}