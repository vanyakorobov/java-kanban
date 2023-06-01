package core;

import model.Task;
import java.util.List;
import java.util.Map;

public interface HistoryManager {


    Map<Integer, Node<Task>> getHistoryMap();

    void add(Task Task); // Добавление задач в историю
    List<Task> getHistory(); // Получение списка
    void remove(int id); // удаление задачи из просмотра
}
