package serie03;

import java.util.Scanner;

public class Velo {

    private static final int DEBUT_TARIF_PLEIN = 7;
    private static final int FIN_TARIF_PLEIN = 17;
    private static final double TARIF_REDUIT = 1.0;
    private static final double TARIF_PLEIN = 2.0;

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Donnez l'heure de début de la location (un entier) : ");
        int debut = clavier.nextInt();
        System.out.print("Donnez l'heure de fin de la location (un entier) : ");
        int fin = clavier.nextInt();

        if (debut < 0 || fin < 0 || debut > 24 || fin > 24) {
            System.out.println("Les heures doivent être comprises entre 0 et 24 !");
            return;
        } else if (debut == fin) {
            System.out.println("Bizarre, vous n'avez pas loué votre vélo bien longtemps !");
            return;
        } else if (debut > fin) {
            System.out.println("Bizarre, le début de la location est après la fin ...");
            return;
        }

        // Hours outside 7h-17h are charged at the reduced rate
        int heuresReduitesMatin = Math.max(0, Math.min(fin, DEBUT_TARIF_PLEIN) - debut);
        int heuresReduitesSoir = Math.max(0, fin - Math.max(debut, FIN_TARIF_PLEIN));
        int heuresReduites = heuresReduitesMatin + heuresReduitesSoir;
        int heuresPleines = (fin - debut) - heuresReduites;

        System.out.println("Vous avez loué votre vélo pendant");
        if (heuresReduites != 0) {
            System.out.println(heuresReduites + " heure(s) au tarif horaire de " + TARIF_REDUIT + " franc(s)");
        }
        if (heuresPleines != 0) {
            System.out.println(heuresPleines + " heure(s) au tarif horaire de " + TARIF_PLEIN + " franc(s)");
        }

        double total = heuresReduites * TARIF_REDUIT + heuresPleines * TARIF_PLEIN;
        System.out.print("Le montant total à payer est de " + total);
        System.out.println(" franc(s).");

        clavier.close();
    }
}
