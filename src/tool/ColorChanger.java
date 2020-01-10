package tool;

import component.MainCanvas;

import java.awt.*;

public class ColorChanger {
    public static void changeColor(Color color, MainCanvas canvas) {
        canvas.getListener().getDrawer().setColor(color);
    }
}
