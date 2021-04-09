package ru.vsu.cs;

import java.util.HashMap;

public class DateFormat {
    private static final String defaultPattern = "'dd'.'MM'.'yyyy'";
    private final String pattern;
    private final HashMap<Integer, String> middleNameMonth = createMap(new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    });
    private final HashMap<Integer, String> fullNameMonth = createMap(new String[]{
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    });

    public DateFormat() {
        this.pattern = defaultPattern;
    }

    public DateFormat(String pattern) {
        this.pattern = pattern;
    }

    private HashMap<Integer, String> createMap(String[] arr) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put(i + 1, arr[i]);
        }
        return map;
    }

    public String formatDateByATemplate(Date date) {
        int[] arr = date.convertDateInPattern();
        String str = pattern;
        String dayWithZero = arr[0] < 10 ? "0" : "";
        dayWithZero += String.valueOf(arr[0]);
        str = str.replace("'dd'", dayWithZero);
        str = str.replace("'d'", String.valueOf(arr[0]));
        String monthFull = fullNameMonth.get(arr[1]);
        str = str.replace("'MMMM'", monthFull);
        String monthMiddle = middleNameMonth.get(arr[1]);
        str = str.replace("'MMM'", monthMiddle);
        String monthWithZero = arr[1] < 10 ? "0" : "";
        monthWithZero += String.valueOf(arr[1]);
        str = str.replace("'MM'", monthWithZero);
        str = str.replace("'M'", String.valueOf(arr[1]));
        str = str.replace("'yyyy'", String.valueOf(arr[2]));
        String shortYear = String.valueOf(arr[2]).substring(2);
        str = str.replace("'yy'", shortYear);
        str = str.replace("'y'", String.valueOf(arr[2]));
        return str;
    }

    public static Date parseADateFromAString(String str) {
        int day, month, year;
        String[] arr = str.split("\\D++");
        day = Integer.parseInt(arr[0]);
        month = Integer.parseInt(arr[1]);
        year = Integer.parseInt(arr[2]);
        return new Date(year, month, day);
    }
}
