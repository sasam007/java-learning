package serie05;

public class NombresAmicaux {

    /**
     * Two numbers a and b are amicable when the sum of all divisors
     * of each one (itself included) equals a + b.
     */
    public static void afficherAmicaux(int[] nombres) {
        System.out.println();
        for (int i = 0; i < nombres.length; i++) {
            for (int j = i + 1; j < nombres.length; j++) {
                int a = nombres[i];
                int b = nombres[j];
                int sommeA = sommeDiviseurs(a);
                if (sommeA == sommeDiviseurs(b) && sommeA == a + b) {
                    System.out.println(a + " " + b);
                }
            }
        }
    }

    static int sommeDiviseurs(int n) {
        int somme = 0;
        for (int d = 1; d <= n; d++) {
            if (n % d == 0) {
                somme += d;
            }
        }
        return somme;
    }

    public static void main(String[] args) {
        int[] nombres = {1210, 45, 27, 220, 54, 284, 9890, 120, 1184};
        System.out.println("Les paires de nombres amicaux sont : ");
        afficherAmicaux(nombres);
    }
}
