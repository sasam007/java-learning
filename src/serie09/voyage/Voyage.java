package serie09.voyage;

import java.util.ArrayList;

class OptionVoyage {
    private final String nom;
    private final double prixForfaitaire;

    public OptionVoyage(String nom, double prixForfaitaire) {
        this.nom = nom;
        this.prixForfaitaire = prixForfaitaire;
    }

    public String getNom() {
        return nom;
    }

    public double prix() {
        return prixForfaitaire;
    }

    @Override
    public String toString() {
        return getNom() + " -> " + prix() + " CHF";
    }
}

class Sejour extends OptionVoyage {
    private final int nbNuits;
    private final double prixParNuit;

    public Sejour(String nom, double prixForfaitaire, int nbNuits, double prixParNuit) {
        super(nom, prixForfaitaire);
        this.nbNuits = nbNuits;
        this.prixParNuit = prixParNuit;
    }

    @Override
    public double prix() {
        return nbNuits * prixParNuit + super.prix();
    }
}

class Transport extends OptionVoyage {
    public static final int TARIF_LONG = 1500;
    public static final int TARIF_BASE = 200;

    private final boolean trajetLong;

    public Transport(String nom, double prixForfaitaire, boolean trajetLong) {
        super(nom, prixForfaitaire);
        this.trajetLong = trajetLong;
    }

    public Transport(String nom, double prixForfaitaire) {
        this(nom, prixForfaitaire, false);
    }

    @Override
    public double prix() {
        return (trajetLong ? TARIF_LONG : TARIF_BASE) + super.prix();
    }
}

class KitVoyage {
    private final ArrayList<OptionVoyage> options = new ArrayList<>();
    private final String depart;
    private final String destination;

    public KitVoyage(String depart, String destination) {
        this.depart = depart;
        this.destination = destination;
    }

    public double prix() {
        double total = 0;
        for (OptionVoyage option : options) {
            total += option.prix();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder texte = new StringBuilder("Voyage de " + depart + " à " + destination + ", avec pour options : \n");
        for (OptionVoyage option : options) {
            texte.append("- ").append(option).append("\n");
        }
        texte.append("Prix total : ").append(prix()).append(" CHF\n");
        return texte.toString();
    }

    public void ajouterOption(OptionVoyage option) {
        if (option != null) {
            options.add(option);
        }
    }

    public void annuler() {
        options.clear();
    }

    public int getNbOptions() {
        return options.size();
    }
}

public class Voyage {
    public static void main(String[] args) {

        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1);

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night", 50.0);
        System.out.println(option2);
        System.out.println();

        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1);

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2);

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1);
        System.out.println();

        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1);
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2);
        kit2.annuler();
    }
}
