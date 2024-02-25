package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPv4Validator {
    public static boolean isValidIPv4(String input) {
        Pattern pattern = Pattern.compile("((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}" +
                "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)");
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
    public static void main(String[] args) {
        String ipAddress = "192.168.0.1.txt";
        boolean isValid = isValidIPv4(ipAddress);
        System.out.println("Is valid IPv4 address: " + isValid);
    }
}
// ^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$"