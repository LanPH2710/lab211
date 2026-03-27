
package entity;

/**
 *
 * @author ADMIN
 */
public class Country {
    protected String code;
    protected String name;
    protected float area;

    public Country() {
    }

    public Country(String code, String name, float area) {
        this.code = code;
        this.name = name;
        this.area = area;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void display(){
        System.out.printf("%-10s%-20s%-20s",
                code, name, area);
    }
    
    
}
