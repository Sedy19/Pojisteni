package cz.itnetwork;
import java.util.Scanner;
/**
 * Třída pro komunikaci s uživatelem
 */
public class UzivatelskeRozhrani {
    /**
     * Volba z nabídky příkazů
     */
    private String volba = "0";
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefonniCislo;
    /**
     * Iniciace třídy Scanner pro přijímání vstupů od uživatele
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * Vykreslí do konzole hlavní nabídku příkazů
     */
    public void vykresliNabidku (){
        System.out.println("------------------------\nEvidence pojištěných\n------------------------\n");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - přidat nového pojištěného\n2 - vypsat všechny pojištěné\n3 - vyhledat pojištěného\n4 - konec");
    }

    /**
     * Setter čísla volby
     */
    public void setVolba () {
        this.volba = scanner.nextLine();
    }
    /**
     * Getter čísla volby
     * @return vrátí číslo vybraného příkazu
     */
    public String getVolba() {
        return volba;
    }

    /**
     * Vyžádá nové zadání vybraného příkazu, pokud byl zadán chybně
     */
    public void opravVolbu () {
        System.out.println("Chyba zadání, prosím zadejte znovu.");
    }

    /**
     * Setter jména zadaného uživatelem, zkontroluje formát zadání, případně si vyžádá nové zadání od uživatele
     */
    public void setJmeno (){
        System.out.println("Zadejte jméno pojištěného:");
        try{
            jmeno = scanner.nextLine().trim().toLowerCase();
        }
        catch (Exception ex) {
            jeChyba();
            setJmeno();
        }
        for (char c : jmeno.toCharArray()) {
            if (!Character.isLetter(c)) {
                jeChyba();
                setJmeno();
            }
        }
    }

    /**
     * Getter jména, nahradí první písmeno velkým písmenem
     * @return jméno
     */
    public String getJmeno () {
        setJmeno();
        jmeno = jmeno.substring(0,1).toUpperCase() + jmeno.substring(1);
        return jmeno;
    }

    /**
     * Setter příjmení zadaného uživatelem, zkontroluje formát zadání, případně si vyžádá nové zadání od uživatele
     */
    public void setPrijmeni (){
        System.out.println("Zadejte příjmení pojištěného:");
        try{
            prijmeni = scanner.nextLine().trim().toLowerCase();
        }
        catch (Exception ex) {
            jeChyba();
            setPrijmeni();
        }
        for (char c : prijmeni.toCharArray()) {
            if (!Character.isLetter(c)) {
                jeChyba();
                setPrijmeni();
            }
        }
    }

    /**
     * Getter příjmení, nahradí první písmeno velkým písmenem
     * @return příjmení
     */
    public String getPrijmeni () {
        setPrijmeni();
        prijmeni = prijmeni.substring(0, 1).toUpperCase() + prijmeni.substring(1);
        return prijmeni;
    }

    /**
     * Getter telefonního čísla zadaného uživatelem
     * @return telefonní číslo
     */
    public void setTelefonniCislo () {
        System.out.println("Zadejte telefonní číslo:");
        try{
            telefonniCislo = scanner.nextLine().trim();
        }
        catch (Exception ex) {
            jeChyba();
            setTelefonniCislo();
        }
        telefonniCislo = telefonniCislo.replace(" ", "");
        if (telefonniCislo.length() != 9) {
            if (!telefonniCislo.startsWith("+420")) {
                jeChyba();
                setTelefonniCislo();
            } else if (telefonniCislo.length() != 13) {
                jeChyba();
                setTelefonniCislo();
            }
        } else telefonniCislo = "+420" + telefonniCislo;
    }

    public String getTelefonniCislo() {
        setTelefonniCislo();
        return telefonniCislo;
    }

    /**
     * Getter věku, zkontroluje zadání, zda je ve správném formátu, případně si vyžádá jeho opravu
     * @return věk
     */
    public void setVek () {
        System.out.println("Zadejte věk:");
        try{
               vek = Integer.parseInt(scanner.nextLine().trim());
        }
        catch (Exception ex) {
               jeChyba();
               setVek();
        }
        if (vek < 0 || vek > 100) {
                jeChyba();
                setVek();
        }
    }
    public int getVek () {
        setVek();
        return vek;
    }
    /**
     * Vypíše chybovou hlášku při špatném zadání
     * @return
     */
    public boolean jeChyba () {
        System.out.println("Chyba zadání, opakujte zádání ve správném formátu.");
        return true;
    }
    /**
     * Vypíše pojištěnce
     * @param pojistenec
     */
    public void vypisPojistence (Pojistenec pojistenec) {
        System.out.println(pojistenec);
    }

    /**
     * Zastaví program dokud uživatel nestiskne Enter
     */
    public void cekej () {
        System.out.println("\nPro pokračování stiskněte ENTER...");
        scanner.nextLine();
    }
    /**
     * Vypíše do konzole, že databáze neobsahuje žádná data
     * @return true
     */
    public void jePrazdna () {
        System.out.println("Databáze zatím neobsahuje žádná data.");
    }
}
