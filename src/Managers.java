import core.HistoryManager;
import core.InMemoryHistoryManager;
import core.TaskManager;

public class Managers {
    InMemoryHistoryManager inMemoryHistoryManager;

    public static TaskManager getDefault() {
        // здесь должна быть реализация, которая возвращает нужный объект-менеджер

        return new DefaultTaskManager();
    }

    static HistoryManager getDefaultHistory(){

        return new InMemoryHistoryManager();
    }

}

class DefaultTaskManager implements TaskManager {

    // здесь реализуем все методы, определенные в интерфейсе TaskManager

}
