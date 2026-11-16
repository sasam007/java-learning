package serie09.course;

import java.util.ArrayList;

class Vehicule {

    private final String nom;
    private final double vitesseMax;
    private final int poids;
    private final int carburant;

    public Vehicule(String nom, double vitesseMax, int poids, int carburant) {
        this.nom = nom;
        this.vitesseMax = vitesseMax;
        this.poids = poids;
        this.carburant = carburant;
    }

    public Vehicule() {
        this("Anonyme", 130, 1000, 0);
    }

    @Override
    public String toString() {
        return nom + " -> vitesse max = " + vitesseMax + " km/h, poids = " + poids + " kg";
    }

    public boolean meilleur(Vehicule autre) {
        return getPerformance() > autre.getPerformance();
    }

    public String getNom() {
        return nom;
    }

    public double getVitesseMax() {
        return vitesseMax;
    }

    public int getPoids() {
        return poids;
    }

    public int getCarburant() {
        return carburant;
    }

    /** Speed-to-weight ratio: higher is better. */
    public double getPerformance() {
        return vitesseMax / poids;
    }

    public boolean estDeuxRoues() {
        return false;
    }
}

class Voiture extends Vehicule {

    private final String categorie;

    public Voiture(String nom, double vitesseMax, int poids, int carburant, String categorie) {
        super(nom, vitesseMax, poids, carburant);
        this.categorie = categorie;
    }

    public Voiture(String categorie) {
        super();
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return super.toString() + ", Voiture de " + categorie;
    }

    public String getCategorie() {
        return categorie;
    }
}

class Moto extends Vehicule {

    private final boolean sidecar;

    public Moto(String nom, double vitesseMax, int poids, int carburant, boolean sidecar) {
        super(nom, vitesseMax, poids, carburant);
        this.sidecar = sidecar;
    }

    public Moto(String nom, double vitesseMax, int poids, int carburant) {
        this(nom, vitesseMax, poids, carburant, false);
    }

    public Moto(boolean sidecar) {
        super();
        this.sidecar = sidecar;
    }

    public Moto() {
        this(false);
    }

    @Override
    public String toString() {
        String texte = super.toString() + ", Moto";
        if (sidecar) {
            texte += ", avec sidecar";
        }
        return texte;
    }

    /** A motorbike with a sidecar has three wheels. */
    @Override
    public boolean estDeuxRoues() {
        return !sidecar;
    }
}

abstract class Rallye {
    public abstract boolean check();
}

class GrandPrix extends Rallye {

    private final ArrayList<Vehicule> vehicules = new ArrayList<>();

    public void ajouter(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    /** A Grand Prix is valid when all vehicles are of the same kind (two-wheelers or not). */
    @Override
    public boolean check() {
        if (vehicules.isEmpty()) {
            return false;
        }
        boolean deuxRoues = vehicules.get(0).estDeuxRoues();
        for (Vehicule vehicule : vehicules) {
            if (vehicule.estDeuxRoues() != deuxRoues) {
                return false;
            }
        }
        return true;
    }

    /** Vehicles without enough fuel for all laps are eliminated; the best performer wins. */
    public void run(int tours) {
        if (!check()) {
            System.out.println("Pas de Grand Prix\n");
            return;
        }
        Vehicule gagnant = null;
        for (Vehicule vehicule : vehicules) {
            if (vehicule.getCarburant() - tours > 0
                    && (gagnant == null || vehicule.getPerformance() >= gagnant.getPerformance())) {
                gagnant = vehicule;
            }
        }
        if (gagnant == null) {
            System.out.println("Elimination de tous les vehicules");
        } else {
            System.out.println("Le gagnant du grand prix est :\n" + gagnant);
        }
    }
}

public class Course {

    public static void main(String[] args) {

        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // Arguments: name, speed, weight, fuel
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }

        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // Arguments: name, speed, weight, fuel, sidecar?
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // Arguments: name, speed, weight, fuel, category
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();

        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());

        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
    }
}
