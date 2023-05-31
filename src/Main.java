import core.FileBackedTasksManager;
import core.InMemoryHistoryManager;
import core.InMemoryTaskManager;
import model.*;

public class Main {

    public static void main(String[] args) {

        FileBackedTasksManager file = new FileBackedTasksManager();
        InMemoryHistoryManager hh = new InMemoryHistoryManager();
        Task task = new Task("Задача", "Описание этой задачи", Status.NEW);
        Epic epic1 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic2 = new Epic("Эпик", "описание этого эпике", Status.NEW);
        Epic epic3 = new Epic("Эпик", "описание этого эпике", Status.NEW);


        file.createEpic(epic1);
        file.createEpic(epic2);
        file.createEpic(epic3);

        file.createTask(task);


        file.getEpic(1);
        file.getHistory();

        file.getEpic(2);
        file.getHistory();

        file.getEpic(3);
        file.getHistory();

        file.getTask(4);
        file.getHistory();

        System.out.println(hh.historyMap.keySet());
    }
}