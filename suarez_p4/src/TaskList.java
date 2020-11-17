import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    private ArrayList<TaskItem> taskList;
    private int size;


    //Constructors
    public TaskList()
    {
        taskList = new ArrayList<TaskItem>();
        size = 0;
    }
    public TaskList(String str){
        try {
            File file = new File(str);
            Scanner reader = new Scanner(file);
            taskList = new ArrayList<TaskItem>(); //Initialize List
            size = reader.nextInt(); //set size
            TaskItem item;
            //Load Items to List
            for(int i = 0; i < size; i++) {
                item = new TaskItem(reader.nextLine(), reader.nextLine(), reader.nextLine());
                reader.nextLine();
                taskList.add(item);
            }
        }catch (FileNotFoundException e) {
            System.out.println("WARNING: File Not Found");
        }
    }

    //Useful Functions
    public void displayTask() {
        for(int i = 0; i < size; i++) {
            System.out.print(i + ") ");
            if(taskList.get(i).isComplete()) {
                System.out.print("*** ");
            }
            System.out.println("[" + taskList.get(i).getTaskDate()+ "] " + taskList.get(i).getTaskTitle() + ": " + taskList.get(i).getTaskDescription() + "\n");
        }
    }
    public void displayComplete() {
        try {
            System.out.println("Completed Tasks");
            System.out.println("-------------\n");
            for(int i = 0; i < getSize(); i++) {
                if(taskList.get(i).isComplete()){
                    System.out.print(i + ") ");
                    System.out.println("[" + taskList.get(i).getTaskDate()+ "] " + taskList.get(i).getTaskTitle() + ": " + taskList.get(i).getTaskDescription() + "\n");
                }
            }
        }catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: item not found in list");

        }
    }
    public void displayUnconplete() {
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------\n");
        try {
            for(int i = 0; i < getSize(); i++) {
                if(! taskList.get(i).isComplete()){
                    System.out.print(i + ") ");
                    System.out.println("[" + taskList.get(i).getTaskDate()+ "] " + taskList.get(i).getTaskTitle() + ": " + taskList.get(i).getTaskDescription() + "\n");
                }
            }
        }catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: item not found in list");

        }
    }
    public void addTask(TaskItem task) {
        taskList.add(task);
        size++;
    }
    public void removeTask(int i) {
        try {
            taskList.remove(i);
            size--;
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task not in list");
        }
    }
    public void saveList(String str){
        try{
            File file = new File(str);
            if (file.createNewFile()) {
                System.out.println("task list has been created");
            } else {
                System.out.println("file already exists.");
            }
        }catch(IOException e){
            System.out.println("Have not gotter nere yet");
        }
    }
    public void setTaskComplete(int i) {
        try{
            TaskItem item = taskList.get(i);
            item.setComplete(true);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: item not found in the array");
        }
    }
    public void setTaskIncomplete(int i) {
        try{
            TaskItem item = taskList.get(i);
            item.setComplete(false);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: item not found in the array");
        }
    }
    public void editTaskItem(int i, String title, String description, String date) {
        try{
            TaskItem item = taskList.get(i);
            item.editTaskItem(title, description, date);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task is not in list");
        }
    }

    //Getters
    public String getTaskTitle(int i) {
        try{
            TaskItem item = taskList.get(i);
            return item.getTaskTitle();
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task not in list");
        }
        return null;
    }
    public String getTaskDescription(int i) {
        try{
            TaskItem item = taskList.get(i);
            return item.getTaskDescription();
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task not in list");
        }
        return null;
    }
    public String getTaskDate(int i) {
        try{
            TaskItem item = taskList.get(i);
            return item.getTaskDate();
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task not in list");
        }
        return null;
    }
    public ArrayList<TaskItem> getTaskList() {
        return taskList;
    }
    public int getSize() {
        return size;
    }
}
