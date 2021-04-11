package ru.vsu.cs.gui.frame;

import ru.vsu.cs.gui.controller.Button1ResultListener;
import ru.vsu.cs.gui.controller.Button2ResultListener;

import javax.swing.*;

public class Frame extends JFrame {
    private JPanel mainPanel;
    private JTextField enterDate;
    private JTextField enterTheActionSign;
    private JTextField enterValue;
    private JTextField convertedDate;
    private JButton performAnActionButton;
    private JTextField enterTheFirstDateForComparison;
    private JTextField enterTheSecondDateForComparison;
    private JTextField comparisonResult;
    private JButton compareOfDatesButton;
    private JTextField enterTimePeriod;


    public Frame() {
        super("Task №1");

        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        pack();
        setBounds(400, 300, 950, 300);

        performAnActionButton.addActionListener(new Button1ResultListener(enterDate, enterTheActionSign, enterValue, convertedDate, enterTimePeriod));
        compareOfDatesButton.addActionListener(new Button2ResultListener(enterTheFirstDateForComparison, enterTheSecondDateForComparison, comparisonResult));
    }
}