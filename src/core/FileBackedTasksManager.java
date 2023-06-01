package core;

import model.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileBackedTasksManager extends InMemoryTaskManager {
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
                for (Integer id : getHistoryManager().getHistoryMap().keySet()) {
                    String str = String.valueOf(id);
                    fileWriter.write(str);
                    fileWriter.write(",");
                }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void read() {
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\79779\\dev\\java-kanban\\src\\core\\saved.csv"))) {
            while (reader.ready()){
                String s = reader.readLine();
                List<String> a = Arrays.asList(s.split(","));
                for (int i = 0; i < a.size(); i++) {
                    if (a.contains("EPIC")) {
                        int id = Integer.parseInt(a.get(i));
                        TypeOfTasks type = TypeOfTasks.valueOf(a.get(i+1));
                        String title = a.get(i+2);
                        Status status = Status.valueOf(a.get(i+3));
                        String description = a.get(i+4);
                        Epic epic = new Epic(title, description, status, type);
                        epic.setId(id);
                        epics.put(id, epic);
                    } if (a.contains("TASK")) {
                        int id = Integer.parseInt(a.get(i));
                        TypeOfTasks type = TypeOfTasks.valueOf(a.get(i+1));
                        String title = a.get(i+2);
                        Status status = Status.valueOf(a.get(i+3));
                        String description = a.get(i+4);
                        Task task = new Task(title, description, status, type);
                        task.setId(id);
                        tasks.put(id, task);
                    } if (a.contains("SUBTASK")) {
                        int id = Integer.parseInt(a.get(i));
                        TypeOfTasks type = TypeOfTasks.valueOf(a.get(i+1));
                        String title = a.get(i+2);
                        Status status = Status.valueOf(a.get(i+3));
                        String description = a.get(i+4);
                        int epicId = Integer.parseInt(a.get(i+5));
                        SubTask subTask = new SubTask(title, description, status, epicId, type);
                        subTask.setId(id);
                        subTasks.put(id, subTask);
                    }
                }
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
