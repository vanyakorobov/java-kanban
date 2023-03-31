package Storage;

import java.util.ArrayList;

public class Epic extends Task {

    protected ArrayList<String> subTaskStatus = new ArrayList<>();
    public Epic(String title, String description, int id, String[] status) {
        super(title, description, id, status);
    }

    public ArrayList<String> getSubtaskStatus() {
        return subTaskStatus;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtaskStatus=" + subTaskStatus +
                '}';
    }
}