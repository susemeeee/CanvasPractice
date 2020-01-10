package button;

import component.MainCanvas;
import tool.ColorChanger;

import javax.swing.*;
import java.awt.*;

public class ColorChooserButton {
    private JButton button;

    public ColorChooserButton(MainCanvas canvas) {
        button = new JButton("Color");
        button.setSize(30, 30);
        button.setLocation(10, 90);
        button.setVisible(true);
        button.addActionListener(e -> {
            JColorChooser chooser = new JColorChooser();
            Color seletedColor = chooser.showDialog(null, "Color", Color.GRAY);

            if(seletedColor != null) {
                ColorChanger.changeColor(seletedColor, canvas);
            }
        });
    }

    public JButton getButton() {
        return button;
    }
}
