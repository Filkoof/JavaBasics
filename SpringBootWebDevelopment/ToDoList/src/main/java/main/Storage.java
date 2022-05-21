package main;

import response.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<>();

    public static List<Task> getTasks() {
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.addAll(tasks.values());
        return taskList;
    }

    public static int addAffair(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static Task getTask(int taskId){
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }

    public static Task deleteTask(int id) {
        if (tasks.containsKey(id)) {
            return tasks.remove(id);
        }
        return null;
    }

    public static Task patchTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            return tasks.replace(task.getId(), task);
        }
        return null;
    }

    public static List<Task> deleteTask() {
        ArrayList<Task> affairsList = new ArrayList<>();
        tasks.clear();
        affairsList.addAll(tasks.values());
        return affairsList;
    }
}
