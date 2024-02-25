package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isValidEmail(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static void main(String[] args) {
        String email = "user@example.com";
        boolean isValid = isValidEmail(email);
        System.out.println("Is valid email address: " + isValid);
    }
}
