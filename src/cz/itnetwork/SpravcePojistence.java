package cz.itnetwork;

import java.util.Scanner;

public class SpravcePojistence {
    /**
     * Pomocná proměnná pro ověřování validnosti zadaných dat
     */
    private boolean jePlatne;
    /**
     * Scanner pro načtení z konzole
     */
    private Scanner scanner;

    /**
     * Konstruktor pro předání instance třídy scanner
     * @param scanner
     */
    public SpravcePojistence (Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Zkontroluje zda je jméno zadané ve správném formátu
     * @param jmeno
     * @return hodnota true pokud je jméno ve správném formátu
     */
    public boolean jeValidniJmeno(String jmeno) {
        jePlatne = true;
        for (char c : jmeno.toCharArray()) {
            if (!Character.isLetter(c)) {
                jePlatne = false;
                break;
            }
        }
        return (jePlatne && !jmeno.isEmpty());
    }

    /**
     * Zformátuje jméno tak, aby bylo na začátku velké písmeno
     * @param jmeno
     * @return jméno
     */
    public String zformatujJmeno(String jmeno) {
        jmeno = jmeno.substring(0,1).toUpperCase() + jmeno.substring(1);
        return jmeno;
    }

    /**
     * Zkontroluje zadání telefonního čísla
     * @param telefonniCislo
     * @return hodnota true pokud je číslo validní
     */
    public boolean jeValidniTelefonniCislo (String telefonniCislo) {
        jePlatne = true;
        telefonniCislo = telefonniCislo.replace(" ", "");
        if (telefonniCislo.length() != 9) {
            if (!telefonniCislo.startsWith("+420")) {
                jePlatne = false;
            } else if (telefonniCislo.length() != 13) {
                jePlatne = false;
            }
        }
        return (jePlatne && !telefonniCislo.isEmpty());
    }

    /**
     * Zformátuje telefonní číslo do požadovaného formátu s českou předvolbou
     * @param telefonniCislo
     * @return telefonní číslo
     */
    public String zformatujTelefonniCislo (String telefonniCislo) {
        if (!telefonniCislo.startsWith("+420")) {
            telefonniCislo = "+420" + telefonniCislo;
        }
        return telefonniCislo;
    }

    /**
     * Zkontroluje zda zadání odpovídá požadovanému rozmezí
     * @param vek
     * @return hodnota true pokud je věk mezi 0 a 100
     */
    public boolean zvalidujVek (Integer vek) {
        return (vek > 0 && vek < 100);
    }
}