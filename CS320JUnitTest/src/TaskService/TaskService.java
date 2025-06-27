package TaskService;

import java.util.HashMap;

import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

   
    public void addTask(Task task) {  
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        taskMap.put(task.getTaskId(), task);
    }
   
    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskMap.remove(taskId);
    }
     public Task getTask(String taskId) {
        return taskMap.get(taskId);
    } 

    public void updateTaskName(String taskId, String name) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskMap.get(taskId).setName(name);
    }

    public void updateTaskDescription(String taskId, String description) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskMap.get(taskId).setDescription(description);
    }

   
}
