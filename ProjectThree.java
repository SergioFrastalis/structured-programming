package gr.aueb.cf.ch10;

public class ProjectThree {

    public static void main(String[] args) {

        int[][] originalArray = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };

        int[][] shallowCopyArray = shallowCopy(originalArray);

        int[][] deepCopyArray = deepCopy(originalArray);

        // Modify the deep copy array to demonstrate independence
        deepCopyArray[0][0] = 50;

        // Modify the shallow copy array to demonstrate dependence
        shallowCopyArray[0][0] = 100;

        // Print original array
        System.out.println("Original Array:");
        printArray(originalArray);

        // Print shallow copy array
        System.out.println("\nShallow Copy Array:");
        printArray(shallowCopyArray);

        // Print deep copy array
        System.out.println("\nDeep Copy Array:");
        printArray(deepCopyArray);
    }

    // Method to create a shallow copy of a 2D integer array
    public static int[][] shallowCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    // Method to create a deep copy of a 2D integer array
    public static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i].clone();
        }
        return copy;
    }


    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
