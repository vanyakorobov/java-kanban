package core;

import model.Task;

import java.util.List;

public interface HistoryManager {
    void add(Task Task); // Добавление задач в историю
    List<Task> getHistory(); // Получение списка
}
