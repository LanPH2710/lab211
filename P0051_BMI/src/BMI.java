/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class BMI {
    //chia ra lam package rieng
    public static void main(String[] args) {
        //Infinite loop until user choose exit program
        while(true){
            //Step 1: Display a menu
            displayMenu();
            // Enter an option
            int choice = GetInput.getChoice();
            switch(choice){
                //Step 2: Display result normal calculator
                case 1:
                    BMI.normalCalculator();
                    break;
                //Step 3: Display result BMI calculator
                case 2:
                    BMI.bmiCalculator();
                    break;
                //Step 4: Exit program
                case 3:
                  return;  
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Calculator program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
    }
    
    
    public static void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        double memory = GetInput.getNumber("Enter Number: ");
        // loop until user enter operator "="
        while (true) {
            String operator = GetInput.getOperator("Enter Operator: ");
            if (operator.equals("=")) {
                break;
            }
            double number= GetInput.getNumber("Enter number: ");
            memory=Calculator.normalCalculator(memory, operator, number);
            System.out.println("Result = " + memory);
        }
        System.out.println("Result = " + memory);
    }
    
    public static void bmiCalculator() {
        double weight = GetInput.getWeightOrHeight("Enter weight(kg): ");
        double height = GetInput.getWeightOrHeight("Enter height(cm): ");
        double bmi = Calculator.bmiCalculator(weight, height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.print("BMI status: ");
        //check if BMI is under standard
        if (bmi < 19) {
            System.out.println("Under Standard");
        } //check if BMI is standard
        else if (bmi >= 19 && bmi < 25) {
            System.out.println("Standard");
        } // check if BMI is overweight
        else if (bmi >= 25 && bmi < 30) {
            System.out.println("Overweight");
        } // check if BMI is Fat
        else if (bmi >= 30 && bmi < 40) {
            System.out.println("Fat should lose weight");
        } // check if BMI is very fat
        else if (bmi > 40) {
            System.out.println("Very fat, should lose weight imediatly");
        }
    }
}
