package serie03;

import java.util.Scanner;

public class Rebonds1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez le nombre de rebonds : ");
        int nbRebonds = scanner.nextInt();

        System.out.print("Donnez la hauteur initiale : ");
        double hauteur = scanner.nextDouble();
        if (hauteur <= 0) {
            System.out.println("La hauteur doit être strictement positive");
            return;
        }

        System.out.print("Donnez epsilon : ");
        double epsilon = scanner.nextDouble();
        if (epsilon < 0 || epsilon >= 1) {
            System.out.println("Epsilon doit être compris entre 0 et 1");
            return;
        }

        // Each bounce multiplies the speed by epsilon, so the height by epsilon²
        double hauteurFinale = hauteur * Math.pow(epsilon, 2 * nbRebonds);

        System.out.println("La hauteur finale est " + hauteurFinale);
    }
}
