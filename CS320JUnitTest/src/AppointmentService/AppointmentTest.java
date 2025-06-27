package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentTest {

	// Test valid appointment creation
    @Test
    void testValidAppointment() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        Appointment appointment = new Appointment("12345", appointmentDate, "Description");
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(appointmentDate, appointment.getDate());
        assertEquals("Description", appointment.getDescription());
    }

    // Test invalid Appointment ID (null or longer than 10 characters)
    @Test
    void testInvalidAppointmentId() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, appointmentDate, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", appointmentDate, "Description"));
    }

    // Test invalid date (null or in the past)
    @Test
    void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 60000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", pastDate, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", null, "Description"));
    }
    
 // Test setter for date
    @Test
    public void testSetDate() {
    	Appointment appointment = new Appointment();
    	Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
    	appointment.setDate(appointmentDate);
    	assertEquals(appointment.getDate(), appointmentDate);
    }

    // Test invalid description (null or longer than 50 characters)
    @Test
    void testInvalidDescription() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", appointmentDate, null));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", appointmentDate, "This description is more than 50 characters and is invalid"));
    }
    
    // Test setter for description
    @Test
    public void testSetDescription() {
    	Appointment appointment = new Appointment();
    	String description = "Description";
    	appointment.setDescription(description);
    	assertEquals(appointment.getDescription(), description);
    }
      
    // Test that fields cannot be updated outside of allowed setters
    @Test
    public void testImmutableAppointmentId() {
    	Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        Appointment appointment = new Appointment("12345", appointmentDate, "Description");
        assertThrows(IllegalAccessException.class, 
            () -> appointment.getClass().getDeclaredField("appointmentId").set(appointment, "67890"));
    }
}