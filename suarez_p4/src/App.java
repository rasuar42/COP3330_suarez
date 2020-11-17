import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
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
                        if(taskList==null){
                            continue;
                        }else{
                            break;
                        }
                    case 3:
                        System.exit(0);
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
                        taskList.displayTask();
                        continue;
                    case 2:
                        //addItem;
                        addItem(taskList);
                        continue;
                    case 3:
                        //editItem();
                        System.out.println("Current Tasks");
                        System.out.println("-------------");
                        taskList.displayTask();
                        editItem(taskList);
                        continue;
                    case 4:
                        //removeItem;
                        System.out.println("Current Tasks");
                        System.out.println("-------------");
                        taskList.displayTask();
                        removeItem(taskList);
                        continue;
                    case 5:
                        //markComplete;
                        taskList.displayUnconplete();
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
                        break;
                    default:
                        System.out.println("Enter a valid selection");
                        continue;
                }
                break;
            }
        }
    }


    public static void mainMenu() {
        System.out.print("\n" +
                "Main Menu\n" +
                "---------\n" +
                "\n" +
                "1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n" +
                "\n");
    }
    public static void subMenu() {
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


    public static void addItem(TaskList list) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Task title: ");
            String title = sc.nextLine();
            sc.reset();

            System.out.print("Task description: ");
            String description = sc.nextLine();
            sc.reset();

            System.out.print("Task due date (YYYY-MM-DD): ");
            String date = sc.nextLine();
            sc.reset();
            list.addTask(title, description, date);     //Adding Item
            System.out.println("");
        }catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }
    }
    public static void removeItem(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Which task will you remove? ");
            int i = in.nextInt();
            list.removeTask(i);
        }catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }
    }
    public static void editItem(TaskList list) {
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
            String date = in.nextLine();
            in.close();                                         //Closes Scanner
            list.editTaskItem(i, title, description, date);    //This line does the actual editing
        }catch (InputMismatchException e) {
            System.out.println("Warning: input mismatch");
        }
    }
    public static void markComplete(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Which task will you mark as completed? ");
            int i = in.nextInt();
            list.setTaskComplete(i);
            System.out.println("");
        }catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }
    }
    public static void unmarkComplete(TaskList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Which task will you unmark as completed? ");
            int i = in.nextInt();
            list.setTaskIncomplete(i);
            System.out.println("");
        }catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }
    }
    public static void saveList(TaskList list) {
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
    public static TaskList loadTaskList() {
        try {
            TaskList list = new TaskList();
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the filename to load: ");
            String str = in.nextLine();
            list.loadList(str);
            if(list.equals(new TaskList())){
                return null;
            }else {
                return list;
            }
        }catch (InputMismatchException e) {
            System.out.println("WARNING: invalid file name");
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