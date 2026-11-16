package serie05;

import java.util.Scanner;

public class Rectangle {

    private static final Scanner KEYB = new Scanner(System.in);

    public static double lireDonnee(String dimension) {
        System.out.print("Donne la " + dimension + ": ");
        return KEYB.nextDouble();
    }

    public static boolean testerDonnees(double largeur, double hauteur) {
        return largeur >= 0 && hauteur >= 0;
    }

    public static void calculer(double largeur, double hauteur) {
        System.out.print("Surface ('s/S') ou perimètre ('p/P')?: ");
        char instruction = Character.toLowerCase(KEYB.next().charAt(0));
        switch (instruction) {
            case 's':
                System.out.println("La surface est " + largeur * hauteur);
                break;
            case 'p':
                System.out.println("Le périmètre est " + 2 * (largeur + hauteur));
                break;
            default:
                System.out.println("Entrée invalide.");
                calculer(largeur, hauteur);
        }
    }

    public static void afficherErreur() {
        System.out.println("Erreur: vous avez introduit une largeur ou une hauteur négative!");
    }

    public static void main(String[] args) {
        double largeur = lireDonnee("largeur");
        double hauteur = lireDonnee("hauteur");

        if (testerDonnees(largeur, hauteur)) {
            calculer(largeur, hauteur);
        } else {
            afficherErreur();
        }
    }
}
