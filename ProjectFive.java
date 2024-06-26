package gr.aueb.cf.ch10;

import java.util.Scanner;

public class ProjectFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[][] seats = new boolean[30][12];

        System.out.println("Please choose your row (1-30): ");
        int row = scanner.nextInt();

        System.out.println("Please choose your column (A-L): ");
        char column = scanner.next().charAt(0);
        // Convert column letter to zero-indexed column number
        int colIndex = column - 'A';

        if (isValidRow(row) && isValidColumn(colIndex)) {
            // Book the seat if it's not already booked
            if (!seats[row - 1][colIndex]) {
                seats[row - 1][colIndex] = true;
                System.out.println("Seat " + column + row + " booked successfully.");
            } else {
                System.out.println("Seat " + column + row + " is already booked.");
            }
        } else {
            System.out.println("Invalid row or column input. Please try again.");
        }

        scanner.close();

    }

    private static boolean isValidRow(int row) {
        return row >= 1 && row <= 30;
    }

    private static boolean isValidColumn(int colIndex) {
        return colIndex >= 0 && colIndex < 12;
    }



}
