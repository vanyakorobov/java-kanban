package model;

public class Task {
    protected String title;
    protected String description;
    protected int id;
    protected Status status;
    protected TypeOfTasks type;



    public Task(String title, String description, Status status, TypeOfTasks type) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
        return id + "," +
                type + "," +
                title + "," +
                status + "," +
                description;
    }
}
