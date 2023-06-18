package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Status;
import model.Epic;
import model.Task;
import core.FileBackedTasksManager;
import core.InMemoryTaskManager;
import core.Managers;
import org.junit.jupiter.api.AfterEach;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// объявление класса FileBackedTasksManagerTest, расширяющего TaskManagerTest с параметром InMemoryTaskManager
class FileBackedTasksManagerTest extends TaskManagerTest<InMemoryTaskManager> {
    // объявление константы path типа Path, инициализированной значением "data.test.csv"
    public static final Path path = Path.of("data.test.csv");
    // объявление переменной file типа File и инициализация ее значением, полученным преобразованием path в строку
    File file = new File(String.valueOf(path));

    // метод, аннотированный @BeforeEach, вызывающийся перед каждым тестом
    @BeforeEach
    public void beforeEach() {
        // создание экземпляра FileBackedTasksManager, используя конструктор с параметрами Managers.getDefaultHistory() и file, и присвоение его manager
        manager = new FileBackedTasksManager(Managers.getDefaultHistory(), file);
    }

    // метод, аннотированный @AfterEach, вызывающийся после каждого теста
    @AfterEach
    public void afterEach() {
        // попытка удалить файл по пути path, если это не удалось, выводится сообщение об ошибке в консоль
        try {
            Files.delete(path);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    // тест на проверку корректного сохранения и загрузки задач и эпиков
    @Test
    public void shouldCorrectlySaveAndLoad() {
        Task task = new Task("Description", "Title", Status.NEW, Instant.now(), 0);
        // создание задачи task
        manager.createTask(task);
        Epic epic = new Epic("Description", "Title", Status.NEW, Instant.now(), 0);
        // создание эпика epic
        manager.createEpic(epic);
        // создание нового экземпляра FileBackedTasksManager, инициализированного с параметрами Managers.getDefaultHistory() и file
        FileBackedTasksManager fileManager = new FileBackedTasksManager(Managers.getDefaultHistory(), file);
        // вызов метода loadFromFile() для загрузки данных из файла
        fileManager.loadFromFile();
        // сравнение полученных значений с ожидаемыми
        assertEquals(List.of(task), manager.getAllTasks());
        assertEquals(List.of(epic), manager.getAllEpics());
    }

    // тест на проверку сохранения и загрузки пустых задач, эпиков и подзадач
    @Test
    public void shouldSaveAndLoadEmptyTasksEpicsSubtasks() {
        // создание нового экземпляра FileBackedTasksManager, инициализированного с параметрами Managers.getDefaultHistory() и file
        FileBackedTasksManager fileManager = new FileBackedTasksManager(Managers.getDefaultHistory(), file);
        // вызов метода save() для сохранения данных в файл
        fileManager.save();
        // вызов метода loadFromFile() для загрузки данных из файла
        fileManager.loadFromFile();
        // сравнение полученных значений с ожидаемыми (пустыми списками)
        assertEquals(Collections.EMPTY_LIST, manager.getAllTasks());
        assertEquals(Collections.EMPTY_LIST, manager.getAllEpics());
        assertEquals(Collections.EMPTY_LIST, manager.getAllSubtasks());
    }

    // тест на проверку сохранения и загрузки пустой истории
    @Test
    public void shouldSaveAndLoadEmptyHistory() {
        // создание нового экземпляра FileBackedTasksManager, инициализированного с параметрами Managers.getDefaultHistory() и file
        FileBackedTasksManager fileManager = new FileBackedTasksManager(Managers.getDefaultHistory(), file);
        // вызов метода save() для сохранения данных в файл
        fileManager.save();
        // вызов метода loadFromFile() для загрузки данных из файла
        fileManager.loadFromFile();
        // сравнение полученного значения с ожидаемым (пустым списком)
        assertEquals(Collections.EMPTY_LIST, manager.getHistory());
    }
}