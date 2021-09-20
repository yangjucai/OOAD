package com.OOAD.ant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.pow;

public class PlayRoomJFrame {

    private static int times = 0;

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Ant Creeping");

        jFrame.setSize(600, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setLayout(new BorderLayout());

        JButton button1 = new JButton("Start");
        button1.setSize(50, 30);
        JButton button2 = new JButton("Reset");
        button2.setSize(50, 30);
        JButton button3 = new JButton("PlayNext");
        button3.setSize(50, 30);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground((new Color(0, 127, 255, 255)));
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        jFrame.add(buttonPanel, BorderLayout.NORTH);


        JLabel label = new JLabel("Time counting");
        jFrame.add(label, BorderLayout.SOUTH);

        CreepPanel creepPanel = new CreepPanel();
        jFrame.add(creepPanel, BorderLayout.CENTER);

        jFrame.setVisible(true);

        button1.addActionListener(event -> {
            System.out.println(times);
            if (times >= 0 && times <= 31) {
                CreepingGame cg = new CreepingGame(times, 5);
                cg.init();
                creepPanel.setCg(cg);
                Thread t = new Thread(creepPanel);
                t.start();
            }
            times += 1;
        });

        button2.addActionListener(event -> times = 0);

        button3.addActionListener(event -> {
            System.out.println(times);
            if (times >= 0 && times <= 31) {
                CreepingGame cg = new CreepingGame(times, 5);
                cg.init();
                creepPanel.setCg(cg);
                Thread t = new Thread(creepPanel);
                t.start();
            }
            times += 1;

        });
    }

}


class CreepPanel extends JPanel implements Runnable {

    private CreepingGame cg;
    private int y = 30;

    public CreepPanel() {

    }

    public CreepPanel(CreepingGame cg) {
        super();
        this.cg = cg;
    }

    public void setCg(CreepingGame cg) {
        this.cg = cg;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(25, 25, 255));
        g.drawLine(110, 45, 400, 45);
        if (cg != null) {
            List<Ant> ants = cg.getAnts();
            List<Color> colors = new ArrayList<>();
            colors.add(new Color(0,255,255));
            colors.add(new Color(0,0,0));
            colors.add(new Color(255,255,0));
            colors.add(new Color(255,0,255));
            colors.add(new Color(0,255,0));

            for (int i = 0; i < ants.size(); i++) {
                if (ants.get(i).getPosition() >= 0 && ants.get(i).getPosition() <= 300) {
                    g.setColor(colors.get(i));
                    g.fillOval(ants.get(i).getPosition() + 100, y, 10, 10);
                }
            }
        }
    }

    @Override
    public void run() {
        while (!cg.GameOver()) {
            cg.run();
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            repaint();
        }
    }
}
