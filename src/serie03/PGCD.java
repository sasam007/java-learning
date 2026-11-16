package serie03;

import java.util.Scanner;

public class PGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez la valeur de a : ");
        int a = scanner.nextInt();

        System.out.print("Donnez la valeur de b : ");
        int b = scanner.nextInt();

        // The subtraction algorithm only terminates for strictly positive numbers
        if (a <= 0 || b <= 0) {
            System.out.println("a et b doivent être strictement positifs");
            return;
        }

        while (a != b) {
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            a = a - b;
        }
        System.out.println("le pgcd est " + a);
    }
}
