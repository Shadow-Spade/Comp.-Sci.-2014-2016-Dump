import java.util.Random;
import java.util.Scanner;

public class Sorts {
    private static int[] tempData;

    public static void main(String[] args) {
        Random randGen = new Random();
        Scanner keyboard = new Scanner(System.in);
        boolean display = false;
        System.out.println("Please enter the size of the array you would like to have sorted: ");
        int size = keyboard.nextInt();
        long startTime;
        long endTime;
        double runTime;

        int[] data = new int[size];


        // generate values for the data array
        for (int i = 0; i < size; i++) {
            data[i] = randGen.nextInt(10000);
        }
        System.out.println("\nAn array of " + size + " random values was generated.");

        int show;
        do {
            System.out.println("Display data (1 yes / 0 no):");
            show = keyboard.nextInt();
        } while (show < 0 || show > 1);

        if (show == 1)
            display = true;

        System.out.print("\n");
        // prints the values for the data array to the screen if display is true
        if (display) {
            System.out.println("\n  The generated array contains the following values: ");
            for (int y = 0; y < size; y++) {
                System.out.printf("%6d", data[y]);
                if ((size + 1) % 10 == 0)
                    System.out.println();
            }
            System.out.println("\n\n\n");
        }

        int[] copy = copyArray(data);
        startTime = System.nanoTime();
        selectionSort(copy);
        endTime = System.nanoTime();
        runTime = (double) (endTime - startTime) / 1000000000L;


        System.out.printf("Selection sort took %.7f seconds to sort the array.\n", runTime);
        // prints the values for the data array to the screen if display is true
        if (display) {
            System.out.println("\n  Order of the array after sort");
            for (int y = 0; y < size; y++) {
                System.out.printf("%6d", copy[y]);
                if ((size + 1) % 10 == 0)
                    System.out.println();
            }
            System.out.println("\n\n\n");
        }

        copy = copyArray(data);
        startTime = System.nanoTime();
        insertionSort(copy);
        endTime = System.nanoTime();
        runTime = (double) (endTime - startTime) / 1000000000L;

        System.out.printf("Insertion sort took %.7f seconds to sort the array.\n", runTime);
        // prints the values for the data array to the screen if display is true
        if (display) {
            System.out.println("\n  Order of the array after sort");
            for (int y = 0; y < size; y++) {
                System.out.printf("%6d", copy[y]);
                if ((size + 1) % 10 == 0)
                    System.out.println();
            }
            System.out.println("\n\n\n");
        }

        copy = copyArray(data);
        tempData = new int[data.length];
        startTime = System.nanoTime();
        mergeSort(copy, 0, data.length - 1);
        endTime = System.nanoTime();
        runTime = (double) (endTime - startTime) / 1000000000L;

        System.out.printf("Merge sort took %.7f seconds to sort the array.\n", runTime);
        // prints the values for the data array to the screen if display is true
        if (display) {
            System.out.println("\n  Order of the array after sort");
            for (int y = 0; y < size; y++) {
                System.out.printf("%6d", copy[y]);
                if ((size + 1) % 10 == 0)
                    System.out.println();
            }
            System.out.println("\n\n\n");
        }
    }

    //Pre:		receives an array
    //Post:		changes the received array so that it is sorted in ascending order
    private static void selectionSort(int[] data) {
        for (int x = 0; x < data.length; x++) {
            int minIndex = x;
            for (int y = x + 1; y < data.length; y++) {
                if (data[y] < data[minIndex]) {
                    minIndex = y;
                }
            }
            swap(data, minIndex, x);
        }
    }

    //Pre:		receives an array
    //Post:		changes the received array so that it is sorted in ascending order
    private static void insertionSort(int[] data) {
        for (int x = 1; x < data.length; x++) {
            int temp = data[x];
            int y = x;
            while (y > 0 && data[y - 1] > temp) {
                data[y] = data[y - 1];
                y = y - 1;
            }
            data[y] = temp;
        }
    }

    //Pre:		receives an array, a to and from letting the method know what portion of the array to sort
    //Post:		changes the received array so that it is sorted in ascending order in the portion that was sent
    private static void mergeSort(int[] data, int from, int to) {
        if (to == from) {
            return;
        }
        int middle = (from + to) / 2;
        mergeSort(data, from, middle);
        mergeSort(data, middle + 1, to);
        int i = from, j = middle + 1, k = from;
        while (i <=middle && j <= to) {
            if (data[i] < data[j]) {
                tempData[k++] = data[i++];
            } else {
                tempData[k++] = data[j++];
            }
        }
        while (i <= middle) {
            tempData[k++] = data[i++];
        }
        while (j <= to) {
            tempData[k++] = data[j++];
        }
        for (k = from; k <= to; k++) {
            data[k] = tempData[k];
        }
    }

    // Pre:		receives an array of data and two indexes to be swapped
    // Post:	swaps the values at the two indexes of the received array
    private static void swap(int[] data, int spot1, int spot2) {
        int temp = data[spot1];
        data[spot1] = data[spot2];
        data[spot2] = temp;
    }

    //Pre:		receives an array
    //Post:		returns a new array that is a copy of the received array
    private static int[] copyArray(int[] data) {
        int[] data2 = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            data2[i] = data[i];
        }
        return data2;
    }
}