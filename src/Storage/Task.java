package Storage;

import java.util.Arrays;

public class Task {
    protected String title;
    protected String description;
    protected int id;
    protected String[] status;


    public Task(String title, String description, int id, String[] status) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String[] status) {
        this.status = new String[3];
        status[0] = "NEW";
        status[1] = "IN_PROGRESS";
        status[2] = "DONE";
    }

    public String[] getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + Arrays.toString(status) +
                '}';
    }
}
