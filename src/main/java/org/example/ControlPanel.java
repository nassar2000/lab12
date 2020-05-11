package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ControlPanel extends JPanel {
    MainFrame frame = null;
    DesignPanel design = null;

    public ControlPanel(MainFrame frame, DesignPanel design) {
        this.frame = frame;
        this.design = design;
        setControlPanel();
    }

    public void setControlPanel() {
        JLabel labelX = new JLabel("Set Position X:");
        JLabel labelY = new JLabel("Set Position Y:");
        JLabel sizeW = new JLabel("Set Size width:");
        JLabel sizeH = new JLabel("Set Size height:");
        TextField textX = new TextField();
        TextField textY = new TextField();
        TextField textSizeW = new TextField();
        TextField textSizeH = new TextField();
        JButton randomButton = new JButton("DateRandom");
        JButton create = new JButton("Create");
        JButton exit = new JButton("Exit");
        JButton save = new JButton("Save");
        JButton reset = new JButton("Reset");
        JLabel numeBtn = new JLabel("Nume/Text:");
        TextField numeButton = new TextField();


        String[] lista = {"Button", "Label", "TextField", "ProgressBar"};
        setLayout(new GridLayout(4, 4, 5, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        setBackground(Color.GREEN);
        JComboBox componente = new JComboBox(lista);
        add(labelX);
        add(textX);
        add(labelY);
        add(textY);
        add(sizeW);
        add(textSizeW);
        add(sizeH);
        add(textSizeH);
        add(numeBtn);
        add(numeButton);
        add(componente);
        add(randomButton);
        add(exit);
        add(create);
        add(save);
        add(reset);
        setVisible(true);

        frame.add(design);

        create.addActionListener(e -> {

            if (componente.getSelectedItem().equals("Button")) {

                final JButton newButton = new JButton(numeButton.getText());


                newButton.setBounds(Integer.parseInt(textX.getText()),
                        Integer.parseInt(textY.getText()),
                        Integer.parseInt(textSizeW.getText()),
                        Integer.parseInt(textSizeH.getText()));
                design.add(newButton);
                design.revalidate();
                design.repaint();
                Move mv = new Move(design.getComponents());
            } else if (componente.getSelectedItem().equals("Label")) {

                final JLabel newLabel = new JLabel(numeButton.getText());
                newLabel.setForeground(Color.black);
                newLabel.setBackground(Color.white);
                newLabel.setOpaque(true);

                newLabel.setBounds(Integer.parseInt(textX.getText()),
                        Integer.parseInt(textY.getText()),
                        Integer.parseInt(textSizeW.getText()),
                        Integer.parseInt(textSizeH.getText()));
                design.add(newLabel);
                design.revalidate();
                design.repaint();
                Move mv = new Move(design.getComponents());

            } else if (componente.getSelectedItem().equals("TextField")) {
                final TextField newTextField = new TextField();

                newTextField.setBounds(Integer.parseInt(textX.getText()),
                        Integer.parseInt(textY.getText()),
                        Integer.parseInt(textSizeW.getText()),
                        Integer.parseInt(textSizeH.getText()));
                design.add(newTextField);
                design.revalidate();
                design.repaint();
                Move mv = new Move(design.getComponents());
            } else if (componente.getSelectedItem().equals("ProgressBar")) {
                final JProgressBar newProgressBar = new JProgressBar();

                newProgressBar.setBounds(Integer.parseInt(textX.getText()),
                        Integer.parseInt(textY.getText()),
                        Integer.parseInt(textSizeW.getText()),
                        Integer.parseInt(textSizeH.getText()));
                newProgressBar.setValue(50);
                design.add(newProgressBar);
                design.revalidate();
                design.repaint();
                Move mv = new Move(design.getComponents());
            }

        });

        exit.addActionListener(e -> {
            System.out.println("you close the application!");
            System.exit(0);
        });

        save.addActionListener(e -> {
            try {
                Rectangle captureRect = new Rectangle(10, 240, 800, 370);
                BufferedImage capture = new Robot().createScreenCapture(captureRect);
                ImageIO.write(capture, "PNG", new File("d:/test.png"));
            } catch (IOException | AWTException ex) {
                System.err.println(ex);
            }
        });

        reset.addActionListener(e -> {
            frame.setVisible(false);
            new MainFrame().setVisible(true);
        });

        randomButton.addActionListener(e -> {
            textX.setText(String.valueOf(random(150)));
            textY.setText(String.valueOf(random(150)));
            textSizeH.setText(String.valueOf(random(300)));
            textSizeW.setText(String.valueOf(random(400)));
            numeButton.setText("nume random");

        });

    }

    public int random(int i) {
        Random random = new Random();
        int n = random.nextInt(i);
        return n;
    }
}