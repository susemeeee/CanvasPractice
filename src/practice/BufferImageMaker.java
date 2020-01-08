package practice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferImageMaker {
    private MainCanvas canvas;
    private BufferedImage image;
    private File imageFile = new File("files/canvas.png");

    public BufferImageMaker(MainCanvas canvas) {
        this.canvas = canvas;

        image = new BufferedImage(canvas.getCanvas().getWidth(), canvas.getCanvas().getHeight(), BufferedImage.TYPE_INT_ARGB);

        if(imageFile == null) {
            try {
                imageFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void make() {
        Graphics2D g = (Graphics2D) image.getGraphics();

        canvas.getCanvas().print(g);

        try {
            ImageIO.write(image, "png", imageFile);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}