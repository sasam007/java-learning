package serie09.tostringeq;

import java.util.Objects;

public class ToStringEq {

    public static void main(String[] args) {
        System.out.println("Test 1 :");
        Rectangle rect = new Rectangle(12.5, 4.0);
        System.out.println(rect);
        System.out.println();

        System.out.println("Test 2: ");
        // Declared type RectangleColore, actual object RectangleColore
        RectangleColore rect1 = new RectangleColore(12.5, 4.0, "rouge");
        System.out.println(rect1);
        System.out.println();

        System.out.println("Test 3 :");
        // Declared type Rectangle, actual object RectangleColore
        Rectangle rect2 = new RectangleColore(25.0 / 2, 8.0 / 2, new String("rouge"));
        System.out.println(rect2);

        System.out.println(rect1.equals(rect2)); // 1. true: same class, same values
        System.out.println(rect2.equals(rect1)); // 2. true: equals is symmetric
        System.out.println(rect1.equals(null));  // 3. false
        System.out.println(rect.equals(rect1));  // 4. false: different classes
        System.out.println(rect1.equals(rect));  // 5. false: different classes
    }
}

class Rectangle {
    private final double largeur;
    private final double hauteur;

    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    @Override
    public boolean equals(Object objet) {
        if (this == objet) {
            return true;
        }
        if (objet == null || objet.getClass() != getClass()) {
            return false;
        }
        Rectangle autre = (Rectangle) objet;
        return autre.hauteur == hauteur && autre.largeur == largeur;
    }

    // equals and hashCode must always be overridden together
    @Override
    public int hashCode() {
        return Objects.hash(largeur, hauteur);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " : \n   largeur : " + largeur + " \n   hauteur : " + hauteur;
    }
}

class RectangleColore extends Rectangle {
    private final String couleur;

    public RectangleColore(double largeur, double hauteur, String couleur) {
        super(largeur, hauteur);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public boolean equals(Object objet) {
        // super.equals already checks that objet has exactly the same class
        return super.equals(objet) && ((RectangleColore) objet).couleur.equals(couleur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), couleur);
    }

    @Override
    public String toString() {
        return super.toString() + "\n   couleur : " + couleur;
    }
}
