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
     * Getter jména zadaného uživatelem
     * @return jméno
     */
    public String getJmeno (){
        System.out.println("Zadejte jméno pojištěného:");
        jmeno = scanner.nextLine().trim().toUpperCase();
        return jmeno;
    }

    /**
     * Getter příjmení zadaného uživatelem
     * @return příjmení
     */
    public String getPrijmeni (){
        System.out.println("Zadejte příjmení pojištěného:");
        String prijmeni = scanner.nextLine().trim().toUpperCase();
        return prijmeni;
    }

    /**
     * Getter telefonního čísla zadaného uživatelem
     * @return telefonní číslo
     */
    public String getTelefonniCislo () {
        System.out.println("Zadejte telefonní číslo:");
        try{
            telefonniCislo = scanner.nextLine().trim();        }
        catch (Exception ex) {
            jeChyba();
            getTelefonniCislo();
        }
        telefonniCislo = telefonniCislo.replace(" ", "");
        if (telefonniCislo.length() != 9) {
            if (!telefonniCislo.startsWith("+420")) {
                jeChyba();
                getTelefonniCislo();
            } else if (telefonniCislo.length() != 13) {
                jeChyba();
                getTelefonniCislo();
            }
        } else telefonniCislo = "+420" + telefonniCislo;
        return telefonniCislo;
    }

    /**
     * Getter věku, zkontroluje zadání, zda je ve správném formátu, případně si vyžádá jeho opravu
     * @return věk
     */
    public int getVek () {
        System.out.println("Zadejte věk:");
        try{
               vek = Integer.parseInt(scanner.nextLine().trim());
        }
        catch (Exception ex) {
               jeChyba();
               getVek();
        }
        if (vek < 0 || vek > 100) {
                jeChyba();
                getVek();
        }
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
