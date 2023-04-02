package Storage;
import Enum.Status;

public class SubTask extends Task {
    protected int epicId;
    Status status;
    protected int id;

    public SubTask(String title, String description, Status status) {
        super(title, description, status);
        this.status = status;
    }

    @Override
    public int getId() {
        return id;
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
