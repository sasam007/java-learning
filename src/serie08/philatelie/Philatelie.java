package serie08.philatelie;

import java.util.ArrayList;

class Timbre {

    // Fixed by the exercise statement so the expected prices stay reproducible
    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    private final String code;
    private final int anneeEmission;
    private final String paysOrigine;
    private final double valeur;

    public Timbre(String code, int anneeEmission, String paysOrigine, double valeur) {
        this.code = code;
        this.anneeEmission = anneeEmission;
        this.paysOrigine = paysOrigine;
        this.valeur = valeur;
    }

    public Timbre(String code, int anneeEmission, String paysOrigine) {
        this(code, anneeEmission, paysOrigine, VALEUR_TIMBRE_DEFAUT);
    }

    public Timbre(String code, int anneeEmission) {
        this(code, anneeEmission, PAYS_DEFAUT);
    }

    public Timbre(String code) {
        this(code, ANNEE_COURANTE);
    }

    public Timbre() {
        this(CODE_DEFAUT);
    }

    public double vente() {
        if (age() < 5) {
            return valeur;
        }
        return valeur * age() * 2.5;
    }

    @Override
    public String toString() {
        return "Timbre de code " + code + " datant de  " + anneeEmission + " (provenance " + paysOrigine
                + ") ayant pour valeur faciale " + valeur + " francs\n";
    }

    public int age() {
        return ANNEE_COURANTE - anneeEmission;
    }

    public String getCode() {
        return code;
    }

    public int getAnnee() {
        return anneeEmission;
    }

    public String getPays() {
        return paysOrigine;
    }

    public double getValeurFaciale() {
        return valeur;
    }
}

class Rare extends Timbre {

    private final int exemplaires;

    public Rare(String code, int anneeEmission, String paysOrigine, double valeur, int exemplaires) {
        super(code, anneeEmission, paysOrigine, valeur);
        this.exemplaires = exemplaires;
    }

    public Rare(String code, int anneeEmission, String paysOrigine, int exemplaires) {
        super(code, anneeEmission, paysOrigine);
        this.exemplaires = exemplaires;
    }

    public Rare(String code, int anneeEmission, int exemplaires) {
        super(code, anneeEmission);
        this.exemplaires = exemplaires;
    }

    public Rare(String code, int exemplaires) {
        super(code);
        this.exemplaires = exemplaires;
    }

    public Rare(int exemplaires) {
        super();
        this.exemplaires = exemplaires;
    }

    public int getExemplaires() {
        return exemplaires;
    }

    @Override
    public String toString() {
        return super.toString() + "Nombre d'exemplaires -> " + exemplaires + " ";
    }

    /** The rarer the stamp, the higher the base price. */
    @Override
    public double vente() {
        double prixBase;
        if (exemplaires < BASE_1_EXEMPLAIRES) {
            prixBase = PRIX_BASE_1;
        } else if (exemplaires < BASE_2_EXEMPLAIRES) {
            prixBase = PRIX_BASE_2;
        } else {
            prixBase = PRIX_BASE_3;
        }
        return prixBase * (age() / 10.0);
    }
}

class Commemoratif extends Timbre {

    public Commemoratif(String code, int anneeEmission, String paysOrigine, double valeur) {
        super(code, anneeEmission, paysOrigine, valeur);
    }

    public Commemoratif(String code, int anneeEmission, String paysOrigine) {
        super(code, anneeEmission, paysOrigine);
    }

    public Commemoratif(String code, int anneeEmission) {
        super(code, anneeEmission);
    }

    public Commemoratif(String code) {
        super(code);
    }

    @Override
    public String toString() {
        return super.toString() + "Timbre celebrant un evenement";
    }

    @Override
    public double vente() {
        return super.vente() * 2;
    }
}

public class Philatelie {

    public static void main(String[] args) {
        // Arguments: name, year of issue, country, face value, number of copies
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // Arguments: name, year of issue, country, face value
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);

        ArrayList<Timbre> collection = new ArrayList<>();
        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}
