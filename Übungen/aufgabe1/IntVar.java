// IntVar.java

package aufgabe1;

import java.util.Scanner;
//import java.util.*;
// mport static java.lang.System.out;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Abusaleh.
 *@version IntVar.
*/
public final class IntVar {
    private IntVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);
    /**
     * main ist der Startpunkt des Programms.
     * @param args private static final wird nicht verwendet.
    */
    public static void main(final String[] args) {
        /* to-do: Konstanten min und max definieren */
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        /* to-do: Eingabeaufforderung ausgeben */
        System.out.println("Bitte geben Sie die 1.Zahl ein : ");
        if (!EINGABE.hasNextInt()) {
            System.out.println("Eingabe ist ungültig");
        }
        int zahl1 = EINGABE.nextInt();
        System.out.println("Bitte geben Sie die 2.Zahl ein : ");
        if (!EINGABE.hasNextInt()) {
            System.out.println("Eingabe ist ungültig");
        }
        int zahl2 = EINGABE.nextInt();
        long z1 = zahl1;
        long z2 = zahl2;
        /* to-do: zwei ganze Zahlen einlesen */
        System.out.printf("Die eingegebenen Integer Zahlen : %d und %d %n ",
            zahl1, zahl2);
        /* to-do: die beiden Zahlen dezimal, okatal und hexadezimal ausgeben */
        System.out.printf(" Zahlen in Dezimal %d und  %d %n", zahl1, zahl2);
        System.out.printf(" Zahlen in Oktal %o und  %o %n", zahl1, zahl2);
        System.out.printf(" Zahlen in Hexa %x und  %x %n", zahl1, zahl2);
        /* to-do: alle zweistelligen arithmetischen Operatoren ausprobieren */
        System.out.println("Bitte geben Sie den gewünschten Operator ein  : ");
        String verrechnen = EINGABE.next();
        String plus = "+";
        String minus = "-";
        String mult = "*";
        String div = "/";
        String lt = "<";
        String gt = ">";
        String gl = "==";
        String ug = "!=";
        switch(verrechnen) {
        case "+":
            System.out.println(zahl1 + zahl2);
            break;
        case "-":
            System.out.println(zahl1 - zahl2);
            break;
        case "*":
            System.out.println(zahl1 * zahl2);
            break;
        case "/":
            System.out.println(zahl1 / zahl2);
            break;
        case "<":
            System.out.println(zahl1 < zahl2);
            break;
        case ">":
            System.out.println(zahl1 > zahl2);
            break;
        case "==":
            System.out.println(zahl1 == zahl2);
            break;
        case "!=":
            System.out.println(zahl1 != zahl2);
            break;
        default:
            System.out.println("Illegal operator !");
            break;
        }
        long l = z1 * z2;
        System.out.println("Zahl1 * Zahl2 = " + l);
        if (l < min || l > max) {
            System.out.println("Ergebnis kann NICHT als Int dargestellt werdn");
        } else {
            System.out.println("Ergebnis kann als Int dargestellt werden" + l);
        }
    }
}
