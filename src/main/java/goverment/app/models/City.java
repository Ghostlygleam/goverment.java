package goverment.app.models;
import java.util.ArrayList;
import java.util.List;

public class City {
    private  String name;
    private boolean capital;

    public City(String name, boolean capital){
        this.name = name;
        this.capital = capital;
    }
    public String getName(){
        return name;
    }
    public boolean isCapital(){
        return capital;
    }

    @Override
    public String toString() {
        return name + (capital ? " (Capital)" : "");
    }
}


