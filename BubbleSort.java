import java.io.FileWriter;

/**
* The Bubble Sort program will read sets of integers between 0 and 100.
* It will populate the sets of integers into arrays.
* It will then sort the arrays using the bubble sort algorithm.
* It will write the sorted arrays to the output file.
*
* @version 1.0
* @since 2025-04-08
*/

final class BubbleSort {

    /**
     * This is the maximum number.
     */
    public static final int MAX_NUM = 100;

    /**
     * This is the minimum number.
     */
    public static final int MIN_NUM = 0;

    /**
     * This is the size of the array.
     */
    public static final int ARRAY_SIZE = 10;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private BubbleSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the populating arrays method.
     *
     * @return array of random numbers
     */

    public static int[] populatingArrays() {

        // Create an array of numbers
        // The size of the array is 10
        int[] arrayNum = new int[ARRAY_SIZE];

        // Write a random number to the array of numbers
        // until 10 numbers have been added
        for (int counter = 0; counter < arrayNum.length; counter += 1) {

            // Add a random integer to the array, cast as an integer
            // The random integer is between 0 and 100
            arrayNum[counter] = (int) (Math.random() * (MAX_NUM + 1));
        }

        // return the array of numbers
        return arrayNum;
    }

    /**
     * This is the binary search method.
     *
     * @param arrayInt array of integers
     * @return sorted array
     */

    public static int[] bubbleSort(final int[] arrayInt) {
        // Sort the array using bubble sort
        // The outer loop is for the number of passes
        for (int pass = 0; pass < arrayInt.length - 1; pass += 1) {

            // The inner loop is for the actual sorting
            for (
                int counter = 0;
                counter < arrayInt.length - pass - 1;
                counter += 1
            ) {
                // Compare the two numbers
                // If the first number is greater than the second number
                // then swap the numbers
                if (arrayInt[counter] > arrayInt[counter + 1]) {
                    // swap the numbers
                    int temp = arrayInt[counter];
                    arrayInt[counter] = arrayInt[counter + 1];
                    arrayInt[counter + 1] = temp;
                }
            }
        }

        // return the sorted array
        return arrayInt;
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Greeting
        System.out.println("Welcome to the bubble sort program!");

        // Get the unsorted array by calling the populating arrays function
        int[] arrayNumber = populatingArrays();

        // Get the sorted array by calling the bubble sort function
        arrayNumber = bubbleSort(arrayNumber);

        // Display the array
        for (int num : arrayNumber) {
            // Display each number, separated by a space
            outputStr += (num + " ");
        }

        outputStr += "\n";

         // Write to the output file
        FileWriter myWriter = new FileWriter("./output.txt");

        // Write the output string to the file
        myWriter.write(outputStr);

        // Added a blank line for spacing
        System.out.println("");

        // Close the file writer
        myWriter.close();

        // Display success message
        System.out.println("Successfully wrote to 'output.txt'");
    }
}
