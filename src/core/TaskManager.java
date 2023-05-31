package core;

import model.Task;
import model.Epic;
import model.SubTask;
import java.util.List;


public interface TaskManager {
    // Метод создания задачи
     int createTask(Task task);

    // Метод обновления задачи
     void updateTask(Task task);

    // Метод очистки списка задач
     void clearTasks();

    // Метод удаления задачи
     void removeTask(int id);

    // Метод получения задачи по идентификатору
     Task getTask(int id);

    // Метод создания блока задач
     int createEpic(Epic epic);

    // Метод обновления блока задач
     void updateEpic(Epic epic);

    // Метод получения блока задач по идентификатору
     Epic getEpic(int id);

    // Метод очистки списка блоков задач
     void clearEpics();

    // Метод удаления блока задач
     void removeEpic(int id);

    // Метод создания подзадачи
     int createSubTask(SubTask subTask);

    // Метод обновления подзадачи
     void updateSubTask(SubTask subTask);

    // Метод получения подзадачи по идентификатору
     SubTask getSubTask(int id);

    // Метод очистки списка подзадач блока задач
     void clearSubTasks();

    // Метод удаления подзадачи
    void removeSubs(int id);

    // Метод получения списка истории задач
     List<Task> getHistory();

}