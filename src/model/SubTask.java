package model;
import Enum.Status;

public class SubTask extends Task {
    private int epicId;
    protected int id;

    public SubTask(String title, String description, Status status) {
        super(title, description, status);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", Status=" + status +
                '}';
    }
}
