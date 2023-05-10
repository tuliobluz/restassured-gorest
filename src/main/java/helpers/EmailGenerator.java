package helpers;

import java.util.Random;

public class EmailGenerator {
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
    private static final String[] NAMES = {"johndoe", "janedoe", "bobsmith", "sarahjones", "mikewilliams", "laurabrown"};
    private static final Random random = new Random();

    public static String generateEmail() {
        String name = NAMES[random.nextInt(NAMES.length)];
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];
        int randomNumber = random.nextInt(1000);
        return name + randomNumber + "@" + domain;
    }
}