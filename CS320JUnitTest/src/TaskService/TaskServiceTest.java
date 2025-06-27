package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	
    // Test adding new task
    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Name", "Description");
        service.addTask(task);
        assertEquals(task, service.getTask("12345"));
    } 

    // Test adding task with duplicate id (should be invalid) 
    @Test
    public void testAddTaskDuplicateId() {
        TaskService service = new TaskService();
        Task task1 = new Task("12345", "Name", "Description");
        Task task2 = new Task("12345", "Name 2", "Description 2");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
    }

    // Test deleting task
    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Name", "Description");
        service.addTask(task);
        service.deleteTask("12345");
        assertNull(service.getTask("12345"));
    }

    // Test updating existing task name
    @Test
    public void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Name", "Description");
        service.addTask(task);
        service.updateTaskName("12345", "New Name");
        assertEquals("New Name", service.getTask("12345").getName());
    }

    // Test updating existing task description
    @Test
    public void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Name", "Description");
        service.addTask(task);
        service.updateTaskDescription("12345", "New Description");
        assertEquals("New Description", service.getTask("12345").getDescription());
    }

}
