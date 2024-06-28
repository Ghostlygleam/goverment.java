package goverment.app.utils;
import java.util.Random;

public class DataGenerator {
    public static String generateRandomName(){
        int length = 5+ new Random().nextInt(6);
        StringBuilder name = new StringBuilder();
        for (int i = 0; i<length;i++){
            name.append((char) ('a' + new Random().nextInt(26)));
        }
        return name.toString();
    }
    public static int generateRandomAge(){
        return 18 +new Random().nextInt(63);
    }
}
