import java.util.Scanner;

public class ReverseArrayChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = {3,4,5,6,7,8};
        System.out.println("Original order: ");
        printArray(array);
        reverse(array);
        System.out.println("Reverse order: ");
        printArray(array);
    }

    private static void reverse(int[] array) {
        int holdInt;
        int maxIndex = array.length -1;     // <- Needed hint
        int halflength = array.length / 2;  // <- Needed hint

        for(int i=0; i < halflength; i++) {
            holdInt = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = holdInt;
        }
    }
    private static void printArray(int[] array) {
        for(int i=0; i < array.length; i++) {
            System.out.println("Element " + i + ", value is "
                    + array[i]);
        }
    }
}
