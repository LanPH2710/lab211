/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Calculator {

    
    static double normalCalculator(double memory, String operator, double number) {
        if (operator.equals("+")){
            memory=memory+number;
        }
        else if(operator.equals("-")){
            memory=memory-number;
        }
        else if(operator.equals("*")){
            memory=memory*number;
        }
        else if(operator.equals("/")){
            if (number == 0) {
                System.out.println("Cannot divide by zero!");
            } else {
                memory = memory / number;
            }
        }
        else if(operator.equals("^")){
            memory = Math.pow(memory, number);
        }
        return memory;
    }
    
    static double bmiCalculator(double weight,double height) {
        double bmi = weight / (height / 100 * height / 100);
        return bmi;
    }
    

    }
    

