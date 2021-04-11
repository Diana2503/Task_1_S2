package ru.vsu.cs.gui.controller;

import ru.vsu.cs.Date;
import ru.vsu.cs.DateFormat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button2ResultListener implements ActionListener {
    JTextField enterTheFirstDateForComparison;
    JTextField enterTheSecondDateForComparison;
    JTextField comparisonResult;
    DateFormat form1 = new DateFormat("'dd'.'MM'.'yyyy'");

    public Button2ResultListener(JTextField enterTheFirstDateForComparison, JTextField enterTheSecondDateForComparison, JTextField comparisonResult) {
        this.enterTheFirstDateForComparison = enterTheFirstDateForComparison;
        this.enterTheSecondDateForComparison = enterTheSecondDateForComparison;
        this.comparisonResult = comparisonResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dateFirst = enterTheFirstDateForComparison.getText();
        Date dateFirstForComparison = DateFormat.parseADateFromAString(dateFirst);
        String dateSecond = enterTheSecondDateForComparison.getText();
        Date dateSecondForComparison = DateFormat.parseADateFromAString(dateSecond);
        String resultOfComparison = comparisonDates(form1, dateFirstForComparison, dateSecondForComparison);
        comparisonResult.setText(resultOfComparison);
    }

    public static String comparisonDates(DateFormat form1, Date dateFirstForComparison, Date dateSecondForComparison) {
        int comparisonOfDate = Date.compareDates(dateFirstForComparison, dateSecondForComparison);
        if (comparisonOfDate == 1) {
            return ("Date " + form1.formatDateByATemplate(dateFirstForComparison) + " more then date " + form1.formatDateByATemplate(dateSecondForComparison));
        } else if (comparisonOfDate == -1) {
            return ("Date " + form1.formatDateByATemplate(dateFirstForComparison) + " less then date " + form1.formatDateByATemplate(dateSecondForComparison));
        } else {
            return ("The numbers are equal");
        }
    }
}