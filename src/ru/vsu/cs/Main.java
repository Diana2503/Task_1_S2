package ru.vsu.cs;

public class Main {

    public static void main(String[] args) {
        DateFormat form = new DateFormat();
        DateFormat form1 = new DateFormat("'dd'.'MM'.'yyyy'");
        DateFormat form2 = new DateFormat("Day 'd', Month 'MMMM', Year 'yyyy'");


        Date date = new Date(736457);
        Date date1 = new Date(2021, 2, 17);
        Date date2 = new Date(1995, 6, 5);

        String str = "4.06.2015";
        Date date3 = DateFormat.parseADateFromAString(str);
        System.out.println(form1.formatDateByATemplate(date3));

        String str1 = "07 5 1998";
        Date date4 = DateFormat.parseADateFromAString(str1);
        System.out.println(form1.formatDateByATemplate(date4));
        System.out.println(form2.formatDateByATemplate(date4));

        date3.addingNAmountOfTime(478, "month");
        System.out.println(form2.formatDateByATemplate(date3));

        date2.subtractNAmountOfTime(20, "year");
        System.out.println(form1.formatDateByATemplate(date2));

        printResultOfFormat(form, form1, form2, date);
        printResultOfFormat(form, form1, form2, date1);
        printResultOfFormat(form, form1, form2, date2);
        printResultOfFormat(form, form1, form2, date3);
        printResultOfFormat(form, form1, form2, date4);

        int comparisonOfData = Date.compareDates(date1, date2);
        if (comparisonOfData == 1) {
            System.out.println("Число" + form1.formatDateByATemplate(date1) + " > числа " + form1.formatDateByATemplate(date2));
        } else if (comparisonOfData == -1) {
            System.out.println("Число" + form1.formatDateByATemplate(date2) + "< числа" + form1.formatDateByATemplate(date1));
        } else {
            System.out.println("Числа равны");
        }
    }

    public static void printResultOfFormat(DateFormat form, DateFormat form1, DateFormat form2, Date date) {
        System.out.println("Program result: \n" + form.formatDateByATemplate(date) +
                "\n" + form1.formatDateByATemplate(date) + "\n" + form2.formatDateByATemplate(date));
    }
}
