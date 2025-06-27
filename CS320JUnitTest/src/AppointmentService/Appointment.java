package AppointmentService;

import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private Date date;
    private String description;

    public Appointment(String appointmentId, Date date, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Invalid date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.appointmentId = appointmentId;
        this.date = date;
        this.description = description;
    }

    public Appointment() {
  		this.appointmentId = "";
		this.date = new Date();
		this.description = "";	
  	}
    
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDate(Date date) {
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.date = date;
    }
    
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}