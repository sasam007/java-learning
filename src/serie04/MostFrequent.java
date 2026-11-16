package serie04;

public class MostFrequent {

    public static void main(String[] args) {
        int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};

        int maxOccurrences = 0;
        int nombreMax = 0;
        for (int i : tab1) {
            int occurrences = 0;
            for (int j : tab1) {
                if (i == j) {
                    occurrences++;
                }
            }
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                nombreMax = i;
            }
        }
        System.out.println("Le nombre le plus frequent dans le tableau est le :");
        System.out.println(nombreMax + " (" + maxOccurrences + " x)");
    }
}
