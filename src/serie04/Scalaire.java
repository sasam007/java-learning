package serie04;

import java.util.Scanner;

public class Scalaire {

    private static final int N_MAX = 10;

    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);

        System.out.print("Entrez la taille du vecteur (entre 1 et " + N_MAX + ") : ");
        int n = keyb.nextInt();
        while (n <= 0 || n > N_MAX) {
            System.out.print("Taille invalide, essayez à nouveau ");
            n = keyb.nextInt();
        }

        double[] v1 = new double[n];
        double[] v2 = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Donnez la composante " + i + " du vecteur v1 ");
            v1[i] = keyb.nextDouble();
            System.out.print("Donnez la composante " + i + " du vecteur v2 ");
            v2[i] = keyb.nextDouble();
        }

        double somme = 0;
        for (int i = 0; i < n; i++) {
            somme += v1[i] * v2[i];
        }

        System.out.println("Produit scalaire = " + somme);
        keyb.close();
    }
}
