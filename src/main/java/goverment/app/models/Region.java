package goverment.app.models;
import java.util.ArrayList;
import java.util.List;

public class Region {
    private String name;
    private List<District> districts;

    public Region(String name){
        this.name = name;
        this.districts = new ArrayList<>();
    }

    public void addDistrict(District district){
        districts.add(district);
    }
    public String getName(){
        return name;
    }
    public List<District> getDistricts(){
        return districts;
    }
    @Override
    public String toString() {
        return "Region: " + name + ", Districts: " + districts;
    }
}
