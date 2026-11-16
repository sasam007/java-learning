package serie07.supermarche;

import java.util.ArrayList;

public class Supermarche {

    public static void main(String[] args) {
        // Items sold in the supermarket (the last argument: is it on sale?)
        Article choufleur = new Article("Chou-fleur extra", 3.50, false);
        Article roman = new Article("Les malheurs de Sophie", 16.50, true);
        Article camembert = new Article("Cremeux 100%MG", 5.80, false);
        Article cdrom = new Article("C++ en trois jours", 48.50, false);
        Article boisson = new Article("Petit-lait", 2.50, true);
        Article petitspois = new Article("Pois surgeles", 4.35, false);
        Article poisson = new Article("Sardines", 6.50, false);
        Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
        Article poires = new Article("Poires Williams", 4.80, false);
        Article cafe = new Article("100% Arabica", 6.90, true);
        Article pain = new Article("Pain d'epautre", 6.90, false);

        Caddie caddie1 = new Caddie();
        Caddie caddie2 = new Caddie();
        Caddie caddie3 = new Caddie();

        // Arguments: register number, initial amount in the register
        Caisse caisse1 = new Caisse(1, 0.0);
        Caisse caisse2 = new Caisse(2, 0.0);

        caddie1.remplir(choufleur, 2);
        caddie1.remplir(cdrom, 1);
        caddie1.remplir(biscuits, 4);
        caddie1.remplir(boisson, 6);
        caddie1.remplir(poisson, 2);

        caddie2.remplir(roman, 1);
        caddie2.remplir(camembert, 1);
        caddie2.remplir(petitspois, 2);
        caddie2.remplir(poires, 2);

        caddie3.remplir(cafe, 2);
        caddie3.remplir(pain, 1);
        caddie3.remplir(camembert, 2);

        caisse1.scanner(caddie1);
        caisse1.scanner(caddie2);
        caisse2.scanner(caddie3);

        caisse1.totalCaisse();
        caisse2.totalCaisse();
    }
}

class Article {
    private final String nom;
    private final double prix;
    private final boolean enAction;

    public Article(String nom, double prix, boolean enAction) {
        this.nom = nom;
        this.prix = prix;
        this.enAction = enAction;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    /** Items on sale are half price. */
    public boolean isEnAction() {
        return enAction;
    }
}

class Achat {
    private final Article article;
    private final int quantite;

    public Achat(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public double calculerPrix() {
        double prix = article.getPrix() * quantite;
        return article.isEnAction() ? prix / 2 : prix;
    }

    public void afficher() {
        System.out.print(article.getNom() + " : ");
        System.out.print(quantite + " x " + article.getPrix() + " = " + calculerPrix());
        System.out.println(article.isEnAction() ? "(1/2 prix)" : "");
    }
}

class Caddie {
    private final ArrayList<Achat> achats = new ArrayList<>();

    public void remplir(Article article, int quantite) {
        achats.add(new Achat(article, quantite));
    }

    public ArrayList<Achat> getAchats() {
        return achats;
    }

    public double total() {
        double total = 0;
        for (Achat achat : achats) {
            total += achat.calculerPrix();
        }
        return total;
    }
}

class Caisse {
    private final int numero;
    private double total;

    public Caisse(int numero, double montantInitial) {
        this.numero = numero;
        this.total = montantInitial;
    }

    public void scanner(Caddie caddie) {
        System.out.println("=========================================");
        System.out.println("14/10/11");
        System.out.println("Caisse numéro " + numero);
        System.out.println();
        for (Achat achat : caddie.getAchats()) {
            achat.afficher();
        }
        System.out.println();
        System.out.println("Total à payer " + caddie.total());
        System.out.println();
        total += caddie.total();
    }

    public void totalCaisse() {
        System.out.println("La caisse " + numero + " a encaisse " + total + " Frs aujourd'hui.");
        System.out.println();
    }
}
