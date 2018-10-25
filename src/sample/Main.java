package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static sample.LogicsVer2.matrixIteration_death;
import static sample.LogicsVer2.matrixIteration_life;

public class Main extends JFrame {

    private static byte[][] tab = new byte[500][500];
    private static int counter=0;

    private Main() {
        setTitle("Game of Life");
        setSize(500, 580);

        JButton b=new JButton("Play");
        JButton b1=new JButton("Next step");
        b.setBounds(0,501,140, 40);
        b1.setBounds(344,501,140, 40);
        MyPanel panel = new MyPanel();
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tab=LogicsVer2.creatadRandomArrayVer2(500, 500, 10000);
                repaint();
            }
        });
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter%2==0){
                tab=matrixIteration_life(tab);
                repaint();
                counter++;}
                else{
                tab=matrixIteration_death(tab);
                repaint();
                counter++;}
            }
        });
        add(b);
        add(b1);
        add(panel);

    }

    public static void main(final String[] args) {
        Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
    }

    class MyPanel extends JPanel {

        @Override
        public void paintComponent (Graphics g) {
            super.paintComponent(g);
            Graphics2D gr2d = (Graphics2D) g;
            gr2d.setBackground(Color.green);

            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    if (tab[i][j] == 1) {
                        gr2d.setPaint(Color.BLACK);
                        gr2d.drawOval(j, i, 1, 1);
                    }
                    else {
                        gr2d.setPaint(Color.WHITE);
                        gr2d.drawOval(j, i, 1, 1);
                    }
                }
            }
        }
    }
}
