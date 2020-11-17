import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertDoesNotThrow(() -> new TaskItem("Test1", "Description", "0000-00-00"));
        assertDoesNotThrow(() -> new TaskItem("Test1", "Description", "04/27/2001"));
        assertDoesNotThrow(() -> new TaskItem("Test1", "Description", "13 April 2001 "));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertDoesNotThrow(() -> new TaskItem("", "Description", "2001-04-27"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        assertDoesNotThrow(() -> new TaskItem("Test", "Description", "2001-04-27"));

        /*
        assertEquals("Test", item.getTaskTitle());
        assertEquals("Description", item.getTaskDescription());
        assertEquals("2001-04-27", item.getTaskDate());
         */
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("Test", "Description", "2001-04-27"));
        /*
        assertEquals("Test", item.getTaskTitle());
        assertEquals("Description", item.getTaskDescription());
        assertEquals("2001-04-27", item.getTaskDate());
         */
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");

        //If invalid date
        assertDoesNotThrow(() -> item.editTaskItem("Test", "Description", "04/27/2001"));
        //Stays the same
        assertEquals("Test", item.getTaskTitle());
        assertEquals("Description", item.getTaskDescription());
        assertEquals("2001-04-27", item.getTaskDate());
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        //If valid Date
        assertDoesNotThrow(() -> item.editTaskItem("Test", "Description", "2021-11-04")); //New Date
        //Item changes
        assertEquals("Test", item.getTaskTitle());
        assertEquals("Description", item.getTaskDescription());
        assertEquals("2021-11-04", item.getTaskDate());
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        //If invalid Title
        assertDoesNotThrow(() -> item.editTaskItem("", "Description", "2001-04-27"));
        //Item does not change
        assertEquals("Test", item.getTaskTitle());
        assertEquals("Description", item.getTaskDescription());
        assertEquals("2001-04-27", item.getTaskDate());
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem item = new TaskItem("Test", "Description", "2001-04-27");
        //If valid Title
        assertDoesNotThrow(() -> item.editTaskItem("NewTest", "Description", "2001-04-27"));//New Title
        //Item does not change
        assertEquals("NewTest", item.getTaskTitle());
        assertEquals("Description", item.getTaskDescription());
        assertEquals("2001-04-27", item.getTaskDate());
    }


}