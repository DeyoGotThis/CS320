package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskTest {

	//Test valid task creation
    @Test
    public void testValidTask() {
        Task task = new Task("12345", "Name", "Description");
        assertEquals("12345", task.getTaskId());
        assertEquals("Name", task.getName());
        assertEquals("Description", task.getDescription());
    }

 // Test invalid Task ID (null or longer than 10 characters)
    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Description"));
    }

 // Test invalid name (null or longer than 20 characters)
    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "This name is not valid", "Description"));
    }
    
    // Test setter for name
    @Test
    public void testSetName() {
    	Task task = new Task();
    	String name = "Name";
    	task.setName(name);
    	assertEquals(task.getName(), name);
    }

 // Test invalid description (null or longer than 50 characters)
    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Name", "This description is more than 50 characters and is invalid"));
    }
    
    // Test setter for description
    @Test
    public void testSetDescription() {
    	Task task = new Task();
    	String description = "Description";
    	task.setDescription(description);
    	assertEquals(task.getDescription(), description);
    }

    // Test that fields cannot be updated outside of allowed setters
    @Test
    public void testImmutableTaskId() {
    	Task task = new Task("12345", "Name", "Description");
        assertThrows(IllegalAccessException.class, 
            () -> task.getClass().getDeclaredField("taskId").set(task, "67890"));
    }
}
