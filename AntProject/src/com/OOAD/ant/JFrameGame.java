package com.OOAD.ant;

import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JFrameGame {

    private int times = 0;
    JLabel label1;
    JLabel label2;
    JLabel label3;


    JLabel labelAnt1;
    JLabel labelAnt2;
    JLabel labelAnt3;
    JLabel labelAnt4;
    JLabel labelAnt5;

    JLabel labelAntD1;
    JLabel labelAntD2;
    JLabel labelAntD3;
    JLabel labelAntD4;
    JLabel labelAntD5;

    JLabel labelAntP1;
    JLabel labelAntP2;
    JLabel labelAntP3;
    JLabel labelAntP4;
    JLabel labelAntP5;

    JTextField textFieldAnt1;
    JTextField textFieldAnt2;
    JTextField textFieldAnt3;
    JTextField textFieldAnt4;
    JTextField textFieldAnt5;

    private int minTime = Integer.MAX_VALUE;
    private int maxTime = 0;

    public JFrameGame() {
        JFrame jFrame = new JFrame("Ant Creeping");

        jFrame.setBounds(10, 100, 1300, 800);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setLayout(new BorderLayout());

        JButton button1 = new JButton("Start");
        button1.setBounds(500,0,80, 20);
        JButton button2 = new JButton("Reset");
        button2.setBounds(600,0,80, 20);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground((new Color(0, 127, 255, 255)));
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);

//        jFrame.add(buttonPanel);

        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setBackground(new Color(0,243,255,255));
        textFieldPanel.setLayout(null);

        labelAnt1 = new JLabel("ant1's direction:");
        labelAnt1.setBounds(0,10,120,20);
        labelAnt2 = new JLabel("ant2's direction:");
        labelAnt2.setBounds(200,10,120,20);
        labelAnt3 = new JLabel("ant3's direction:");
        labelAnt3.setBounds(400,10,120,20);
        labelAnt4 = new JLabel("ant4's direction:");
        labelAnt4.setBounds(600,10,120,20);
        labelAnt5 = new JLabel("ant5's direction:");
        labelAnt5.setBounds(800,10,120,20);

        textFieldAnt1 = new JTextField();
        textFieldAnt1.setBounds(120,10,40,20);
        textFieldAnt2 = new JTextField();
        textFieldAnt2.setBounds(320,10,40,20);
        textFieldAnt3 = new JTextField();
        textFieldAnt3.setBounds(520,10,40,20);
        textFieldAnt4 = new JTextField();
        textFieldAnt4.setBounds(720,10,40,20);
        textFieldAnt5 = new JTextField();
        textFieldAnt5.setBounds(920,10,40,20);
        textFieldPanel.add(labelAnt1);
        textFieldPanel.add(textFieldAnt1);
        textFieldPanel.add(labelAnt2);
        textFieldPanel.add(textFieldAnt2);
        textFieldPanel.add(labelAnt3);
        textFieldPanel.add(textFieldAnt3);
        textFieldPanel.add(labelAnt4);
        textFieldPanel.add(textFieldAnt4);
        textFieldPanel.add(labelAnt5);
        textFieldPanel.add(textFieldAnt5);

        JButton buttonCustomize = new JButton("Start Customized");
        buttonCustomize.setBounds(1000,10,120,20);
        textFieldPanel.add(buttonCustomize);
//        jFrame.add(textFieldPanel);

        JPanel panelD = new JPanel();
        panelD.setLayout(null);
        panelD.setBackground((new Color(223,234,55,255)));
        labelAntD1 = new JLabel("Ant1's Direction: ");
        labelAntD1.setBounds(0,10,200,20);
        labelAntD2 = new JLabel("Ant2's Direction: ");
        labelAntD2.setBounds(200,10,200,20);
        labelAntD3 = new JLabel("Ant3's Direction: ");
        labelAntD3.setBounds(400,10,200,20);
        labelAntD4 = new JLabel("Ant4's Direction: ");
        labelAntD4.setBounds(600,10,200,20);
        labelAntD5 = new JLabel("Ant5's Direction: ");
        labelAntD5.setBounds(800,10,200,20);
        panelD.add(labelAntD1);
        panelD.add(labelAntD2);
        panelD.add(labelAntD3);
        panelD.add(labelAntD4);
        panelD.add(labelAntD5);

        JPanel panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBackground((new Color(22,234,55,255)));
        labelAntP1 = new JLabel("Ant1's Position: ");
        labelAntP1.setBounds(0,10,200,20);
        labelAntP2 = new JLabel("Ant2's Position: ");
        labelAntP2.setBounds(200,10,200,20);
        labelAntP3 = new JLabel("Ant3's Position: ");
        labelAntP3.setBounds(400,10,200,20);
        labelAntP4 = new JLabel("Ant4's Position: ");
        labelAntP4.setBounds(600,10,200,20);
        labelAntP5 = new JLabel("Ant5's Position: ");
        labelAntP5.setBounds(800,10,200,20);
        panelP.add(labelAntP1);
        panelP.add(labelAntP2);
        panelP.add(labelAntP3);
        panelP.add(labelAntP4);
        panelP.add(labelAntP5);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,0,0));
        panel.add(buttonPanel);
        panel.add(textFieldPanel);
        panel.add(panelD);
        panel.add(panelP);
        jFrame.add(panel,BorderLayout.NORTH);

        label1 = new JLabel("第"+times+"次用时：    ");
        label1.setSize(600, 30);
        label2 = new JLabel("最短用时：    ");
        label2.setSize(600, 30);
        label3 = new JLabel("最长用时：    ");
        label3.setSize(600, 30);

        JPanel labelPanel = new JPanel();
        labelPanel.setBackground((new Color(0, 127, 255, 255)));
        labelPanel.setLayout(new FlowLayout());
        labelPanel.add(label1);
        labelPanel.add(label2);
        labelPanel.add(label3);

        jFrame.add(labelPanel, BorderLayout.SOUTH);








        CreepingPanel creepingPanel = new CreepingPanel();
        jFrame.add(creepingPanel, BorderLayout.CENTER);

        jFrame.setVisible(true);

        button1.addActionListener(event -> {
            System.out.println(times);
            if (times >= 0 && times <= 31) {
                CreepingGame cg = new CreepingGame(times, 5);
                cg.init();
                creepingPanel.setCg(cg);
                Thread t = new Thread(creepingPanel);
                t.start();
            }

        });

        button2.addActionListener(event -> times = 0);

        buttonCustomize.addActionListener(event -> {
            CreepingGame cg = new CreepingGame(0,5);
            cg.init();
            System.out.println(":"+Integer.parseInt(textFieldAnt1.getText())+":");
            cg.getAnts().get(0).setDirection(Integer.parseInt(textFieldAnt1.getText()));
            cg.getAnts().get(1).setDirection(Integer.parseInt(textFieldAnt2.getText()));
            cg.getAnts().get(2).setDirection(Integer.parseInt(textFieldAnt3.getText()));
            cg.getAnts().get(3).setDirection(Integer.parseInt(textFieldAnt4.getText()));
            cg.getAnts().get(4).setDirection(Integer.parseInt(textFieldAnt5.getText()));

            creepingPanel.setCg(cg);
            Thread t = new Thread(creepingPanel);
            t.start();

        });
    }

    class CreepingPanel extends JPanel implements Runnable {

        private CreepingGame cg;
        private int y = 90;

        List<Color> colors ;
        List<String> antsImage;
        List<String> iAntsImage;

        public CreepingPanel() {
            colors = new ArrayList<>();
            colors.add(new Color(0,255,255));
            colors.add(new Color(0,0,0));
            colors.add(new Color(255,255,0));
            colors.add(new Color(255,0,255));
            colors.add(new Color(0,255,0));

            antsImage = new ArrayList<>();
            antsImage.add("ant1.png");
            antsImage.add("ant2.png");
            antsImage.add("ant3.png");
            antsImage.add("ant4.png");
            antsImage.add("ant5.png");

            iAntsImage = new ArrayList<>();
            iAntsImage.add("iAnt1.png");
            iAntsImage.add("iAnt2.png");
            iAntsImage.add("iAnt3.png");
            iAntsImage.add("iAnt4.png");
            iAntsImage.add("iAnt5.png");

        }

        public void setCg(CreepingGame cg) {
            this.cg = cg;
        }

        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(new Color(25, 25, 255));
//            g.drawLine(50, 45, 350, 45);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.getImage(this.getClass().getResource("stick.png"));

//            g.drawImage(image,50,45,this);
            g.drawImage(image,
                    0, 137, 1240, 120, this);
            if (cg != null) {
                List<Ant> ants = cg.getAnts();
                for (int i = 0; i < ants.size(); i++) {
                    if (ants.get(i).getPosition() >= 0 && ants.get(i).getPosition() <= 300) {
//                        g.setColor(colors.get(i));
//                        g.fillOval(ants.get(i).getPosition() + 50, y, 10, 10);
                        if (ants.get(i).getDirection() == 1) {
                            Image imageOfAnt = toolkit.getImage(this.getClass().getResource(iAntsImage.get(i)));
                            g.drawImage(imageOfAnt, ants.get(i).getPosition() * 4, y, 30, 50, this);
                        } else if (ants.get(i).getDirection() == -1) {
                            Image imageOfAnt = toolkit.getImage(this.getClass().getResource(antsImage.get(i)));
                            g.drawImage(imageOfAnt, ants.get(i).getPosition() * 4, y, 30, 50, this);
                        }

                    }
                }

                labelAntD1.setText("Ant1's Direction: " + Integer.toString(ants.get(0).getDirection()));
                labelAntD2.setText("Ant2's Direction: " + Integer.toString(ants.get(1).getDirection()));
                labelAntD3.setText("Ant3's Direction: " + Integer.toString(ants.get(2).getDirection()));
                labelAntD4.setText("Ant4's Direction: " + Integer.toString(ants.get(3).getDirection()));
                labelAntD5.setText("Ant5's Direction: " + Integer.toString(ants.get(4).getDirection()));

                labelAntP1.setText("Ant1's Position: " + Integer.toString(ants.get(0).getPosition()));
                labelAntP2.setText("Ant2's Position: " + Integer.toString(ants.get(1).getPosition()));
                labelAntP3.setText("Ant3's Position: " + Integer.toString(ants.get(2).getPosition()));
                labelAntP4.setText("Ant4's Position: " + Integer.toString(ants.get(3).getPosition()));
                labelAntP5.setText("Ant5's Position: " + Integer.toString(ants.get(4).getPosition()));

                label1.setText("第"+times+"次用时：" + cg.getTime());
            }
        }

        @Override
        public void run() {
            while (!cg.GameOver()) {
                cg.run();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                repaint();
            }

            label1.setText("第"+times+"次用时：" + cg.getTime());
            times += 1;
            if (cg.getTime() < minTime)
                minTime = cg.getTime();
            if (cg.getTime() > maxTime)
                maxTime = cg.getTime();
            label2.setText("最短用时：" + minTime);
            label3.setText("最长用时：" + maxTime);
        }
    }

}
