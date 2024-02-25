package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringLiteralFinder {
    public static List<String> findStringLiterals(String input) {
        List<String> literals = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"(?:\\\\\"|[^\"])*\"");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String lit = matcher.group();

            literals.add(lit);
        }
        return literals;
    }
    public static void main(String[] args){
        String code = "String message = \"Hello, world!\";\n" +
                "String path = \"C:\\\\Program Files\\\\Java\";";
        List<String> stringLiterals = findStringLiterals(code);
        for (String literal : stringLiterals) {
            System.out.println(literal);
        }
    }
}
