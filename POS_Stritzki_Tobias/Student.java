public class Student
{

    private String name;
    private float kg;
    private float cm;
    private int geburtsjahr;
    private char geschlecht;

    private void setName(String name) {
        if  (name.length() < 3) {
            throw new IllegalArgumentException("Der Name muss mindestens 3 Buchstaben haben!!!");
        } else if (name.length() > 50) {
            throw new IllegalArgumentException("Der Name darf nicht mehr als 50 Buchstaben haben!!!");
        }
        this.name = name;
    }

    private void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    private void setKg(float kilogramm) {
        if (kilogramm > 635) {
            throw new IllegalArgumentException("So schwer kannst du nicht sein!");
        } else if (kilogramm < 2) {
            throw new IllegalArgumentException("So leicht kannst du nicht sein!");
        }
        this.kg = kilogramm;
    }

    private void setCm(float centimeter) {
        if (centimeter > 250) {
            throw new IllegalArgumentException("So groß kannst du nicht sein!");
        } else if (centimeter < 50) {
            throw new IllegalArgumentException("So klein kannst du nicht sein!");
        }
        this.cm = centimeter;
    }

    private void setGeschlecht(char geschlecht) {
        if (geschlecht != 'm' && geschlecht != 'w') {
            throw new IllegalArgumentException("Sry, Queers");
        }
        this.geschlecht = geschlecht;
    }

    public Student(String name, int geburtsjahr,float kg, float cm, char geschlecht) {
        this.setName(name);
        this.setGeburtsjahr(geburtsjahr);
        this.setKg(kg);
        this.setCm(cm);
        this.setGeschlecht(geschlecht);
    }

    public void printStudent() {
        System.out.println("Name: " + this.name + " (Geb. " + this.geburtsjahr + ")");
        System.out.println("BMI: " + bmi_rechner(this.kg, this.cm));
        System.out.println("Dein Geschlecht: " + MannOderFrau(this.geschlecht));
        System.out.println("Du bist: " + bmi_werter(this.geschlecht));
    }

    public float bmi_rechner(float kg,float cm) {
        cm /= 100;
        float ergebnis = (kg / (cm*cm));
        return ergebnis;
    }

    public String MannOderFrau(char geschlecht) {
        if (geschlecht == 'm'){
            return "Männlich";
        }
        else {
            return "Weiblich";
        }
    }

    public String bmi_werter(char geschlecht) {
        int normal_max_m = 25;
        int normal_min_m = 20;
        int normal_max_f = 24;
        int normal_min_f = 19;
        if (geschlecht == 'm'){
            if (bmi_rechner(this.kg, this.cm) < normal_min_m){
                return "Iss was du kek";
            }
            else if (bmi_rechner(this.kg, this.cm) > normal_max_m){
                return "Du bist Fett!";
            }
            else return "Normal";
        }
        else if (geschlecht == 'w'){
            if (bmi_rechner(this.kg, this.cm) < normal_min_f){
                return "Iss was du kek";
            }
            else if (bmi_rechner(this.kg, this.cm) > normal_max_f){
                return "Du bist Fett!";
            }
            else return "Normal";
        }
        else return "Ein Fehler ist aufgetreten!!!";
    }
}
