import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContactApp extends TaskApp {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Select Your Application\n" +
                    "-----------------------\n" +
                    "\n" +
                    "1) task list\n" +
                    "2) contact list\n" +
                    "3) quit\n");
            int select = getMenuInput();
            switch (select){
                case 1:
                    TaskApp app = new TaskApp();
                    app.run();
                    break;
                case 2:
                    ContactApp app2 = new ContactApp();
                    app2.run();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Enter a valid selection");
                    continue;
            }
        }
    }

    public void run() {
        ContactList contactList;
        int select;


        while (true) {
            //Main Menu
            while (true) {
                mainMenu();
                select = getMenuInput();
                switch (select) {
                    case 1:
                        contactList = new ContactList();
                        System.out.println("new contact list has been created");
                        break;
                    case 2:
                        //Load List
                        contactList = loadContactList();
                        if (contactList == null) {
                            continue;
                        } else {
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
                        contactList.display();
                        continue;
                    case 2:
                        //addItem;
                        addItem(contactList);
                        continue;
                    case 3:
                        //editItem();
                        System.out.println("Current Tasks");
                        System.out.println("-------------");
                        contactList.display();
                        editItem(contactList);
                        continue;
                    case 4:
                        //removeItem;
                        System.out.println("Current Tasks");
                        System.out.println("-------------");
                        contactList.display();
                        removeItem(contactList);
                        continue;
                    case 5:
                        //saveList;
                        saveList(contactList);
                        continue;
                    case 6:
                        //Exits to Main Menu
                        contactList.clear();   //Empties List
                        break;
                    default:
                        System.out.println("Enter a valid selection");
                        continue;
                }
                break;
            }
        }

    }


    @Override
    public void mainMenu() {
        super.mainMenu();
    }

    @Override
    public void subMenu() {
        System.out.print("\n" +
                "List Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) save the current list\n" +
                "6) quit to the main menu\n" +
                "\n");
    }

    public void addItem(ContactList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("First Name: ");
            String first = in.nextLine();
            in.reset();
            System.out.print("Last Name: ");
            String last = in.nextLine();
            in.reset();
            System.out.print("Phone Number (xxx-xxx-xxxx):");
            String number = in.nextLine();
            in.reset();
            System.out.print("Email address (x@y.z):");
            list.add(first, last, number, in.nextLine());     //Adding Item
            in.reset();
        } catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        } catch (Exception e) {
            System.out.println("WARNING: unknown error");
            e.printStackTrace();
        }
    }

    public void removeItem(ContactList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Which task will you remove? ");
            int i = in.nextInt();
            list.remove(i);
        } catch (InputMismatchException e) {
            System.out.println("WARNING: enter a valid input");
        }
    }

    public void editItem(ContactList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Which task will you edit? ");
            int i = in.nextInt();
            System.out.print("Enter a new first name for contact 1" + i + ": ");
            String first = in.nextLine();
            in.reset();
            System.out.print("Enter a new last name for contact 1" + i + ": ");
            String last = in.nextLine();
            in.reset();
            System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + i + ": ");
            String phone = in.nextLine();
            in.reset();
            System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + i + ": ");
            list.editContact(i, first, last, phone, in.nextLine());    //This line does the actual editing
            in.reset();
        } catch (InputMismatchException e) {
            System.out.println("WARNING: input mismatch");
        } catch (Exception e) {
            System.out.println("WARNING: Unknown Error");
            e.printStackTrace();
        }
    }

    public void saveList(ContactList list) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the filename to save as: ");
            String str = in.nextLine();
            list.saveList(str);
            System.out.println("task list has been saved");
        } catch (InputMismatchException e) {
            System.out.println("WARNING: invalid file name");
        }
    }

    private ContactList loadContactList() {
        try {
            //Ask File
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the filename to load: ");
            String str = in.nextLine();
            //Set Up New List
            ContactList list = new ContactList();
            list.loadList(str);
            return list;
        } catch (InputMismatchException e) {
            System.out.println("WARNING: invalid file name");
        } catch (NoSuchElementException e) {
            System.out.println("WARNING: cannot read file");
        } catch (Exception e) {
            System.out.println("WARNING: unexpected error");
            e.printStackTrace();
        }
        return null;
    }
}



