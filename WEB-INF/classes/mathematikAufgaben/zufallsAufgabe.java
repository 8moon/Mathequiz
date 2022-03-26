package mathematikAufgaben;

import java.util.Random;

public class zufallsAufgabe {
    Random random = new Random();

//Anzahl der richtigen Ergebnisse
//int anzahlRichtigeErgebnisse =0;

    public static void main(String[] args) {
        new zufallsAufgabe().plusMinus("leicht", 10);
        new zufallsAufgabe().plusMinus("mittel", 10);
        new zufallsAufgabe().plusMinus("schwer", 10);
        new zufallsAufgabe().malGeteilt("leicht", 10);
        new zufallsAufgabe().malGeteilt("mittel", 10);
        new zufallsAufgabe().malGeteilt("schwer", 10);
        new zufallsAufgabe().plusMinusMalGeteilt("leicht", 10);
        new zufallsAufgabe().plusMinusMalGeteilt("mittel", 10);
        new zufallsAufgabe().plusMinusMalGeteilt("schwer", 10);
    }

    public void plusMinus(String schwierigkeit, int anzahlAufgaben) {
        for (int aufgabeNummer = 0; aufgabeNummer < anzahlAufgaben; aufgabeNummer++) {
            int operationsZahl = random.nextInt(2)+ 1;
            if (schwierigkeit.equals("leicht")) {
                if (operationsZahl == 1) {
                    int wert1 = random.nextInt(10);
                    int wert2 = random.nextInt(10);
                    int ergebnis = wert1 + wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "+" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                } else if (operationsZahl == 2){
                    int wert1 = random.nextInt(10);
                    int wert2 = random.nextInt(10);
                    int ergebnis = wert1 - wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "-" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                }
            } else if (schwierigkeit.equals("mittel")) {
                if (operationsZahl == 1) {
                    int wert1 = random.nextInt(100);
                    int wert2 = random.nextInt(100);
                    int ergebnis = wert1 + wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "+" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                } else if (operationsZahl == 2){
                    int wert1 = random.nextInt(100);
                    int wert2 = random.nextInt(100);
                    int ergebnis = wert1 - wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "-" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                }
            } else if (schwierigkeit.equals("schwer")) {
                if (operationsZahl == 1) {
                    int wert1 = random.nextInt(100)+(-100);
                    int wert2 = random.nextInt(100)+(-100);
                    int ergebnis = wert1 + wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "+" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                } else if (operationsZahl == 2){
                    int wert1 = random.nextInt(100)+(-100);
                    int wert2 = random.nextInt(100)+(-100);
                    int ergebnis = wert1 - wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "-" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                }
            }
        }
    }

    public void malGeteilt(String schwierigkeit, int anzahlAufgaben) {
        for (int aufgabeNummer = 0; aufgabeNummer < anzahlAufgaben; aufgabeNummer++) {
            int operationsZahl = random.nextInt(2)+ 1;
            if (schwierigkeit.equals("leicht")) {
                if (operationsZahl == 1) {
                    int wert1 = random.nextInt(10);
                    int wert2 = random.nextInt(10);
                    int ergebnis = wert1 * wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "*" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                } else if (operationsZahl == 2){
                    int wert1 = random.nextInt(10);
                    int wert2 = random.nextInt(10);
                    int ergebnis = wert1 / wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "/" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                }
            } else if (schwierigkeit.equals("mittel")) {
                if (operationsZahl == 1) {
                    int wert1 = random.nextInt(100);
                    int wert2 = random.nextInt(100);
                    int ergebnis = wert1 * wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "*" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                } else if (operationsZahl == 2){
                    int wert1 = random.nextInt(100);
                    int wert2 = random.nextInt(100);
                    int ergebnis = wert1 / wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "/" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                }
            } else if (schwierigkeit.equals("schwer")) {
                if (operationsZahl == 1) {
                    int wert1 = random.nextInt(100)+(-100);
                    int wert2 = random.nextInt(100)+(-100);
                    int ergebnis = wert1 * wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "*" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                } else if (operationsZahl == 2){
                    int wert1 = random.nextInt(100)+(-100);
                    int wert2 = random.nextInt(100)+(-100);
                    int ergebnis = wert1 / wert2;
                    System.out.println("Aufgabe lautet: " + wert1 + "/" + wert2);
                    System.out.println("Richtiges ergebnis ist: " + ergebnis);
                }
            }
        }
    }

    public void plusMinusMalGeteilt(String schwierigkeit, int anzahlAuzgaben) {
        new zufallsAufgabe().plusMinus(schwierigkeit, anzahlAuzgaben/2);
        new zufallsAufgabe().malGeteilt(schwierigkeit, anzahlAuzgaben/2);
    }

}