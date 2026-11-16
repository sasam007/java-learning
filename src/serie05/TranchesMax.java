package serie05;

import java.util.ArrayList;
import java.util.Scanner;

public class TranchesMax {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);
        clavier.close();

        if (!checkFormat(matrice)) {
            return;
        }

        // Indexes of the rows that contain the longest run of consecutive 1s
        ArrayList<Integer> maxConsecutifList = findConsecutiveList(matrice);

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1 !");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs :");
            for (int index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }

    public static boolean checkLineLength(String[] lignes) {
        if (lignes.length == 1 && lignes[0].isEmpty()) {
            System.out.println("Matrice vide !");
            return false;
        }

        int longueur = lignes[0].length();
        for (String ligne : lignes) {
            if (ligne.length() != longueur) {
                System.out.println("Matrice invalide, lignes de longueurs differentes !");
                return false;
            }
        }
        return true;
    }

    public static boolean checkFormat(String matrice) {
        String[] lignes = matrice.split(" +");
        if (!checkLineLength(lignes)) {
            return false;
        }
        for (char c : matrice.toCharArray()) {
            if (c != ' ' && c != '1' && c != '0') {
                System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> findConsecutiveList(String matrice) {
        String[] lignes = matrice.split(" +");
        ArrayList<Integer> lignesMax = new ArrayList<>();
        int longueurMax = 0;
        for (int i = 0; i < lignes.length; i++) {
            int longueur = plusLongueSuite(lignes[i]);
            if (longueur == 0) {
                continue;
            }
            if (longueur > longueurMax) {
                // New record: forget the rows found so far
                longueurMax = longueur;
                lignesMax.clear();
                lignesMax.add(i);
            } else if (longueur == longueurMax) {
                lignesMax.add(i);
            }
        }
        return lignesMax;
    }

    /** Length of the longest run of consecutive '1' in a row. */
    static int plusLongueSuite(String ligne) {
        int max = 0;
        int courant = 0;
        for (char c : ligne.toCharArray()) {
            courant = (c == '1') ? courant + 1 : 0;
            max = Math.max(max, courant);
        }
        return max;
    }
}
