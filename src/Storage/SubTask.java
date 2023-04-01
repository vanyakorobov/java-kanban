package Storage;



public class SubTask extends Epic {
    protected int epicId;

    public SubTask(String title, String description, int id) {
        super(title, description, id);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    public Status getStatus() {
        return null;
    }

    public void setStatus(Status newStatus) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "epicId=" + epicId +
                ", subTaskId=" + subTaskId +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
