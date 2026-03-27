package ultis;

import java.util.Scanner;

public class Validator {

    public static final String PHONE_REGEX = "^([0-9]{10}"
            + "|[0-9]{3}[-\\. ][0-9]{3}[-\\. ][0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}\\s?(x|ext)[0-9]{4}"
            + "|\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}"
            + ")$";
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String message, String error1, String error2, String error3, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println(error1);
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min) {
                        System.out.println(error2);
                    } else if (number > max) {
                        System.out.println(error3);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static String getString(String message, String error1) {
        while (true) {
            try {
                System.out.println(message);
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

    public static String getPhone(String message, String error1, String error2) {
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println(error1);
                } else if (input.matches(PHONE_REGEX)) {
                    return input;
                }
            } catch (Exception e) {
            }
        }
    }
}
