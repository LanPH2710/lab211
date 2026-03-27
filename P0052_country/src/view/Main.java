/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.EastAsiaCountries;
import java.util.ArrayList;
import service.EastAsiaCountriesService;
import static utils.Constants.EMPTY_LIST;
import static utils.Constants.ERR_FOUND;
import static utils.Constants.EXITS_CODE;
import utils.Validator;
import static utils.Validator.VALID_CODE;
import static utils.Validator.VALID_STR;

/**
 *
 * @author ADMIN
 */
public class Main {

    static EastAsiaCountriesService service = new EastAsiaCountriesService(new ArrayList<>());

    public static void main(String[] args) {
        service.addData();
        while (true) {
            menu();
            int choice = Validator.getInt("Please choice one option", 1, 5);
            switch (choice) {
                case 1:
                    inputCountryInformation(5);
                    break;
                case 2:
                    displayJustInputCountry();
                    break;
                case 3:
                    searchCountryByName();
                    break;
                case 4:
                    displayCountrySortedByName();
                    break;
                case 5:
                    return;
                
            }
        }
    }

    public static void inputCountryInformation(int limit) {
        ArrayList<EastAsiaCountries> listCountry = service.displayAllCountry();
        if (listCountry.size() == limit) {
            System.out.println("enough country");
            return;
        }
        System.out.println("-------------- Input Country Information ---------------");
        int countLimit = listCountry.size();
        while (countLimit < limit) {
            String code = Validator.getString("Enter country code: ", VALID_CODE);
            EastAsiaCountries countryFound = service.getCode(code);
            if (countryFound == null) {
                String name = Validator.getString("Enter country name: ", VALID_STR);
                float area = Validator.getFloat("Enter country area", 1);
                String terrain = Validator.getString("Enter country terrain: ", VALID_STR);
                service.addCountry(code, name, area, terrain);
                System.out.println("Add successful");
                countLimit++;
            } else {
                System.out.println(EXITS_CODE);
            }
        }

    }
    //ham yeu cau: dua het display vao 1 ham
    public static void display(ArrayList<EastAsiaCountries> c){
        System.out.printf("%-10s%-20s%-20s%-20s\n", "Code", "Name", "Area", "Terrain");
            for (EastAsiaCountries eastAsiaCountries : c) {
                eastAsiaCountries.display();
            }
    }
    public static void displayJustInputCountry() {
        ArrayList<EastAsiaCountries> justInputCountry = service.displayAllCountry();
        if (justInputCountry == null) {
            System.out.println("no country just input");
        } else {
            display(justInputCountry);
//            System.out.printf("%-10s%-20s%-20s%-20s\n", "Code", "Name", "Area", "Terrain");
//            for (EastAsiaCountries eastAsiaCountries : justInputCountry) {
//                eastAsiaCountries.display();
//            }
        }
    }

    public static void searchCountryByName() {
        String name = Validator.getString("Enter country name: ", VALID_STR);
        ArrayList<EastAsiaCountries> countryFound = service.searchCountryByName(name);
        if (countryFound.isEmpty()) {
            System.out.println(ERR_FOUND);
        } else {
            display(countryFound);
//            System.out.printf("%-10s%-20s%-20s%-20s\n", "Code", "Name", "Area", "Terrain");
//            for (EastAsiaCountries eastAsiaCountries : countryFound) {
//                eastAsiaCountries.display();
//            }
        }
    }

    public static void displayCountrySortedByName() {
        ArrayList<EastAsiaCountries> sortCountry = service.sortCountryByName();
        if (sortCountry.isEmpty()) {
            System.out.println(ERR_FOUND);
        } else {
            display(sortCountry);
//            System.out.printf("%-10s%-20s%-20s%-20s\n", "Code", "Name", "Area", "Terrain");
//            for (EastAsiaCountries eastAsiaCountries : sortCountry) {
//                eastAsiaCountries.display();
//            }
        }
    }

    public static void menu() {
        System.out.println("                          MENU                             ");
        System.out.println("===========================================================");
        System.out.println("1. Input the information if 11 country");
        System.out.println("2. Display the information of country");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("6. top name");
        System.out.println("7. top area");
    }
    //yeu cau code them 
    // display top 3 country co area lon nhat
    // get top 3 area lon nhat, display tat ca (vi du: countryArea a,b =100, c=70, d,e=50, f-30, g=20 -> top 3 co a,b,c,d,e)
    
}
