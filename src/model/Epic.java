package model;
import java.util.ArrayList;


public class Epic extends Task {
    protected ArrayList<Integer> subTaskIds = new ArrayList<>();

    public Epic(String title, String description, Status status) {
        super(title, description, status);
    }

    public ArrayList<Integer> getSubTaskId() {
        return subTaskIds;
    }

    public void setSubTaskId(ArrayList<Integer> subTaskId) {
        this.subTaskIds = subTaskId;
    }

    @Override
    public String toString() {
        return "Epic{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}