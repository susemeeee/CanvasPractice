package button;

import tool.ColorChanger;
import component.MainCanvas;

import javax.swing.*;

public class EraseButton {
    private JButton button;

    public EraseButton(MainCanvas canvas) {
        button = new JButton("Erase");
        button.setSize(30, 30);
        button.setLocation(10, 50);
        button.setVisible(true);
        button.addActionListener(e -> {
            ColorChanger.changeColor(canvas.getBackgroundColor(), canvas);
        });
    }

    public JButton getButton() {
        return button;
    }
}
