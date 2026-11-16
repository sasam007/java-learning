package serie03;

import java.util.Scanner;

public class Rebonds2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez la hauteur initiale : ");
        double hauteur = scanner.nextDouble();

        System.out.print("Donnez epsilon : ");
        double epsilon = scanner.nextDouble();

        System.out.print("Donnez la hauteur finale : ");
        double hauteurFinale = scanner.nextDouble();

        if (hauteur <= 0 || epsilon <= 0 || epsilon >= 1 || hauteurFinale <= 0) {
            System.out.println("Valeurs invalides");
            return;
        }

        int rebonds = 0;
        do {
            // Each bounce multiplies the speed by epsilon, so the height by epsilon²
            hauteur = epsilon * epsilon * hauteur;
            ++rebonds;
        } while (hauteur > hauteurFinale);

        System.out.println("Nombre de rebonds : " + rebonds);
    }
}
