package Portfolio1.vessel;

public abstract class Vessel {


    // Anvendelsen af en constructor i abstract class
    // Er det relevant?
    // Alle vessels har currentload og et navn
    // Men vi har ikke brug for at initalizere variabler i
    // I den abstrakte klasse, fordi vi ikke har nogen implementation i vores metoder, som kræver initializering af variabler.
    // Hvilket betyder vi ikke har brug for at initalizere felter før subklassen er lavet.

    double capacity;
    String name;
    double currentLoad = 0;

    public Vessel (double capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }
    
    //default modifier;
    //kan kun tilgås indeni pakken

    //Anvender abstract, da de forskellige klasser har forskellige måde at loade på
    abstract double loadingCargo(int num, String type);

    //roro + container vessel bruger denne metode 
    //tankerens skal nok have sin egen, da vi skal finde loaden fra én af 10 compartments.
    //tankeren bruger derfor methodover loading med compartment nr som parameter
    public double loadFraction() { //constant time
        return currentLoad / capacity;
    }

    //test af void methods?
    // Vi bruger generelt return value til at checke at funktionen returnerer det vi forventer
    // Men void metoder returnerer ikke noget, så hvordan checker vi dem?
    // Mockito kan har en verify() der checker antallet af kald til metoden, hvis den er 0
    // så ingen kald. 

    // Men vi kan også få loadingCargo til at returnere den
    // Men metoden kan også returnere currentsize, der referer til mængden af cargo i vesselen. 
    // Mere sofistikerede metoder kunne have være anvendt, hvis man initaliserede en datatype i loadingCargo?
    // Det kan være en løsning

    // Hvorfor anvender vi en abstract class her?
    // Vi har aldrig brug for intantiere vessel-klassen, så vi anvender ikke en superklasse. 
    // Abstract klasser er ens relativt ens til interfaces 
    // Abstract klasser kan definere fællesadfærd og implementation, men det gør vi ikke her.
    // Det er måske relevant at gøre, da opgaven foreslår vi anvender poly
    /// Skal rettes
}
