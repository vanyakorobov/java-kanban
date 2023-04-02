package Core;

import Storage.Epic;
import Enum.Status;
import Storage.SubTask;
import Storage.Task;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();
        Task task = new Task("Задача", "Описание этой задачи", Status.NEW);
        Epic epic = new Epic("Эпик", "описание этого эпике", Status.NEW);
        SubTask subTask = new SubTask("Подзадача", "описание этой подзадачи", Status.NEW);
        SubTask subTask1 = new SubTask("Подзадача 1", "описание подзадачи 1", Status.IN_PROGRESS);
        SubTask subTask2 = new SubTask("Подзадача 2", "описание подзадачи 2", Status.IN_PROGRESS);
        SubTask subTask3 = new SubTask("Подзадача 3", "описание подзадачи 3", Status.NEW);
        SubTask subTask4 = new SubTask("Подзадача 4", "описание подзадачи 4", Status.DONE);
        SubTask subTask5 = new SubTask("Подзадача 5", "описание подзадачи 5", Status.IN_PROGRESS);
        manager.createEpic(epic);
        manager.createSubTask(subTask);
        manager.createTask(subTask1);
        manager.createSubTask(subTask2);
        manager.createSubTask(subTask3);
        manager.createSubTask(subTask4);
        manager.createSubTask(subTask5);
        manager.addSubTaskToEpic(1, 2);
        manager.updateEpic(epic, 1);
        System.out.println(subTask);
        System.out.println(subTask1);
        System.out.println(subTask2);
        System.out.println(subTask3);
        System.out.println(subTask4);
        System.out.println(subTask5);
        System.out.println(epic);
    }

}
