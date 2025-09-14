public class Auto {
    private String farbe;
    private int bauJahrAuto;
    private int aktuellesJahr = 2025;

    //setter
    public void setFarbe(String farbe){
        this.farbe = farbe;
    }

    public void setBauJahr(int bauJahrAuto) {
        this.bauJahrAuto = bauJahrAuto;
    }
    //Ausgabe 
    public void Auto() {
        System.out.println("Farbe: " + farbe);
        System.out.println("Baujahr " + bauJahrAuto);
        System.out.println("Alter des Autos: " + (this.aktuellesJahr - bauJahrAuto));
    }
}