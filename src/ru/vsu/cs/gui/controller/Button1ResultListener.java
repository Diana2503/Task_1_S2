package ru.vsu.cs.gui.controller;

import ru.vsu.cs.Date;
import ru.vsu.cs.DateFormat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1ResultListener implements ActionListener {
    JTextField enterDate;
    JTextField enterTheActionSign;
    JTextField enterValue;
    JTextField convertedDate;
    JTextField enterTimePeriod;
    DateFormat form1 = new DateFormat("'dd'.'MM'.'yyyy'");


    public Button1ResultListener(JTextField enterDate, JTextField enterTheActionSign, JTextField enterValue, JTextField convertedDate, JTextField enterTimePeriod) {
        this.enterDate = enterDate;
        this.enterTheActionSign = enterTheActionSign;
        this.enterValue = enterValue;
        this.convertedDate = convertedDate;
        this.enterTimePeriod = enterTimePeriod;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String date1 = enterDate.getText();
        Date date = DateFormat.parseADateFromAString(date1);
        int valueN = Integer.parseInt(enterValue.getText());
        String dateValue = enterTimePeriod.getText();
        String sign = enterTheActionSign.getText();
        if (sign.equals("+")) {
           date.addingNAmountOfTime(valueN, dateValue);
        } else {
            date.subtractNAmountOfTime(valueN, dateValue);
        }
        String dateNew = form1.formatDateByATemplate(date);
        convertedDate.setText(dateNew);
    }

}

