import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertEquals(1, list.size());
        list.add("first", "last", "5556667788", "example@yes.zoe");
        assertEquals(2, list.size());
    }
    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertDoesNotThrow(() -> list.editContact(0, "", "", "", ""));
        //Stays Same
        assertEquals("Name: John Smith" + "\n" + "Phone: 95475949" + "\n" + "Email: theDoctor@tardis.eu", list.getContact(0).toString());
    }
    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertDoesNotThrow(() -> list.editContact(100, "first", "last", "5556667788", "example@test.com"));
    }
    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertDoesNotThrow(() -> list.editContact(0, "", "last", "5556667788", "example@test.com"));
        assertEquals("Name:  last" + "\n" + "Phone: 5556667788" + "\n" + "Email: example@test.com", list.getContact(0).toString());
    }
    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertDoesNotThrow(() -> list.editContact(0, "first", "", "5556667788", "example@test.com"));
        assertEquals("Name: first " + "\n" + "Phone: 5556667788" + "\n" + "Email: example@test.com", list.getContact(0).toString());
    }
    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertDoesNotThrow(() -> list.editContact(0, "first", "last", "", "example@test.com"));
        assertEquals("Name: first last" + "\n" + "Phone: " + "\n" + "Email: example@test.com", list.getContact(0).toString());
    }
    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertDoesNotThrow(() -> list.editContact(0, "first", "last", "5556667788", "example@test.com"));
        assertEquals("Name: first last" + "\n" + "Phone: 5556667788" + "\n" + "Email: example@test.com", list.getContact(0).toString());
    }
    //list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
    @Test
    public void newListIsEmpty() {
        ContactList list = new ContactList();
        assertEquals(0, list.size());
    }
    @Test
    public void removingItemsDecreasesSize() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertEquals(3, list.size());
        list.remove(2);
        assertEquals(2, list.size());
        list.remove(1);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        assertEquals(3, list.size());
        list.remove(42);
        assertEquals(3, list.size());
    }
    @Test
    public void savedContactListCanBeLoaded() {
        ContactList list = new ContactList();
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        list.add("John", "Smith", "95475949", "theDoctor@tardis.eu");
        list.saveList("contacts.txt");  //save list

        ContactList load = new ContactList();
        load.loadList("contacts.txt");  //load list

        //comparing items
        assertEquals("Name: John Smith" + "\n" + "Phone: 95475949" + "\n" + "Email: theDoctor@tardis.eu", load.getContact(0).toString());
        assertEquals("Name: John Smith" + "\n" + "Phone: 95475949" + "\n" + "Email: theDoctor@tardis.eu", load.getContact(1).toString());
        assertEquals("Name: John Smith" + "\n" + "Phone: 95475949" + "\n" + "Email: theDoctor@tardis.eu", load.getContact(2).toString());
        assertEquals(list.size(), load.size());
    }
}