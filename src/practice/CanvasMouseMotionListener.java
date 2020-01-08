package practice;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class CanvasMouseMotionListener {
    private CanvasDrawer drawer;
    private BufferImageMaker maker;
    private MouseMotionListener listener;

    public CanvasMouseMotionListener(MainCanvas canvas) {
        drawer = new CanvasDrawer(canvas);
        maker = new BufferImageMaker(canvas);
        createListener(canvas);
    }

    private void createListener(MainCanvas canvas) {
        listener = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                canvas.setPrevX(canvas.getX());
                canvas.setPrevY(canvas.getY());
                canvas.setX(e.getX());
                canvas.setY(e.getY());

                drawer.drawCanvas();
            }
        };

        canvas.getCanvas().addMouseMotionListener(listener);
    }
}
