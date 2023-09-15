
package com.mycompany.program;

/**
 *
 * @author Private Pyle
 */
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Private Pyle
 */
public class Evidence {
    //seznam pro ukládání záznamů o pojištěncích
    private LinkedList<Zaznam> zaznamy = new LinkedList<>();
    private Zaznam aktualniZaznam;
    private Scanner scanner = new Scanner(System.in,"windows-1250");
//hlavní metoda programu
    public void Program() {

        String volba = "";
        while (!volba.equals("4")) {
            getMenu();

            if (aktualniZaznam != null) {
                try {
                    aktualniZaznam = zaznamy.getLast();
                } catch (Exception e) {
                    // System.out.println("Bez záznamu");
                }
            }

            System.out.print("Zadejte vaši volbu žádosti: \n");
            System.out.println(spacer);
            volba = scanner.nextLine();

            switch (volba) {
                case "1":
                    setNovyPojistenec(); //přidá nového pojištěnce
                    break;

                case "2":
                    getVsechnyPojistenec(); //vypíše všechny pojištěnce
                    break;

                case "3": //vyhledá pojištěnce, v případě nenalezení vypíše chybovou hlášku
                    if (zaznamy.size() != 0) {
                        getPojistenec();
                    } else {
                        System.out.println("\n Pojištěnec nenalezen \n");
                    }
                    break;

                case "4":
                    System.out.println(" Konec ");
                    break;
            }
        }

    }
String spacer = "______________________________________________________________";
    void getPocetPojistenec() {
        System.out.println(spacer);
        System.out.println("Počet pojištěnců: " + zaznamy.size());
        System.out.println(spacer);
    }

    void getMenu() {
        System.out.println(spacer);
        String vitac = "Dobrý den! Vítejte v elektronické evidenci pojištěných!";
        System.out.println(vitac);
        System.out.println(spacer);
    
        System.out.println("Jaká je vaše žádost?");
        System.out.println(spacer);
        System.out.println("1 - Přidat nového pojištěnce");
        System.out.println("2 - Vypsat všechny pojištěnce");
        System.out.println("3 - Vyhledat pojištěnce");
        System.out.println("4 - Konec programu");
        getPocetPojistenec();
    }
//vytvoří nový záznam pojištěnce
    void setNovyPojistenec() {
       System.out.println(spacer);
        System.out.println("Zadejte jméno:");
        String jmeno = scanner.nextLine();

        System.out.println("Zadejte příjmení:");
        String prijmeni = scanner.nextLine();
System.out.println("Zadejte telefonní číslo bez předvolby:");
      int telCislo;
do {

    telCislo = Integer.parseInt(scanner.nextLine());
    if (String.valueOf(telCislo).length() != 9) {
        System.out.println("Neplatné telefonní číslo!");
        System.out.println("Zadejte znovu.");
    }
} while (String.valueOf(telCislo).length() != 9);
        System.out.println("Zadejte věk: ");
        
     int vek;
do {
    vek = Integer.parseInt(scanner.nextLine());
    if (vek < 0 || vek > 120) {
        System.out.println("Neplatný věk!");
        System.out.println("Zadejte znovu");
    }
} while (vek < 0 || vek > 120);
        Zaznam zaznam = new Zaznam(jmeno, prijmeni, vek, telCislo);
        zaznamy.add(zaznam);
        //přidá záznam
        aktualniZaznam = zaznam;

        System.out.println("Záznam byl vytvořen");
       System.out.println(spacer);
    }

    void getVsechnyPojistenec() {
        getPocetPojistenec();

        System.out.println(spacer);
        System.out.println("V evidenci pojištěných máme:");
        for (int i = 0; i < zaznamy.size(); i++) {
            System.out.println(zaznamy.get(i).toString() + "\n");

        }
        System.out.println("********************************************");
    }

    void getPojistenec() {
        System.out.println("________________________________________________");
        System.out.println("Zadejte jméno nebo příjmení pojištěného:");
        String hledany = scanner.nextLine();

        boolean nalezeno = false;
        for (Zaznam zaznam : zaznamy) {
            if (zaznam.jmeno.equalsIgnoreCase(hledany) || zaznam.prijmeni.equalsIgnoreCase(hledany)) {
                System.out.println("Nalezen pojištěný: " + zaznam.toString());
                nalezeno = true;
            }
        }

        if (!nalezeno) {
            System.out.println("Pojištěnec s tímto jménem nebo příjmením nebyl nalezen.");
        }

        System.out.println(spacer);
}
}
