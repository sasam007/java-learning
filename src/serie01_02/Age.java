package serie01_02;

import java.time.Year;
import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre âge");
        int age = scanner.nextInt();

        int anneeNaissance = Year.now().getValue() - age;
        System.out.println("Votre année de naissance est : " + anneeNaissance);
    }
}
