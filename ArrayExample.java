public class ArrayExample {
    public static void main(String[] args) {

        // Arrays always start with ZERO.
        //
        int[] myIntArray = new int[10];  // 10 is # of entries in the array
        // Can initialize individual entries in the array
        myIntArray[0] = 5;
        myIntArray[3] = 20;
        myIntArray[8] = 45;
        System.out.println("myIntArray");
        printArray(myIntArray);

        // Can initialize the entries when the array is created.
        int[] myIntArray2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("myIntArray2");
        printArray(myIntArray2);

        // Can initialize the entries with a for loop
        int[] myIntArray3 = new int[25];
        //for(int i=0; i < 25; i++) {
        for(int i=0; i < myIntArray3.length; i++) {
            myIntArray3[i] = i * 10;
        }
        // Instead of code to print, call a method to print the array.
        System.out.println("myIntArray3");
        printArray(myIntArray3);
    }
    public static void printArray(int[] array) {
        for(int i=0; i < array.length; i++) {
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }
}
