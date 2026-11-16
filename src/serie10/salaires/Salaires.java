package serie10.salaires;

import java.util.ArrayList;

public class Salaires {

    public static void main(String[] args) {
        Personnel personnel = new Personnel();

        personnel.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        personnel.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        personnel.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        personnel.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        personnel.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
        personnel.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));

        personnel.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + personnel.salaireMoyen() + " francs.");
    }
}

abstract class Employe {

    private final String prenom;
    private final String nom;
    private final int age;
    private final String anneeEntree;

    public Employe(String prenom, String nom, int age, String anneeEntree) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.anneeEntree = anneeEntree;
    }

    public abstract int calculerSalaire();

    public String getNom() {
        return prenom + " " + nom;
    }

    public int getAge() {
        return age;
    }

    public String getAnneeEntree() {
        return anneeEntree;
    }
}

/** Employees paid with a share of the turnover they generate. */
abstract class Affaire extends Employe {

    private final int chiffreAffaire;

    public Affaire(String prenom, String nom, int age, String anneeEntree, int chiffreAffaire) {
        super(prenom, nom, age, anneeEntree);
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    public int calculerSalaire() {
        return (int) (chiffreAffaire * 0.2);
    }
}

class Vendeur extends Affaire {

    public Vendeur(String prenom, String nom, int age, String anneeEntree, int chiffreAffaire) {
        super(prenom, nom, age, anneeEntree, chiffreAffaire);
    }

    @Override
    public int calculerSalaire() {
        return super.calculerSalaire() + 400;
    }

    @Override
    public String getNom() {
        return "Le vendeur " + super.getNom();
    }
}

class Representant extends Affaire {

    public Representant(String prenom, String nom, int age, String anneeEntree, int chiffreAffaire) {
        super(prenom, nom, age, anneeEntree, chiffreAffaire);
    }

    @Override
    public int calculerSalaire() {
        return super.calculerSalaire() + 800;
    }

    @Override
    public String getNom() {
        return "Le representant " + super.getNom();
    }
}

class Technicien extends Employe {

    private final int unitesProduites;

    public Technicien(String prenom, String nom, int age, String anneeEntree, int unitesProduites) {
        super(prenom, nom, age, anneeEntree);
        this.unitesProduites = unitesProduites;
    }

    @Override
    public int calculerSalaire() {
        return unitesProduites * 5;
    }

    @Override
    public String getNom() {
        return "Le technicien " + super.getNom();
    }
}

class Manutentionnaire extends Employe {

    private final int heuresTravail;

    public Manutentionnaire(String prenom, String nom, int age, String anneeEntree, int heuresTravail) {
        super(prenom, nom, age, anneeEntree);
        this.heuresTravail = heuresTravail;
    }

    @Override
    public int calculerSalaire() {
        return heuresTravail * 65;
    }

    @Override
    public String getNom() {
        return "Le manutentionnaire " + super.getNom();
    }
}

/** Employees doing dangerous work receive a monthly risk bonus. */
interface ARisque {
    int calculerPrime();
}

class TechnARisque extends Technicien implements ARisque {
    private static final int PRIME = 400;

    public TechnARisque(String prenom, String nom, int age, String anneeEntree, int unitesProduites) {
        super(prenom, nom, age, anneeEntree, unitesProduites);
    }

    @Override
    public int calculerSalaire() {
        return super.calculerSalaire() + calculerPrime();
    }

    @Override
    public int calculerPrime() {
        return PRIME;
    }
}

class ManutARisque extends Manutentionnaire implements ARisque {
    private static final int PRIME = 300;

    public ManutARisque(String prenom, String nom, int age, String anneeEntree, int heuresTravail) {
        super(prenom, nom, age, anneeEntree, heuresTravail);
    }

    @Override
    public int calculerSalaire() {
        return super.calculerSalaire() + calculerPrime();
    }

    @Override
    public int calculerPrime() {
        return PRIME;
    }
}

class Personnel {
    private final ArrayList<Employe> employes = new ArrayList<>();

    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    public void afficherSalaires() {
        for (Employe employe : employes) {
            System.out.println(employe.getNom() + " gagne " + employe.calculerSalaire() + " francs.");
        }
    }

    public double salaireMoyen() {
        if (employes.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Employe employe : employes) {
            total += employe.calculerSalaire();
        }
        return total / employes.size();
    }
}
