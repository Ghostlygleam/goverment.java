package goverment.app.main;
import goverment.app.models.*;
import goverment.app.services.*;
import goverment.app.utils.DataGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Goverment goverment = Goverment.getInstance("MyCountry");
        Region region1 = new Region("Region1");
        Region region2 = new Region("Region2");

        District district1 = new District("District1");
        District district2 = new District("District2");

        City city1 = new City("City1", true); // Capital city
        City city2 = new City("City2", false);

        district1.addCity(city1);
        district2.addCity(city2);

        region1.addDistrict(district1);
        region2.addDistrict(district2);

        goverment.addRegion(region1);
        goverment.addRegion(region2);

        CitizenService service = new CitizenService();
        for (int i = 0; i < 100; i++) { // Generate 100 citizens
            service.addCitizen(new Citizen(goverment));
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Display capital");
            System.out.println("2. Display number of regions");
            System.out.println("3. Display total area of the country");
            System.out.println("4. Display regional centers");
            System.out.println("5. Display average age of citizens");
            System.out.println("6. Display citizens with names of a specific length");
            System.out.println("7. Display citizens with names starting with a specific letter");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayCapital(goverment);
                    break;
                case 2:
                    displayNumberOfRegions(goverment);
                    break;
                case 3:
                    displayTotalArea(goverment);
                    break;
                case 4:
                    displayRegionalCenters(goverment);
                    break;
                case 5:
                    displayAverageAge(service);
                    break;
                case 6:
                    System.out.print("Enter name length: ");
                    int length = scanner.nextInt();
                    displayCitizensByNameLength(service, length);
                    break;
                case 7:
                    System.out.print("Enter starting letter: ");
                    char letter = scanner.next().charAt(0);
                    displayCitizensByStartingLetter(service, letter);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayCapital(Goverment government) {
        for (Region region : government.getRegions()) {
            for (District district : region.getDistricts()) {
                for (City city : district.getCities()) {
                    if (city.isCapital()) {
                        System.out.println("Capital: " + city);
                        return;
                    }
                }
            }
        }
        System.out.println("Capital not found.");
    }

    private static void displayNumberOfRegions(Goverment government) {
        System.out.println("Number of regions: " + government.getRegions().size());
    }

    private static void displayTotalArea(Goverment government) {
        // Assuming total area is the sum of areas of regions. Let's assume each region has an area for simplicity.
        int totalArea = 0;
        for (Region region : government.getRegions()) {
            totalArea += region.getDistricts().size(); // Example logic for area
        }
        System.out.println("Total area: " + totalArea);
    }

    private static void displayRegionalCenters(Goverment government) {
        for (Region region : government.getRegions()) {
            System.out.println("Region: " + region.getName());
            for (District district : region.getDistricts()) {
                System.out.println("  District: " + district.getName());
                for (City city : district.getCities()) {
                    System.out.println("    City: " + city);
                }
            }
        }
    }

    private static void displayAverageAge(CitizenService service) {
        int totalAge = 0;
        for (Citizen citizen : service.getCitizens()) {
            totalAge += citizen.getAge();
        }
        double averageAge = (double) totalAge / service.getCitizens().size();
        System.out.println("Average age: " + averageAge);
    }

    private static void displayCitizensByNameLength(CitizenService service, int length) {
        for (Citizen citizen : service.getCitizens()) {
            if (citizen.getFirstName().length() == length) {
                System.out.println(citizen);
            }
        }
    }

    private static void displayCitizensByStartingLetter(CitizenService service, char letter) {
        for (Citizen citizen : service.getCitizens()) {
            if (citizen.getFirstName().charAt(0) == letter) {
                System.out.println(citizen);
            }
        }
    }
}