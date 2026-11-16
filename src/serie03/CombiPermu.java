package serie03;

public class CombiPermu {

    public static void main(String[] args) {
        // Permutations of k elements among n: n! / (n-k)!
        // Combinations of k elements among n: n! / (k! * (n-k)!)
        int n = 10;
        int k = 6;

        long nFactoriel = factorielle(n);
        long kFactoriel = factorielle(k);
        long nkFactoriel = factorielle(n - k);

        System.out.println("Permutation : " + nFactoriel / nkFactoriel);
        System.out.println("Combinaisons : " + nFactoriel / (kFactoriel * nkFactoriel));
    }

    static long factorielle(int n) {
        long resultat = 1;
        for (int i = 2; i <= n; i++) {
            resultat *= i;
        }
        return resultat;
    }
}
