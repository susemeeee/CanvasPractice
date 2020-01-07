package practice;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setSize(800, 600);
        setTitle("canvas");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new MainCanvas().getCanvas());
    }
}
