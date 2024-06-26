package gr.aueb.cf.ch10;

import java.io.*;
import java.util.*;

public class ProjectOne {
    public static void main(String[] args) {
        String inputFile = "src/gr/aueb/cf/ch10/projectone.txt";
        int[] numbers = new int[19];
        int index = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null && index < numbers.length) {
                numbers[index++] = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.sort(numbers);

        // Generate and print combinations of 6 elements with filters
        generateCombinations(numbers, 6, new ArrayList<>(), 0);
    }

    private static void generateCombinations(int[] numbers, int k, List<Integer> combination, int start) {
        // Base case: If k is 0, we have formed a complete combination
        if (k == 0) {
            // Print or process the combination
            System.out.println(combination);
            return;
        }

        // Recursive case: Iterate over the numbers array starting from 'start'
        for (int i = start; i <= numbers.length - k; i++) {
            int num = numbers[i];

            // Apply filters
            if ((hasTooManyEvens(combination) && isEven(num)) ||
                    (hasTooManyOdds(combination) && isOdd(num)) ||
                    (hasTooManyConsecutive(combination, num)) ||
                    (hasTooManySameLastDigit(combination, num)) ||
                    (hasTooManyFromSameSet(combination, num))) {
                continue; // Skip this number if it violates any filter
            }

            // Add current number to combination
            combination.add(num);

            // Recursive call
            generateCombinations(numbers, k - 1, combination, i + 1);

            // Backtrack: Remove last added number
            combination.remove(combination.size() - 1);
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean hasTooManyEvens(List<Integer> combination) {
        int count = 0;
        for (int num : combination) {
            if (isEven(num)) {
                count++;
            }
        }
        return count > 4;
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    private static boolean hasTooManyOdds(List<Integer> combination) {
        int count = 0;
        for (int num : combination) {
            if (isOdd(num)) {
                count++;
            }
        }
        return count > 4;
    }

    private static boolean hasTooManyConsecutive(List<Integer> combination, int num) {
        if (combination.isEmpty()) {
            return false; // No consecutive numbers if combination is empty
        }

        int lastIdx = combination.size() - 1;
        int lastNum = combination.get(lastIdx);

        // Check if adding 'num' would violate consecutive numbers rule
        return (lastIdx > 0 && num == lastNum + 1 && lastNum == combination.get(lastIdx - 1) + 1);
    }

    private static int getLastDigit(int number) {
        return Math.abs(number % 10);
    }

    private static boolean hasTooManySameLastDigit(List<Integer> combination, int num) {
        int lastDigit = getLastDigit(num);
        int count = 0;
        for (int n : combination) {
            if (getLastDigit(n) == lastDigit) {
                count++;
            }
        }
        return count >= 3;
    }

    private static int getSetNumber(int number) {
        return number / 10; // Assuming sets are defined by the first digit
    }

    private static boolean hasTooManyFromSameSet(List<Integer> combination, int num) {
        int setNumber = getSetNumber(num);
        int count = 0;
        for (int n : combination) {
            if (getSetNumber(n) == setNumber) {
                count++;
            }
        }
        return count >= 3;
    }








}
