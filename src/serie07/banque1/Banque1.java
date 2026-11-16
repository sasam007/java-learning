package serie07.banque1;

/** First version of the bank: procedural code, before classes are introduced (see Banque2). */
public class Banque1 {

    public static void main(String[] args) {
        // Interest rate for all private accounts
        double taux1 = 0.01;
        // Interest rate for all savings accounts
        double taux2 = 0.02;

        String nom1 = "Pedro";
        String ville1 = "Geneve";
        double solde1PremierClient = 1000.0;
        double solde2PremierClient = 2000.0;

        String nom2 = "Alexandra";
        String ville2 = "Lausanne";
        double solde1DeuxiemeClient = 3000.0;
        double solde2DeuxiemeClient = 4000.0;

        afficherClient(nom1, ville1, solde1PremierClient, solde2PremierClient);
        afficherClient(nom2, ville2, solde1DeuxiemeClient, solde2DeuxiemeClient);

        // Year-end closing: add the interest to every account
        solde1PremierClient = bouclerCompte(solde1PremierClient, taux1);
        solde2PremierClient = bouclerCompte(solde2PremierClient, taux2);
        solde1DeuxiemeClient = bouclerCompte(solde1DeuxiemeClient, taux1);
        solde2DeuxiemeClient = bouclerCompte(solde2DeuxiemeClient, taux2);

        afficherClient(nom1, ville1, solde1PremierClient, solde2PremierClient);
        afficherClient(nom2, ville2, solde1DeuxiemeClient, solde2DeuxiemeClient);
    }

    static void afficherClient(String nom, String ville, double solde1, double solde2) {
        System.out.println("Client " + nom + " de " + ville);
        System.out.println("   Compte prive:     " + solde1 + " francs");
        System.out.println("   Compte d'epargne: " + solde2 + " francs");
    }

    static double bouclerCompte(double solde, double taux) {
        return solde + taux * solde;
    }
}
