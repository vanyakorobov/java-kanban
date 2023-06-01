package model;

public class SubTask extends Task {
    private int epicId;
    protected TypeOfTasks type;

    public SubTask(String title, String description, Status status, int epicId, TypeOfTasks type) {
        super(title, description, status, type);
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
