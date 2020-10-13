public class Contact {
    // Fields in the Contact class
    private String name;
    private String phoneNum;

    // Constructor
    public Contact(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
    // Getters
    public String getName() {
        return name;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    // Static Method
    // Use "static" for the method so that
    //  creating a new object is NOT needed
    //  in order to use the class.

    public static Contact creatContact(String name, String phoneNum) {
        return new Contact(name, phoneNum);
    }

    // Shortcut for Autoboxing
    Integer myIntValue = 56;
    //Integer myIntValue = Integer.valueOf(56); // Java adds this

    // Shortcut for Unboxing
    int myInt = myIntValue;
    //int myInt = myIntValue.intValue();  // Java adds this
}
