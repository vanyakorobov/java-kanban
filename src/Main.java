import core.InMemoryHistoryManager;
import core.InMemoryTaskManager;
import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;
public class Main {

    public static void main(String[] args) {

        InMemoryTaskManager manager = new InMemoryTaskManager();
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
        Task task = new Task("Задача", "Описание этой задачи", Status.NEW);
        Epic epic = new Epic("Эпик", "описание этого эпике", Status.NEW);
        SubTask subTask = new SubTask("Подзадача", "описание этой подзадачи", Status.NEW);
        SubTask subTask1 = new SubTask("Подзадача 1", "описание подзадачи 1", Status.IN_PROGRESS);
        SubTask subTask2 = new SubTask("Подзадача 2", "описание подзадачи 2", Status.IN_PROGRESS);
        SubTask subTask3 = new SubTask("Подзадача 3", "описание подзадачи 3", Status.NEW);
        SubTask subTask4 = new SubTask("Подзадача 4", "описание подзадачи 4", Status.DONE);
        SubTask subTask5 = new SubTask("Подзадача 5", "описание подзадачи 5", Status.IN_PROGRESS);
        manager.createEpic(epic);
        manager.createTask(task);
        manager.createSubTask(subTask);
        manager.createSubTask(subTask1);
        manager.createSubTask(subTask2);
        manager.createSubTask(subTask3);
        manager.createSubTask(subTask4);
        manager.createSubTask(subTask5);
        manager.getTaskId(1);
        manager.getSubTaskId(1);
        manager.getSubEpicId(1);
        manager.getTaskId(1);
        manager.getSubTaskId(1);
        manager.getSubEpicId(1);
        manager.getTaskId(1);
        manager.getSubTaskId(1);
        manager.getSubEpicId(1);
        manager.getTaskId(1);
        manager.getSubTaskId(1);
        manager.getSubEpicId(1);
        manager.getTaskId(1);
        manager.getSubTaskId(1);
        manager.getSubEpicId(1);
        manager.getHistory();
    }

}
