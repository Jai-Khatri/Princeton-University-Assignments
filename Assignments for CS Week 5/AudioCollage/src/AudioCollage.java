public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[i + a.length] = b[i];
        }
        return result;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int maxLength = Math.max(a.length, b.length);
        double[] result = new double[maxLength];
        for (int i = 0; i < maxLength; i++) {
            double aValue = (i < a.length) ? a[i] : 0.0;
            double bValue = (i < b.length) ? b[i] : 0.0;
            result[i] = aValue + bValue;
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) (a.length / alpha);
        double[] result = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            result[i] = a[(int) (i * alpha)];
        }
        return result;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        // Load at least five different WAV files
        double[] sound1 = StdAudio.read("beatbox.wav");
        double[] sound2 = StdAudio.read("buzzer.wav");
        double[] sound3 = StdAudio.read("chimes.wav");
        double[] sound4 = StdAudio.read("cow.wav");
        double[] sound5 = StdAudio.read("piano.wav");

        // Apply audio effects
        double[] amplifiedSound = amplify(sound1, 1.5);
        double[] reversedSound = reverse(sound2);
        double[] mergedSound = merge(sound3, sound4);
        double[] mixedSound = mix(sound5, sound1);
        double[] speedChangedSound = changeSpeed(sound2, 0.8);

        // Create an audio collage
        double[] collage = merge(amplifiedSound, reversedSound);
        collage = merge(collage, mergedSound);
        collage = mix(collage, mixedSound);
        collage = merge(collage, speedChangedSound);

        // Ensure duration is between 10 and 60 seconds
        if (collage.length < 441000 || collage.length > 2646000) {
            throw new IllegalArgumentException("Duration must be between 10 and 60 seconds.");
        }

        // Play the audio collage
        StdAudio.play(collage);
    }
}
