package serie04;

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nbLignes;
        do {
            System.out.print("Combien de lignes du triangle de Pascal ? ");
            nbLignes = scanner.nextInt();
        } while (nbLignes < 1);

        int[][] triangle = new int[nbLignes][];

        for (int i = 0; i < nbLignes; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }

            for (int valeur : triangle[i]) {
                System.out.print(valeur + " ");
            }
            System.out.println();
        }
    }
}
