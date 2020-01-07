package practice;

import java.awt.*;

public class MainCanvas {
    private Canvas canvas = new Canvas();
    private int x;
    private int y;
    private int prevX;
    private int prevY;

    public MainCanvas() {
        canvas.setBackground(Color.WHITE);
        canvas.setBounds(0, 0, 800, 600);

        new CanvasMouseMotionListener(this);
        new CanvasMouseListener(this);
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
}
