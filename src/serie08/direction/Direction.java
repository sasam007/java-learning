package serie08.direction;

import java.time.Year;
import java.util.ArrayList;

public class Direction {
    public static void main(String[] args) {
        EPFLiens epfliens = new EPFLiens();

        epfliens.add(new EleveRegulier("Gaston Peutimide", 2020, "Syscom", 6.0));
        epfliens.add(new EleveRegulier("Yvan Rattrapeut", 2016, "Syscom", 2.5));
        epfliens.add(new EleveEchange("Björn Borgue", 2018, "Info", "KTH"));
        epfliens.add(new Enseignant("Mathieu Matheu", 2015, "LMEP", 10000, "physique"));
        epfliens.add(new Secretaire("Sophie Scribona", 2005, "LMT", 5000));

        epfliens.afficherNbPersonnes();
        epfliens.afficherAnneesMoyen();
        epfliens.listePersonnes();
    }
}

class EPFLiens {
    private final ArrayList<EPFLien> epfliens = new ArrayList<>();

    public void add(EPFLien personne) {
        epfliens.add(personne);
    }

    public void afficherNbPersonnes() {
        int nbEleves = 0;
        for (EPFLien personne : epfliens) {
            if (personne instanceof Eleve) {
                nbEleves++;
            }
        }
        System.out.println("Nombre d'EPFLiens : " + epfliens.size());
        System.out.println("Nombre Eleves : " + nbEleves);
    }

    public void afficherAnneesMoyen() {
        int anneeCourante = Year.now().getValue();
        double total = 0;
        for (EPFLien personne : epfliens) {
            total += anneeCourante - personne.getAnneeArrivee();
        }
        System.out.println("Nombre d'années de fréquentation moyen : " + total / epfliens.size());
    }

    public void listePersonnes() {
        for (EPFLien personne : epfliens) {
            personne.afficher();
            System.out.println();
        }
    }
}

class EPFLien {
    private final String nom;
    private final int anneeArrivee;

    public EPFLien(String nom, int anneeArrivee) {
        this.nom = nom;
        this.anneeArrivee = anneeArrivee;
    }

    public int getAnneeArrivee() {
        return anneeArrivee;
    }

    public void afficher() {
        System.out.println("Nom : " + nom);
        System.out.println("Année d'arrivée : " + anneeArrivee);
    }
}

class Adulte extends EPFLien {
    private final String nomLabo;
    private final double salaire;

    public Adulte(String nom, int anneeArrivee, String nomLabo, double salaire) {
        super(nom, anneeArrivee);
        this.nomLabo = nomLabo;
        this.salaire = salaire;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Nom labo : " + nomLabo);
        System.out.println("Salaire : " + salaire);
    }
}

class Secretaire extends Adulte {
    public Secretaire(String nom, int anneeArrivee, String nomLabo, double salaire) {
        super(nom, anneeArrivee, nomLabo, salaire);
    }
}

class Enseignant extends Adulte {
    private final String section;

    public Enseignant(String nom, int anneeArrivee, String nomLabo, double salaire, String section) {
        super(nom, anneeArrivee, nomLabo, salaire);
        this.section = section;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Section : " + section);
    }
}

class Eleve extends EPFLien {
    private final String section;

    public Eleve(String nom, int anneeArrivee, String section) {
        super(nom, anneeArrivee);
        this.section = section;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Section : " + section);
    }
}

class EleveEchange extends Eleve {
    private final String uniOrigine;

    public EleveEchange(String nom, int anneeArrivee, String section, String uniOrigine) {
        super(nom, anneeArrivee, section);
        this.uniOrigine = uniOrigine;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Université d'origine : " + uniOrigine);
    }
}

class EleveRegulier extends Eleve {
    private final double resultatPropedeutique;

    public EleveRegulier(String nom, int anneeArrivee, String section, double resultatPropedeutique) {
        super(nom, anneeArrivee, section);
        this.resultatPropedeutique = resultatPropedeutique;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Résultat propédeutique I : " + resultatPropedeutique);
    }
}
