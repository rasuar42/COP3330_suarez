import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        assertDoesNotThrow(() -> new ContactItem("", "", "", ""));
    }
    @Test
    public void creationSucceedsWithBlankEmail() {
        assertDoesNotThrow(() -> new ContactItem("John", "Smith", "95475949", ""));
    }
    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow(() -> new ContactItem("", "Smith", "95475949", "johnSmith@tardis.eu"));
    }
    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow(() -> new ContactItem("John", "", "95475949", "johnSmith@tardis.eu"));
    }
    @Test
    public void creationSucceedsWithBlankPhone() {
        assertDoesNotThrow(() -> new ContactItem("John", "Smith", "", "johnSmith@tardis.eu"));
    }
    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow(() -> new ContactItem("John", "Smith", "95475949", "johnSmith@tardis.eu"));
    }
    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem item = new ContactItem("John", "Smith", "95475949", "johnSmith@tardis.eu");
        assertDoesNotThrow(() -> item.editContactItem("", "", "", ""));
    }
    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem item = new ContactItem("John", "Smith", "95475949", "johnSmith@tardis.eu");
        assertDoesNotThrow(() -> item.editContactItem("Alan", "Turing", "4765239866", ""));
    }
    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("John", "Smith", "95475949", "johnSmith@tardis.eu");
        assertDoesNotThrow(() -> item.editContactItem("", "Turing", "4765239866", "alanTuring@enigma.tr"));
    }
    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("John", "Smith", "95475949", "johnSmith@tardis.eu");
        assertDoesNotThrow(() -> item.editContactItem("Alan", "", "4765239866", "alanTuring@enigma.tr"));
    }
    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("John", "Smith", "95475949", "johnSmith@tardis.eu");
        assertDoesNotThrow(() -> item.editContactItem("Alan", "Turing", "", "alanTuring@enigma.tr"));
    }
    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("John", "Smith", "95475949", "johnSmith@tardis.eu");
        assertDoesNotThrow(() -> item.editContactItem("Alan", "Turing", "4765239866", "alanTuring@enigma.tr"));
    }
    @Test
    public void testToString() {
        ContactItem item = new ContactItem("John", "Smith", "95475949", "johnSmith@tardis.eu");
        assertEquals("Name: John Smith" + "\n" + "Phone: 95475949"+ "\n" + "Email: johnSmith@tardis.eu", item.toString());
    }
}