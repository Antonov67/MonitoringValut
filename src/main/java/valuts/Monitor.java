package valuts;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Monitor extends JFrame implements Runnable {
    private JPanel rootPanel;
    private JLabel usd;
    private JLabel eur;
    static int count = 0;

    public Monitor() {
        setTitle("монитор курса валют");
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        setLocation(300,300);
        setContentPane(rootPanel);
        setResizable(false);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        eur.setOpaque(true);
        usd.setOpaque(true);
        setVisible(true);

    }

    @Override
    public void run() {
        while (true){
            count++;
            Data data = Main.getEur();
            if (data.dinamika<0)
                eur.setBackground(Color.RED);
            else
                eur.setBackground(Color.GREEN);
            eur.setText(count + ": " + data.dataString);
            data = Main.getUsd();
            if (data.dinamika<0)
                usd.setBackground(Color.RED);
            else
                usd.setBackground(Color.GREEN);
            usd.setText(count + ": " + data.dataString);

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
