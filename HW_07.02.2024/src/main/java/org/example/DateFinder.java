package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFinder {
    public static List<String> findDates(String input) {
        List<String> dates = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(0?[1-9]|[12]\\d|3[01])/(0?[1-9]|1[0-2])/\\d{4}\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
    public static void main(String[] args) {
        String text2 = "The meeting is scheduled for 25/09/2023. Please RSVP by 20/09/2023.";
        List<String> dates = DateFinder.findDates(text2);
        for (String date : dates) {
            System.out.println(date);
        }
    }
}

