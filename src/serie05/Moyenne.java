package serie05;

import java.util.Scanner;

public class Moyenne {

    private static final Scanner KEYB = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Donnez moi 2 nombres ");
        double n1 = KEYB.nextDouble();
        double n2 = KEYB.nextDouble();

        System.out.println("La moyenne est " + moyenne(n1, n2));
    }

    /** Average of one or more numbers. */
    public static double moyenne(double premier, double... autres) {
        double somme = premier;
        for (double nombre : autres) {
            somme += nombre;
        }
        return somme / (1 + autres.length);
    }
}
