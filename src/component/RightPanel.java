package component;

import javax.swing.*;
import java.awt.*;

public class RightPanel {
    private JPanel panel;
    private MainCanvas mainCanvas = new MainCanvas();

    public RightPanel() {
        panel = new JPanel();
        panel.setSize(800, 600);
        panel.setLocation(50, 0);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(mainCanvas.getCanvas());
    }

    public JPanel getPanel() {
        return panel;
    }

    public MainCanvas getMainCanvas() {
        return mainCanvas;
    }
}
