import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem {

    private String taskTitle;
    private String taskDescription;
    private Date taskDate;
    private boolean complete;

    //Constructor
    public TaskItem(String taskTitle, String taskDescription, String taskDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            if (validTitleSize(taskTitle)) {
                this.taskDate = formatter.parse(taskDate);
                this.taskTitle = taskTitle;
                this.taskDescription = taskDescription;
                this.complete = false;
            } else {
                throw new Exception();
            }
        }catch(ParseException e) {
            System.out.println("WARNING: invalid due date; task not created");
        }catch(Exception e) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        }
    }
    //Custom Functions
    private static boolean validTitleSize(String str){
        if(str.length() < 1) {
            return false;
        }else {
            return true;
        }
    }
    public void editTaskItem(String taskTitle, String taskDescription, String taskDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            if (validTitleSize(taskTitle)) {
                this.taskDate = formatter.parse(taskDate);
                this.taskTitle = taskTitle;
                this.taskDescription = taskDescription;
                this.complete = false;
            } else {
                throw new Exception();
            }
        }catch(ParseException e) {
            System.out.println("WARNING: invalid due date; task not changed");
        }catch(Exception e) {
            System.out.println("WARNING: title must be at least 1 character long; task not changed");
        }
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

    //Setters
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
