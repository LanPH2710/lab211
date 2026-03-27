
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Main {
    // chia lai thanh 3 class main, validator, service
    public static void main(String[] args) {
        int[] arrayNeedSort = {};
        //Infinite loop until user choose exit program
        while (true) {
            //Step 1: Display a menu
            displayMenu();
            // Enter an option
            int choice = getChoice(arrayNeedSort.length);
            switch (choice) {
                //Step 2: get input element
                case 1:
                    //int size = getPositiveNumber();
                    arrayNeedSort = getInputElements();
                    break;

                //Step 3: Display element of the array in ascending order
                case 2:
                    int[] ascArray = bubbleSortAscending(arrayNeedSort, true);
                    displayAscendingOrderArray(ascArray);
                    break;

                //step3: Display element of the array in a descending order    
                case 3:
                    int[] descArray = bubbleSortDescending(arrayNeedSort, true);
                    displayDescendingOrderArray(descArray);
                    break;

                //Step 4: Exit program
                case 4:
                    return;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("========= Bubble Sort program =========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Descending");
        System.out.println("4. Exit");
    }

    private static int getChoice(int arrayLength) {
        Scanner scanner = new Scanner(System.in);
        String getChoice;
        double choice;
        while (true) {
            System.out.print("Please choice one option: ");
            getChoice = scanner.nextLine();
            //check if input is empty
            if (getChoice.isEmpty()) {
                System.out.println("Input can not be empty, try again");
                continue;
            }
            try {
                choice = Double.parseDouble(getChoice);
                //check if input is negative or equal to 0
                if (choice <= 0) {
                    System.out.println("Input must be greater than zero(0)");
                    continue;
                }
                //check if input is not an integer
                if ((choice - (int) choice) != 0) {
                    System.out.println("Input must be integer, try again");
                    continue;
                }
                // check if input is in valid range
                if (choice < 1 || choice > 4) {
                    System.out.println("Please enter number 1 or 2 or 3 or 4!");
                    continue;
                }
                //check if input element is available
                if ((choice == 2 || choice == 3) && arrayLength == 0) {
                    System.out.println("Please input elements first (option 1)");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input cannot contain non-digit characters");
            }
        }
        return (int) choice;
    }

    private static int getLengthOfArray() {
        Scanner scanner = new Scanner(System.in);
        String getSize;
        double arraySize;
        while (true) {
            System.out.println("Enter number of array:");
            getSize = scanner.nextLine();
            //check if input is empty
            if (getSize.isEmpty()) {
                System.out.println("Input can not be empty, try again");
                continue;
            }
            try {
                arraySize = Double.parseDouble(getSize);
                //check if input is negative or equal to 0
                if (arraySize <= 0) {
                    System.out.println("Input must be greater than zero(0)");
                    continue;
                }
                //check if input is not an integer
                if ((arraySize - (int) arraySize) != 0) {
                    System.out.println("Input must be integer");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input cannot contain non-digit characters");
            }
        }
        return (int) arraySize;
    }

    private static int getNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        String getSize;
        double arraySize;
        while (true) {
            System.out.println(message);
            getSize = scanner.nextLine();
            //check if input is empty
            if (getSize.isEmpty()) {
                System.out.println("Input can not be empty, try again");
                continue;
            }
            try {
                arraySize = Double.parseDouble(getSize);
                //check if input is negative or equal to 0
                if (arraySize <= 0) {
                    System.out.println("Input must be greater than zero(0)");
                    continue;
                }
                //check if input is not an integer
                if ((arraySize - (int) arraySize) != 0) {
                    System.out.println("Input must be integer");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input cannot contain non-digit characters");
            }
        }
        return (int) arraySize;
    }

    private static int[] getInputElements() {
        int size = getLengthOfArray();
        int[] number = new int[size];
        for (int i = 0; i < size; i++) {
            //System.out.print("Enter number " + (i + 1) + ": ");
            number[i] = getNumber("Enter number " + (i + 1) + ": ");
        }
        return number;
    }

    private static int[] bubbleSortAscending(int[] arrayNeedSort, boolean test) {
        int[] ascArray = new int[arrayNeedSort.length];
        for (int i = 0; i < arrayNeedSort.length; i++) {
            ascArray[i] = arrayNeedSort[i];
        }
        //loop from 1st to last element
        for (int i = 0; i < ascArray.length; i++) {
            //loop from 1st to the last sorted element
            for (int j = 0; j < ascArray.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (ascArray[j] > ascArray[j + 1]) {
                    //Display each step loop
                    if (test == true) {
                        //display(array, "");
                        System.out.println(Arrays.toString(ascArray) + "");
                        System.out.println("    " + ascArray[j] + ">" + ascArray[j + 1] + ", " + "swap");
                    }
                    int temp = ascArray[j];
                    ascArray[j] = ascArray[j + 1];
                    ascArray[j + 1] = temp;
                } //Display each step loop
                else if (test == true) {
                    System.out.println(Arrays.toString(ascArray) + "");
                    System.out.println("    " + ascArray[j] + "<" + ascArray[j + 1] + ", " + "ok");
                }
            }
        }
        return ascArray;
    }

    private static void displayAscendingOrderArray(int[] sortedArray) {
        System.out.println("----- Ascending -----");
        //using loop to acess each element of array except the last element
        for (int i = 0; i < sortedArray.length - 1; i++) {
            System.out.print("[" + sortedArray[i] + "]->");
        }
        System.out.println("[" + sortedArray[sortedArray.length - 1] + "]");
    }

    private static int[] bubbleSortDescending(int[] arrayNeedSort, boolean test) {
        int[] descArray = new int[arrayNeedSort.length];
        //loop to acess each element of array 
        for (int i = 0; i < arrayNeedSort.length; i++) {
            descArray[i] = arrayNeedSort[i];
        }
        //loop from 1st to last element
        for (int i = 0; i < descArray.length; i++) {
            //loop from last element to the current i
            for (int j = descArray.length - 1; j > i; j--) {
                //compare each pair adjacent elements
                if (descArray[j] > descArray[j - 1]) {
                    //Display each step loop
                    if (test == true) {
                        //display(array, "");
                        System.out.println(Arrays.toString(descArray) + "");
                        System.out.println("    " + descArray[j] + ">" + descArray[j - 1] + ", " + "swap");
                    }
                    int temp = descArray[j];
                    descArray[j] = descArray[j - 1];
                    descArray[j - 1] = temp;
                } //Display each step loop
                else if (test == true) {
                    System.out.println(Arrays.toString(descArray) + "");
                    System.out.println("    " + descArray[j] + "<" + descArray[j - 1] + ", " + "ok");
                }
            }
        }
        return descArray;
    }

    private static void displayDescendingOrderArray(int[] sortedArray) {
        System.out.println("----- Descending -----");
        //using loop to acess each element of array except the last element
        for (int i = 0; i < sortedArray.length - 1; i++) {
            System.out.print("[" + sortedArray[i] + "]<-");
        }
        System.out.println("[" + sortedArray[sortedArray.length - 1] + "]");
    }

}
