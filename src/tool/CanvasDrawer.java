package tool;

import component.MainCanvas;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class CanvasDrawer {
    private MainCanvas canvas;
    private Color color = new Color(0, 0, 0);
    private BufferStrategy bufferCanvas;
    //private BufferedImage image;
    //private File imageFile = new File("files/canvas.png");

    public CanvasDrawer(MainCanvas canvas) {
        this.canvas = canvas;
    }

    public void drawCanvas() {
        bufferCanvas = canvas.getCanvas().getBufferStrategy();

        if(bufferCanvas == null) {
            canvas.getCanvas().createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) bufferCanvas.getDrawGraphics();
        //image = new BufferedImage(canvas.getCanvas().getWidth(), canvas.getCanvas().getHeight(), BufferedImage.TYPE_INT_RGB);
        //Graphics2D g = (Graphics2D) image.createGraphics();

        g.setColor(color);
        g.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, 0));
        g.drawLine(canvas.getPrevX(), canvas.getPrevY(), canvas.getX(), canvas.getY());

        g.dispose();
        bufferCanvas.show();
    }

    public void setColor(Color color) {
        this.color = new Color(color.getRGB());
    }
}
