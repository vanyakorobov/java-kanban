package model;

public class SubTask extends Task {
    private int epicId;

    public SubTask(String title, String description, Status status) {
        super(title, description, status);
        this.status = status;
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
                ", model.Status=" + status +
                '}';
    }
}
