package com.example.myapp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class App implements ActionListener 
{
    JFrame frame;
    JPanel panel;
    JTextField t1, t2, tresult;
    JButton addBtn, subBtn, mulBtn, divBtn, exitBtn;
    JLabel statusLabel;

    public App() 
    {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {}

        frame = new JFrame("SRM-IST - Practical Calculator");
        frame.setSize(520, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(248, 250, 252)); // Slate-50 background

        // Typography
        Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 17);
        Font subTitleFont = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 13);
        Font inputFont = new Font(Font.SANS_SERIF, Font.PLAIN, 13);
        Font statusFont = new Font(Font.SANS_SERIF, Font.ITALIC, 11);

        // Header Section
        JLabel titleLabel = new JLabel("Calculator Utility");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(30, 41, 59)); // Slate-800
        titleLabel.setBounds(45, 18, 300, 24);

        JLabel subLabel = new JLabel("Java Full Stack Practical • Basic Arithmetic Operations");
        subLabel.setFont(subTitleFont);
        subLabel.setForeground(new Color(100, 116, 139)); // Slate-500
        subLabel.setBounds(45, 44, 430, 18);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(226, 232, 240)); // Slate-200
        separator.setBounds(45, 72, 430, 2);

        // Input borders
        final Border defaultBorder = BorderFactory.createCompoundBorder(
            new LineBorder(new Color(203, 213, 225), 1, true),
            BorderFactory.createEmptyBorder(4, 10, 4, 10)
        );
        final Border focusedBorder = BorderFactory.createCompoundBorder(
            new LineBorder(new Color(59, 130, 246), 2, true),
            BorderFactory.createEmptyBorder(3, 9, 3, 9)
        );

        // Form Labels & Inputs
        JLabel l1 = new JLabel("First Number:");
        l1.setFont(labelFont);
        l1.setForeground(new Color(51, 65, 85)); // Slate-700
        l1.setBounds(45, 95, 125, 30);

        t1 = new JTextField(10);
        t1.setFont(inputFont);
        t1.setBackground(Color.WHITE);
        t1.setBorder(defaultBorder);
        t1.setBounds(180, 95, 200, 30);
        addFocusEffect(t1, defaultBorder, focusedBorder);

        JLabel l2 = new JLabel("Second Number:");
        l2.setFont(labelFont);
        l2.setForeground(new Color(51, 65, 85));
        l2.setBounds(45, 140, 125, 30);

        t2 = new JTextField(10);
        t2.setFont(inputFont);
        t2.setBackground(Color.WHITE);
        t2.setBorder(defaultBorder);
        t2.setBounds(180, 140, 200, 30);
        addFocusEffect(t2, defaultBorder, focusedBorder);

        JLabel l3 = new JLabel("Result:");
        l3.setFont(labelFont);
        l3.setForeground(new Color(51, 65, 85));
        l3.setBounds(45, 185, 125, 30);

        tresult = new JTextField(10);
        tresult.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        tresult.setBackground(new Color(241, 245, 249)); // Tinted display
        tresult.setForeground(new Color(15, 23, 42));
        tresult.setBorder(defaultBorder);
        tresult.setEditable(false);
        tresult.setBounds(180, 185, 200, 30);

        // Buttons with improved labels
        addBtn = new JButton("Add (+)");
        subBtn = new JButton("Subtract (−)");
        mulBtn = new JButton("Multiply (×)");
        divBtn = new JButton("Divide (÷)");
        exitBtn = new JButton("Exit");

        // Style operation buttons (Primary blue theme)
        Color opBg = new Color(37, 99, 235);     // Blue-600
        Color opHover = new Color(29, 78, 216);  // Blue-700
        styleButton(addBtn, opBg, opHover, Color.WHITE);
        styleButton(subBtn, opBg, opHover, Color.WHITE);
        styleButton(mulBtn, opBg, opHover, Color.WHITE);
        styleButton(divBtn, opBg, opHover, Color.WHITE);

        // Style exit button (Neutral slate theme)
        Color exitBg = new Color(100, 116, 139);   // Slate-500
        Color exitHover = new Color(71, 85, 105);  // Slate-600
        styleButton(exitBtn, exitBg, exitHover, Color.WHITE);

        // Button positions
        addBtn.setBounds(45, 235, 95, 34);
        subBtn.setBounds(150, 235, 115, 34);
        mulBtn.setBounds(275, 235, 115, 34);
        divBtn.setBounds(400, 235, 85, 34);

        exitBtn.setBounds(400, 290, 85, 30);

        // Feedback / status label
        statusLabel = new JLabel("Ready: Enter numbers and choose an operation.");
        statusLabel.setFont(statusFont);
        statusLabel.setForeground(new Color(100, 116, 139));
        statusLabel.setBounds(45, 295, 345, 20);

        // Add listeners
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        // Add components to panel
        panel.add(titleLabel);
        panel.add(subLabel);
        panel.add(separator);

        panel.add(l1); panel.add(t1);
        panel.add(l2); panel.add(t2);
        panel.add(l3); panel.add(tresult);

        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(mulBtn);
        panel.add(divBtn);
        panel.add(exitBtn);

        panel.add(statusLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void styleButton(final JButton btn, final Color bg, final Color hoverBg, final Color fg) 
    {
        btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setOpaque(true);
        btn.setContentAreaFilled(true);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(bg.darker(), 1, true),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        btn.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                btn.setBackground(hoverBg);
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                btn.setBackground(bg);
            }
        });
    }

    private void addFocusEffect(final JTextField field, final Border normalBorder, final Border focusedBorder) 
    {
        field.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusGained(FocusEvent e) 
            {
                field.setBorder(focusedBorder);
            }

            @Override
            public void focusLost(FocusEvent e) 
            {
                field.setBorder(normalBorder);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == exitBtn) 
        {
            System.exit(0);
        }
        try 
        {
            double num1 = Double.parseDouble(t1.getText().trim());
            double num2 = Double.parseDouble(t2.getText().trim());
            double result;

            if (e.getSource() == addBtn) 
            {
                result = num1 + num2;
                tresult.setForeground(new Color(15, 23, 42));
                tresult.setText(String.valueOf(result));
                statusLabel.setText("Status: Addition completed successfully.");
                statusLabel.setForeground(new Color(22, 101, 52));
            } 
            if (e.getSource() == subBtn) 
            {
                result = num1 - num2;
                tresult.setForeground(new Color(15, 23, 42));
                tresult.setText(String.valueOf(result));
                statusLabel.setText("Status: Subtraction completed successfully.");
                statusLabel.setForeground(new Color(22, 101, 52));
            } 
            if (e.getSource() == mulBtn) 
            {
                result = num1 * num2;
                tresult.setForeground(new Color(15, 23, 42));
                tresult.setText(String.valueOf(result));
                statusLabel.setText("Status: Multiplication completed successfully.");
                statusLabel.setForeground(new Color(22, 101, 52));
            } 
            if (e.getSource() == divBtn) 
            {
                if (num2 != 0) 
                {
                    result = num1 / num2;
                    tresult.setForeground(new Color(15, 23, 42));
                    tresult.setText(String.valueOf(result));
                    statusLabel.setText("Status: Division completed successfully.");
                    statusLabel.setForeground(new Color(22, 101, 52));
                } 
                else 
                {
                    tresult.setForeground(new Color(220, 38, 38));
                    tresult.setText("Error: Divide by 0");
                    statusLabel.setText("Status: Error - Division by zero is not allowed.");
                    statusLabel.setForeground(new Color(220, 38, 38));
                }
            } 
        } 
        catch (NumberFormatException ex) 
        {
            tresult.setForeground(new Color(220, 38, 38));
            tresult.setText("Invalid Input");
            statusLabel.setText("Status: Error - Please enter valid numeric values.");
            statusLabel.setForeground(new Color(220, 38, 38));
        }
    }

    public static void main(String[] args) 
    {
        new App();
    }
}
