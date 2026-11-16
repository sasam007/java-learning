package serie07.surfaces;

/*
 * A plot of land made of 3 rectangles and 2 circles, encapsulated in a Terrain
 * object that computes and prints the total area. Fields are private everywhere,
 * and Rectangle and Cercle offer getters and setters.
 */
public class Surfaces {

    public static void main(String[] args) {
        Terrain terrain = new Terrain(1.0, 2.0, 3.0, 4.0, 5, 6, 7, 8);
        terrain.afficherSurfaceTotale();
    }
}

class Terrain {

    private final Rectangle rect1;
    private final Rectangle rect2;
    private final Rectangle rect3;
    private final Cercle cercle1;
    private final Cercle cercle2;

    public Terrain(double l1, double h1, double l2, double h2, double l3, double h3, double r1, double r2) {
        rect1 = new Rectangle(l1, h1);
        rect2 = new Rectangle(l2, h2);
        rect3 = new Rectangle(l3, h3);
        cercle1 = new Cercle(r1);
        cercle2 = new Cercle(r2);
    }

    private double calculerSurfaceTotale() {
        return rect1.calculerSurface() + rect2.calculerSurface() + rect3.calculerSurface()
                + cercle1.calculerSurface() + cercle2.calculerSurface();
    }

    public void afficherSurfaceTotale() {
        System.out.println("La surface totale est " + calculerSurfaceTotale());
    }
}

class Rectangle {

    private double largeur;
    private double hauteur;

    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double calculerSurface() {
        return largeur * hauteur;
    }
}

class Cercle {

    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
    }

    public double calculerSurface() {
        return Math.PI * rayon * rayon;
    }
}
