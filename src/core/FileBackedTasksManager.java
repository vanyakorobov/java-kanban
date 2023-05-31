package core;

import model.Epic;
import model.SubTask;
import model.Task;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FileBackedTasksManager extends InMemoryTaskManager {
    InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
    public void save() {
        try(Writer fileWriter = new FileWriter("C:\\Users\\79779\\dev\\java-kanban\\src\\core\\saved.csv", false)) {
            fileWriter.write("id,type,name,status,description,epic\n");
            for (Epic id : epics.values()) {
                String str = id.toString();
                fileWriter.write(str);
                fileWriter.write("\n");
            }
            for (Task id : tasks.values()) {
                String str = id.toString();
                fileWriter.write(str);
                fileWriter.write("\n");
            }
            for (SubTask id : subTasks.values()) {
                String str = id.toString();
                fileWriter.write(str);
                fileWriter.write("\n");
            }
                fileWriter.write("\n");
                for (Integer id : inMemoryHistoryManager.historyMap.keySet()) {
                    String str = String.valueOf(id);
                    fileWriter.write(str);
                }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
    @Override
    public int createEpic(Epic epic) {
        super.createEpic(epic);
        save();
        return epic.getId();
    }

    @Override
    public int createSubTask(SubTask subTask) {
        super.createSubTask(subTask);
        save();
        return subTask.getId();
    }

    @Override
    public Epic getEpic(int id) { // Получение Эпика по ID
        super.getEpic(id);
        save();
        return epics.get(id);
    }

    @Override
    public List<Task> getHistory() { // Просмотр истории
        super.getHistory();
        save();
        return historyManager.getHistory();
    }

    @Override
    public Task getTask(int id) {
        super.getTask(id);
        save();
        return tasks.get(id);
    }

    @Override
    public SubTask getSubTask(int id) {// Получение подзадачи по ID
        super.getSubTask(id);
        save();
        return subTasks.get(id);
    }
    }
