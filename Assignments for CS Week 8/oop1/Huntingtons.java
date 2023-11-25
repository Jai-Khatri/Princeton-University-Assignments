public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        dna = removeWhitespace(dna);
        int maxRepeats = 0;
        int currentRepeats = 0;

        for (int i = 0; i < dna.length() - 2; i++) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                currentRepeats += 3;
                maxRepeats = Math.max(maxRepeats, currentRepeats);
            } else {
                currentRepeats = 0;
            }
        }

        return maxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 181) {
            return "not human";
        } else if (maxRepeats >= 40) {
            return "Huntington's";
        } else if (maxRepeats >= 36) {
            return "high risk";
        } else if (maxRepeats >= 10) {
            return "normal";
        } else {
            return "not human";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        if (args.length == 1) {
            String dna = args[0];
            int repeats = maxRepeats(dna);
            System.out.println("max repeats = " + repeats);
            System.out.println(diagnose(repeats));
        } else {
            System.out.println("Usage: java Huntingtons <dna>");
        }
    }
}
