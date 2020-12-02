import java.util.InputMismatchException;

public class ContactItem {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        try {
            if (isAllEmpty(firstName, lastName, phoneNumber, emailAddress)) {
                throw new InputMismatchException();
            }
            this.lastName = lastName;
            this.firstName = firstName;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;

        } catch (InputMismatchException e) {
            System.out.println("WARNING: at least one field must be entered");
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }

    public void editContactItem (String firstName, String lastName, String phoneNumber, String emailAddress) {
        try {
            if (isAllEmpty(firstName, lastName, phoneNumber, emailAddress)) {
                throw new InputMismatchException();
            }
            this.lastName = lastName;
            this.firstName = firstName;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;

        } catch (InputMismatchException e) {
            System.out.println("WARNING: at least one field must be entered");
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }

    private boolean isAllEmpty(String firstName, String lastName, String phoneNumber, String emailAddress) {
        return (firstName.length() == 0 && lastName.length() == 0 && phoneNumber.length() == 0 && emailAddress.length() == 0);
    }

    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Phone: " +phoneNumber + "\n" +
                "Email: " +emailAddress;
    }

    //getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
}
