package model;
import Enum.Status;

public class Task {
    protected String title;
    protected String description;
    protected int id;
    protected Status status;


    public Task(String title, String description, Status status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }


    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", Status=" + status +
                '}';
    }
}
