import core.FileBackedTasksManager;
import model.*;

public class Main {

    public static void main(String[] args) {

        FileBackedTasksManager file = new FileBackedTasksManager();
        file.read();
    }
}