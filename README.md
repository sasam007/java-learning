# My Java Learning

Exercises from my first Java course at EPFL (Introduction to Programming in Java I). They trace my progress from a first `Hello, World!` to object-oriented programs with inheritance, abstract classes and interfaces.

## Structure

Each problem set ("série") is a Java package. From series 7 on, each exercise defines several classes, so it gets its own sub-package (`serie07.biblio`, `serie09.course`, …). That way two exercises can both have a class named `Rectangle` or `Voiture` without conflicting.

| Package | Topics | Exercises |
|---|---|---|
| `serie01_02` | Variables, input/output, arithmetic | `HelloWorld`, `Age`, `Fondue`, `RosesBlanches`, `EquationDegre2`, `PolynomeDegre3` |
| `serie03` | Conditions and loops | `Bilan`, `Boucles`, `CombiPermu`, `Intervalle`, `Pair`, `PGCD`, `Rebonds1`, `Rebonds2`, `Tables`, `Velo` |
| `serie04` | Arrays, strings, characters | `Cloture`, `Conversion`, `Crypto`, `MostFrequent`, `Napoleon`, `Palindrome`, `Pascal`, `Premiers`, `Scalaire`, `Unicode` |
| `serie05` | Methods | `Benford`, `Cesure`, `Decharge`, `MasterMind`, `Moyenne`, `NombresAmicaux`, `Operations`, `Paques`, `Rectangle`, `TranchesMax` |
| `serie07` | Classes, objects, encapsulation | `banque1`, `banque2`, `biblio`, `geometrie`, `labo`, `maniprectangle`, `supermarche`, `surfaces` |
| `serie08` | Inheritance | `direction`, `erreur`, `figuresgeometriques`, `gestionvehicules`, `lego`, `philatelie`, `poste` |
| `serie09` | Polymorphism, abstract classes, `equals`/`toString` | `course`, `figuresgeometriques`, `magic`, `surfaces`, `tostringeq`, `voyage` |
| `serie10` | Interfaces | `postecommercial`, `salaires`, `unite` |

Some exercises come back in a later series to show how the design improves: `Banque1` → `Banque2` (from procedural code to classes), `serie07.surfaces` → `serie09.surfaces` (from fixed fields to an abstract `Forme`), `serie08.poste` → `serie10.postecommercial` (adding an interface).

The course was taught in French, so class names, variables and console messages are in French. Comments are in English.

## Running an exercise

Requires Java 17 or newer.

```bash
# Compile everything
javac -encoding UTF-8 -d out $(find src -name "*.java")

# Run one exercise (package + class name)
java -cp out serie03.Velo
java -cp out serie09.course.Course
```

`serie10.unite` is a class design exercise and has no `main` method.
