package model;
import java.util.ArrayList;


public class Epic extends Task {
    protected ArrayList<Integer> subTaskIds = new ArrayList<>();

    public Epic(String title, String description, Status status) {
        super(title, description, status);
        this.subTaskIds = subTaskIds;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Integer> getSubTaskId() {

        return subTaskIds;
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