import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList list = new TaskList();
        assertEquals(0, list.getSize());
        list.addTask("Title", "Description", "2001-04-27");
        assertEquals(1, list.getSize());
        list.addTask("Title1", "description1", "2001-04-28");
        assertEquals(2, list.getSize());
    }
    @Test
    public void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        //index 0 item 1
        assertFalse(list.getTaskList().get(0).isComplete());
        list.setTaskComplete(0);
        assertTrue(list.getTaskList().get(0).isComplete());
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        assertDoesNotThrow(() -> list.setTaskComplete(100));
    }
    @Test
    public void editingTaskItemChangesValues() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        list.editTaskItem(0, "NewTitle", "NewDescription", "2020-11-16");

        assertEquals("NewTitle", list.getTaskList().get(0).getTaskTitle());
        assertEquals("NewDescription", list.getTaskList().get(0).getTaskDescription());
        assertEquals("2020-11-16", list.getTaskList().get(0).getTaskDate());
    }
    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        list.editTaskItem(0, "NewTitle", "NewDescription", "2020-11-16");

        assertEquals("NewDescription", list.getTaskList().get(0).getTaskDescription());

    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");
        //Change Description
        assertDoesNotThrow(() -> list.editTaskItem(100, "Title", "NewDescription", "2001-04-27"));
    }
    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        list.editTaskItem(0, "NewTitle", "NewDescription", "2020-11-16");

        assertEquals("2020-11-16", list.getTaskList().get(0).getTaskDate());
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");
        //Change Date
        assertDoesNotThrow(() -> list.editTaskItem(100, "Title", "Description", "2020-11-16"));
    }
    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        list.editTaskItem(0, "NewTitle", "Description", "2001-04-27");

        assertEquals("NewTitle", list.getTaskList().get(0).getTaskTitle());
    }
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");
        //Change Title
        assertDoesNotThrow(() -> list.editTaskItem(100, "NewTitle", "Description", "2001-04-27"));
    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        assertDoesNotThrow(() -> list.getTaskDescription(100));
    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        assertEquals("Description", list.getTaskDescription(0));
    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        assertDoesNotThrow(() -> list.getTaskDate(100));
    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        assertEquals("2001-04-27", list.getTaskDate(0));
    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        assertDoesNotThrow(() -> list.getTaskTitle(100));
    }
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        assertEquals("Title", list.getTaskTitle(0));
    }
    @Test
    public void newTaskListIsEmpty() {
        TaskList list = new TaskList();

        assertEquals(0, list.getSize());

    }
    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");
        assertEquals(1, list.getSize());
        list.removeTask(0);
        assertEquals(0, list.getSize());
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        assertDoesNotThrow(() -> list.removeTask(100));
    }
    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList list = new TaskList();
        list.loadList("test.txt");

        assertEquals(2, list.getSize());
        assertEquals("Title 1", list.getTaskTitle(0));
        assertEquals("Description 1", list.getTaskDescription(0));
        assertEquals("2001-04-27", list.getTaskDate(0));
        assertEquals("Title 2", list.getTaskTitle(1));
        assertEquals("Description 2", list.getTaskDescription(1));
        assertEquals("2001-04-28", list.getTaskDate(1));

    }
    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        //index 0 item 1
        list.setTaskComplete(0);
        assertTrue(list.getTaskList().get(0).isComplete());
        list.setTaskIncomplete(0);
        assertFalse(list.getTaskList().get(0).isComplete());
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Title", "Description", "2001-04-27");

        //index 0 item 1
        list.setTaskComplete(0);
        assertTrue(list.getTaskList().get(0).isComplete());
        assertDoesNotThrow(() -> list.setTaskIncomplete(42069));
        assertTrue(list.getTaskList().get(0).isComplete());
    }

}