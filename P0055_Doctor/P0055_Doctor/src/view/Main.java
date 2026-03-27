package view;

import entity.Doctor;
import java.util.ArrayList;
import utils.Validator;
import service.DoctorService;

public class Main {

    static DoctorService service = new DoctorService();

    public static void main(String[] args) {
        Main view = new Main();
        while (true) {
            System.out.println("========= Doctor Management ==========\n"
                    + "1.Add Doctor\n"
                    + "2.Update Doctor\n"
                    + "3.Delete Doctor\n"
                    + "4.Search Doctor\n"
                    + "5.Exit\n"
                    + "6.view count\n"
                    + "7. display avaiable and not available Doctor\n"
                    + "8. display doctor sort by name\n"
                    + "9. display all\n"
                    + "10. update 2");
            int choice = Validator.getInt("Enter your choice", "Please enter your choice",
                    "Invalid choice", 1, 10);
            switch (choice) {
                case 1:
                    System.out.println("--------- Add Doctor ----------");
                    view.viewAddDoctor();
                    break;
                case 2:
                    System.out.println("--------- Update Doctor -------");
                    viewUpdateDoctor();
                    break;
                case 3:
                    System.out.println("--------- Delete Doctor -------");
                    viewDeleteDoctor();
                    break;
                case 4:
                    System.out.println("---------- Search Doctor --------");
                    viewSearchDoctor();
                    break;
                case 5:
                    return;
                case 6:
                    viewCountAvailableDoctor();
                    break;
                case 7:
                    viewDisplayAvailableDoctor();
                    break;
                case 8:
                    displayDoctorByName();
                    break;
                case 9:
                    displayAllDoctor();
                    break;
                case 10:
                    viewUpdateDoctor2();
                    break;
            }
        }
    }

    public static void viewCountAvailableDoctor() {
        System.out.println("------- Available Doctor-------");
        int count =service.countAvailableDoctor();
        System.out.println("available doctor: "+count);
    }

    private static void displayAllDoctor() {
        System.out.println("------- Display all Doctor-------");
        ArrayList<Doctor> doctorList = service.displayAllDoctor();
        System.out.format("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
        String status;
        for (Doctor doctor : doctorList) {
            if(doctor.getAvailability()==1){
                status = "available";
            }
            else {
                status = "no available";
            }
            System.out.format("%-10s%-15s%-25s%-20s\n",doctor.getCode(),doctor.getName(),doctor.getSpecialization(),status);
        }
    }
    
    
    
    public void viewAddDoctor() {
        String code = Validator.getCode("Enter Code:", "Code cannot be empty!");
        if (service.getDoctorByCode(code) != null) {
            System.out.println("Doctor code already exists!");
            return;
        }
        String name = Validator.getString("Enter Name:", "Name cannot be empty!");
        String specialization = Validator.getString("Enter Specialization:", "Specialization cannot be empty!");
        int availability = Validator.getInt("Enter Availability (0-1):",
                "Availability cannot be empty!", "Must be 0 or 1!", 0, 1);
        service.addDoctor(code, name, specialization, availability);
    }

    public static void viewUpdateDoctor() {
        String code = Validator.getString("Enter Code: ", "Please enter code!");
        Doctor doctorFound = service.getDoctorByCode(code);
        if (doctorFound == null) {
            System.out.println("Doctor code does not exist!");
        } else {
            String name = Validator.getString("Enter Name: ", "Please enter name!");
            String specialization = Validator.getString("Enter Specialization: ", "Please enter specialization!");
            int availability = Validator.getInt("Enter Availability: ", "Please enter availability!", "Please enter 0 or 1", 0, 1);
            if (!Validator.checkChangeInformation(name, specialization, availability, doctorFound)) {
                System.out.println("No change");
                return;
            }
            service.updateDoctor(doctorFound, name, specialization, availability);
        }
    }
    public static void viewUpdateDoctor2() {
        String code = Validator.getString("Enter Code: ", "Please enter code!");
        Doctor doctorFound = service.getDoctorByCode(code);
        if (doctorFound == null) {
            System.out.println("Doctor code does not exist!");
        } else {
            String name = Validator.getUpdateString("Enter Name: ");
            String specialization = Validator.getUpdateString("Enter Specialization: ");
            int availability = Validator.getUpdateInt("Enter Availability: ", "Please enter 0 or 1", 0, 1);
            if (!Validator.checkChangeInformation(name, specialization, availability, doctorFound)) {
                System.out.println("No change");
                return;
            }
            service.updateDoctor2(doctorFound, name, specialization, availability);
        }
    }

    public static void viewDeleteDoctor() {
        String code = Validator.getString("Enter Code: ", "Please enter code!");
        Doctor doctorFound = service.getDoctorByCode(code);
        if (doctorFound == null) {
            System.out.println("Code does not exist Doctor!");
        } else {
            service.deleteDoctor(doctorFound);
        }
    }

    public static void viewSearchDoctor() {
        String text = Validator.getString("Enter text: ", "Please enter text");
        ArrayList<Doctor> listFound = service.searchDoctor(text);
        if (listFound.isEmpty()) {
            System.out.println("Not Found!");
        } else {
            System.out.println("--------- Result ------------");
            System.out.format("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFound) {
                System.out.format("%-10s%-15s%-25s%-20s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }

    public static void displayDoctor(String option, int slot) {
        ArrayList<Doctor> listOver = service.getDoctorBySlot("over", 10);
        ArrayList<Doctor> listUnder = service.getDoctorBySlot("under", 10);
        if (listOver.isEmpty()) {
            System.out.println("Not Found!");
        } else {
            System.out.println("--------- Result ------------");
            System.out.format("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listOver) {
                System.out.format("%-10s%-15s%-25s%-20s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
        if (listUnder.isEmpty()) {
            System.out.println("Not Found!");
        } else {
            System.out.println("--------- Result ------------");
            System.out.format("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listUnder) {
                System.out.format("%-10s%-15s%-25s%-20s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }

    public static void viewDisplayAvailableDoctor() {
        ArrayList<Doctor> availableDoctor = service.displayAvailableDoctor("available");
        ArrayList<Doctor> notAvailableDoctor = service.displayAvailableDoctor("no");
        if (availableDoctor.isEmpty()) {
            System.out.println("not found");
        } else {
            System.out.println("-----------Avaiable Doctor -------------");
            System.out.format("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : availableDoctor) {
                System.out.format("%-10s%-15s%-25s%-20s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }

        if (notAvailableDoctor.isEmpty()) {
            System.out.println("not found");
        } else {
            System.out.println("-----------Not Avaiable Doctor -------------");
            System.out.format("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : notAvailableDoctor) {
                System.out.format("%-10s%-15s%-25s%-20s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }

    public static void displayDoctorByName() {
        ArrayList<Doctor> sort = service.sortDoctorByName();
        System.out.format("%-10s%-15s%-25s%-20s\n",
                "Code", "Name", "Specialization", "Availability");

        for (Doctor doctor : sort) {
            System.out.format("%-10s%-15s%-25s%-20d\n",
                    doctor.getCode(),
                    doctor.getName(),
                    doctor.getSpecialization(),
                    doctor.getAvailability());
        }
    }
    //yeu cau viet them 
    // ham delete khong in ra msg delete success ma in ra tat ca info cua contact vua delete => delete doi thanh truyen object, return object delete va add vao new object de in ra
    //
}
