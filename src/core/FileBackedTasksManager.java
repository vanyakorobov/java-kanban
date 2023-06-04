package core;

import model.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileBackedTasksManager extends InMemoryTaskManager {


    public static void main(String[] args) {
        FileBackedTasksManager fileBackedTasksManager = new FileBackedTasksManager();

        Task task = new Task("Задача", "Описание этой задачи", Status.NEW, TypeOfTasks.TASK);
        Epic epic = new Epic("Эпик", "описание этого эпике", Status.NEW, TypeOfTasks.EPIC);
        Epic epic1 = new Epic("Эпик", "описание этого эпике", Status.NEW,TypeOfTasks.EPIC);

        SubTask subTask = new SubTask("Подзадача", "описание этой подзадачи", Status.IN_PROGRESS, 1, TypeOfTasks.SUBTASK);
        SubTask subTask1 = new SubTask("Подзадача 1", "описание подзадачи 1", Status.NEW,2, TypeOfTasks.SUBTASK);

        fileBackedTasksManager.createEpic(epic);
        fileBackedTasksManager.createEpic(epic1);

        fileBackedTasksManager.createTask(task);
        fileBackedTasksManager.createSubTask(subTask);
        fileBackedTasksManager.createSubTask(subTask1);

        fileBackedTasksManager.getEpic(1);
        fileBackedTasksManager.getHistory();

        fileBackedTasksManager.getEpic(2);
        fileBackedTasksManager.getHistory();

        fileBackedTasksManager.getEpic(3);
        fileBackedTasksManager.getEpic(4);
        fileBackedTasksManager.getEpic(5);
        fileBackedTasksManager.getEpic(6);
        fileBackedTasksManager.getEpic(7);
        fileBackedTasksManager.getEpic(8);
        fileBackedTasksManager.getEpic(9);
        fileBackedTasksManager.getEpic(10);
        fileBackedTasksManager.getEpic(11);
        fileBackedTasksManager.getEpic(9);
        fileBackedTasksManager.getEpic(2);
        fileBackedTasksManager.getHistory();
        fileBackedTasksManager.getEpic(5);
    }



    static InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
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
                for (Integer id : getHistoryManager().getHistoryMap().keySet()) { // сохранение истории
                    String str = String.valueOf(id);
                    fileWriter.write(str);
                    fileWriter.write(",");
                }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void loadFromFile() {
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
                    } if (a != null) {
                        if (tasks.get(i) != null){
                            inMemoryHistoryManager.add(tasks.get(i));
                        } if (epics.get(i) != null) {
                            inMemoryHistoryManager.add(epics.get(i));
                        } if (subTasks.get(i) != null) {
                            inMemoryHistoryManager.add(subTasks.get(i));
                        }
                    }
                }
            }
            System.out.println();
        } catch (IOException e) {
            throw new ManagerSaveException("An error occurred while saving data.", e);
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
    public int createTask(Task task) {
        super.createTask(task);
        save();
        return task.getId();
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

    @Override
    public void updateTask(Task task) { // Обновление задач
        super.updateTask(task);
        save();
    }

    @Override
    public void updateEpic(Epic epic) { // Обновление Эпика
        super.updateEpic(epic);
        save();
    }

    @Override
    public void updateSubTask(SubTask subTask) { // Обновление подзадачи
        super.updateSubTask(subTask);
        save();
    }

    @Override
    public void clearEpics() { // Удаление Эпика и всех его подзадач
        super.clearEpics();
        save();
    }

    @Override
    public void clearTasks() {
        super.clearTasks();
        save();
    }

    @Override
    public void clearSubTasks() { // Удаление всех подзадач
        super.clearSubTasks();
        save();
    }

    }
