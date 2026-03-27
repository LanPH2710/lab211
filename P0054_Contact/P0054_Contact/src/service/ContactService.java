package service;

import entity.Contact;
import java.util.ArrayList;
import ultis.Validator;

public class ContactService {

    ArrayList<Contact> listContacts;

    public ContactService(ArrayList<Contact> listContacts) {
        this.listContacts = listContacts;
    }

    public void addContact(String fullName, String group, String address, String phone) {
        String firstName;
        String lastName;
        int id = listContacts.size() + 1;
        int index = fullName.indexOf(" ");
        if (index == -1) {
            firstName = fullName;
            lastName = "";
        } else {
            firstName = fullName.substring(0, index);
            lastName = fullName.substring(index + 1);
        }
        listContacts.add(new Contact(id, fullName, group, address, phone, lastName, firstName));
    }

    public ArrayList<Contact> displayAllContact() {
        return listContacts;
    }

    public boolean deleteContact(int id) {
        Contact contactFound = getContactById(id);
        if (contactFound == null) {
            return false;
        } else {
            listContacts.remove(contactFound);
            for (Contact list : listContacts) {
                if (list.getId() > id) {
                    list.setId(list.getId()-1);
                }
            }
            return true;
        }
    }

    public Contact getContactById(int id) {
        for (Contact contact : listContacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }
}
