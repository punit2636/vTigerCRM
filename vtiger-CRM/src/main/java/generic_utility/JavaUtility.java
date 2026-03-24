package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JavaUtility {
	public int ranNum() {

		int random = (int) (Math.random() * 9999);
		System.out.println(random);
		return random;

	}
	
	public void printCurrentDateAndTime() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        // Define a friendly format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        // Format and print
        String formattedDate = now.format(formatter);
        System.out.println("Current Date and Time: " + formattedDate);
    }
	
	public String randomString(int length) {
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
	}
}
