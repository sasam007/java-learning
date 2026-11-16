package serie03;

/** The same loop written three ways: for, while and do...while. */
public class Boucles {
    public static void main(String[] args) {
        System.out.println("Boucle for :");
        for (int a = 3; a <= 10; a++) {
            System.out.println("a : " + a);
        }

        System.out.println("Boucle while :");
        int a = 3;
        while (a <= 10) {
            System.out.println("a : " + a);
            a++;
        }

        System.out.println("Boucle do..while :");
        a = 3;
        do {
            System.out.println("a : " + a);
            a++;
        } while (a <= 10);
    }
}
