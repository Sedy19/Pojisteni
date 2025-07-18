package cz.itnetwork;

public class SpravcePojistence {
    /**
     * Pomocná proměnná pro ověřování validnosti zadaných dat
     */
    private boolean jePlatne;

    /**
     * Zkontroluje zda je jméno zadané ve správném formátu - neobsahuje mezery, číslice ani jiné bílé znaky
     * @param jmeno jméno
     * @return hodnota true pokud je jméno ve správném formátu
     */
    public boolean jeValidniJmeno (String jmeno) {
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
     * @param jmeno jméno pojištěnce
     * @return jméno pojištěnce typu String s prvním písmenem velkým
     */
    public String zformatujJmeno(String jmeno) {
        jmeno = jmeno.substring(0,1).toUpperCase() + jmeno.substring(1);
        return jmeno;
    }

    /**
     * Zkontroluje zadání telefonního čísla - musí mít 9 znaků, v případě zadání předvolby musí být tato česká +420 a číslo musí mít celkem 13 znaků
     * @param telefonniCislo telefonní číslo
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
        return jePlatne;
    }

    /**
     * Zformátuje telefonní číslo do požadovaného formátu s českou předvolbou
     * @param telefonniCislo telefonní číslo
     * @return telefonní číslo typu String ve formátu +420*********
     */
    public String zformatujTelefonniCislo (String telefonniCislo) {
        if (!telefonniCislo.startsWith("+420")) {
            telefonniCislo = "+420" + telefonniCislo;
        }
        return telefonniCislo;
    }

    /**
     * Zkontroluje zda zadání odpovídá požadovanému rozmezí
     * @param vek věk
     * @return hodnota true pokud je věk mezi 0 a 100
     */
    public boolean zvalidujVek (Integer vek) {
        return (vek > 0 && vek < 100);
    }
}