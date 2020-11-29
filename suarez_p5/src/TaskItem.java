import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class TaskItem {

    private String taskTitle;
    private String taskDescription;
    private Date taskDate;
    private boolean complete;

    //Constructor
    public TaskItem(String taskTitle, String taskDescription, String taskDate) {
        try {
            if (taskTitle.length() < 1) {
                throw new InputMismatchException();
            } else {
                this.taskDate = toDate(taskDate);
                this.taskTitle = taskTitle;
                this.taskDescription = taskDescription;
                this.complete = false;
            }
        }catch(InputMismatchException e) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        }catch(ParseException e) {
            System.out.println("WARNING: invalid date");
        }catch(Exception e) {
            System.out.println("WARNING: unknown error");
        }
    }
    //Helpers
    private static Date toDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        return formatter.parse(date);
    }
    public void editTaskItem(String taskTitle, String taskDescription, String taskDate) {
        try {
            if (taskTitle.length() < 1) {
                throw new InputMismatchException();
            } else {
                this.taskDate = toDate(taskDate);
                this.taskTitle = taskTitle;
                this.taskDescription = taskDescription;
                this.complete = false;
            }
        }catch(ParseException e) {
            System.out.println("WARNING: invalid date");
        }catch(InputMismatchException e) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        }catch(Exception e) {
            System.out.println("WARNING: unknown error");
        }
    }
    //Set/Edit
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    //Getters
    public String getTaskTitle() {
        return taskTitle;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public String getTaskDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(taskDate);
    }
    public boolean isComplete() {
        return complete;
    }
}
