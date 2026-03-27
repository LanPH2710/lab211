/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import static utils.Constants.ERR_EMPTY;
import static utils.Constants.ERR_FOMAT;
import static utils.Constants.ERR_OUT_OF_RANGE;
import static utils.Constants.MAX_INT;
import static utils.Constants.MSG_INT;

/**
 *
 * @author ADMIN
 */
public class Validator {
    static Scanner scanner = new Scanner(System.in);
    public static final String VALID_CODE = "^[A-Z]{2,}+$";
    public static final String VALID_STR = "^[A-Za-z][ a-zA-Z]*$";
    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println(ERR_EMPTY);
                } else {
                    int inputInt = Integer.parseInt(input);
                    if (inputInt < min || inputInt > max) {
                        System.out.println(ERR_OUT_OF_RANGE);
                    } else {
                        return inputInt;
                    }
                }
            } catch (Exception e) {
                System.out.println(MSG_INT);
            }
        }
    }
    public static String getString(String msg, String regex) {
        while (true) {
            try {
                System.out.println(msg);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println(ERR_EMPTY);
                } else if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(ERR_FOMAT);
                }
            } catch (Exception e) {
                System.out.println(MSG_INT);
            }
        }
    }
    public static float getFloat(String msg, int min) {
        while (true) {
            try {
                System.out.println(msg);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println(ERR_EMPTY);
                } else {
                    float inputFloat = Float.parseFloat(input);
                    if (inputFloat < min || inputFloat > MAX_INT) {
                        System.out.println(ERR_OUT_OF_RANGE);
                    } else {
                        return inputFloat;
                    }
                }
            } catch (Exception e) {
                System.out.println(MSG_INT);
            }
        }
    }
}
