package backend.academy.fractalflame;

import backend.academy.fractalflame.domain.FractalImage;
import backend.academy.fractalflame.domain.FractalImage.Pixel;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

@SuppressWarnings("all")
public final class ImageUtils {

    private ImageUtils() {
    }

    public static void save(FractalImage image, File file, String format) {
        try {
            BufferedImage img = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < image.height(); y++) {
                for (int x = 0; x < image.width(); x++) {
                    Pixel pixel = image.pixel(x, y);
                    int rgb = (pixel.r() << 16) | (pixel.g() << 8) | pixel.b();
                    img.setRGB(x, y, rgb);
                }
            }
            ImageIO.write(img, format, file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
