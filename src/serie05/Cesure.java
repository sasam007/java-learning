package serie05;

import java.util.Scanner;

public class Cesure {
    public static void main(String[] args) {
        String[] phrase = lirePhrase();
        if (phrase.length != 0) {
            System.out.println("Le résultat est : ");
            for (String mot : phrase) {
                cesure(mot);
            }
        }
    }

    /** Reads the words typed by the user. */
    static String[] lirePhrase() {
        Scanner keyb = new Scanner(System.in);
        int nMots;
        do {
            System.out.print("Donnez le nombre de mots dans votre phrase: ");
            nMots = keyb.nextInt();
            if (nMots <= 0) {
                System.out.println("Entrez une valeur plus grande que 0");
            }
        } while (nMots <= 0);

        String[] mots = new String[nMots];
        for (int i = 0; i < nMots; i++) {
            System.out.println("Donnez le mot " + (i + 1) + " : ");
            mots[i] = keyb.next();
        }
        return mots;
    }

    static boolean voyelle(char c) {
        return "aeiouy".indexOf(c) != -1;
    }

    static boolean queVoyelles(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!voyelle(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /** Prints the word split into syllables, one per line. */
    static void cesure(String mot) {
        // A word of 1 or 2 letters cannot be split
        if (mot.length() <= 2) {
            System.out.println(mot);
            return;
        }

        // Ignore the first and last letter when looking for split points
        String interieur = mot.substring(1, mot.length() - 1);
        if (queVoyelles(interieur)) {
            System.out.println(mot);
            return;
        }

        int indexDebut = 0;
        for (int i = 1; i < interieur.length(); i++) {
            boolean voyellePuisConsonne = voyelle(interieur.charAt(i - 1)) && !voyelle(interieur.charAt(i));
            if (voyellePuisConsonne && i + 1 - indexDebut >= 2
                    && !queVoyelles(mot.substring(indexDebut, i + 1))) {
                System.out.println(mot.substring(indexDebut, i + 1) + "-");
                indexDebut = i + 1;
            }
        }
        System.out.println(mot.substring(indexDebut));
    }
}
