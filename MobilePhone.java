import java.util.ArrayList;

public class MobilePhone {
    // Fields in the class MobilePhone
    // Notice that instead of using "String" or "int" to define
    //    the Arraylist, the class "Contact" is used.
    private String myNumber;
    private ArrayList<Contact> myContacts;

    // Constructors
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        // The following will initialize a new ArrayList
        this.myContacts = new ArrayList<Contact>();
    }
    // Methods
    public boolean addNewContact(Contact contact) {
        int x = findContact(contact.getName());
        if (x >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        this.myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contact currContact, Contact newContact) {
        int foundPosition = findContact(currContact);
        if (foundPosition < 0) {
            System.out.println(currContact.getName() + " was not found");
            return false;
        }
        System.out.println("\nCurrent Name = " + currContact.getName()
                + "\nNew Name = " + newContact.getName()
                + "\nCurrent Phone = " + currContact.getPhoneNum()
                + "\nNew Phone = " + newContact.getPhoneNum());
        if (currContact.getName().equals(newContact.getName())) {
            System.out.println("Names are equal");
        }
        if (currContact.getPhoneNum().equals(newContact.getPhoneNum())) {
            System.out.println("Numbers are equal");
        }
        // The following does not work. Strings need .equals(), not ==
        // if ((currContact.getName() == newContact.getName()) &&
        //        (currContact.getPhoneNum() == newContact.getPhoneNum())) {
        if ((currContact.getName().equals(newContact.getName())) &&
            (currContact.getPhoneNum().equals(newContact.getPhoneNum()))) {
            System.out.println(currContact.getName() + " with phone # "
                    + currContact.getPhoneNum() + " already exists");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(currContact.getName() + " "
                + currContact.getPhoneNum() + " was replaced with "
                + newContact.getName() + " " + newContact.getPhoneNum());
        return true;
    }
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        String name = contact.getName();
        this.myContacts.remove(foundPosition);
        System.out.println(name + " was deleted");
        return true;
    }
    // Overloaded methods - queryContact
    // 1st - Pass a Contact class and return a string
    public String queryContact(Contact contact) {
        int position = findContact(contact);
        if (position >= 0) {
            return contact.getName();
        }
        return null;
    }
    // 2nd - Pass a string and return a Contact class
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            // Return the entire record
            return this.myContacts.get(position);
        }
        return null;
    }
    // Overloaded methods - findContact
    // Find index of contact name and number - fields in Contact class
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }
    // Find index of contact name only
    private int findContact(String contactName) {
        for (int i=0; i< this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
    public void printContacts() {
        System.out.println("Contact List");
        for (int i=0; i< this.myContacts.size(); i++) {
            System.out.println((i+1) + ". " +
                    this.myContacts.get(i).getName() + "  " +
                    this.myContacts.get(i).getPhoneNum());
        }
    }
}
