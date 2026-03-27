package service;

import entity.Doctor;
import java.util.ArrayList;
import utils.Validator;

public class DoctorService {

    Validator validator = new Validator();
    ArrayList<Doctor> listDoctor = new ArrayList<>();

    public void addDoctor(String code, String name, String specialization, int availability) {
        listDoctor.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful");
    }

    public void updateDoctor(Doctor doctorFound, String name, String specialization, int availability) {
        doctorFound.setName(name);
        doctorFound.setSpecialization(specialization);
        doctorFound.setAvailability(availability);
        System.out.println("Update successful!");
    }

    public void deleteDoctor(Doctor doctorFound) {
        listDoctor.remove(doctorFound);
        System.out.println("Delete successful!");
    }

    public ArrayList<Doctor> searchDoctor(String text) {
        text = text.toLowerCase();
        ArrayList<Doctor> listFound = new ArrayList<>();
        for (Doctor doctor : listDoctor) {
            if (doctor.getCode().toLowerCase().contains(text)
                    || doctor.getName().toLowerCase().contains(text)
                    || doctor.getSpecialization().toLowerCase().contains(text)) {
                listFound.add(doctor);
            }
        }
        return listFound;
    }

    public ArrayList<Doctor> getDoctorBySlot(String option, int slots) {
        ArrayList<Doctor> listOver = new ArrayList<>();
        ArrayList<Doctor> listUnder = new ArrayList<>();
        for (Doctor doctor : listDoctor) {
            if (doctor.getAvailability() > slots) {
                listOver.add(doctor);
            } else {
                listUnder.add(doctor);
            }
        }
        if (option.equalsIgnoreCase("over")) {
            return listOver;
        } else {
            return listUnder;
        }
    }

    public Doctor getDoctorByCode(String code) {
        for (Doctor doctor : listDoctor) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public int countAvailableDoctor() {
        int count = 0;

        for (Doctor doctor : listDoctor) {
            if (doctor.getAvailability() == 1) {
                count++;
            }
        }        return count;
    }

    public ArrayList<Doctor> displayAvailableDoctor(String option) {
        ArrayList<Doctor> availableDoctor = new ArrayList<>();
        ArrayList<Doctor> notAvailableDoctor = new ArrayList<>();
        for (Doctor doctor : listDoctor) {
            if (doctor.getAvailability() == 1) {
                availableDoctor.add(doctor);
            } else {
                notAvailableDoctor.add(doctor);
            }
        }
        if (option.equalsIgnoreCase("available")) {
            return availableDoctor;
        } else {
            return notAvailableDoctor;
        }
    }

    public ArrayList<Doctor> sortDoctorByName() {
        for (int i = 0; i < listDoctor.size() - 1; i++) {
            for (int j = i + 1; j < listDoctor.size(); j++) {

                if (listDoctor.get(i).getName()
                        .compareToIgnoreCase(listDoctor.get(j).getName()) > 0) {

                    Doctor temp = listDoctor.get(i);
                    listDoctor.set(i, listDoctor.get(j));
                    listDoctor.set(j, temp);
                }
            }
        }
        return listDoctor;
    }

    public ArrayList<Doctor> displayAllDoctor() {
        return listDoctor;
    }

    public void updateDoctor2(Doctor doctorFound, String name, String specialization, int availability) {
        if (name.isEmpty()) {
            name = doctorFound.getName();
        }
        doctorFound.setName(name);
        if (specialization.isEmpty()) {
            specialization = doctorFound.getSpecialization();
        }
        doctorFound.setSpecialization(specialization);

        if (availability == -1) {
            availability = doctorFound.getAvailability();
        }
        doctorFound.setAvailability(availability);
        System.out.println("Update successful!");
    }

}
