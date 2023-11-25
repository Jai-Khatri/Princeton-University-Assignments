public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] kernel = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        return applyFilter(picture, kernel);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}
        };
        return applyFilter(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0}
        };
        return applyFilter(picture, kernel);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}
        };
        return applyFilter(picture, kernel);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] kernel = {
                {-2, -1, 0},
                {-1, 1, 1},
                {0, 1, 2}
        };
        return applyFilter(picture, kernel);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    kernel[i][j] = 1.0 / 9;
                }
            }
        }
        return applyFilter(picture, kernel);
    }

    // Helper method to apply a filter to a picture
    private static Picture applyFilter(Picture picture, double[][] kernel) {
        int width = picture.width();
        int height = picture.height();
        Picture result = new Picture(width, height);

        int kernelSize = kernel.length;
        int k = kernelSize / 2;

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                double sumRed = 0, sumGreen = 0, sumBlue = 0;
                int alpha = 255; // Added alpha initialization

                for (int i = 0; i < kernelSize; i++) {
                    for (int j = 0; j < kernelSize; j++) {
                        int x = (col - k + i + width) % width;
                        int y = (row - k + j + height) % height;

                        int rgb = picture.getRGB(x, y);
                        alpha = (rgb >> 24) & 0xFF; // Update alpha
                        int red = (rgb >> 16) & 0xFF;
                        int green = (rgb >> 8) & 0xFF;
                        int blue = rgb & 0xFF;

                        sumRed += kernel[i][j] * red;
                        sumGreen += kernel[i][j] * green;
                        sumBlue += kernel[i][j] * blue;
                    }
                }

                int newRed = Math.min(255, Math.max(0, (int) Math.round(sumRed)));
                int newGreen = Math.min(255, Math.max(0, (int) Math.round(sumGreen)));
                int newBlue = Math.min(255, Math.max(0, (int) Math.round(sumBlue)));

                int newRGB = (alpha << 24) | (newRed << 16) | (newGreen << 8) | newBlue;
                result.setRGB(col, row, newRGB);
            }
        }

        return result;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        // Test your methods here
    }
}
