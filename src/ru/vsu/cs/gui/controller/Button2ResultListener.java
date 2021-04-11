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
        String date1 = enterTheFirstDateForComparison.getText();
        Date dateFirst = DateFormat.parseADateFromAString(date1);
        String date2 = enterTheSecondDateForComparison.getText();
        Date dateSecond = DateFormat.parseADateFromAString(date2);
        String comparisonOfDate = comparisonDates(form1, dateFirst, dateSecond);
        comparisonResult.setText(comparisonOfDate);
    }

    public static String comparisonDates(DateFormat form1, Date dateFirst, Date dateSecond) {
        int comparisonOfDate = Date.compareDates(dateFirst, dateSecond);
        if (comparisonOfDate == 1) {
            return ("Date" + form1.formatDateByATemplate(dateFirst) + " more then date " + form1.formatDateByATemplate(dateSecond));
        } else if (comparisonOfDate == -1) {
            return ("Date" + form1.formatDateByATemplate(dateFirst) + " less then date" + form1.formatDateByATemplate(dateSecond));
        } else {
            return ("The numbers are equal");
        }
    }

}