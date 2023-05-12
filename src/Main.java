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
        Epic epic1 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic2 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic3 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic4 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic5 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic6 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic7 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic8 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic9 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic10 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic11 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        SubTask subTask = new SubTask("Подзадача", "описание этой подзадачи", Status.IN_PROGRESS, 1);
        SubTask subTask1 = new SubTask("Подзадача 1", "описание подзадачи 1", Status.NEW,2);
        SubTask subTask2 = new SubTask("Подзадача 2", "описание подзадачи 2", Status.NEW,3);
        SubTask subTask3 = new SubTask("Подзадача 3", "описание подзадачи 3", Status.NEW,4);
        SubTask subTask4 = new SubTask("Подзадача 4", "описание подзадачи 4", Status.NEW,5);
        SubTask subTask5 = new SubTask("Подзадача 4", "описание подзадачи 4", Status.NEW,5);
        SubTask subTask6 = new SubTask("Подзадача 5", "описание подзадачи 5", Status.NEW,6);
        SubTask subTask7 = new SubTask("Подзадача 5", "описание подзадачи 5", Status.NEW,7);
        SubTask subTask8 = new SubTask("Подзадача 5", "описание подзадачи 5", Status.NEW,8);
        SubTask subTask9 = new SubTask("Подзадача 5", "описание подзадачи 5", Status.NEW,9);
        SubTask subTask10 = new SubTask("Подзадача 5", "описание подзадачи 5", Status.NEW,10);
        SubTask subTask11= new SubTask("Подзадача 5", "описание подзадачи 5", Status.NEW,11);
        manager.createEpic(epic);
        manager.createEpic(epic1);
        manager.createEpic(epic2);
        manager.createEpic(epic3);
        manager.createEpic(epic4);
        manager.createEpic(epic5);
        manager.createEpic(epic6);
        manager.createEpic(epic7);
        manager.createEpic(epic8);
        manager.createEpic(epic9);
        manager.createEpic(epic10);
        manager.createEpic(epic11);
        manager.createTask(task);
        manager.createSubTask(subTask);
        manager.createSubTask(subTask1);
        manager.createSubTask(subTask2);
        manager.createSubTask(subTask3);
        manager.createSubTask(subTask4);
        manager.createSubTask(subTask6);
        manager.createSubTask(subTask7);
        manager.createSubTask(subTask8);
        manager.createSubTask(subTask9);
        manager.createSubTask(subTask10);
        manager.createSubTask(subTask11);

        manager.getEpic(1);
        manager.getHistory();

        manager.getEpic(2);
        manager.getHistory();

        manager.getEpic(3);
        manager.getEpic(4);
        manager.getEpic(5);
        manager.getEpic(6);
        manager.getEpic(7);
        manager.getEpic(8);
        manager.getEpic(9);
        manager.getEpic(10);
        manager.getEpic(11);
        manager.getEpic(9);
        manager.getEpic(2);

        manager.getEpic(5);
        manager.getHistory();
    }
}