package Storage;

import java.util.ArrayList;


public class Epic extends Task {
    protected ArrayList<Integer> subTaskId = new ArrayList<>();
    protected  String status;
    public Epic(String title, String description, int id) {

        super(title, description, id);
    }

    public ArrayList<Integer> getSubTaskId() {

        return subTaskId;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subTaskId=" + subTaskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}