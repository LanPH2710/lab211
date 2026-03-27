/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //step1: input size of array
        int sizeOfArray = inputSizeOfArray();
        //step2: Enter Search value
        int searchValue = enterSearchValue(sizeOfArray);
        //step3: Generate random integer number for each array element
        int[] array = randomIntegerNumber(sizeOfArray);
        //step4: Display the array
        displayArray(array);
        //step5: Display the index of search number in array
        displayIndexOfSearchNumber(array, searchValue);
        
    }
    // Input Size Of Array
    private static int inputSizeOfArray() {
        Scanner scanner = new Scanner(System.in);
        int number=0;
        //repeat until number is positive number
        while (number<=0) {
            try {
                System.out.println("Enter number of array: ");
                String input = scanner.nextLine().trim();
                //check number input is empty
                if (input.isEmpty()) {
                    System.out.println("Array cannot be empty!");
                    continue;
                }
                //check input value
                if (Integer.parseInt(input) <= 0) {
                    System.out.println("Please enter a positive number!");

                } else {
                    return Integer.parseInt(input);
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a integer number!");
            }
        }
        return number;
    }

    //
    private static int enterSearchValue(int sizeOfArray) {
        Scanner scanner = new Scanner(System.in);
        int number=0;
        //repeat until number is positive number
        while (number<=0) {
            try {
                System.out.println("Enter search value: ");
                String input = scanner.nextLine().trim();
                //check number input is empty
                if (input.isEmpty()) {
                    System.out.println("Array cannot be empty!");
                    continue;
                }
                //check input value
                if (Integer.parseInt(input) <= 0) {
                    System.out.println("Please enter a positive number!");

                } else {
                    return Integer.parseInt(input);
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a integer number!");
            }
        }
        return number;
    }

    private static int[] randomIntegerNumber(int sizeOfArray) {
        int[] array = new int[sizeOfArray];
        Random random = new Random();
        //loop for generate random integer number to array at position i
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(sizeOfArray);
        }
        return array;
    }

    private static void displayArray(int[] array) {
        //loop for display array at position i
        System.out.print("The array: [");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array.length - 1 + "]");

    }

    private static void displayIndexOfSearchNumber(int[] array, int SearchValue) {
        int flag = 0;
        //loop for display index of search number at position i
        for (int i = 0; i < array.length; i++) {
            //check position of search value in array
            if (array[i] == SearchValue) {
                System.out.println("Found " + SearchValue + " at index: " + i);
                flag = 1;
            }
        }
        //check position of Search value in array
        if (flag == 0) {
            System.out.println("Not found " + SearchValue + " in array!");
        }

    }

}
