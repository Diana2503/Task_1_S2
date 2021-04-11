package ru.vsu.cs.gui.controller;

import ru.vsu.cs.Date;
import ru.vsu.cs.DateFormat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonResultChangeDateListener implements ActionListener {
    JTextField enterDate;
    JTextField enterTheActionSign;
    JTextField enterValue;
    JTextField convertedDate;
    JTextField enterTimePeriod;
    DateFormat form1 = new DateFormat("'dd'.'MM'.'yyyy'");

    public ButtonResultChangeDateListener(JTextField enterDate, JTextField enterTheActionSign, JTextField enterValue, JTextField convertedDate, JTextField enterTimePeriod) {
        this.enterDate = enterDate;
        this.enterTheActionSign = enterTheActionSign;
        this.enterValue = enterValue;
        this.convertedDate = convertedDate;
        this.enterTimePeriod = enterTimePeriod;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sourceDate = enterDate.getText();
        Date date = DateFormat.parseADateFromAString(sourceDate);
        int numberOfTimePeriod = Integer.parseInt(enterValue.getText());
        String nameOfTimePeriod = enterTimePeriod.getText();
        String signOfExecutingCommand = enterTheActionSign.getText();
        if (signOfExecutingCommand.equals("+")) {
            date.addingNAmountOfTime(numberOfTimePeriod, nameOfTimePeriod);
        } else {
            date.subtractNAmountOfTime(numberOfTimePeriod, nameOfTimePeriod);
        }
        String newChangedDate = form1.formatDateByATemplate(date);
        convertedDate.setText(newChangedDate);
    }
}

