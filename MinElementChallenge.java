import java.util.Arrays;
import java.util.Scanner;

public class MinElementChallenge {
    // Need "private static" to create a scanner
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] inArray = readIntegers(5);
        int minVal = findMin(inArray);
        System.out.println("Minimum Value = " + minVal);
    }
    public static int[] readIntegers(int count) {
        System.out.println("Enter " + count + " integers \r");
        int[] inputArray = new int[count];
        for (int i=0; i<inputArray.length; i++) {
            inputArray[i] = scanner.nextInt();
        }
        return inputArray;
    }

    public static int findMin(int[] inArray) {
        int[] sortArray = new int[inArray.length];
        for (int i=0; i<inArray.length; i++) {
            sortArray[i] = inArray[i];
        }
        int holdInt;
        boolean shouldContinue = true;
        while (shouldContinue) {
            shouldContinue = false;
            for (int i = 0; i< sortArray.length - 1; i++) {
                if (sortArray[i] < sortArray[i+1]) {
                    holdInt = sortArray[i];
                    sortArray[i] = sortArray[i+1];
                    sortArray[i+1] = holdInt;
                    shouldContinue = true;
                }
            }
        }
        // Print the array
        System.out.println("Sorted Array = "
                + Arrays.toString(sortArray));
        // Return the lowest value
        return sortArray[sortArray.length - 1];
    }
}
