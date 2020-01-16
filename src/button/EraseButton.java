package button;

import tool.ColorChanger;
import component.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class EraseButton {
    private JButton button;

    public EraseButton(MainCanvas canvas) {
        button = new JButton("Erase");
        button.setSize(30, 30);
        button.setLocation(10, 50);
        button.setVisible(true);
        button.addActionListener(e -> {
            Color backColor = canvas.getBackgroundColor();
            ColorChanger.changeColor(new Color(backColor.getRed(), backColor.getGreen(), backColor.getBlue(), 255), canvas);
        });
    }

    public JButton getButton() {
        return button;
    }
}
