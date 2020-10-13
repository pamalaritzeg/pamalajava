import java.util.Scanner;

public class Main2 {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new
            MobilePhone("317-555-1111");

    public static void main(String[] args) {
        startPhone();

        boolean continu = true;
        int choice;
        printActions();
        while (continu) {
            System.out.print("\t Enter your selection: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("\nShutting down...");
                    continu = false;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }
    private static void startPhone() {
        System.out.println("Starting phone...");
    }
    private static void printActions() {
        System.out.println("\nAvailable actions;\npress");
        System.out.println("1 - to print contacts\n" +
                "2 - to add a contact\n" +
                "3 - to update a contact\n" +
                "4 - to remove a contact\n" +
                "5 - to query a contact\n" +
                "6 - to print available actions\n" +
                "0 - to shutdown the app");
    }
    public static void addContact() {
        System.out.print("Please enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter contact number: ");
        String number = scanner.nextLine();
        // The following works when you have a static method
        //   and don't have to create a new object.
        Contact newContact = Contact.creatContact(name, number);
        // Because mobilePhone's method addNewContact returns a
        //    boolean flag, the following "if" is asking if
        //    the flag is true.
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name
                + ", phone = " + number);
        } else {
            System.out.println("Cannot add " + name + ".  Already on file.");
        }
    }
    public static void updateContact() {
        System.out.print("Please enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRec = mobilePhone.queryContact(name);
        if (existingContactRec == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Please enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Please enter new contact phone number: ");
        String newPhone = scanner.nextLine();
        Contact newContact = Contact.creatContact(newName, newPhone);
        boolean isUpdated = mobilePhone.updateContact(existingContactRec,
                newContact);
        if (isUpdated) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record");
        }
        // The above can be shortened to the following:
        // if (mobilePhone.updateContact(existingContactRec,
        //                newContact)) {
        //     System.out.println("Successfully updated record");
        // } else {
        //     System.out.println("Error updating record");
        // }
    }
    public static void removeContact() {
        System.out.println("Please enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRec = mobilePhone.queryContact(name);
        if (existingContactRec == null) {
            System.out.println("Contact not found");
            return;
        }
        boolean isRemoved = mobilePhone.removeContact(existingContactRec);
        if (isRemoved) {
            System.out.println("Contact successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }
    public static void searchForContact() {
        System.out.println("Please enter contact name: ");
        String name = scanner.nextLine();
        Contact entry = mobilePhone.queryContact(name);
        System.out.println("Found: " + entry.getName() + "  " +
                entry.getPhoneNum());
    }
}
