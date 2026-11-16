package serie10.postecommercial;

/** Mail of any kind. */
abstract class Courrier {

    protected final double poids;
    protected final boolean express;
    protected final String adresse;

    public Courrier(double poids, boolean express, String adresse) {
        this.poids = poids;
        this.express = express;
        this.adresse = adresse;
    }

    /** Postage at the normal rate; each kind of mail has its own formula. */
    protected abstract double affranchirNormal();

    /**
     * Postage to pay: 0 for invalid mail, double the normal rate for express mail.
     * Doubling here avoids repeating it in every subclass.
     */
    public double affranchir() {
        if (!valide()) {
            return 0;
        }
        double total = affranchirNormal();
        return express ? total * 2 : total;
    }

    /** Mail without a destination address is invalid. */
    public boolean valide() {
        return !adresse.isEmpty();
    }

    @Override
    public String toString() {
        String s = "";
        if (!valide()) {
            s += "(Courrier  invalide)\n";
        }
        s += "\tPoids : " + poids + " grammes\n";
        s += "\tExpress : " + (express ? "oui" : "non") + "\n";
        s += "\tDestination : " + adresse + "\n";
        s += "\tPrix : " + affranchir() + " CHF\n";
        return s;
    }
}

class Lettre extends Courrier {

    protected final String format;

    public Lettre(double poids, boolean express, String adresse, String format) {
        super(poids, express, adresse);
        this.format = format;
    }

    @Override
    protected double affranchirNormal() {
        double montant = format.equals("A4") ? 2.0 : 3.5;
        return montant + poids / 1000.0;
    }

    @Override
    public String toString() {
        return "Lettre\n" + super.toString() + "\tFormat : " + format + "\n";
    }
}

/** Mail sent by companies. */
interface Commercial {
    default String toStringCommercial() {
        return "\tColis Commercial";
    }
}

class Publicite extends Courrier implements Commercial {

    public Publicite(double poids, boolean express, String adresse) {
        super(poids, express, adresse);
    }

    @Override
    protected double affranchirNormal() {
        return poids / 1000.0 * 5.0 * 0.8;
    }

    @Override
    public String toString() {
        return "Publicité\n" + super.toString();
    }
}

class Colis extends Courrier {

    private static final double VOLUME_MAX = 50;

    protected final double volume;

    public Colis(double poids, boolean express, String adresse, double volume) {
        super(poids, express, adresse);
        this.volume = volume;
    }

    @Override
    protected double affranchirNormal() {
        return 0.25 * volume + poids / 1000.0;
    }

    /** A parcel is also invalid when it is too big. */
    @Override
    public boolean valide() {
        return super.valide() && volume <= VOLUME_MAX;
    }

    @Override
    public String toString() {
        return "Colis\n" + super.toString() + "\tVolume : " + volume + " litres\n";
    }
}

/** Commercial parcels get a 15% discount. */
class ColisCommercial extends Colis implements Commercial {

    public ColisCommercial(double poids, boolean express, String adresse, double volume) {
        super(poids, express, adresse, volume);
    }

    @Override
    public double affranchir() {
        return super.affranchir() * 0.85;
    }

    @Override
    public String toString() {
        return super.toString() + toStringCommercial();
    }
}

/** A letter box with a fixed capacity. */
class Boite {

    private final Courrier[] contenu;
    private int nbCourriers = 0;

    public Boite(int capacite) {
        contenu = new Courrier[capacite];
    }

    public double affranchir() {
        double montant = 0.0;
        for (int i = 0; i < nbCourriers; i++) {
            montant += contenu[i].affranchir();
        }
        return montant;
    }

    public int size() {
        return nbCourriers;
    }

    public Courrier getCourrier(int index) {
        if (index >= 0 && index < nbCourriers) {
            return contenu[index];
        }
        return null;
    }

    public int courriersInvalides() {
        int nb = 0;
        for (int i = 0; i < nbCourriers; i++) {
            if (!contenu[i].valide()) {
                nb++;
            }
        }
        return nb;
    }

    public void ajouterCourrier(Courrier courrier) {
        if (nbCourriers < contenu.length) {
            contenu[nbCourriers] = courrier;
            nbCourriers++;
        } else {
            System.out.println("Impossible d'ajouter un nouveau courrier. Boite pleine !");
        }
    }

    public void afficher() {
        for (int i = 0; i < nbCourriers; i++) {
            System.out.println(contenu[i]);
        }
    }
}

public class PosteCommercial {

    public static void main(String[] args) {
        Boite boite = new Boite(30);

        Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
        Publicite pub2 = new Publicite(3000, false, "Ch. de l'Impasse 1, 9999 Nowhere");

        ColisCommercial colisCom1 = new ColisCommercial(7000, false, "Route de la rape 11, 1509 Vucherens", 25);
        ColisCommercial colisCom2 = new ColisCommercial(2500, true, "Route du Rameau 14b, 404 Notfound", 21);

        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colisCom1);
        boite.ajouterCourrier(colisCom2);

        System.out.println("Le montant total d'affranchissement est de " + boite.affranchir());
        boite.afficher();

        System.out.println("La boite contient " + boite.courriersInvalides() + " courriers invalides");
    }
}
