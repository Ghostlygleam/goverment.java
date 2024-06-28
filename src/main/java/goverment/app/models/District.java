package goverment.app.models;
import java.util.ArrayList;
import java.util.List;

public class District {
    private String name;
    private List<City> cities;

    public District(String name){
        this.name = name;
        this.cities = new ArrayList<>();
    }

    public  void addCity(City city){
        cities.add(city);
    }

    public String getName(){
        return name;
    }
    public List<City> getCities(){
        return cities;
    }

    @Override
    public String toString(){
        return "District: " + name +", Cities:"+ cities;
    }
}
