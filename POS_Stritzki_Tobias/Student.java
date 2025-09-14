public class Student
{
    
    private String name;
    private float kg;
    private float cm;
    private int geburtsjahr;
    private char geschlecht;
  
    public void setName(String name){
        this.name = name;
    }
    public void setGeburtsjahr(int gebjahr){
        this.geburtsjahr = gebjahr;
    }
    public void setKg(float kilogramm){
        this.kg = kilogramm;
    }
    public void setCm(float centimeter){
        this.cm = centimeter;
    }
    public void setGeschlecht(char geschlecht){
        this.geschlecht = geschlecht;
    }
   
    public Student(String name, int geburtsjahr,float kg, float cm, char geschlecht){
        this.setName(name);
        this.setGeburtsjahr(geburtsjahr);
        this.setKg(kg);
        this.setCm(cm);
        this.setGeschlecht(geschlecht);
    }
   
    public void printStudent(){
        System.out.println("Name: " + this.name + " (Geb. " + this.geburtsjahr + ")");
        System.out.println("BMI: " + bmi_rechner(this.kg, this.cm));
        System.out.println("Dein Geschlecht: " + MannOderFrau(this.geschlecht));
        System.out.println("Du bist: " + bmi_werter(this.geschlecht));
    }
   
    public float bmi_rechner(float kg,float cm){
        cm /= 100;
        float ergebnis = (kg / (cm*cm));
        return ergebnis;
    }
 
    public String MannOderFrau(char geschlecht){
        if (geschlecht == 'm'){
            return "Männlich";
        }
        else if (geschlecht == 'f'){
            return "Weiblich";
        }
        else return "Geben Sie 'm' oder 'f'";
    }

    public String bmi_werter(char geschlecht){
        int normal_max_m = 25;
        int normal_min_m = 20;
        int normal_max_f = 24;
        int normal_min_f = 19;
        if (geschlecht == 'm'){
            if (bmi_rechner(this.kg, this.cm) < normal_min_m){
                return "Untergewicht";
            }
            else if (bmi_rechner(this.kg, this.cm) > normal_max_m){
                return "Übergwicht";
            }
            else return "Normal";
        }
        else if (geschlecht == 'f'){
            if (bmi_rechner(this.kg, this.cm) < normal_min_f){
                return "Untergewicht";
            }
            else if (bmi_rechner(this.kg, this.cm) > normal_max_f){
                return "Übergewicht";
            }
            else return "Normal";
        }
        else return "Ein Fehler ist aufgetreten!!!";
    }
}
