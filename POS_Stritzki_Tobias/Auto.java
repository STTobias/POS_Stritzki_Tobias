/**
 * Write a description of class Auto here.
 *
 * @author (Tobias S.)
 * @version (9.10.2025)
 */
public class Auto
{
    // Variable
    private String name;
    private double eigengewicht;
    
    private Person fahrer;
    private Person beifahrer;
    private Person rueckbank;
    
    // Auto Objekte
    public Auto(){
        this.setName("n/A");
        this.setEigengewicht(1300); 
    }
    
    public Auto(String name, double eigengewicht){
        this.setName(name);
        this.setEigengewicht(eigengewicht);
    }
    
    // Die Getter
    public String getName(){
        return name;
    }
    
    public double getEigengewicht(){
        return eigengewicht;
    }
    
    // Die Setter
    public void setName(String name){
        if (name == null){
            throw new IllegalArgumentException("Autoname darf nicht null sein");
        }
        this.name = name;
    }
    
    public void setEigengewicht(double eigengewicht){
        if (eigengewicht < 600 || eigengewicht > 3000){
            throw new IllegalArgumentException("Eigengewicht nur zwischen 600 und 3000 möglich");
        }
        this.eigengewicht = eigengewicht;
    }
    
    public boolean personAnwesend(Person person){
        boolean anwesend = false;
        if (person == null){
            throw new IllegalArgumentException("Diese Person ist null!");
        }
        if (person == fahrer || person == beifahrer || person == rueckbank){
            anwesend = true;
        }
        return anwesend;
    }
    
    // Einsteige Funktion
    public void einsteigen(Person person){
        if (person == null){
            throw new IllegalArgumentException("Person kann nicht 'null' sein");
        }
        if (personAnwesend(person) == true){
                throw new IllegalArgumentException("Person ist im Auto! Mach die Augen auf!!!");
            }
        if (this.fahrer == null && personAnwesend(person) == false){
            this.fahrer = person;
            System.out.println(fahrer.getName() + " ist der Fahrer");
        }
        else if (this.beifahrer == null && personAnwesend(person) == false){
            this.beifahrer = person;
            System.out.println(beifahrer.getName() + " ist der Beifahrer");
        }
        else if (this.rueckbank == null && personAnwesend(person) == false){
            this.rueckbank = person;
            System.out.println(rueckbank.getName() + " ist auf der Rückbank");
        }
        else throw new IllegalStateException("Auto ist voll");
    }
    
    // Aussteiger und Aussteige Funktion per Person
    private void aussteigenFahrer(){
        System.out.println(fahrer.getName() + " steigt aus");
        fahrer = null;
    }
    private void aussteigenBeifahrer(){
        System.out.println(beifahrer.getName() + " steigt aus");
        beifahrer = null;
    }
    private void aussteigenRuckbank(){
        System.out.println(rueckbank.getName() + " steigt aus");
        rueckbank = null;
    }
    
    public void aussteigen(Person person){
        if (person == null){
            throw new IllegalArgumentException("Person kann nicht 'null' sein");
        }
        if (this.fahrer == person){
            aussteigenFahrer();
        }
        else if (this.beifahrer == person){
            aussteigenBeifahrer();
        }
        else if (this.rueckbank == person){
            aussteigenRuckbank();
        }
        else throw new IllegalArgumentException("Kein Person im Auto oder Person ist nicht im Auto");
    }
    
    // Austeige Funktion per Name
    public void aussteigen(String name){
        if (name == null){
            throw new IllegalArgumentException("Name darf nicht 'null' sein");
        }
        if (this.fahrer != null && name.equals(fahrer.getName())){
            aussteigenFahrer();
        }
        else if (this.beifahrer != null && name.equals(beifahrer.getName())){
            aussteigenBeifahrer();
        }
        else if (this.rueckbank != null && name.equals(rueckbank.getName())){
            aussteigenRuckbank();
        }
        else throw new IllegalArgumentException("Person mit diesem Namen (" + name + ") ist nicht im Auto");
    }
    
    // Gesamt Gewicht des Autos ausrechnen
    public double gesamtGewicht(){
        double gesamtGewicht = getEigengewicht(); 
        if (this.fahrer != null){
            gesamtGewicht += this.fahrer.getKg();
            System.out.println(gesamtGewicht);
        }
        if (this.beifahrer != null){
            gesamtGewicht += this.beifahrer.getKg();
            System.out.println(gesamtGewicht);
        }
        if (this.rueckbank != null){
            gesamtGewicht += this.rueckbank.getKg();
            System.out.println(gesamtGewicht);
        }
        return gesamtGewicht;
    }
    
    
    public void autoAushalten(){
        if (gesamtGewicht() > 3500){
            throw new IllegalArgumentException("Auto hält das nicht aus");
        }
        System.out.println("Auto hält das Gewicht aus");
    }
    
    // Print Auto Infos
    public void printAuto(){
        System.out.println("Auto: " + name + ", Eigengewicht: " + eigengewicht);
        System.out.println("--------------------------------------------------------");
        
        System.out.print("Fahrer: ");
        if (this.fahrer == null){
            System.out.println("--frei--");
        }
        else this.fahrer.printPerson();
        System.out.println("---------");
        System.out.println("Beifahrer: ");
        if (this.beifahrer == null){
            System.out.println("--frei--");
        }
        else this.beifahrer.printPerson();
        System.out.println("---------");
        System.out.println("Ruckbank: ");
        if (this.rueckbank == null){
            System.out.println("--frei--");
        }
        else this.rueckbank.printPerson();
        System.out.println("---------");
        System.out.println("Das Gesamtgewicht: " + gesamtGewicht());
        autoAushalten();
        System.out.println("--------------------------------------------------------");
    }
}
