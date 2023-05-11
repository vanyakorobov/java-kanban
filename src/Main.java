import core.InMemoryTaskManager;
import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;
public class Main {

    public static void main(String[] args) {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task = new Task("Задача", "Описание этой задачи", Status.NEW);
        Epic epic = new Epic("Эпик", "описание этого эпике", Status.NEW);
        SubTask subTask = new SubTask("Подзадача", "описание этой подзадачи", Status.IN_PROGRESS, 1);
        SubTask subTask1 = new SubTask("Подзадача 1", "описание подзадачи 1", Status.NEW,1);
        SubTask subTask2 = new SubTask("Подзадача 2", "описание подзадачи 2", Status.NEW,1);
        SubTask subTask3 = new SubTask("Подзадача 3", "описание подзадачи 3", Status.NEW,1);
        SubTask subTask4 = new SubTask("Подзадача 4", "описание подзадачи 4", Status.NEW,1);
        SubTask subTask5 = new SubTask("Подзадача 5", "описание подзадачи 5", Status.NEW,1);
        manager.createEpic(epic);
        manager.createTask(task);
        manager.createSubTask(subTask);
        manager.createSubTask(subTask1);
        manager.createSubTask(subTask2);
        manager.createSubTask(subTask3);
        manager.createSubTask(subTask4);
        manager.createSubTask(subTask5);
        manager.removeEpic(1);
        System.out.println(manager.getEpic(1));
    }
}
