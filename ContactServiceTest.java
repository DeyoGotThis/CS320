package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Deyo", "Leo", "5555555555", "504 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Deyo", "Leo", "5555555555", "504 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Deyo", "Leo", "5555555555", "504 Main St");
        service.addContact(contact);

        // Update fields
        service.updateContact("12345", "John", "Smith", "4444444444", "123 Main St");
        Contact updatedContact = service.getContact("12345");

        // Assert updated fields
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("4444444444", updatedContact.getPhone());
        assertEquals("123 Main St", updatedContact.getAddress());
    }

}
