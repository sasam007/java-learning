package serie09.magic;

import java.util.ArrayList;

public class Magic {
    public static void main(String[] args) {
        Jeu maMain = new Jeu(10);

        maMain.piocher(new Terrain('b'));
        maMain.piocher(new Creature(6, "Golem", 4, 6));
        maMain.piocher(new Sortilege(1, "Croissance Gigantesque",
                "La créature ciblée gagne +3/+3 jusqu'à la fin du tour"));

        System.out.println("Là, j'ai en stock :");
        maMain.afficher();
        maMain.joue();
    }
}

/** A hand of cards. */
class Jeu {
    private final int tailleMax;
    private final ArrayList<Carte> main = new ArrayList<>();

    public Jeu(int tailleMax) {
        System.out.println("On change de main");
        this.tailleMax = tailleMax;
    }

    public void afficher() {
        for (Carte carte : main) {
            System.out.println(carte.afficher());
            System.out.println();
        }
    }

    public void piocher(Carte carte) {
        if (main.size() < tailleMax) {
            main.add(carte);
        } else {
            System.out.println("La main est pleine.");
        }
    }

    /** Plays (and removes) the first card of the hand. */
    public void joue() {
        if (main.isEmpty()) {
            System.out.println("Aucune carte à jouer.");
            return;
        }
        System.out.println("La carte jouée est :");
        System.out.println(main.remove(0).afficher());
    }
}

abstract class Carte {
    private final int cout;

    public Carte(int cout) {
        this.cout = cout;
    }

    public int getCout() {
        return cout;
    }

    public abstract String afficher();
}

class Terrain extends Carte {
    private final char couleur;

    public Terrain(char couleur) {
        super(0);
        this.couleur = couleur;
        System.out.println("Un nouveau terrain.");
    }

    @Override
    public String afficher() {
        return "Terrain \n couleur : " + couleur;
    }
}

class Creature extends Carte {
    private final String nom;
    private final int degats;
    private final int pointsDeVie;

    public Creature(int cout, String nom, int degats, int pointsDeVie) {
        super(cout);
        this.nom = nom;
        this.degats = degats;
        this.pointsDeVie = pointsDeVie;
        System.out.println("Une nouvelle créature.");
    }

    @Override
    public String afficher() {
        return "Creature \n nom : " + nom
                + "\n degat : " + degats
                + "\n pv : " + pointsDeVie;
    }
}

class Sortilege extends Carte {
    private final String nom;
    private final String description;

    public Sortilege(int cout, String nom, String description) {
        super(cout);
        this.nom = nom;
        this.description = description;
        System.out.println("Un sortilège de plus.");
    }

    @Override
    public String afficher() {
        return "Sortilege \n nom : " + nom
                + "\n description : " + description;
    }
}
