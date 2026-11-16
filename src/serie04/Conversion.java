package serie04;

import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);

        System.out.print("Entrez une seule lettre A..Z ou a..z : ");
        char lettre = keyb.next().charAt(0);

        if (lettre >= 'A' && lettre <= 'Z') {
            System.out.println((char) (lettre + ('a' - 'A')));
        } else if (lettre >= 'a' && lettre <= 'z') {
            System.out.println((char) (lettre - ('a' - 'A')));
        } else {
            System.out.println("Caractere non valable");
        }
    }
}
