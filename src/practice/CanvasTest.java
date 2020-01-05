package practice;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferStrategy;

public class CanvasTest extends Canvas {
    private int x, y;
    private int prevX, prevY;
    private Color color = new Color(0, 0, 0);
    private CanvasThread canvasThread = new CanvasThread(this);
    private boolean isMouseDragged;
    private BufferStrategy bufferCanvas = getBufferStrategy();

    public CanvasTest() {
        setBackground(Color.WHITE);
        setBounds(0, 0, 800, 600);

        canvasThread.start();

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                prevX = x;
                prevY = y;
                x = e.getX();
                y = e.getY();
                isMouseDragged = true;
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prevX = e.getX();
                prevY = e.getY();
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isMouseDragged = false;
            }
        });
    }

    public void render() {
        bufferCanvas = getBufferStrategy();

        if(bufferCanvas == null) {
            createBufferStrategy(2);
            System.out.println("return");
            return;
        }

        Graphics2D g = (Graphics2D) bufferCanvas.getDrawGraphics();
        g.setColor(color);
        g.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, 0));
        g.drawLine(prevX, prevY, x, y);

        g.dispose();
        bufferCanvas.show();
    }

    public boolean getIsMouseDragged() {
        return isMouseDragged;
    }
}