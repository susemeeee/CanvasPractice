package component;

import core.ColorArray;
import tool.CanvasMouseListener;

import java.awt.*;
import java.util.ArrayList;

public class MainCanvas {
    private Canvas canvas = new Canvas();
    private Color backgroundColor = new Color(255,255,255);
    private int x;
    private int y;
    private int prevX;
    private int prevY;
    private CanvasMouseListener listener;
    private ColorArray canvasColorInfoArray;
    private int[] pixels;

    public MainCanvas() {
        canvas.setBackground(backgroundColor);
        canvas.setBounds(50, 0, 800, 600);

        listener = new CanvasMouseListener(this);

        canvasColorInfoArray = new ColorArray(canvas.getWidth(), canvas.getHeight());

        pixels = new int[canvas.getWidth() * canvas.getHeight()];

        for(int i = 0; i < pixels.length; i++) {
            pixels[i] = 0xffffffff;
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public CanvasMouseListener getListener() {
        return listener;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public ColorArray getCanvasColorInfoArray() {
        return canvasColorInfoArray;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public void setPixels(int index, int pixelData) {
        pixels[index] = pixelData;
    }
}
