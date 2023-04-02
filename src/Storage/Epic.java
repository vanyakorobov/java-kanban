package Storage;
import Enum.Status;
import java.util.ArrayList;


public class Epic extends Task {
    protected ArrayList<Integer> subTaskId = new ArrayList<>();
    protected int id;


    public Epic(String title, String description, Status status) {
        super(title, description, status);
        this.subTaskId = subTaskId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Integer> getSubTaskId() {

        return subTaskId;
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