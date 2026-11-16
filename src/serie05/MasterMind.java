package serie05;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {

    private static final int TAILLE = 4;
    private static final int MAX = 6;
    private static final int ESSAIS = 10;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int[] laCombinaison = new int[TAILLE];
        int[] combinaison = new int[TAILLE];
        int[] reponse = new int[2];

        tirerCombinaison(laCombinaison, MAX);
        for (int essai = 1; essai <= ESSAIS; essai++) {
            Arrays.fill(reponse, 0);
            demanderCombinaison(combinaison, MAX);
            boolean trouve = compare(combinaison, laCombinaison, reponse);
            afficheReponse(reponse);
            if (trouve) {
                System.out.println("Bravo, vous avez trouvé en " + essai + " coups");
                return;
            }
            System.out.println("Raté !");
        }
        System.out.println("Dommage, la combinaison était " + Arrays.toString(laCombinaison));
    }

    public static void tirerCombinaison(int[] uneCombinaison, int max) {
        for (int i = 0; i < uneCombinaison.length; i++) {
            uneCombinaison[i] = hasard(max);
        }
    }

    static int hasard(int max) {
        return 1 + (int) (Math.random() * max);
    }

    public static void demanderCombinaison(int[] uneCombinaison, int max) {
        System.out.println("Donnez votre combinaison (" + uneCombinaison.length + " chiffres entre 1 et " + max + ")");
        for (int i = 0; i < uneCombinaison.length; i++) {
            uneCombinaison[i] = SCANNER.nextInt();
        }
    }

    /**
     * Fills reponse[0] with the number of well-placed digits ("#")
     * and reponse[1] with the number of right digits in the wrong place ("O").
     * Returns true when the guess is exactly the secret combination.
     */
    static boolean compare(int[] essai, int[] secret, int[] reponse) {
        boolean[] dejaCompte = new boolean[secret.length];
        for (int i = 0; i < essai.length; i++) {
            if (essai[i] == secret[i]) {
                reponse[0]++;
                dejaCompte[i] = true;
            }
        }
        for (int i = 0; i < essai.length; i++) {
            if (essai[i] == secret[i]) {
                continue;
            }
            for (int j = 0; j < secret.length; j++) {
                if (!dejaCompte[j] && essai[i] == secret[j]) {
                    reponse[1]++;
                    dejaCompte[j] = true;
                    break;
                }
            }
        }
        return reponse[0] == secret.length;
    }

    static void afficheReponse(int[] reponse) {
        System.out.println();
        System.out.print("#".repeat(reponse[0]));
        System.out.print("O".repeat(reponse[1]));
        System.out.println("\n");
    }
}
