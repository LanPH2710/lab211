package utils;

import entity.Doctor;
import java.util.Scanner;

public class Validator {

    static Scanner scanner = new Scanner(System.in);
    private static final String VALID_CODE = "^[a-zA-Z]{1,2}[0-9]+$";

    public static String getCode(String messager, String error1) {
        while (true) {
            try {
                System.out.println(messager);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println(error1);
                } else if (input.matches(VALID_CODE)) {
                    return input;
                }
            } catch (Exception e) {
            }
        }
    }

    public static String getString(String messager, String error1) {
        while (true) {
            try {
                System.out.println(messager);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println(error1);
                } else {
                    return input;
                }
            } catch (Exception e) {
            }
        }
    }

    public static String getUpdateString(String messager) {
        while (true) {
            try {
                System.out.println(messager);
                String input = scanner.nextLine().trim();

                return input;
            } catch (Exception e) {
            }
        }
    }

    public static int getInt(String messager, String error1, String error2, int min, int max) {
        while (true) {
            try {
                System.out.println(messager);
                String input = scanner.next();
                if (input.isEmpty()) {
                    System.out.println(error1);
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min) {
                        System.out.println(error2);
                    } else if (number > max) {
                        System.out.println(error2);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    public static int getUpdateInt(String messager, String error2, int min, int max) {
        while (true) {
            try {
                System.out.println(messager);
                String input = scanner.next();
                if (input.isEmpty()) {
                return -1; // skip update
            }
                int number = Integer.parseInt(input);
                if (number < min) {
                    System.out.println(error2);
                } else if (number > max) {
                    System.out.println(error2);
                } else {
                    return number;
                }

            } catch (NumberFormatException e) {
            }
        }
    }

    public static boolean checkChangeInformation(String name, String specialization, int availability, Doctor doctor) {
        if (doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        } else {
            return true;
        }
    }
}
