package core;

public class Managers {

    public static TaskManager getDefault() {
        // здесь должна быть реализация, которая возвращает нужный объект-менеджер

        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {

        return new InMemoryHistoryManager();
    }
}

