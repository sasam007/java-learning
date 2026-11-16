package serie07.maniprectangle;

class Rectangle {

    private double largeur;
    private double longueur;

    public Rectangle(double largeur, double longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public double surface() {
        return largeur * longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    /** Negative values are ignored. */
    public void setLargeur(double largeur) {
        if (largeur >= 0) {
            this.largeur = largeur;
        }
    }

    /** Negative values are ignored. */
    public void setLongueur(double longueur) {
        if (longueur >= 0) {
            this.longueur = longueur;
        }
    }
}

public class ManipRectangle {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(1.5, 12.8);
        System.out.println("Largeur " + rect.getLargeur());
        rect.setLargeur(3);
        System.out.println("Largeur " + rect.getLargeur());
    }
}
