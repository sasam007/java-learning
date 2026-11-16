package serie08.poste;

import java.util.ArrayList;

public class Poste {

    public static void main(String[] args) {
        Boite boite = new Boite();

        Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
        Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalid: no address

        Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
        Publicite pub2 = new Publicite(3000, false, ""); // invalid: no address

        Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
        Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); // invalid: too big

        boite.ajouterCourrier(lettre1);
        boite.ajouterCourrier(lettre2);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colis1);
        boite.ajouterCourrier(colis2);

        System.out.println("Le montant total d'affranchissement est de " + boite.affranchir());
        boite.afficher();

        System.out.println("La boite contient " + boite.courriersInvalides() + " courriers invalides");
    }
}

class Boite {

    private final ArrayList<Courrier> courriers = new ArrayList<>();

    public void ajouterCourrier(Courrier courrier) {
        courriers.add(courrier);
    }

    public double affranchir() {
        double montant = 0;
        for (Courrier courrier : courriers) {
            montant += courrier.calculerMontant();
        }
        return montant;
    }

    public void afficher() {
        for (Courrier courrier : courriers) {
            courrier.afficher();
            System.out.println();
        }
    }

    public int courriersInvalides() {
        int nb = 0;
        for (Courrier courrier : courriers) {
            if (!courrier.isValide()) {
                nb++;
            }
        }
        return nb;
    }
}

abstract class Courrier {

    private final double poids;
    private final boolean express;
    private final String adresse;

    public Courrier(double poids, boolean express, String adresse) {
        this.poids = poids;
        this.express = express;
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getPoids() {
        return poids;
    }

    public boolean isExpress() {
        return express;
    }

    public boolean isValide() {
        return !adresse.isEmpty();
    }

    /** Postage at the normal rate; each kind of mail has its own formula. */
    protected abstract double calculerTarif();

    /** Invalid mail costs nothing; express mail costs double. */
    public double calculerMontant() {
        if (!isValide()) {
            return 0;
        }
        return express ? calculerTarif() * 2 : calculerTarif();
    }

    protected abstract String getType();

    public void afficher() {
        System.out.println(getType());
        if (!isValide()) {
            System.out.println("Courrier Invalide");
        }
        System.out.println("Poids : " + poids);
        System.out.println("Express : " + express);
        System.out.println("Destination : " + adresse);
        System.out.println("Montant : " + calculerMontant());
    }
}

class Lettre extends Courrier {

    private final String format;

    public Lettre(double poids, boolean express, String adresse, String format) {
        super(poids, express, adresse);
        this.format = format;
    }

    @Override
    protected double calculerTarif() {
        double base = format.equals("A4") ? 2.5 : 3.5;
        return base + getPoids() / 1000;
    }

    @Override
    protected String getType() {
        return "Lettre";
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Format : " + format);
    }
}

class Colis extends Courrier {

    private static final double VOLUME_MAX = 50;

    private final double volume;

    public Colis(double poids, boolean express, String adresse, double volume) {
        super(poids, express, adresse);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean isValide() {
        return super.isValide() && volume <= VOLUME_MAX;
    }

    @Override
    protected double calculerTarif() {
        return 0.25 * volume + getPoids() / 1000;
    }

    @Override
    protected String getType() {
        return "Colis";
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Volume : " + volume);
    }
}

class Publicite extends Courrier {

    public Publicite(double poids, boolean express, String adresse) {
        super(poids, express, adresse);
    }

    @Override
    protected double calculerTarif() {
        return getPoids() / 200;
    }

    @Override
    protected String getType() {
        return "Publicite";
    }
}
