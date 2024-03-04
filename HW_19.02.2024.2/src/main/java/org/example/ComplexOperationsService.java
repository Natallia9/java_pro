package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexOperationsService {
    public static void main(String[] args) {

    }
    public void validatePasswordStrength(String password) {
        // Password must contain at least 8 characters, including a digit, a lowercase letter, an uppercase letter, and a special character
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Password does not meet the strength requirements.");
        }
    }
    public void processText(String text) {
        // Text must not contain any forbidden words: "error", "fail", "wrong"
        List<String> forbiddenWords = Arrays.asList("error", "fail", "wrong");
        boolean containsForbiddenWord = forbiddenWords.stream().anyMatch(text::contains);
        if (containsForbiddenWord) {
            throw new IllegalArgumentException("Text contains forbidden words.");
        }
    }

    public void sumOfNumbersInString(String numbers) {
        // The string must contain numbers separated by commas, e.g., "1,2,3"
        List<Double> parsedNumbers;
        try {
            parsedNumbers = Arrays.stream(numbers.split(","))
                    .map(Double::parseDouble)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("String contains non-numeric values.");
        }

        double sum = parsedNumbers.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Sum: " + sum);
    }

    public void validateUrlFormat(String url) {
        // URL must start with http or https and contain a domain name
        String regex = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}.*$";
        if (!url.matches(regex)) {
            throw new IllegalArgumentException("URL format is invalid.");
        }
    }

    public void checkEmailListConsistency(List<String> emails) {
        // All emails in the list must be valid
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        boolean allEmailsValid = emails.stream().allMatch(email -> pattern.matcher(email).matches());
        if (!allEmailsValid) {
            throw new IllegalArgumentException("Email list contains invalid emails.");
        }
    }

    public void checkStringPalindrome(String input) {
        String sanitized = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(sanitized).reverse().toString();
        if (!sanitized.equals(reversed)) {
            throw new IllegalArgumentException("String is not a palindrome.");
        }
    }

    public void validateIdentificationNumber(String id) {
        // ID должен быть в формате: две буквы, за которыми следуют 6 цифр (например, AB123456)
        if (!id.matches("^[A-Za-z]{2}\\d{6}$")) {
            throw new IllegalArgumentException("Identification number format is invalid.");
        }
    }

    public void checkSumOfListAgainstThreshold(List<Integer> numbers, int threshold) {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        if (sum <= threshold) {
            throw new IllegalArgumentException("Sum of the list is not above the threshold.");
        }
    }

    public void validateIPAddress(String ipAddress) {
        // IP адрес должен соответствовать формату IPv4
        if (!ipAddress.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
            throw new IllegalArgumentException("IP address format is invalid.");
        }
    }

    public void ensureNoDuplicateEntries(List<String> entries) {
        long uniqueCount = entries.stream().distinct().count();
        if (uniqueCount < entries.size()) {
            throw new IllegalArgumentException("List contains duplicate entries.");
        }
    }

}