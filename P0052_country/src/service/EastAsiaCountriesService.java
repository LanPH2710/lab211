/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ADMIN
 */
public class EastAsiaCountriesService {

    ArrayList<EastAsiaCountries> listCountry;

    public EastAsiaCountriesService(ArrayList<EastAsiaCountries> listCountry) {
        this.listCountry = listCountry;
    }
    

    public void addData() {
        listCountry.add(new EastAsiaCountries("nice", "VN", "Viet nam", 200));
        listCountry.add(new EastAsiaCountries("good", "TL", "Thai lan", 300));
        listCountry.add(new EastAsiaCountries("okay", "LA", "Lao", 200));
    }

    public EastAsiaCountries getCode(String code) {
        for (EastAsiaCountries eastAsiaCountries : listCountry) {
            if (code.equals(eastAsiaCountries.getCode())) {
                return eastAsiaCountries;
            }
        }
        return null;
    }

    public void addCountry(String code, String name, float area, String terrain) {
        listCountry.add(new EastAsiaCountries(terrain, code, name, area));
    }


    public ArrayList<EastAsiaCountries> searchCountryByName(String name) {
        ArrayList<EastAsiaCountries> countryFound = new ArrayList<>();
        for (EastAsiaCountries eastAsiaCountries : listCountry) {
            if (eastAsiaCountries.getName().toLowerCase().contains(name.toLowerCase())) {
                countryFound.add(eastAsiaCountries);
            }
        }
        return countryFound;
    }

    public ArrayList<EastAsiaCountries> sortCountryByName() {
        ArrayList<EastAsiaCountries> sortName = new ArrayList<>(listCountry);
        for (int i = 0; i < sortName.size() - 1; i++) {
            for (int j = i + 1; j < sortName.size(); j++) {

                if (sortName.get(i).getName()
                        .compareToIgnoreCase(sortName.get(j).getName()) > 0) {

                    EastAsiaCountries temp = sortName.get(i);
                    sortName.set(i, sortName.get(j));
                    sortName.set(j, temp);
                }
            }
        }
        return sortName;
    }
    

    public EastAsiaCountries getName(String name) {
        for (EastAsiaCountries eastAsiaCountries : listCountry) {
            if (name.equals(eastAsiaCountries.getName())) {
                return eastAsiaCountries;
            }
        }
        return null;
    }

    public ArrayList<EastAsiaCountries> displayAllCountry() {
        return listCountry;
    }

    
}
