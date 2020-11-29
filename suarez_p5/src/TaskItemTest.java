import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("Test1", "Description", "0000-00-00"));
        assertDoesNotThrow(() -> new TaskItem("Test1", "Description", "04/27/2001"));
        assertDoesNotThrow(() -> new TaskItem("Test1", "Description", "13 April 2001 "));
    }
    @Test
    public void constructorFailsWithInvalidTitle() {
        assertDoesNotThrow(() -> new TaskItem("", "Description", "2001-04-27"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        assertDoesNotThrow(() -> new TaskItem("Test", "Description", "2001-04-27"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("Test", "Description", "2001-04-27"));
    }
    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        item.editTaskItem("Test", "New Description", "2001-02-27");

        assertEquals("New Description", item.getTaskDescription());
    }
    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        //If Invalid Date
        assertDoesNotThrow(() -> item.editTaskItem("Test", "Description", "January 01 2200")); //New Date
        //Date Does NOT Change
        assertEquals("2001-04-27", item.getTaskDate());
    }
    @Test
    public void editingDueDateFailsWithInvalidYYYYMMDD() {
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        //If Invalid Date
        assertDoesNotThrow(() -> item.editTaskItem("Test", "Description", "9999-99-99")); //New Date
        //Date Does NOT Change
        assertEquals("2001-04-27", item.getTaskDate());
    }
    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        //If valid Date
        assertDoesNotThrow(() -> item.editTaskItem("Test", "Description", "2021-11-04")); //New Date
        //Item changes
        assertEquals("2021-11-04", item.getTaskDate());
    }
    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        //If Invalid Title
        assertDoesNotThrow(() -> item.editTaskItem("", "Description", "2001-04-27")); //New Title
        //Item Does NOT Change
        assertEquals("Test", item.getTaskTitle());
    }
    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        //If Invalid Title
        assertDoesNotThrow(() -> item.editTaskItem("New Title", "Description", "2001-04-27")); //New Title
        //Item Does NOT Change
        assertEquals("New Title", item.getTaskTitle());
    }
}