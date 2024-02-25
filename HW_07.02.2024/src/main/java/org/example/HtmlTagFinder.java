package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagFinder {
    public static List<String> findHtmlTags(String input) {
        List<String> tags = new ArrayList<>();
        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            tags.add(matcher.group());
        }
        return tags;
    }
    public static void main(String[] args) {
        String text = "<div class='content'>This is some <b>formatted</b> text.</div>";
        List<String> htmlTags = findHtmlTags(text);
        for (String tag : htmlTags) {
            System.out.println(tag);
        }
    }
}
