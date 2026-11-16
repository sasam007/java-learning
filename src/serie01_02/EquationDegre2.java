package serie01_02;

import java.util.Scanner;

/** Solves a quadratic equation ax² + bx + c = 0. */
public class EquationDegre2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nous allons résoudre une équation du second degré de la forme ax2 + bx + c");

        System.out.print("Donnez la valeur de a : ");
        double a = scanner.nextDouble();
        if (a == 0) {
            System.out.println("a ne doit pas être égal à 0");
            return;
        }

        System.out.print("Donnez la valeur de b : ");
        double b = scanner.nextDouble();

        System.out.print("Donnez la valeur de c : ");
        double c = scanner.nextDouble();

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            System.out.println("Pas de solution réelle");
        } else if (delta == 0) {
            System.out.println("x : " + (-b / (2 * a)));
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("x1 : " + x1);
            System.out.println("x2 : " + x2);
        }
    }
}
