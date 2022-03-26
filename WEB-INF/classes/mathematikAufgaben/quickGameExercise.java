package mathematikAufgaben;

import java.util.Random;

public class quickGameExercise {

    public void generateExercise(){
        Random random = new Random();
        for (int aufgabeNummer = 0; aufgabeNummer < 10; aufgabeNummer++) {
            int operationsZahl = random.nextInt(4)+ 1;
            if (operationsZahl == 1) {
                int wert1 = random.nextInt(50);
                int wert2 = random.nextInt(50);
                int ergebnis = wert1 + wert2;
            } else if (operationsZahl == 2){
                int wert1 = random.nextInt(50);
                int wert2 = random.nextInt(50);
                int ergebnis = wert1 - wert2;
            } else if (operationsZahl == 3) {
                int wert1 = random.nextInt(50);
                int wert2 = random.nextInt(50);
                int ergebnis = wert1 * wert2;
            } else if (operationsZahl == 4) {
                int wert1 = random.nextInt(50);
                int wert2 = random.nextInt(50);
                int ergebnis = wert1 / wert2;
            }
        }
    }
}
