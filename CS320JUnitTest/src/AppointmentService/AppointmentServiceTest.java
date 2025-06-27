package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    // Test adding new appointment
    @Test
    void testAddAppointment() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        Appointment appointment = new Appointment("12345", appointmentDate, "Description");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("12345"));
    }

    // Test adding appointment with duplicate id (should be invalid)
    @Test
    void testAddDuplicateAppointment() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        Appointment appointment = new Appointment("12345", appointmentDate, "Description");
        appointmentService.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment));
    }

    // Test deleting appointment
    @Test
    void testDeleteAppointment() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        Appointment appointment = new Appointment("12345", appointmentDate, "Description");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("12345");
        assertNull(appointmentService.getAppointment("12345"));
    }

    // Test deleting non-existent appointment
    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("67890"));
    }
    
    // Test updating existing appointment date
    @Test
    public void testUpdateAppointmentDate() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        Date newDate = new Date(System.currentTimeMillis() + 300000);
        Appointment appointment = new Appointment("12345", appointmentDate, "Description");
        appointmentService.addAppointment(appointment);
        appointmentService.updateAppointmentDate("12345", newDate);
        assertEquals(newDate, appointmentService.getAppointment("12345").getDate());
    }
    
    // Test updating existing description
    @Test
    public void testUpdateDescription() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 60000);
        Appointment appointment = new Appointment("12345", appointmentDate, "Description");
        appointmentService.addAppointment(appointment);
        appointmentService.updateDescription("12345", "New Description");
        assertEquals("New Description", appointmentService.getAppointment("12345").getDescription());
    }
    
}
