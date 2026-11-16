package serie03;

import java.util.Scanner;

public class Intervalle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un décimal ");
        double x = scanner.nextDouble();

        if ((-10 <= x && x <= -2) || (0 < x && x <= 1) || (2 <= x && x < 3)) {
            System.out.println("x est compris dans l'intervalle");
        } else {
            System.out.println("x n'est pas compris dans l'intervalle");
        }
    }
}
