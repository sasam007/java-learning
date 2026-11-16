package serie03;

import java.util.Scanner;

public class Pair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez un nombre : ");
        int nombre = scanner.nextInt();

        if (nombre == 0) {
            System.out.println("Le nombre est zéro (il est pair)");
            return;
        }

        String parite = (nombre % 2 == 0) ? "pair" : "impair";
        String signe = (nombre < 0) ? "négatif" : "positif";
        System.out.println(nombre + " est " + parite + " et " + signe);
    }
}
