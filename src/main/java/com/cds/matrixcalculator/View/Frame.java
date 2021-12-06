package com.cds.matrixcalculator.View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mavila
 */
public class Frame extends JFrame implements ActionListener {

    JMenuBar menuBar;

    JMenu appMenu;
    JMenu opsMenu;

    JMenuItem exitItem;
    JMenuItem restartItem;

    JMenuItem sumMat;
    JMenuItem multEsc;
    JMenuItem multMat;
    JMenuItem invMat;
    JMenuItem sisEc;
    JMenuItem obtDeter;
    JMenuItem sisEcCramer;

    JPanel home;
    JLabel homeTitle;

    JPanel sumMatPanel;
    JLabel sumMatPanelTitle;

    JPanel multEscPanel;
    JLabel multEscPanelTitle;

    JPanel multMatPanel;
    JLabel multMatPanelTitle;

    JPanel invMatPanel;
    JLabel invMatPanelTitle;

    JPanel sisEcPanel;
    JLabel sisEcPanelTitle;

    JPanel obtDeterPanel;
    JLabel obtDeterPanelTitle;

    JPanel sisEcCramerPanel;
    JLabel sisEcCramerPanelTitle;

    Frame() {

        this.setTitle("Matrix Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(
                false);
        this.setSize(
                500, 500);
        this.setLayout(null);

        menuBar = new JMenuBar();

        appMenu = new JMenu("App");
        opsMenu = new JMenu("Operations");

        exitItem = new JMenuItem("Exit");
        restartItem = new JMenuItem("Go Home");

        sumMat = new JMenuItem("Suma de matrices");
        multEsc = new JMenuItem("Multiplicacion por Escalar");
        multMat = new JMenuItem("Multiplicacion de matrices");
        invMat = new JMenuItem("Inversa de Matriz");
        sisEc = new JMenuItem("Sistema de ecuaciones");
        obtDeter = new JMenuItem("Obtener determinante");
        sisEcCramer = new JMenuItem("Sistema de ecuaciones de Cramer");

        exitItem.addActionListener(this);
        restartItem.addActionListener(this);
        sumMat.addActionListener(this);
        multEsc.addActionListener(this);
        multMat.addActionListener(this);
        invMat.addActionListener(this);
        sisEc.addActionListener(this);
        obtDeter.addActionListener(this);
        sisEcCramer.addActionListener(this);

        appMenu.add(restartItem);
        appMenu.add(exitItem);

        opsMenu.add(sumMat);
        opsMenu.add(multMat);
        opsMenu.add(multEsc);
        opsMenu.add(invMat);
        opsMenu.add(sisEc);
        opsMenu.add(sisEcCramer);
        opsMenu.add(obtDeter);

        menuBar.add(appMenu);
        menuBar.add(opsMenu);

//        Panels
//        Home
        home = new JPanel();
        home.setBounds(0, 0, 500, 500);

        homeTitle = new JLabel();
        homeTitle.setText("Matrix Calculator");
        homeTitle.setForeground(Color.black);
        homeTitle.setFont(new Font("Serif", Font.PLAIN, 16));

        home.add(homeTitle);

//        Sum Mat Panel
        sumMatPanel = new JPanel();
        sumMatPanel.setBounds(0, 0, 500, 500);

        sumMatPanelTitle = new JLabel();
        sumMatPanelTitle.setText("Suma de Matrices:");
        sumMatPanelTitle.setForeground(Color.black);
        sumMatPanelTitle.setFont(new Font("Serif", Font.PLAIN, 16));

        sumMatPanel.add(sumMatPanelTitle);

// 
        multEscPanel = new JPanel();
        multEscPanel.setBounds(0, 0, 500, 500);

        multEscPanelTitle = new JLabel();
        multEscPanelTitle.setText("Multiplica por Escalar:");
        multEscPanelTitle.setForeground(Color.black);
        multEscPanelTitle.setFont(new Font("Serif", Font.PLAIN, 16));

        multEscPanel.add(multEscPanelTitle);

//
        multMatPanel = new JPanel();
        multMatPanel.setBounds(0, 0, 500, 500);

        multMatPanelTitle = new JLabel();
        multMatPanelTitle.setText("Multiplicar Matrices:");
        multMatPanelTitle.setForeground(Color.black);
        multMatPanelTitle.setFont(new Font("Serif", Font.PLAIN, 16));

        multMatPanel.add(multMatPanelTitle);

//
        invMatPanel = new JPanel();
        invMatPanel.setBounds(0, 0, 500, 500);

        invMatPanelTitle = new JLabel();
        invMatPanelTitle.setText("Obtener la Inversa:");
        invMatPanelTitle.setForeground(Color.black);
        invMatPanelTitle.setFont(new Font("Serif", Font.PLAIN, 16));

        invMatPanel.add(invMatPanelTitle);

//
        sisEcPanel = new JPanel();
        sisEcPanel.setBounds(0, 0, 500, 500);

        sisEcPanelTitle = new JLabel();
        sisEcPanelTitle.setText("Sistema de Ecuaciones:");
        sisEcPanelTitle.setForeground(Color.black);
        sisEcPanelTitle.setFont(new Font("Serif", Font.PLAIN, 16));

        sisEcPanel.add(sisEcPanelTitle);

//
        obtDeterPanel = new JPanel();
        obtDeterPanel.setBounds(0, 0, 500, 500);

        obtDeterPanelTitle = new JLabel();
        obtDeterPanelTitle.setText("Obtener la Determinante:");
        obtDeterPanelTitle.setForeground(Color.black);
        obtDeterPanelTitle.setFont(new Font("Serif", Font.PLAIN, 16));

        obtDeterPanel.add(obtDeterPanelTitle);

//
        sisEcCramerPanel = new JPanel();
        sisEcCramerPanel.setBounds(0, 0, 500, 500);

        sisEcCramerPanelTitle = new JLabel();
        sisEcCramerPanelTitle.setText("Sistema de Ecuaciones por Cramer:");
        sisEcCramerPanelTitle.setForeground(Color.black);
        sisEcCramerPanelTitle.setFont(new Font("Serif", Font.PLAIN, 16));

        sisEcCramerPanel.add(sisEcCramerPanelTitle);

//        Frame declarations
        this.setJMenuBar(menuBar);
        this.add(home);
        this.add(sumMatPanel);
        this.add(multEscPanel);
        this.add(multMatPanel);
        this.add(invMatPanel);
        this.add(sisEcPanel);
        this.add(obtDeterPanel);
        this.add(sisEcCramerPanel);

        this.setVisible(
                true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitItem) {
            System.exit(0);
        }
        if (e.getSource() == restartItem) {
            hidePanels();
            home.setVisible(true);
        }
        if (e.getSource() == sumMat) {

            hidePanels();
            sumMatPanel.setVisible(true);
        }
        if (e.getSource() == multEsc) {
            hidePanels();
            multEscPanel.setVisible(true);
        }
        if (e.getSource() == multMat) {
            hidePanels();
            multMatPanel.setVisible(true);
        }
        if (e.getSource() == invMat) {
            hidePanels();
            invMatPanel.setVisible(true);
        }
        if (e.getSource() == sisEc) {
            hidePanels();
            sisEcPanel.setVisible(true);
        }
        if (e.getSource() == obtDeter) {
            hidePanels();
            obtDeterPanel.setVisible(true);
        }
        if (e.getSource() == sisEcCramer) {
            hidePanels();
            sisEcCramerPanel.setVisible(true);
        }
    }

    public void hidePanels() {
        System.out.println("Si funciono");
        home.setVisible(false);
        sumMatPanel.setVisible(false);
        multEscPanel.setVisible(false);
        multMatPanel.setVisible(false);
        invMatPanel.setVisible(false);
        sisEcPanel.setVisible(false);
        obtDeterPanel.setVisible(false);
        sisEcCramerPanel.setVisible(false);
    }

}
