package practice;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasMouseListener {
    private CanvasDrawer drawer;
    private BufferImageMaker maker;
    private MouseAdapter listener;

    public CanvasMouseListener(MainCanvas canvas) {
        drawer = new CanvasDrawer(canvas);
        maker = new BufferImageMaker(canvas);
        createListener(canvas);
    }

    private void createListener(MainCanvas canvas) {
        listener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                canvas.setX(e.getX());
                canvas.setY(e.getY());
                canvas.setPrevX(canvas.getX());
                canvas.setPrevY(canvas.getY());

                drawer.drawCanvas();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                maker.make();
            }
        };

        canvas.getCanvas().addMouseListener(listener);
    }
}
