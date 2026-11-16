package serie07.banque2;

/** Second version of the bank (see Banque1), rewritten with classes. */
public class Banque2 {
    public static final double TAUX_PRIVE = 0.01;
    public static final double TAUX_EPARGNE = 0.02;

    public static void main(String[] args) {
        Client pedro = new Client("Pedro", "Geneve", 1000, 2000);
        Client alexandra = new Client("Alexandra", "Lausanne", 3000, 4000);

        pedro.afficher();
        alexandra.afficher();

        pedro.bouclerComptes();
        alexandra.bouclerComptes();

        pedro.afficher();
        alexandra.afficher();
    }
}

class Client {
    private final String nom;
    private final String ville;
    private final Compte comptePrive;
    private final Compte compteEpargne;

    public Client(String nom, String ville, double soldePrive, double soldeEpargne) {
        this.nom = nom;
        this.ville = ville;
        this.comptePrive = new Compte(soldePrive, Banque2.TAUX_PRIVE);
        this.compteEpargne = new Compte(soldeEpargne, Banque2.TAUX_EPARGNE);
    }

    public void bouclerComptes() {
        comptePrive.boucler();
        compteEpargne.boucler();
    }

    public void afficher() {
        System.out.println("Client " + nom + " de " + ville);
        System.out.println("   Compte prive:     " + comptePrive.getSolde() + " francs");
        System.out.println("   Compte d'epargne: " + compteEpargne.getSolde() + " francs");
    }
}

class Compte {
    private final double taux;
    private double solde;

    public Compte(double solde, double taux) {
        this.solde = solde;
        this.taux = taux;
    }

    public double getSolde() {
        return solde;
    }

    /** Adds the yearly interest to the balance. */
    public void boucler() {
        solde += solde * taux;
    }
}
