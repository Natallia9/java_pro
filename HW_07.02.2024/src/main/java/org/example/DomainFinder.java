package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomainFinder {
    public static List<String> findDomains(String input) {
        List<String> domains = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            domains.add(matcher.group());
        }
        return domains;
    }
    public static void main(String[] args) {
        String text3 = "Visit example.com for more information. Also, check out google.com";
        List<String> domains = DomainFinder.findDomains(text3);
        for (String domain : domains) {
            System.out.println(domain);
        }
    }
}
