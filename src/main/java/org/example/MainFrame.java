package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        DesignPanel designPanel = new DesignPanel();
        ControlPanel controlPanel = new ControlPanel(this, designPanel);
        add(controlPanel, BorderLayout.NORTH);
        setVisible(true);
        setTitle("Graphical Application");
        setSize(800, 600);
        setLocation(10, 10);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}