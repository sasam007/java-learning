package serie08.gestionvehicules;

public class GestionVehicules {

    // Fixed current year so the computed prices stay reproducible
    private static final int ANNEE_ACTUELLE = 2026;

    public static void main(String[] args) {
        Voiture[] garage = new Voiture[3];
        Avion[] hangar = new Avion[2];

        garage[0] = new Voiture("Peugeot", 2005, 147325.79, 2.5, 5, 180.0, 12000);
        garage[1] = new Voiture("Porsche", 1999, 250000.00, 6.5, 2, 280.0, 81320);
        garage[2] = new Voiture("Fiat", 2001, 7327.30, 1.6, 3, 65.0, 3000);

        hangar[0] = new Avion("Cessna", 1982, 1230673.90, "HELICES", 250);
        hangar[1] = new Avion("Nain Connu", 1993, 4321098.00, "REACTION", 1300);

        for (Voiture voiture : garage) {
            voiture.calculePrix(ANNEE_ACTUELLE);
            voiture.affiche();
        }

        for (Avion avion : hangar) {
            avion.calculePrix(ANNEE_ACTUELLE);
            avion.affiche();
        }
    }
}

class Vehicule {

    private final String marque;
    private final int dateAchat;
    private final double prixAchat;
    private double prixActuel;

    public Vehicule(String marque, int dateAchat, double prixAchat) {
        this.marque = marque;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
        this.prixActuel = prixAchat;
    }

    public void affiche() {
        System.out.println("Marque " + marque);
        System.out.println("Date Achat " + dateAchat);
        System.out.println("Prix Achat " + prixAchat);
        System.out.println("Prix Actuel " + prixActuel);
    }

    /** Default depreciation: 1% per year since purchase. */
    public void calculePrix(int anneeActuelle) {
        prixActuel = prixAchat * (1 - (anneeActuelle - dateAchat) * 0.01);
    }

    public String getMarque() {
        return marque;
    }

    public int getDateAchat() {
        return dateAchat;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    protected void setPrixActuel(double prixActuel) {
        this.prixActuel = prixActuel;
    }
}

class Voiture extends Vehicule {

    private final double cylindree;
    private final int nbPortes;
    private final double puissance;
    private final int kilometrage;

    public Voiture(String marque, int dateAchat, double prixAchat, double cylindree, int nbPortes,
                   double puissance, int kilometrage) {
        super(marque, dateAchat, prixAchat);
        this.cylindree = cylindree;
        this.nbPortes = nbPortes;
        this.puissance = puissance;
        this.kilometrage = kilometrage;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Cylindree " + cylindree);
        System.out.println("Nombre de Portes " + nbPortes);
        System.out.println("Puissance " + puissance);
        System.out.println("kilometrage " + kilometrage);
        System.out.println();
    }

    /** 2% per year, plus 5% per full 10,000 km, adjusted by brand. */
    @Override
    public void calculePrix(int anneeActuelle) {
        double decote = 0.02 * (anneeActuelle - getDateAchat()) + 0.05 * (kilometrage / 10000);
        String marque = getMarque();
        if (marque.equals("Fiat") || marque.equals("Renault")) {
            decote += 0.1;
        } else if (marque.equals("Porsche") || marque.equals("Ferrari")) {
            decote -= 0.2;
        }
        setPrixActuel(getPrixAchat() * Math.max(0, 1 - decote));
    }
}

class Avion extends Vehicule {

    private final String moteur;
    private final int nbHeuresVol;

    public Avion(String marque, int dateAchat, double prixAchat, String moteur, int nbHeuresVol) {
        super(marque, dateAchat, prixAchat);
        this.moteur = moteur;
        this.nbHeuresVol = nbHeuresVol;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Moteur " + moteur);
        System.out.println("Nombre d'heures de vol " + nbHeuresVol);
        System.out.println();
    }

    /** 10% per 100 flight hours for propellers, per 1000 hours for jets. */
    @Override
    public void calculePrix(int anneeActuelle) {
        double heuresParTranche = moteur.equals("HELICES") ? 100 : 1000;
        double decote = 0.1 * (nbHeuresVol / heuresParTranche);
        setPrixActuel(getPrixAchat() * Math.max(0, 1 - decote));
    }
}
