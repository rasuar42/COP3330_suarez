import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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


    //Useful Functions
    public void displayTask() {
        for(int i = 0; i < size; i++) {
            System.out.print(i + ") ");
            if(taskList.get(i).isComplete()) {
                System.out.print("*** ");
            }
            System.out.println("[" + taskList.get(i).getTaskDate()+ "] " + taskList.get(i).getTaskTitle() + ": " + taskList.get(i).getTaskDescription());
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
    public void addTask(String title, String description, String date) {
        TaskItem item = new TaskItem(title, description, date);
        taskList.add(item);
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
        File file = new File(str);

        try {
            FileWriter writer = new FileWriter(str);
            writer.write(size + "\n");
            for(int i = 0; i < size; i++){
                writer.write(taskList.get(i).getTaskTitle() + "\n");
                writer.write(taskList.get(i).getTaskDescription() + "\n");
                writer.write(taskList.get(i).getTaskDate() + "\n");
                writer.write(taskList.get(i).isComplete() + "\n");
                writer.write("\n");
            }
            writer.write("----------");
            writer.close();
        }catch (IOException e){
            System.out.println("WARNING: there was an error writing to the file");
        }

    }
    public void loadList(String str) {
        try {
            File file = new File(str);
            Scanner reader = new Scanner(file);
            size = Integer.parseInt(reader.nextLine()); //set size
            TaskItem item;
            String title;
            String description;
            String date;
            boolean complete;
            //Load Items to List
            for (int i = 0; i < size; i++) {
                title = reader.nextLine();
                description = reader.nextLine();
                date = reader.nextLine();
                item = new TaskItem(title, description, date);
                item.setComplete(Boolean.parseBoolean(reader.nextLine()));
                reader.nextLine();
                taskList.add(item);
            }
            reader.close();
        }catch (FileNotFoundException e) {
            System.out.println("WARNING: File Not Found");
        }catch (NoSuchElementException e) {
            System.out.println("WARNING: file is corrupted");
        }catch (Exception e) {
            System.out.println("WARNING: unexpected error");
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
    public boolean equals(TaskList list){
        if (this.size == list.getSize() && this.taskList.equals(list.getTaskList())){
            return true;
        }else {
            return false;
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
