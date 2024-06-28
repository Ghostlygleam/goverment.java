package goverment.app.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CitizenService {
    private List<Citizen> citizens;

    public CitizenService(){
        this.citizens = new ArrayList<>();
    }

    public void addCitizen(Citizen citizen){
        citizens.add(citizen);
    }
    public List<Citizen> getCitizens(){
        return citizens;
    }
}
