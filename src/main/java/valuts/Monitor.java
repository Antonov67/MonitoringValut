package valuts;

import javax.swing.*;
import java.awt.*;

public class Monitor extends JFrame implements Runnable {
    private JPanel rootPanel;
    private JLabel usd;
    private JLabel eur;
    static int count = 0;

    public Monitor() {
        setLocation(300,300);
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void run() {
        while (true){
            count++;
            usd.setText(count + ": " + Main.getUsd());
            eur.setText(count + ": " + Main.getEur());
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
