package com.naumDeveloper.javaCore1.unit_8.ui;

/*

Калькулятор

Доделать кнопку "С" - очищение строки
Доделать кнопку "Submit", она же равно "=". По нажатию кнопки должно выполняться вычисление выражения.
Реализовать вычисление выражения только для операций сложения и вычитания
** Попробовать применить ScriptEngine для вычисления математических выражений
** На основании задания №5, расширить добавить к списку операций умножение и деление

 */

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");

    private JFrame mainFrame;
    public Calculator() {
        mainFrame = new JFrame();

        mainFrame.setTitle("Calculator");
        mainFrame.setBounds(100, 300, 400, 700);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 3));

        mainFrame.add(top, BorderLayout.NORTH);
        mainFrame.add(bottom, BorderLayout.CENTER);

        JTextField outField = new JTextField();
        outField.setEditable(false);
        top.add(outField, BorderLayout.CENTER);

        ActionButtonListener abListener = new ActionButtonListener(outField);

        for (int i = 0; i <= 9; i++) {
            JButton digitBtn = new JButton(String.valueOf(i));
            bottom.add(digitBtn);
            digitBtn.addActionListener(abListener);
        }

        JButton plusBtn = new JButton("+");
        plusBtn.addActionListener(abListener);
        bottom.add(plusBtn);

        JButton minusBtn = new JButton("-");
        minusBtn.addActionListener(abListener);
        bottom.add(minusBtn);

        JButton multiplyBtn = new JButton("*");
        multiplyBtn.addActionListener(abListener);
        bottom.add(multiplyBtn);

        JButton divideBtn = new JButton("/");
        divideBtn.addActionListener(abListener);
        bottom.add(divideBtn);

        JButton cancelBtn = new JButton("C");
        cancelBtn.addActionListener(new ActionButtonListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String val = outField.getText() ;
                Object expResult = " ";
                outField.setText(expResult.toString());

            }
        });

         bottom.add(cancelBtn);


        JButton submitBtn = new JButton("=");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val = outField.getText() ;
                Object expResult = null;
                try {
                    expResult = scriptEngine.eval(val);
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
                outField.setText(expResult.toString());
            }
        });
        bottom.add(submitBtn);

        mainFrame.setVisible(true);
    }
}
