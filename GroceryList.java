import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
    // ADD
    public void addGroceryItem(String item) {
        groceryList.add(item);
    }
    //PRINT
    public void printGroceryList() {
        System.out.println("You have " + groceryList.size()
                + " items in your grocery list");
        for(int i=0; i< groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }
    // MODIFY
    public void modifyGroceryList(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyGroceryList(position, newItem);
        }
    }
    private void modifyGroceryList(int position, String newItem) {
        groceryList.set(position, newItem);
    }
    // REMOVE
    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }
    private void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        System.out.println("Grocery item " + theItem
                + " has been removed");
        groceryList.remove(position);
    }
    // FIND ( IS ITEM IN ARRAYLIST? )
    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if (position >= 0) {
            return true;
        }
        return false;
    }
    // FIND (INDEX OF ITEM)
    private int findItem(String searchItem) {
        // To find where it is in the ArrayList, do the following
        return groceryList.indexOf(searchItem);
        // If not found, will return -1
    }
}
