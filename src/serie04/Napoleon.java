package serie04;

import java.util.Scanner;

public class Napoleon {
    public static void main(String[] args) {
        String noms = "Napoleon Bonaparte Bill Gates Claudia Schiffer Martina Hingis ";
        Scanner keyb = new Scanner(System.in);

        System.out.print("Donnez moi un prénom, et je vous donnerai le nom associé ");
        String prenom = keyb.next();

        // Words alternate: first name, last name, first name, last name...
        // Comparing whole words avoids matching "Gates" or "Napo" by mistake.
        String[] mots = noms.trim().split(" ");
        for (int i = 0; i + 1 < mots.length; i += 2) {
            if (mots[i].equals(prenom)) {
                System.out.println("Le nom est " + mots[i + 1]);
                return;
            }
        }
        System.out.println("Inconnu au bataillon");
    }
}
