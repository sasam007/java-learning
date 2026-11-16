package serie08.lego;

import java.util.ArrayList;

class Piece {
    private final String nom;

    public Piece(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}

class Composant {
    private final Piece piece;
    private final int quantite;

    public Composant(Piece piece, int quantite) {
        this.piece = piece;
        this.quantite = quantite;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getQuantite() {
        return quantite;
    }
}

class Simple extends Piece {
    private static final String SANS_ORIENTATION = "aucune";

    private final String orientation;

    public Simple(String nom, String orientation) {
        super(nom);
        this.orientation = orientation;
    }

    public Simple(String nom) {
        this(nom, SANS_ORIENTATION);
    }

    public String getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        if (orientation.equals(SANS_ORIENTATION)) {
            return super.toString();
        }
        return super.toString() + " " + orientation;
    }
}

class Composee extends Piece {
    private final int tailleMax;
    private final ArrayList<Piece> pieces = new ArrayList<>();

    public Composee(String nom, int tailleMax) {
        super(nom);
        this.tailleMax = tailleMax;
    }

    public int taille() {
        return pieces.size();
    }

    public int tailleMax() {
        return tailleMax;
    }

    public void construire(Piece piece) {
        if (taille() < tailleMax()) {
            pieces.add(piece);
        } else {
            System.out.println("Construction impossible");
        }
    }

    @Override
    public String toString() {
        StringBuilder texte = new StringBuilder(getNom() + " (");
        for (int i = 0; i < pieces.size(); i++) {
            if (i > 0) {
                texte.append(",");
            }
            texte.append(pieces.get(i));
        }
        return texte.append(")").toString();
    }
}

class Construction {
    private final int tailleMax;
    private final ArrayList<Composant> composants = new ArrayList<>();

    public Construction(int tailleMax) {
        this.tailleMax = tailleMax;
    }

    public int taille() {
        return composants.size();
    }

    public int tailleMax() {
        return tailleMax;
    }

    public void ajouterComposant(Piece piece, int quantite) {
        if (taille() < tailleMax()) {
            composants.add(new Composant(piece, quantite));
        } else {
            System.out.println("Ajout de composant impossible");
        }
    }

    @Override
    public String toString() {
        StringBuilder texte = new StringBuilder();
        for (Composant composant : composants) {
            texte.append(composant.getPiece()).append(" (quantite ").append(composant.getQuantite()).append(")\n");
        }
        return texte.toString();
    }
}

public class Lego {

    public static void main(String[] args) {
        // A construction set of up to 10 components
        Construction maison = new Construction(10);

        // First component: 59 standard bricks (no orientation by default)
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // A door made of 2 simple pieces, both oriented left
        Composee porte = new Composee("porte", 2);
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));
        maison.ajouterComposant(porte, 1);

        // A window made of 3 simple pieces
        Composee fenetre = new Composee("fenetre", 3);
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));
        maison.ajouterComposant(fenetre, 2);

        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
