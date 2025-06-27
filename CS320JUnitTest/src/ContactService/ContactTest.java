package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    // Test valid Contact creation
    @Test
    public void testValidContact() {
        Contact contact = new Contact("12345", "Deyo", "Leo", "5555555555", "504 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("Deyo", contact.getFirstName());
        assertEquals("Leo", contact.getLastName());
        assertEquals("5555555555", contact.getPhone());
        assertEquals("504 Main St", contact.getAddress());
    }

    // Test invalid Contact ID (null or longer than 10 characters)
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact(null, "Deyo", "Leo", "5555555555", "504 Main St"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345678901", "Deyo", "Leo", "5555555555", "504 Main St"));
    }

    // Test invalid first name (null or longer than 10 characters)
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", null, "Leo", "5555555555", "504 Main St"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyodeyodeyo", "Leo", "5555555555", "504 Main St"));
    }

    // Test setter for first name
    @Test
    public void testSetFirstName() {
    	Contact contact = new Contact();
    	String firstName = "Deyo";
    	contact.setFirstName(firstName);
    	assertEquals(contact.getFirstName(), firstName);
    }
    
    // Test invalid last name (null or longer than 10 characters)
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyo", null, "5555555555", "504 Main St"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyo", "Leoleoleoleo", "5555555555", "504 Main St"));
    }
    
    // Test setter for last name
    @Test
    public void testSetLastName() {
    	Contact contact = new Contact();
    	String lastName = "Leo";
    	contact.setLastName(lastName);
    	assertEquals(contact.getLastName(), lastName);
    }

    // Test invalid phone number (null or not exactly 10 digits)
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyo", "Leo", null, "504 Main St"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyo", "Leo", "555", "504 Main St"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyo", "Leo", "15555555555", "504 Main St"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyo", "Leo", "abcdefghij", "504 Main St"));
    }
    
    // Test setter for phone number
    @Test
    public void testSetPhone() {
    	Contact contact = new Contact();
    	String phone = "5555555555";
    	contact.setPhone(phone);
    	assertEquals(contact.getPhone(), phone);
    }

    // Test invalid address (null or longer than 30 characters)
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyo", "Leo", "5555555555", null));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Deyo", "Leo", "5555555555", "504 Main St New Orleans Louisiana"));
    }
    
    // Test setter for address
    @Test
    public void testSetAddress() {
    	Contact contact = new Contact();
    	String address = "504 Main St";
    	contact.setAddress(address);
    	assertEquals(contact.getAddress(), address);
    }

    // Test that fields cannot be updated outside of allowed setters
    @Test
    public void testImmutableContactId() {
        Contact contact = new Contact("12345", "Deyo", "Leo", "5555555555", "504 Main St");
        assertThrows(IllegalAccessException.class, 
            () -> contact.getClass().getDeclaredField("contactId").set(contact, "67890"));
    }
}
