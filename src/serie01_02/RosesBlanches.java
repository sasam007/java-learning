package serie01_02;

import java.util.Scanner;

public class RosesBlanches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Combien d'argent avez vous (int) : ");
        int argent = scanner.nextInt();

        int livresFournitures = argent * 3 / 4;
        int cafes = argent / 24;
        int flash = argent / 48;
        int metro = argent / 36;
        int reste = argent / 4 - cafes * 2 - flash * 4 - metro * 3;

        System.out.println("Livre et Fournitures: " + livresFournitures + "Frs");
        System.out.println("Vous pouvez ensuite acheter:");
        System.out.println(cafes + " cafes a Sat");
        System.out.println(flash + " numeros du Flash");
        System.out.println(metro + " billets de métro");
        System.out.println("et il vous restera " + reste + " Frs pour les roses blanches.");
    }
}
