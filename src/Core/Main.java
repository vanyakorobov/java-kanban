package Core;

import Storage.Epic;
import Storage.Status;
import Storage.SubTask;
import Storage.Task;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();
        Epic epic1 = new Epic("Эпик первый", "Описание этого эпика", 1);
        SubTask subTask = new SubTask("Подзадача первая", "Описание этой подзадачи", 1);
        manager.createEpic(epic1);
        manager.printAllEpic();
        System.out.println(epic1);
        manager.createSubTask(subTask);
        subTask.setStatus(Status.IN_PROGRESS);
        manager.setEpicStatus(1);
        System.out.println("Статус эпика 1 - " + manager.setEpicStatus(1));
    }

}
