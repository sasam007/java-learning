package serie05;

public class Benford {

    // Prints an array of ints on one line
    public static void print(int[] tab) {
        for (int valeur : tab) {
            System.out.print(valeur + " ");
        }
        System.out.println();
    }

    // Prints an array of doubles on one line
    public static void print(double[] tab) {
        for (double valeur : tab) {
            System.out.print(valeur + " ");
        }
        System.out.println();
    }

    public static void fillWithSquare(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i + 1.0) * (i + 1.0) / 100;
        }
    }

    /** Returns the leading (most significant) digit of a number, or 0 for 0. */
    public static int extractMaxDigit(double number) {
        number = Math.abs(number);
        if (number == 0) {
            return 0;
        }
        while (number >= 10) {
            number /= 10;
        }
        while (number < 1) {
            number *= 10;
        }
        return (int) number;
    }

    public static void analyze(double[] numbers, int[] frequencies) {
        for (double number : numbers) {
            int digit = extractMaxDigit(number);
            if (digit > 0) {
                frequencies[digit - 1]++;
            }
        }
    }

    public static void testBenford(int[] frequencies, int nbNombres) {
        System.out.println("Pourcentage effectif / Predictions de la loi de Benford :");
        for (int i = 1; i < 10; i++) {
            double valeurBenford = Math.log10(1 + 1.0 / i);
            double pourcentage = (double) frequencies[i - 1] / nbNombres * 100;
            System.out.println(i + " : " + pourcentage + "% , Benford : " + valeurBenford * 100 + "%");
        }
    }

    public static void main(String[] args) {
        int[] frequencies = new int[9];
        double[] numbers = new double[25];

        System.out.println("Test 1.1 : ");
        fillWithSquare(numbers);
        print(numbers);
        System.out.println();

        System.out.println("Test 1.2 : ");
        System.out.println(extractMaxDigit(0));
        System.out.println(extractMaxDigit(632));
        System.out.println(extractMaxDigit(-221));
        System.out.println(extractMaxDigit(-554.15));
        System.out.println(extractMaxDigit(0.00421));
        System.out.println();

        System.out.println("Test 1.3 : ");
        analyze(numbers, frequencies);
        print(frequencies);
        System.out.println();

        System.out.println("Test 1.4 : ");
        testBenford(frequencies, numbers.length);
    }
}
