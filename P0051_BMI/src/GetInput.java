
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class GetInput {

    static int getChoice() {
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
                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter number 1 or 2 or 3!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input cannot contain non-digit characters");
            }
        }
        return (int) choice;
    }

    static double getNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        //Infinite loop until user enter a valid number
        while (true) {
            try {
                System.out.print(message);
                String number = scanner.nextLine().trim();
                // check if number is empty
                if (number.isEmpty()) {
                    System.out.println("Input can not be empty, try again");
                } else {
                    double input = Double.parseDouble(number);
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be numertic data");
            }

        }
    }
    
    static String getOperator(String message) {
        Scanner scanner = new Scanner(System.in);
        //Infinite loop until user enter a valid number
        while (true) {
            System.out.print(message);
            String operator = scanner.nextLine().trim();
            //check if input is empty
            if (operator.isEmpty()) {
                System.out.println("Input can not be empty, try again");
            } // check input is valid operator
            else if (operator.equals("+") || operator.equals("-") || 
                    operator.equals("*") || operator.equals("/") || 
                    operator.equals("^") || operator.equals("=")) {
                return operator;
            } else {
                System.out.println("Please input (+, -, *, /, ^)");
            }

        }
    }

    static double getWeightOrHeight(String message) {
        Scanner scanner = new Scanner(System.in);
        //Infinite loop until user enter a valid number
        while (true) {
            System.out.print(message);
                String number = scanner.nextLine().trim();
            try {
                //check if input is empty
                if (number.isEmpty()) {
                    System.out.println("Input can not be empty, try again");
                } else {
                    double input = Double.parseDouble(number);
                    //check if number is positive
                    if (input > 0) {
                        return input;
                    } else {
                        System.out.println("Value Invalid!");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            }

        }
    }
    
}
