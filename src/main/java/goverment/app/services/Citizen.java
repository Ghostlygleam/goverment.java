package goverment.app.services;

import goverment.app.models.Goverment;
import goverment.app.models.Goverment;
import goverment.app.utils.DataGenerator;

import java.util.Random;

public class Citizen {
    private static int idCounter = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private int age;
    private Goverment goverment;

    public Citizen(Goverment goverment){
        this.id= ++idCounter;
        this.firstName = DataGenerator.generateRandomName();
        this.lastName = DataGenerator.generateRandomName();
        this.age = DataGenerator.generateRandomAge();
        this.goverment = goverment;
    }

    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
    public Goverment getGoverment(){
        return goverment;
    }
    @Override
    public String toString() {
        return "Citizen ID: " + id + ", Name: " + firstName + " " + lastName + ", Age: " + age + ", Country: " + goverment.getName();
    }
}
