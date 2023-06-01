package model;
import java.util.ArrayList;


public class Epic extends Task {
    protected ArrayList<Integer> subTaskIds = new ArrayList<>();
    protected TypeOfTasks type;

    public Epic(String title, String description, Status status, TypeOfTasks type) {
        super(title, description, status, type);
    }

    public ArrayList<Integer> getSubTaskId() {
        return subTaskIds;
    }

    public void setSubTaskId(ArrayList<Integer> subTaskId) {
        this.subTaskIds = subTaskId;
    }

    @Override
    public String toString() {
        return id + "," +
                type + "," +
                title + "," +
                status + "," +
                description;
    }
}