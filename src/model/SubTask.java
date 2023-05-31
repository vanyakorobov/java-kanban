package model;

public class SubTask extends Task {
    private int epicId;
    protected TypeOfTasks type = TypeOfTasks.SUBTASK;

    public SubTask(String title, String description, Status status, int epicId) {
        super(title, description, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return id + "," +
                type + "," +
                title + "," +
                status + "," +
                description + "," +
                epicId;
    }
}
