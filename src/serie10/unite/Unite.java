package serie10.unite;

/*
 * Class design exercise (no main program): a game unit can combine a race
 * (dwarf, elf) with a role (magician, rider). Java has no multiple inheritance
 * of classes, so races and roles are modeled as interfaces.
 */
class Unite {
    private boolean enVie;
    private int pointsDeVie;
}

class Hache {
}

class Arc {
}

interface Nain {
    void frappeAvecHache();
}

interface Elfe {
    void tireFleche();
}

interface Magicien {
    void lanceSort();
}

interface Cavalier {
    void chevauche();
}

class NainMagicien extends Unite implements Nain, Magicien {
    private int taille;
    private Hache hache;

    @Override
    public void frappeAvecHache() {
    }

    @Override
    public void lanceSort() {
    }
}

class NainCavalier extends Unite implements Nain, Cavalier {
    private int taille;
    private Hache hache;

    @Override
    public void frappeAvecHache() {
    }

    @Override
    public void chevauche() {
    }
}

class ElfeMagicien extends Unite implements Elfe, Magicien {
    private int poids;
    private Arc arc;

    @Override
    public void tireFleche() {
    }

    @Override
    public void lanceSort() {
    }
}

class ElfeCavalier extends Unite implements Elfe, Cavalier {
    private int poids;
    private Arc arc;

    @Override
    public void tireFleche() {
    }

    @Override
    public void chevauche() {
    }
}
