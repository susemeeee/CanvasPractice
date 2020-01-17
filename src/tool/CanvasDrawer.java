package tool;

import component.MainCanvas;
import core.ColorArray;
import core.Main;
import core.RGB;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.nio.Buffer;

public class CanvasDrawer {
    private MainCanvas canvas;
    private Color color = new Color(0, 0, 0);
    private BufferStrategy bufferCanvas;

    public CanvasDrawer(MainCanvas canvas) {
        this.canvas = canvas;
    }

    public void drawCanvas() {
        bufferCanvas = canvas.getCanvas().getBufferStrategy();
        BufferedImage image = new BufferedImage(canvas.getCanvas().getWidth(), canvas.getCanvas().getHeight(), BufferedImage.TYPE_INT_ARGB);

        if(bufferCanvas == null) {
            canvas.getCanvas().createBufferStrategy(2);
            return;
        }

        int[] newPixel;

        newPixel = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        for(int i = 0; i < newPixel.length; i++) {
            newPixel[i] = canvas.getPixels()[i];
        }

        Graphics2D g = (Graphics2D) bufferCanvas.getDrawGraphics();
        g.drawImage(image, 0, 0, canvas.getCanvas());
        g.dispose();
        bufferCanvas.show();
    }

    public void writePixel() {
        boolean isPlusX = (canvas.getPrevX() < canvas.getX());
        boolean isPlusY = (canvas.getPrevY() < canvas.getY());
        int currentX = canvas.getPrevX();
        int currentY = canvas.getPrevY();
        int deltaX = Math.abs(canvas.getX() - canvas.getPrevX());
        int deltaY = Math.abs(canvas.getY() - canvas.getPrevY());

        if(deltaX == 0 && deltaY == 0) {
            canvas.setPixels(canvas.getCanvas().getWidth()* currentY + currentX, color.getRGB());
            return;
        }

        if(deltaX == 0) {
            while(currentY != canvas.getY()) {
                canvas.setPixels(canvas.getCanvas().getWidth()* currentY + currentX, color.getRGB());

                if(isPlusY) {
                    currentY++;
                }
                else {
                    currentY--;
                }
            }

            return;
        }

        if(deltaY == 0) {
            while(currentX != canvas.getX()) {
                canvas.setPixels(canvas.getCanvas().getWidth()* currentY + currentX, color.getRGB());

                if(isPlusX) {
                    currentX++;
                }
                else {
                    currentX--;
                }
            }

            return;
        }

        double ratio;
        int count = 0;

        if(deltaX > deltaY) {
            ratio = deltaX / deltaY;
        }
        else {
            ratio = deltaY / deltaX;
        }

        while((currentX != canvas.getX()) && (currentY != canvas.getY())) {
            canvas.setPixels(canvas.getCanvas().getWidth()* currentY + currentX, color.getRGB());

            if((count >= (int)ratio)) {
                if(deltaX > deltaY) {
                    if(isPlusY && (currentY != canvas.getY())) {
                        currentY++;
                    }
                    else if(currentY != canvas.getY()) {
                        currentY--;
                    }
                }
                else {
                    if(isPlusX && (currentX != canvas.getX())) {
                        currentX++;
                    }
                    else if(currentX != canvas.getX()) {
                        currentX--;
                    }
                }

                count = 0;
                deltaX = Math.abs(canvas.getX() - currentX);
                deltaY = Math.abs(canvas.getY() - currentY);
                if(deltaX > deltaY) {
                    ratio = deltaX / deltaY;
                }
                else {
                    ratio = deltaY / deltaX;
                }
            }
            else {
                if (deltaX > deltaY) {
                    if (isPlusX && (currentX != canvas.getX())) {
                        currentX++;
                    }
                    else if (currentX != canvas.getX()) {
                        currentX--;
                    }
                }
                else {
                    if (isPlusY && (currentY != canvas.getY())) {
                        currentY++;
                    }
                    else if (currentY != canvas.getY()) {
                        currentY--;
                    }
                }

                count++;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = new Color(color.getRed(), color.getGreen(), color.getBlue());
    }
}
