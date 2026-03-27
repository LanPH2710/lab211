package view;

import entity.Contact;
import java.util.ArrayList;
import service.ContactService;
import ultis.Validator;

public class Main {

    static ContactService service = new ContactService(new ArrayList<>());

    public static void main(String[] args) {

  //      ArrayList<Contact> listContacts = new ArrayList<>();
        while (true) {
            System.out.println("========= Contact program ==========\n"
                    + "1.Add a contact\n"
                    + "2.Display all contact\n"
                    + "3.Delete contact\n"
                    + "4.Exit");
            int choice = Validator.getInt("Enter your choice", "Please enter your choice", "Invalid choice", "Invalid choice", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("--------- Add Contact ----------");
                    viewAddContact();
                    break;
                case 2:
                    System.out.println("--------- Display all contacts -------");
                    displayAllContact();
                    break;
                case 3:
                    System.out.println("--------- Delete Contact -------");
                    viewDeleteContact();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void viewAddContact() {
        String fullName = Validator.getString("Enter Name: ", "Please enter name!");
        String group = Validator.getString("Enter Group: ", "Please enter group!");
        String address = Validator.getString("Enter Address: ", "Please enter address!");
        String phone = Validator.getPhone("Enter phone", "Please enter phone", "Please input Phone flow "
                + "• 1234567890 "
                + "• 123-456-7890 "
                + "• 123-456-7890 x1234 "
                + "• 123-456-7890 ext1234 "
                + "• (123)-456-7890 "
                + "• 123.456.7890 "
                + "• 123 456 7890");
        service.addContact(fullName, group, address, phone);
        System.out.println("Add successful");
    }

    public static void displayAllContact() {
        ArrayList<Contact> listContacts = service.displayAllContact();
        System.out.format("%-10s%-40s%-20s%-20s%-15s%-20s%-20s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact contact : listContacts) {
            System.out.format("%-10s%-40s%-20s%-20s%-15s%-20s%-20s\n", contact.getId(), contact.getFullName(), contact.getFirstName(), contact.getLastName(), contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    public static void viewDeleteContact() {
        int id = Validator.getInt("Enter ID: ", "Please enter Id!", "ID is digit", "ID is digit", 0, Integer.MAX_VALUE);
        if (!service.deleteContact(id)) {
            System.out.println("ID does not exist Contact!");
        } else {
            System.out.println("Delete successful!");
        }
    }
    
    //yeu cau code them
    //search theo group va display ra
}
