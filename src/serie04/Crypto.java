package serie04;

import java.util.Scanner;

public class Crypto {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int DECALAGE = 4;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Veuillez entrer une chaine de caracteres : ");
        String s = scanner.nextLine();

        // Keep only lowercase letters and spaces
        StringBuilder aCoder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ' || ALPHABET.indexOf(c) >= 0) {
                aCoder.append(c);
            }
        }

        // Caesar cipher: shift each letter by DECALAGE, wrapping around the alphabet
        StringBuilder chaineCodee = new StringBuilder();
        for (char c : aCoder.toString().toCharArray()) {
            if (c == ' ') {
                chaineCodee.append(' ');
            } else {
                int index = (ALPHABET.indexOf(c) + DECALAGE) % ALPHABET.length();
                chaineCodee.append(ALPHABET.charAt(index));
            }
        }

        System.out.format("La chaine initiale etait : '%s'\n", s);

        if (aCoder.length() == 0) {
            System.out.println("La chaine a coder est vide.\n");
        } else {
            System.out.format("La chaine a coder est : '%s'\n", aCoder);
            System.out.format("La chaine codee est : '%s'\n", chaineCodee);
        }
    }
}
