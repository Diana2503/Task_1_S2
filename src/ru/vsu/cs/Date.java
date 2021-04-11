package ru.vsu.cs;

public class Date {
    private int date;

    Date(int year, int month, int date) {
        this.date = convertPatternInDate(year, month, date);
    }

    private boolean definingALeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int countDayInMonth(int month, int year) {
        if (month == 2 && definingALeapYear(year)) {
            return 29;
        } else if (month == 2) {
            return 28;
        } else if (month < 8) {
            return 30 + month % 2;
        } else {
            return 30 + (month - 1) % 2;
        }
    }

    public static int compareDates(Date date1, Date date2) {
        return Integer.compare(date1.getDate(), date2.getDate());
    }

    public int convertPatternInDate(int year, int month, int date) {
        int days = (year - 1) * 365;
        for (int i = 1; i < year; i++) {
            if (definingALeapYear(i)) {
                days++;
            }
        }
        for (int i = 1; i < month; i++) {
            days += countDayInMonth(i, year);
        }
        days += date;
        return days - 1;
    }

    public int[] convertDateInPattern() {
        int day, month = 1, year = 1;
        int enteredDate = this.date;
        int i = 1;
        while (enteredDate >= 365) {
            if (definingALeapYear(i) && enteredDate == 365) {
                month = 12;
                day = 31;
                return new int[]{day, month, year};
            }
            enteredDate -= definingALeapYear(i) ? 366 : 365;
            i++;
            year++;
        }
        i = 1;
        enteredDate++;
        while (enteredDate > 31) {
            enteredDate -= countDayInMonth(i, year);
            i++;
            month++;
        }
        day = enteredDate;
        return new int[]{day, month, year};
    }

    public void addingNAmountOfTime(int value, String type) {
        changeNAmountOfTime(value, type, true);
    }

    public void subtractNAmountOfTime(int value, String type) {
        changeNAmountOfTime(value, type, false);
    }

    private void changeNAmountOfTime(int value, String type, boolean add) {
        int[] arrDate = convertDateInPattern();
        if (type.equals("year") && value >= 0) {
            arrDate[2] += add ? value : -value;
            this.date = convertPatternInDate(arrDate[2], arrDate[1], arrDate[0]);
        } else if (type.equals("month") && value >= 0) {
            int n = add ? 12 : 0;
            while (value > n) {
                arrDate[2] += add ? 1 : -1;
                value -= 12;
            }
            arrDate[1] += add ? value : -value;
            this.date = convertPatternInDate(arrDate[2], arrDate[1], arrDate[0]);
        } else if (type.equals("day") && value >= 0) {
            this.date += add ? value : -value;
        }
    }

    public int getDate() {
        return date;
    }
}
