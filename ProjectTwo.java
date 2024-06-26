package gr.aueb.cf.ch10;

/**
 * The following is an implementation of Kadane's algorithm which solves
 * the maximum subarray problem. Since there is a single for loop from 1 to n
 * the time complexity is by necessity linear (O(n)).
 */

public class ProjectTwo {

    public static void main(String[] args) {
        int[] myArray = new int[] {-13, 0, 82, 31, 27, 97, 82, 4, -49, 22, 38, 4, 32, -33, -65, -74, 10, -24, 60, -90};

        // Initialize maxSum and currentSum with the first element
        int maxSum = myArray[0];
        int currentSum = myArray[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < myArray.length; i++) {
            currentSum = Math.max(myArray[i], currentSum + myArray[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        // Print the maximum sum of any contiguous subarray
        System.out.println("The maximum sum of any contiguous subarray is: " + maxSum);
    }
}
