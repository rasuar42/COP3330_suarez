import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskApp {

    public static void main(String[] args) {
        TaskApp app = new TaskApp();
        app.run();
    }

    public void run() {
        TaskList taskList;
        int select;


        while (true) {
            //Main Menu
            while (true) {
                mainMenu();
                select = getMenuInput();
                switch(select) {
                    case 1:
                        taskList = new TaskList();
                        System.out.println("new task list has been created");
                        break;
                    case 2:
                        //Load List
                        taskList = loadTaskList();
                        if(taskList == null){
                            continue;
                        }else{
                            break;
                        }
                    case 3:
                        return;
                    default:
                        System.out.println("Enter a valid selection");
                        continue;
                }
                break;
            }

            //Sub Menu
            while (true) {
                subMenu();
                select = getMenuInput();
                switch (select) {
                    case 1:
                        //viewList;
                        System.out.println("Current Tasks");
                        System.out.println("-------------");
                        taskList.display();
                        continue;
                    case 2:
                        //addItem;
                        addItem(taskList);
                        continue;
                    case 3:
                        //editItem();
                        System.out.println("Current Tasks");
                        System.out.println("-------------");
                        taskList.display();
                        editItem(taskList);
                        continue;
                    case 4:
                        //removeItem;
                        System.out.println("Current Tasks");
                        System.out.println("-------------");
                        taskList.display();
                        removeItem(taskList);
                        continue;
                    case 5:
                        //markComplete;
                        taskList.displayIncomplete();
                        markComplete(taskList);
                        continue;
                    case 6:
                        //unmarkComplete();
                        taskList.displayComplete();
                        unmarkComplete(taskList);
                        continue;
                    case 7:
                        //saveList;
                        saveList(taskList);
                        continue;
                    case 8:
                        //Exits to Main Menu
                        taskList.clear();   //Empties List
                        break;
                    default:
                        System.out.println("Enter a valid selection");
                        continue;
                }
                break;
            }
        }
    }


    public void mainMenu() {
        System.out.print("\n" +
                "Main Menu\n" +
                "---------\n" +
                "\n" +
                "1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n" +
                "\n");
    }
    public void subMenu() {
        System.out.print("\n" +
                "List Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu\n" +
                "\n");
    }
    public void addItem(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Task title: ");
            String title = in.nextLine();
            in.reset();
            System.out.print("Task description: ");
            String description = in.nextLine();
            in.reset();
            System.out.print("Task due date (YYYY-MM-DD): ");
            list.add(title, description, in.nextLine());     //Adding Item
            in.reset();
        }catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }catch (Exception e) {
            System.out.println("WARNING: unknown error");
            e.printStackTrace();
        }
    }
    public void removeItem(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Which task will you remove? ");
            int i = in.nextInt();
            list.remove(i);
        }catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }
    }
    public void editItem(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Which task will you edit? ");
            int i = in.nextInt();
            System.out.print("Enter a new title for task " + i + ": ");
            String title = in.nextLine();
            in.reset();
            System.out.print("Enter a new description for task " + i + ": ");
            String description = in.nextLine();
            in.reset();
            System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + i + ": ");
            list.editTaskItem(i, title, description, in.nextLine());    //This line does the actual editing
            in.reset();
        }catch (InputMismatchException e) {
            System.out.println("WARNING: input mismatch");
        }catch (Exception e){
            System.out.println("WARNING: Unknown Error");
            e.printStackTrace();
        }
    }
    public void markComplete(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Which task will you mark as completed? ");
            int i = in.nextInt();
            list.setTaskComplete(i);
        }catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }
    }
    public void unmarkComplete(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Which task will you unmark as completed? ");
            int i = in.nextInt();
            list.setTaskIncomplete(i);
        }catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }
    }
    public void saveList(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the filename to save as: ");
            String str = in.nextLine();
            list.saveList(str);
            System.out.println("task list has been saved");
        }catch (InputMismatchException e) {
            System.out.println("WARNING: invalid file name");
        }
    }
    public TaskList loadTaskList() {
        try {
            //Ask File
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the filename to load: ");
            String str = in.nextLine();
            TaskList taskList = new TaskList();
            taskList.loadList(str);
            return taskList;
        }catch(InputMismatchException e) {
            System.out.println("WARNING: invalid file name");
        }catch(NoSuchElementException e) {
            System.out.println("WARNING: cannot read file");
        }catch (Exception e) {
            System.out.println("WARNING: unexpected error");
            e.printStackTrace();
        }
        return null;
    }
    public static int getMenuInput() {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        }catch (InputMismatchException E) {
            System.out.println("WARNING: Incorrect Input");
        }catch (Exception e){
            System.out.println("Warning: Unknown Error");
        }
        return -1;
    }

}