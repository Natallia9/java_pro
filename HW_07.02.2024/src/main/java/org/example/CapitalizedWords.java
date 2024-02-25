package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWords {
    public static List<String> findCapitalizedWords(String input) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\p{Lu}\\p{L}*\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        String text = "This is a Test sentence with Some Capitalized Words.";
        List<String> capitalizedWords = CapitalizedWords.findCapitalizedWords(text);
        for (String word : capitalizedWords) {
            System.out.println(word);
        }
    }
}
