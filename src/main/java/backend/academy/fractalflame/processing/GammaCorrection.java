package backend.academy.fractalflame.processing;

import backend.academy.fractalflame.domain.FractalImage;
import backend.academy.fractalflame.domain.FractalImage.Pixel;

public class GammaCorrection {

    private GammaCorrection() {
    }

    public static void applyGammaCorrection(FractalImage image, double gamma) {
        double maxLog = maxLog(image);

        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                Pixel pixel = image.pixel(x, y);
                if (pixel.hitCount() > 0) {
                    Pixel correctedPixel = correct(gamma, pixel, maxLog);

                    image.data()[y * image.width() + x] = correctedPixel;
                }
            }
        }
    }

    @SuppressWarnings("all")
    private static Pixel correct(double gamma, Pixel pixel, double maxLog) {
        double normalized = Math.log10(pixel.hitCount()) / maxLog;

        int correctedRed = (int) Math.min(255, pixel.r() * Math.pow(normalized, 1.0 / gamma));
        int correctedGreen = (int) Math.min(255, pixel.g() * Math.pow(normalized, 1.0 / gamma));
        int correctedBlue = (int) Math.min(255, pixel.b() * Math.pow(normalized, 1.0 / gamma));

        return new Pixel(correctedRed, correctedGreen, correctedBlue, pixel.hitCount());
    }

    private static double maxLog(FractalImage image) {
        double maxLog = 0.0;

        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                Pixel pixel = image.pixel(x, y);
                if (pixel.hitCount() > 0) {
                    double normalizedLog = Math.log10(pixel.hitCount());
                    if (normalizedLog > maxLog) {
                        maxLog = normalizedLog;
                    }
                }
            }
        }
        return maxLog;
    }
}
