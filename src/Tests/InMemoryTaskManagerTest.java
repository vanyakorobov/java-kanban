package Tests;

import core.InMemoryTaskManager;
import core.Managers;
import org.junit.jupiter.api.BeforeEach;

// объявление класса InMemoryTaskManagerTest, расширяющего TaskManagerTest с параметром InMemoryTaskManager
class InMemoryTaskManagerTest extends TaskManagerTest<InMemoryTaskManager> {
    // метод, аннотированный @BeforeEach, вызывающийся перед каждым тестом
    @BeforeEach
    public void beforeEach() {
        // создание нового экземпляра InMemoryTaskManager, используя конструктор с параметром Managers.getDefaultHistory(), и присвоение его manager
        manager = new InMemoryTaskManager(Managers.getDefaultHistory());
    }
}
