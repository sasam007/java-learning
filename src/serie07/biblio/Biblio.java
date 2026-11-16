package serie07.biblio;

import java.util.ArrayList;

class Auteur {
    private final String nom;
    private final boolean prime;

    public Auteur(String nom, boolean prime) {
        this.nom = nom;
        this.prime = prime;
    }

    public String getNom() {
        return nom;
    }

    /** True if the author has won a literary prize. */
    public boolean getPrix() {
        return prime;
    }
}

class Oeuvre {
    private final String titre;
    private final Auteur auteur;
    private final String langue;

    public Oeuvre(String titre, Auteur auteur, String langue) {
        this.titre = titre;
        this.auteur = auteur;
        this.langue = langue;
    }

    public Oeuvre(String titre, Auteur auteur) {
        this(titre, auteur, "francais");
    }

    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public String getLangue() {
        return langue;
    }

    public void afficher() {
        System.out.println(titre + ", " + auteur.getNom() + ", en " + langue);
    }
}

class Exemplaire {
    private final Oeuvre oeuvre;

    public Exemplaire(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
        System.out.print("Nouvel exemplaire -> ");
        oeuvre.afficher();
    }

    public Exemplaire(Exemplaire autre) {
        this.oeuvre = autre.getOeuvre();
        System.out.print("Copie d'un exemplaire de -> ");
        oeuvre.afficher();
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void afficher() {
        System.out.print("Un exemplaire de ");
        oeuvre.afficher();
    }
}

class Bibliotheque {
    private final String nom;
    private final ArrayList<Exemplaire> exemplaires = new ArrayList<>();

    public Bibliotheque(String nom) {
        this.nom = nom;
        System.out.println("La bibliothèque " + nom + " est ouverte !");
    }

    public String getNom() {
        return nom;
    }

    public int getNbExemplaires() {
        return exemplaires.size();
    }

    /** Stores n new copies of a work. */
    public void stocker(Oeuvre oeuvre, int n) {
        for (int i = 0; i < n; i++) {
            exemplaires.add(new Exemplaire(oeuvre));
        }
    }

    public void stocker(Oeuvre oeuvre) {
        stocker(oeuvre, 1);
    }

    public ArrayList<Exemplaire> listerExemplaires(String langue) {
        ArrayList<Exemplaire> resultat = new ArrayList<>();
        for (Exemplaire exemplaire : exemplaires) {
            if (exemplaire.getOeuvre().getLangue().equals(langue)) {
                resultat.add(exemplaire);
            }
        }
        return resultat;
    }

    public ArrayList<Exemplaire> listerExemplaires() {
        return exemplaires;
    }

    public int compterExemplaires(Oeuvre oeuvre) {
        int nb = 0;
        for (Exemplaire exemplaire : exemplaires) {
            if (exemplaire.getOeuvre().equals(oeuvre)) {
                nb++;
            }
        }
        return nb;
    }

    /** Prints the author of each copy whose author has (or has not) won a prize. */
    public void afficherAuteur(boolean prime) {
        for (Exemplaire exemplaire : exemplaires) {
            Auteur auteur = exemplaire.getOeuvre().getAuteur();
            if (auteur.getPrix() == prime) {
                System.out.println(auteur.getNom());
            }
        }
    }

    public void afficherAuteur() {
        afficherAuteur(true);
    }
}

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}
