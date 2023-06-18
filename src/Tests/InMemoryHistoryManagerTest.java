package Tests;

import core.HistoryManager;
import core.InMemoryHistoryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Status;
import model.Task;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    HistoryManager manager;
    private int id = 0;

    // объявление класса, содержащего методы тестирования и наследующего абстрактный класс TaskManagerTest
    public int generateId() {
        // метод, генерирующий уникальный идентификатор и возвращающий его значение
        return ++id;
    }

    // объявление защищенного метода createTask(), возвращающего новый экземпляр задачи с фиксированными параметрами
    protected Task createTask() {
        return new Task("Description", "Title", Status.NEW, Instant.now(), 0);
    }

    // метод, аннотированный @BeforeEach, вызывающийся перед каждым тестом
    @BeforeEach
    public void beforeEach() {
        // создание нового экземпляра InMemoryHistoryManager и присвоение его переменной manager
        manager = new InMemoryHistoryManager();
    }

    // тест на проверку корректного добавления задач в историю
    @Test
    public void shouldAddTasksToHistory() {
        // создание трех задач
        Task task1 = createTask();
        int newTaskId1 = generateId();
        task1.setId(newTaskId1);
        Task task2 = createTask();
        int newTaskId2 = generateId();
        task2.setId(newTaskId2);
        Task task3 = createTask();
        int newTaskId3 = generateId();
        task3.setId(newTaskId3);
        // добавление задач в историю
        manager.add(task1);
        manager.add(task2);
        manager.add(task3);
        // сравнение полученных значений с ожидаемыми
        assertEquals(List.of(task1, task2, task3), manager.getHistory());
    }

    // тест на проверку корректного удаления задачи из истории
    @Test
    public void shouldRemoveTask() {
        // создание трех задач
        Task task1 = createTask();
        int newTaskId1 = generateId();
        task1.setId(newTaskId1);
        Task task2 = createTask();
        int newTaskId2 = generateId();
        task2.setId(newTaskId2);
        Task task3 = createTask();
        int newTaskId3 = generateId();
        task3.setId(newTaskId3);
        // добавление задач в историю
        manager.add(task1);
        manager.add(task2);
        manager.add(task3);
        // удаление задачи task2 из истории
        manager.remove(task2.getId());
        // сравнение полученных значений с ожидаемыми
        assertEquals(List.of(task1, task3), manager.getHistory());
    }

    // тест на проверку корректного удаления единственной задачи из истории
    @Test
    public void shouldRemoveOnlyOneTask() {
        // создание задачи
        Task task = createTask();
        int newTaskId = generateId();
        task.setId(newTaskId);
        // добавление задачи в историю
        manager.add(task);
        // удаление задачи из истории
        manager.remove(task.getId());
        // сравнение полученного значения с ожидаемым (пустым списком)
        assertEquals(Collections.EMPTY_LIST, manager.getHistory());
    }

    // тест на проверку корректного удаления всех задач из пустой истории
    @Test
    public void shouldHistoryIsEmpty() {
        // создание трех задач
        Task task1 = createTask();
        int newTaskId1 = generateId();
        task1.setId(newTaskId1);
        Task task2 = createTask();
        int newTaskId2 = generateId();
        task2.setId(newTaskId2);
        Task task3 = createTask();
        int newTaskId3 = generateId();
        task3.setId(newTaskId3);
        // удаление всех задач из пустой истории
        manager.remove(task1.getId());
        manager.remove(task2.getId());
        manager.remove(task3.getId());
        // сравнение полученного значения с ожидаемым (пустым списком)
        assertEquals(Collections.EMPTY_LIST, manager.getHistory());
    }

    // тест на проверку некорректного удаления задачи с несуществующим идентификатором из истории
    @Test
    public void shouldNotRemoveTaskWithBadId() {
        // создание задачи
        Task task = createTask();
        int newTaskId = generateId();
        task.setId(newTaskId);
        // добавление задачи в историю
        manager.add(task);
        // удаление задачи из истории с несуществующим идентификатором
        manager.remove(0);
        // сравнение полученных значений с ожидаемыми
        assertEquals(List.of(task), manager.getHistory());
    }
}