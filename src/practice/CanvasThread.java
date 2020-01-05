package practice;

public class CanvasThread extends Thread{
    private CanvasTest canvas;
    private boolean isRunning = true;
    private int co = 0;

    public CanvasThread(CanvasTest canvas) {
        this.canvas = canvas;
    }

    @Override
    public void run() {
        while(isRunning) {
            if(canvas.getIsMouseDragged()) {
                canvas.render();
            }
            else {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void shutdown() {
        isRunning = false;
    }
}
