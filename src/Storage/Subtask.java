package Storage;

public class Subtask extends Task {
    protected String EpicStatus;
    public Subtask(String title, String description, int id, String[] status) {
        super(title, description, id, status);
    }

    public String getEpicStatus() {
        return EpicStatus;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "EpicStatus='" + EpicStatus + '\'' +
                '}';
    }
}
