package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlLinkExtractor {
    public static List<String> extractLinks(String html) {
        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile("<a\\s+href=\"([^\"]+)\">");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            links.add(matcher.group());
//            links.add(matcher.group(1));
        }
        return links;
    }
    public static void main(String[] args) {
        String html = "<a href=\"https://www.example.com\">Example</a> " +
                "<a href=\"https://www.google.com\">Google</a>";
        List<String> extractedLinks = extractLinks(html);
        for (String link : extractedLinks) {
            System.out.println(link);
        }
    }
}
