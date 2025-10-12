
/**
 * Beschreiben Sie hier die Klasse Quadraht.
 * 
 * @author (Tobias  S.) 
 * @version (1.0)
 */
public class Quadraht
{
    public static void Netherportal(int x){
        for (int zeile = 1 ; zeile <= x ; zeile++){
            for (int spalte = 1 ; spalte <= x; spalte++){
                if (zeile == 1 || spalte == 1 || spalte == x || zeile == x || spalte == zeile){
                    System.out.print("#");
                } else System.out.print(" ");
            }
            System.out.print("\n"); 
        }
    }
}
