package Storage;


public class Task { // Суперкласс
    protected String title;
    protected String description;
    protected int id;



    public Task(String title, String description, int id) {
        this.title = title;
        this.description = description;
        this.id = id;

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
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}