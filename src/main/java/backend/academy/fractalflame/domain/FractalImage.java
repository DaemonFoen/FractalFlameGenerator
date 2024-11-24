package backend.academy.fractalflame.domain;

import lombok.Getter;

public record FractalImage(Pixel[] data, int width, int height) {
    public static FractalImage create(int width, int height) {
        Pixel[] pixels = new Pixel[width * height];
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = new Pixel(0, 0, 0, 0);
        }
        return new FractalImage(pixels, width, height);
    }

    public Pixel pixel(int x, int y) {
        return data[y * width + x];
    }

    @Getter
    public static class Pixel {
        private int r;
        private int g;
        private int b;
        private int hitCount;

        public Pixel(int r, int g, int b, int hitCount) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.hitCount = hitCount;
        }

        public void incrementHitCount() {
            this.hitCount++;
        }

        public void averageColor(int newR, int newG, int newB) {
            if (this.r == 0 && this.g == 0 && this.b == 0 && this.hitCount == 0) {
                this.r = newR;
                this.g = newG;
                this.b = newB;
            } else {
                this.r = (this.r + newR) / 2;
                this.g = (this.g + newG) / 2;
                this.b = (this.b + newB) / 2;
            }
        }
    }
}

