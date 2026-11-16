package serie04;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez un mot ou une phrase ");
        String phrase = scanner.nextLine().toLowerCase();

        // Ignore spaces and punctuation
        StringBuilder lettres = new StringBuilder();
        for (char c : phrase.toCharArray()) {
            if (Character.isLetter(c)) {
                lettres.append(c);
            }
        }

        String texte = lettres.toString();
        for (int i = 0; i < texte.length() / 2; i++) {
            if (texte.charAt(i) != texte.charAt(texte.length() - 1 - i)) {
                System.out.println("Pas un palindrome");
                return;
            }
        }
        System.out.println("Palindrome !!!");
    }
}
