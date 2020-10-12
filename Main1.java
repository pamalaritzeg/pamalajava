import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();  // Get the number input
            scanner.nextLine();  // Clear input buffer

            switch ((choice)) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }
    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application");
    }
    public static void addItem() {
        // Use "print" to print on same line
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    public static void modifyItem() {
        System.out.print("Enter item to be modified: ");
        String item = scanner.nextLine();
        //scanner.nextLine();  // Only needed after .nextint
        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryList(item,newItem);
    }
    public static void removeItem() {
        System.out.print("Enter item to be removed: ");
        String item = scanner.nextLine();
        //scanner.nextLine();  // Only needed after .nextint
        groceryList.removeGroceryItem(item);
    }
    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem
                    + " in our grocery list");
        } else {
            System.out.println(searchItem
                    + " is not in the shopping list");
        }
    }
    public static void processArrayList() {
        // COPY ARRAY LIST
        // 1st Method
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        // 2nd Method
        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        // 3rd Method
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
