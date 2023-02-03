package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Timer;
import java.util.TimerTask;

public class GUI implements ActionListener {
    int a;
    BigInteger num = BigInteger.valueOf(1);
    private JLabel label;
    private JLabel label2;
    private JPanel panel;
    private static JFrame frame;
    private JButton button;
    public GUI() {
        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Gui Test");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,400);

        button = new JButton("Click Me!");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setFont(new Font("Comic Sans",Font.BOLD,20));
        button.setForeground(Color.gray);
        button.setBackground(Color.LIGHT_GRAY);
        button.setOpaque(true);
        button.setBorderPainted(false);

        label = new JLabel("Number: "+ num);
        label2 = new JLabel("");
        label.setFont(new Font("Serif",Font.BOLD,20));
        panel.add(label);
        panel.add(button);
        panel.add(label2);
        java.util.Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            float counter = 1;
            @Override
            public void run() {
                if(counter>0){
                    a = num.bitLength();
                    frame.setSize(a*4+300,200);
                    label2.setText("Timer: "+counter/1000+"s");
                    counter++;
                }
            }
        };
        timer.schedule(task,0,1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        num = num.multiply(BigInteger.valueOf(2));
        label.setText("Number: "+ num+"|"+a);
    }
}
