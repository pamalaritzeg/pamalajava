import java.util.Arrays;
import java.util.Scanner;

public class ArraysChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] intArray = getIntegers(5);
        System.out.println("Unsorted Input");
        printArray(intArray);
        int[] sortedIntegers = sortIntegers(intArray);
        System.out.println("Sorted Integers");
        printArray(sortedIntegers);
    }
    public static int[] getIntegers(int total) {
        // Output instructions to console
        System.out.println("Enter " + total + " numbers");
        // Create an array to hold the input values
        int[] intInput = new int[total];
        // Fill the array with the input (from scanner)
        for (int i=0; i< intInput.length; i++) {
            intInput[i] = scanner.nextInt();
        }
        return intInput;
    }
    public static void printArray(int[] arrayToPrint) {
        for(int i=0; i < arrayToPrint.length; i++) {
            System.out.println("Element " + i + ", value is "
                    + arrayToPrint[i]);
        }
    }
    public static int[] sortIntegers(int[] unsortedIntegers) {
        // Created new array & copied data into it with for loop
        //int[] sortedIntegers = new int[unsortedIntegers.length];
        //for (int i= 0; i < unsortedIntegers.length; i++) {
        //    sortedIntegers[i] = unsortedIntegers[i];
        //}
        //This can be done more quickly with the following:
        int[] sortedIntegers = Arrays.copyOf(unsortedIntegers,
                unsortedIntegers.length);
        //
        // Process to sort in descending order
        boolean shouldContinue = true;
        int holdInt;
        while (shouldContinue) {
            shouldContinue = false;
            for (int i = 0; i< sortedIntegers.length - 1; i++) {
                if (sortedIntegers[i] < sortedIntegers[i+1]) {
                    holdInt = sortedIntegers[i];
                    sortedIntegers[i] = sortedIntegers[i+1];
                    sortedIntegers[i+1] = holdInt;
                    shouldContinue = true;
                }
            }
        }
        return sortedIntegers;
    }
}
