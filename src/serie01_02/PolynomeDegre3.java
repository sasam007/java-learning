package serie01_02;

import java.util.Scanner;

/** Evaluates (a+b)/2 * x³ + (a+b)² * x² + a + b + c. */
public class PolynomeDegre3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez a (int) : ");
        int a = scanner.nextInt();

        System.out.print("Entrez b (int) : ");
        int b = scanner.nextInt();

        System.out.print("Entrez c (int) : ");
        int c = scanner.nextInt();

        System.out.print("Entrez x (double) : ");
        double x = scanner.nextDouble();

        double somme = (double) a + b;
        double moyenne = somme / 2;
        double carreSomme = somme * somme;
        double resultat = moyenne * x * x * x + carreSomme * x * x + a + b + c;
        System.out.println("Résultat : " + resultat);
    }
}
