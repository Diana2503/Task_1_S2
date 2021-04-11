package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DateFormat form = new DateFormat();
        DateFormat form1 = new DateFormat("'dd'.'MM'.'yyyy'");
        DateFormat form2 = new DateFormat("Day 'd', Month 'MMMM', Year 'yyyy'");

        String dateFirst = readLine("1.Compare dates.\n" + "Enter date: ");
        Date dateFirstForComparison = DateFormat.parseADateFromAString(dateFirst);
        String dateSecond = readLine("Enter date: ");
        Date dateSecondForComparison = DateFormat.parseADateFromAString(dateSecond);
        comparisonDates(form1, dateFirstForComparison, dateSecondForComparison);

        String signOfExecutingCommand = readLine("2.\n" + "Enter command: ");
        while (!signOfExecutingCommand.equals("exit")) {
            switch (signOfExecutingCommand) {
                case "+":
                    String sourceDate1 = readLine("Enter sours date: ");
                    int number1OfTimePeriod = Integer.parseInt(readLine("Enter number of time period: "));
                    String name1OfTimePeriod = readLine("Enter \"day\" or \"month\" or \"year\" : ");
                    firsCommandOfAdding(form, form1, form2, number1OfTimePeriod, sourceDate1, name1OfTimePeriod);
                    break;
                case "-":
                    String sourceDate2 = readLine("Enter sours date: ");
                    int number2OfTimePeriod = Integer.parseInt(readLine("Enter number: "));
                    String name2OfTimePeriod = readLine("Enter \"day\" or \"month\" or \"year\" : ");
                    secondCommandOfSubtract(form, form1, form2, number2OfTimePeriod, sourceDate2, name2OfTimePeriod);
                    break;
                default:
                    System.out.println("Oooops, something wrong!");
            }
            signOfExecutingCommand = readLine("Enter command: ");
        }
    }

    public static void comparisonDates(DateFormat form1, Date dateFirstForComparison, Date dateSecondForComparison) {
        int comparisonOfDate = Date.compareDates(dateFirstForComparison, dateSecondForComparison);
        if (comparisonOfDate == 1) {
            System.out.println("Date" + form1.formatDateByATemplate(dateFirstForComparison) + " more then date " + form1.formatDateByATemplate(dateSecondForComparison));
        } else if (comparisonOfDate == -1) {
            System.out.println("Date " + form1.formatDateByATemplate(dateFirstForComparison) + " less then date " + form1.formatDateByATemplate(dateSecondForComparison));
        } else {
            System.out.println("The numbers are equal");
        }
    }

    public static void firsCommandOfAdding(DateFormat form, DateFormat form2, DateFormat form3, int number1OfTimePeriod, String sourceDate1, String name1OfTimePeriod) {
        Date date = DateFormat.parseADateFromAString(sourceDate1);
        date.addingNAmountOfTime(number1OfTimePeriod, name1OfTimePeriod);
        System.out.println(form.formatDateByATemplate(date));
        printResultOfFormat(form, form2, form3, date);
    }


    public static void secondCommandOfSubtract(DateFormat form, DateFormat form2, DateFormat form3, int number2OfTimePeriod, String sourceDate2, String name2OfTimePeriod) {
        Date date = DateFormat.parseADateFromAString(sourceDate2);
        date.subtractNAmountOfTime(number2OfTimePeriod, name2OfTimePeriod);
        System.out.println(form.formatDateByATemplate(date));
        printResultOfFormat(form, form2, form3, date);
    }

    public static String readLine(String name) {
        Scanner scn = new Scanner(System.in);
        System.out.print(name);
        return scn.nextLine();
    }

    public static void printResultOfFormat(DateFormat form, DateFormat form1, DateFormat form2, Date date) {
        System.out.println("Various forms of date output: \n" + form.formatDateByATemplate(date) +
                "\n" + form1.formatDateByATemplate(date) + "\n" + form2.formatDateByATemplate(date));
    }
}