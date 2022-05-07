import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.RenderedImage;
import java.io.File;

public class ImageResizer extends Thread{

    private final File[] files;
    private final int newWidth;

    private final int newHeight;
    private final String dstFolder;

    public ImageResizer(File[] files, int newHeight, int newWidth, String dstFolder) {
        this.files = files;
        this.newHeight = newHeight;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
    }

    @Override
    public void run() {
        BufferedImage image;
        try {
            for (File file : files) {
                image = ImageIO.read(file);
                if (newWidth > 0 && newHeight > 0) {
                    BufferedImage resizedImage = Scalr.resize(image, Scalr.Method.BALANCED, Scalr.Mode.FIT_TO_WIDTH,
                            newWidth, newHeight, new ConvolveOp[]{Scalr.OP_ANTIALIAS});
                    if (resizedImage.getHeight() > newHeight) {
                        resizedImage = Scalr.crop(resizedImage, resizedImage.getWidth(), newHeight);
                    }
                    ImageIO.write(resizedImage, "PNG", new File(dstFolder + "\\" + file.getName()));
                } else {
                    ImageIO.write((RenderedImage) file, "PNG", new File(dstFolder + "\\" + file.getName()));
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
