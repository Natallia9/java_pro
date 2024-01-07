package HW_18_12_2023;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex_7 {
    public static void main (String[] args){
        String text = "Obey to the system\n" +
                "They wanna hold on your mind\n" +
                "Your mind is the land to invade\n" +
                "Your mind is the land to detain";

        TextAnalyzer words = txt -> {
            if (txt == null || txt.trim().isEmpty()) {
                return 0;
            }
            return Arrays.stream(txt.split(" "))
                    .collect(Collectors.toSet())
                    .size();
        };
        int uniqueWords = analyze(text, words);

        System.out.println("The number of unique words in the text: " + uniqueWords);
    }
    public static int analyze(String txt, TextAnalyzer txtAnalyzer){
        return txtAnalyzer.text(txt);
    }
    @FunctionalInterface
    interface TextAnalyzer{
        int text (String analyze);
    }
}
