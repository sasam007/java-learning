package serie03;

import java.util.Scanner;

public class Bilan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez n : ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("n doit être strictement positif");
            return;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Donnez le montant du mois " + i + " : ");
            int montant = scanner.nextInt();
            total += montant;

            if (montant > max) {
                max = montant;
            }
            if (montant < min) {
                min = montant;
            }
        }
        System.out.println("Moyenne : " + (double) total / n);
        System.out.println("Max : " + max);
        System.out.println("Min : " + min);
    }
}
