import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TaskList {

    private ArrayList<TaskItem> taskList;

    //Constructors
    public TaskList()
    {
        taskList = new ArrayList<>();
    }

    //Helpers
    public void display() {
        for(int i = 0; i < taskList.size(); i++) {
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
            for(int i = 0; i < taskList.size(); i++) {
                if(taskList.get(i).isComplete()){
                    System.out.print(i + ") ");
                    System.out.println("[" + taskList.get(i).getTaskDate()+ "] " + taskList.get(i).getTaskTitle() + ": " + taskList.get(i).getTaskDescription() + "\n");
                }
            }
        }catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: item not found in list");

        }
    }
    public void displayIncomplete() {
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------\n");
        try {
            for(int i = 0; i < size(); i++) {
                if(! taskList.get(i).isComplete()){
                    System.out.print(i + ") ");
                    System.out.println("[" + taskList.get(i).getTaskDate()+ "] " + taskList.get(i).getTaskTitle() + ": " + taskList.get(i).getTaskDescription() + "\n");
                }
            }
        }catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: item not found in list");

        }
    }
    public void saveList(String str){
        try {
            FileWriter writer = new FileWriter(str);
            writer.write(1 + "\n");
            writer.write(size() + "\n");
            for(TaskItem item : taskList){
                writer.write(item.getTaskTitle() + "\n");
                writer.write(item.getTaskDescription() + "\n");
                writer.write(item.getTaskDate() + "\n");
                writer.write(item.isComplete() + "\n");
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
            if(Integer.parseInt(reader.nextLine()) != 1) {
                throw new FileNotFoundException();
            }
            int size = Integer.parseInt(reader.nextLine()); //set size
            TaskItem item;
            //Load Items to List
            for (int i = 0; i < size; i++) {
                item = new TaskItem(reader.nextLine(), reader.nextLine(), reader.nextLine());
                item.setComplete(Boolean.parseBoolean(reader.nextLine()));
                reader.nextLine();
                taskList.add(item);
            }
            reader.close();
        }catch (FileNotFoundException e) {
            System.out.println("WARNING: File Not Found/Invalid File");
            taskList.clear();
        }catch (NoSuchElementException e) {
            System.out.println("WARNING: file is corrupted");
            taskList.clear();
        }catch (Exception e) {
            System.out.println("WARNING: unexpected error");
            taskList.clear();
        }
    }
    public void add(String title, String description, String date) {
        TaskItem item = new TaskItem(title, description, date);
        taskList.add(item);
    }
    public void remove(int i) {
        try {
            taskList.remove(i);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task not in list");
        }
    }
    public void clear() {
        taskList.clear();
    }

    //Setters
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
            TaskItem item = new TaskItem(title, description, date);
            taskList.set(i, item);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task is not in list");
        }
    }

    //Getters
    public String getTaskTitle(int i) {
        try{
            return taskList.get(i).getTaskTitle();
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task not in list");
        }
        return null;
    }
    public String getTaskDescription(int i) {
        try{
            return taskList.get(i).getTaskDescription();
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task not in list");
        }
        return null;
    }
    public String getTaskDate(int i) {
        try{
            return taskList.get(i).getTaskDate();
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: task not in list");
        }
        return null;
    }
    public ArrayList<TaskItem> getTaskList() {
        return taskList;
    }
    public int size() {
        return taskList.size();
    }
}
