package serie05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Decharge {

    private static final DecimalFormat DF = new DecimalFormat("#.000");

    // Coordinates far away from everything, used to "remove" a house already chosen
    private static final int TRES_LOIN = 1_000_000;

    public static double calculerDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    /** Returns the index of the closest house (houses are stored as x0, y0, x1, y1, ...). */
    public static int plusProche(int x, int y, int[] coordonneesHabitations) {
        double distanceMin = Double.MAX_VALUE;
        int indexMin = 0;
        for (int i = 0; i < coordonneesHabitations.length / 2; i++) {
            double distance = calculerDistance(x, y, coordonneesHabitations[2 * i], coordonneesHabitations[2 * i + 1]);
            if (distance < distanceMin) {
                distanceMin = distance;
                indexMin = i;
            }
        }
        return indexMin;
    }

    /** Returns the coordinates of the 3 closest houses: x0, y0, x1, y1, x2, y2. */
    public static int[] troisPlusProches(int x, int y, int[] coordonneesHabitations) {
        int[] restantes = coordonneesHabitations.clone();
        int[] resultat = new int[6];
        for (int i = 0; i < 3; i++) {
            int index = plusProche(x, y, restantes);
            resultat[2 * i] = restantes[2 * index];
            resultat[2 * i + 1] = restantes[2 * index + 1];
            restantes[2 * index] = TRES_LOIN;
            restantes[2 * index + 1] = TRES_LOIN;
        }
        return resultat;
    }

    /** Returns the center of gravity of the 3 closest houses. */
    public static int[] meilleurePlace(int x, int y, int[] coordonneesHabitations) {
        int[] tpp = troisPlusProches(x, y, coordonneesHabitations);
        int xMeilleur = (tpp[0] + tpp[2] + tpp[4]) / 3;
        int yMeilleur = (tpp[1] + tpp[3] + tpp[5]) / 3;
        return new int[]{xMeilleur, yMeilleur};
    }

    public static void afficheTroisPlusProches(int x, int y, int[] coordonneesHabitations) {
        int[] tpp = troisPlusProches(x, y, coordonneesHabitations);

        System.out.println("(" + x + "," + y + ") est a :");
        for (int i = 0; i < 3; i++) {
            System.out.println("    " + DF.format(calculerDistance(x, y, tpp[2 * i], tpp[2 * i + 1]))
                    + " de (" + tpp[2 * i] + "," + tpp[2 * i + 1] + ")");
        }
    }

    public static void main(String[] args) {

        int[] coordonneesHabitations = {
                9, 30, 18, 8, 3, 18, 25, 36
        };

        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrez la coordonnee x de la decharge: ");
        int x = clavier.nextInt();
        System.out.print("Entrez le coordonnee y de la decharge: ");
        int y = clavier.nextInt();

        int plusProche = plusProche(x, y, coordonneesHabitations);
        System.out.println("--- Question 1 ---");
        System.out.println("Coordonnees de l'habitation la plus proche de la decharge :");
        System.out.println("(" + coordonneesHabitations[plusProche * 2] + "," + coordonneesHabitations[plusProche * 2 + 1]
                + ") ; distance = "
                + DF.format(calculerDistance(x, y, coordonneesHabitations[plusProche * 2], coordonneesHabitations[plusProche * 2 + 1]))
                + " metres");

        System.out.println("--- Question 2 ---");
        System.out.println("Coordonnees des 3 habitations les plus proches de la decharge :");
        afficheTroisPlusProches(x, y, coordonneesHabitations);

        int[] gravite = meilleurePlace(x, y, coordonneesHabitations);
        System.out.println("--- Question 3 ---");
        System.out.println("Coordonnees de la meilleure place pour la decharge :");
        System.out.println("(" + gravite[0] + "," + gravite[1] + ")");
        clavier.close();
    }
}
