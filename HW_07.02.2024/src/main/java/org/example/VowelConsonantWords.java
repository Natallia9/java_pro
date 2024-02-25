package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelConsonantWords {
    public static List<String> findVowelConsonantWords(String input) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[aeiouAEIOU][a-zA-Z]*[^aeiouAEIOU\\W]\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;

    }
    public static void main(String[] args){
        String text = "Apple, orange, and banana are fruits. Dog, cat, and bird are animals.";
        List<String> vowelConsonantWords = findVowelConsonantWords(text);
        for (String word : vowelConsonantWords) {
            System.out.println(word);
        }
    }
}
