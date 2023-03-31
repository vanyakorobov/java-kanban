package Core;

import Storage.Epic;
import Storage.Subtask;
import Storage.Task;

public class Main {

    public static void main(String[] args) {
        Task task = new Task("Задача", "задач", 1, new String[] {"NEW"});
        Task task1 = new Task("Задача1", "задач1", 2, new String[] {"NEW"});
        Epic epic = new Epic("Эпик1", "Описание эпика 1", 1, new String[] {"DONE"});
        Subtask subtask = new Subtask("Подзадача1", "Подзадача", 1, new String[] {"NEW"});
        Subtask subtask1 = new Subtask("Подзадача2", "Подзадача", 2, new String[] {"DONE"});
        Manager manager = new Manager();
        manager.createTask(task);
        manager.createTask(task1);
        manager.printAllTasks();
        manager.createEpic(epic);
        manager.createSubtask(subtask);
        manager.createSubtask(subtask1);
        manager.updateSubtask(subtask);
        System.out.println(epic);
    }

}
