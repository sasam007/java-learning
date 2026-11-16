package serie08.figuresgeometriques;

public class FiguresGeometriques {

    public static void main(String[] args) {
        RectangleColore rectangle = new RectangleColore(1.2, 3.4, 12.3, 43.2, 4);
        rectangle.affiche();

        Cercle cercle = new Cercle(2.3, 4.5, 12.2);
        cercle.affiche();
    }
}

class Figure {
    private double x;
    private double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void affiche() {
        System.out.println(x + ", " + y);
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
}

class Rectangle extends Figure {

    private double largeur;
    private double longueur;

    public Rectangle(double largeur, double longueur, double x, double y) {
        super(x, y);
        this.largeur = largeur;
        this.longueur = longueur;
    }

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
        System.out.println("Largeur : " + largeur);
        System.out.println("Longueur : " + longueur);
    }
}

class RectangleColore extends Rectangle {
    private final int couleur;

    public RectangleColore(double largeur, double longueur, double x, double y, int couleur) {
        super(largeur, longueur, x, y);
        this.couleur = couleur;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Couleur : " + couleur);
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
        System.out.println("Rayon : " + rayon);
    }

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
