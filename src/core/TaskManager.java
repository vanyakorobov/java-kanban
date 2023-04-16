package core;

import model.Status;
import model.Task;
import model.Epic;
import model.SubTask;
import java.util.ArrayList;


public interface TaskManager {

    // набор методов для Task
    default int createTask(Task task) {

        return 0;
    }

     default ArrayList<Task> getTasks(){

         return null;
     }

     default void updateTask(Task task) {

    }

     default void clearTasks() {

    }

     default Task removeTask(int id) {


         return null;
     }

     default Task getTaskId(int id) {

         return null;
     }

    //набор методов для SubTask
    default int createSubTask(SubTask subTask) {

        return 0;
    }

     default ArrayList<SubTask> getSubtaskTasks(){

         return null;
     }

     default void updateSubTask(SubTask subTask) {

    }

     default void clearSubTasks() {

    }

     default void removeSubTask(SubTask subTask) {

    }

     default Task getSubTaskId(int id) {

         return null;
     }

//набор методов для Epic
    default int createEpic(Epic epic) {

        return 0;
    }

     default Status updateEpic(Epic epic, int epicId) {

         return null;
     }

     default ArrayList<Epic> getEpics(){

         return null;
     }

     default void clearEpics() {

    }

     default void removeEpic(Epic epic) {


    }

     default Task getSubEpicId(int id) {

         return null;
     }

}