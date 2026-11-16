package serie09.figuresgeometriques;

/** Same figures as in serie08, now with an abstract Figure and polymorphism. */
public class FiguresGeometriques {

    public static void main(String[] args) {
        Figure[] figures = {
                new RectangleColore(1.2, 3.4, 12.3, 43.2, 4),
                new Cercle(2.3, 4.5, 12.2),
                new Rectangle(1.3, 3.6, 2.3, 56.2)
        };
        for (Figure figure : figures) {
            figure.affiche();
            System.out.println("La surface de cette forme est :" + figure.surface());
        }
    }
}

abstract class Figure {

    private double x; // x coordinate of the center
    private double y; // y coordinate of the center

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void affiche() {
        System.out.println("centre = (" + x + ", " + y + ")");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setCentre(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double surface();
}

class Rectangle extends Figure {

    private double largeur;
    private double longueur;

    public Rectangle(double x, double y, double largeur, double longueur) {
        super(x, y);
        this.largeur = largeur;
        this.longueur = longueur;
    }

    @Override
    public double surface() {
        return largeur * longueur;
    }

    public double getLongueur() {
        return longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Largeur = " + largeur);
        System.out.println("Longueur = " + longueur);
    }
}

class RectangleColore extends Rectangle {

    private final int couleur;

    public RectangleColore(double x, double y, double largeur, double longueur, int couleur) {
        super(x, y, largeur, longueur);
        this.couleur = couleur;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Couleur = " + couleur);
    }
}

class Cercle extends Figure {

    private double rayon;

    public Cercle(double x, double y, double rayon) {
        super(x, y);
        setRayon(rayon);
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("rayon = " + rayon);
    }

    @Override
    public double surface() {
        return Math.PI * rayon * rayon;
    }

    public boolean estInterieur(double x, double y) {
        double dx = x - getX();
        double dy = y - getY();
        return dx * dx + dy * dy <= rayon * rayon;
    }

    public double getRayon() {
        return rayon;
    }

    /** A negative radius is replaced by 0. */
    public void setRayon(double rayon) {
        this.rayon = Math.max(0.0, rayon);
    }
}
