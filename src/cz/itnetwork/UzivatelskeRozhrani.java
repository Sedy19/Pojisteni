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
        String telefonniCislo = scanner.nextLine().trim();
        return telefonniCislo;
    }

    /**
     * Getter věku
     * @return věk
     */
    public int getVek () {
        System.out.println("Zadejte věk:");
        int vek = Integer.parseInt(scanner.nextLine());
        return vek;
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

}
