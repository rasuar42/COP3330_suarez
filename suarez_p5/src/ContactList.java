import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContactList extends TaskList {

    private ArrayList<ContactItem> contactList;

    public ContactList(){
        contactList = new ArrayList<>();
        //contactList.add(new ContactItem("John", "Smith", "95475949", "theDoctor@tardis.eu"));
    }

    public void editContact(int i, String firstName, String lastName, String phoneNumber, String emailAddress) {
        try {
            contactList.get(i).editContactItem(firstName, lastName, phoneNumber, emailAddress);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: contact not in list");
        }catch (Exception e) {
            System.out.println("WARNING: unknown error");
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        for(int i = 0; i < contactList.size(); i++) {
            System.out.print(i +")");
            System.out.println(contactList.get(i).toString());
        }
    }

    @Override
    public void saveList(String str) {
        try {
            FileWriter writer = new FileWriter(str);
            writer.write(2 + "\n");
            writer.write(contactList.size() + "\n");
            for(ContactItem item : contactList){
                writer.write(item.getFirstName()+ "\n");
                writer.write(item.getLastName() + "\n");
                writer.write(item.getPhoneNumber() + "\n");
                writer.write(item.getEmailAddress() + "\n");
                writer.write("\n");
            }
            writer.write("----------");
            writer.close();
        }catch (IOException e){
            System.out.println("WARNING: there was an error writing to the file");
        }
    }

    @Override
    public void loadList(String str) {
        try {
            File file = new File(str);
            Scanner reader = new Scanner(file);
            if(Integer.parseInt((reader.nextLine())) != 2) {
                throw new FileNotFoundException();
            }
            int size = Integer.parseInt(reader.nextLine()); //set size
            ContactItem contact;
            //Load Items to List
            for (int i = 0; i < size; i++) {
                contact = new ContactItem(reader.nextLine(), reader.nextLine(), reader.nextLine(), reader.nextLine());
                reader.nextLine();
                contactList.add(contact);
            }
            reader.close();
        }catch (FileNotFoundException e) {
            System.out.println("WARNING: File Not Found/Invalid File");
            contactList.clear();
        }catch (NoSuchElementException e) {
            System.out.println("WARNING: file is corrupted");
            contactList.clear();
        }catch (Exception e) {
            System.out.println("WARNING: unexpected error");
            contactList.clear();
        }
    }

    public void add(String firstName, String lastName, String phoneNumber, String emailAddress) {
        contactList.add(new ContactItem(firstName, lastName, phoneNumber, emailAddress));
    }

    @Override
    public void remove(int i) {
        try{
            contactList.remove(i);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: contact not in list");
        }catch (Exception e) {
            System.out.println("WARNING: unknown error");
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        contactList.clear();
    }

    @Override
    public int size() {
        return contactList.size();
    }

    public ContactItem getContact(int i) {
        return contactList.get(i);
    }
}
