/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class EastAsiaCountries extends Country{
    private String terrain;

    public EastAsiaCountries() {
    }


    public EastAsiaCountries(String terrain, String code, String name, float area) {
        super(code, name, area);
        this.terrain = terrain;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-20s%-20s%-20s\n",
                code, name, area,terrain);
    }
    
    
    
}
