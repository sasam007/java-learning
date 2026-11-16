package serie01_02;

import java.util.Scanner;

public class Fondue {
    // The base recipe is for 4 people
    private static final double BASE = 4;
    private static final double FROMAGE = 800.0;
    private static final double EAU = 2.0;
    private static final double AIL = 2.0;
    private static final double PAIN = 400.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quel est le nombre de convives ?  ");
        int nbConvives = scanner.nextInt();

        double facteur = nbConvives / BASE;

        System.out.println("Pour faire une fondue fribourgeoise pour " + nbConvives + " personnes, il vous faut :");
        System.out.println(FROMAGE * facteur + " gr de Vacherin fribourgeois");
        System.out.println(EAU * facteur + " dl d'eau");
        System.out.println(AIL * facteur + " gousse(s) d'ail");
        System.out.println(PAIN * facteur + " gr de pain");
        System.out.println("du poivre à volonté");
    }
}
