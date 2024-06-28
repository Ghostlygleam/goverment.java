package goverment.app.models;
import java.util.ArrayList;
import java.util.List;

public class Goverment {
    private static Goverment instance;
    private String name;
    private List<Region> regions;

    private Goverment(String name){
        this.name = name;
        this.regions = new ArrayList<>();

    }

    public static Goverment getInstance(String name){
        if (instance == null){
            instance = new Goverment(name);
        }
        return instance;
    }
    public void addRegion(Region region){
        regions.add(region);
    }
    public String getName(){
        return name;
    }
    public List<Region> getRegions(){
        return regions;
    }
    @Override
    public String toString() {
        return "Country: " + name + ", Regions: " + regions;
    }
}