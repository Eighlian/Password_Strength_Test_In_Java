package pwTest;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PasswordStrengthTest {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input a 4-pin password. Only numbers and letters (case-sensitive) are allowed: ");
        String pass = scan.next();

        // Checks for 4 digit passcode length
        if (pass.length() != 4) {
            System.out.println("Error: Invalid password length.");
            return;
        }
        //Confirm only letters and numbers are used
        if (!(Character.isLetterOrDigit(pass.charAt(0)) && Character.isLetterOrDigit(pass.charAt(1)) &&
                Character.isLetterOrDigit(pass.charAt(2)) && Character.isLetterOrDigit(pass.charAt(3)))) {
            System.out.println("Error: Some characters are not numbers or digits.");
            return;
        }

        List<String> dictionary = generateDictionary();

        long start = System.currentTimeMillis(); // Begin Time

        boolean cracked = false;

        for (String word : dictionary) {
            if (word.equals(pass)) {
                cracked = true;
                break;
            }
        }

        long stop = System.currentTimeMillis(); // End Time

        if (cracked) {
            System.out.println("Your password can be hacked within " + (stop - start) + " ms");
        } else {
            System.out.println("Your password is secure.");
        }
    }

    // Generate a simple dictionary of all possible 4-character combinations of numbers and letters
    private static List<String> generateDictionary() {
        List<String> dictionary = new ArrayList<>();
        String allowedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < allowedChars.length(); i++) {
            for (int j = 0; j < allowedChars.length(); j++) {
                for (int k = 0; k < allowedChars.length(); k++) {
                    for (int m = 0; m < allowedChars.length(); m++) {
                        String word = allowedChars.charAt(i) + String.valueOf(allowedChars.charAt(j)) +
                                allowedChars.charAt(k) + allowedChars.charAt(m);
                        dictionary.add(word);
                    }
                }
            }
        }
        return dictionary;
    }
}
