package practice;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setSize(800, 600);
        setTitle("canvas");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CanvasTest canvas = new CanvasTest();

        add(canvas);
    }
}
