package cz.itnetwork;
import java.util.Collection;
import java.util.Scanner;
/**
 * Třída pro komunikaci s uživatelem
 */
public class UzivatelskeRozhrani {
    /**
     * Volba z nabídky příkazů
     */
    private String volba = "0";
    /**
     * Jméno
     */
    private String jmeno;
    /**
     * Příjmení
     */
    private String prijmeni;
    /**
     * Věk
     */
    private int vek;
    /**
     * Telefonní číslo
     */
    private String telefonniCislo;
    /**
     * Scanner pro načítání hodnot z konzole
     */
    private Scanner scanner;
    /**
     * Inicializace instance třídy SprávcePojištěnce
     */
    private SpravcePojistence spravcePojistence;
    /**
     * Pomocná proměnná pro načtení textového řetězce
     */
    private String vstupniText;
    /**
     * Pomocná proměnná pro načtení celého čísla
     */
    private Integer celeCislo;

    /**
     * Konstruktor pro předání instancí třídy Scanner a třídy Správce pojištění
     * @param scanner instance třídy Scanner
     */
    public UzivatelskeRozhrani(Scanner scanner, SpravcePojistence spravcePojistence) {
        this.scanner = scanner;
        this.spravcePojistence = spravcePojistence;
    }
    /**
     * Vykreslí do konzole hlavní nabídku příkazů
     */
    public void vykresliNabidku (){
        System.out.println("------------------------\nEvidence pojištěných\n------------------------\n");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - přidat nového pojištěného\n2 - vypsat všechny pojištěné\n3 - vyhledat pojištěného\n4 - konec");
    }
    /**
     * Setter čísla zvolené akce z hlavní nabídky
     */
    public void setVolbaAkce() {
        this.volba = nactiText();
    }
    /**
     * Getter čísla zvolené akce z hlavní nabídky
     * @return vrátí číslo vybraného příkazu ve formátu String
     */
    public String getVolbaAkce() {
        return volba;
    }
    /**
     * Setter jména zadaného uživatelem, zkontroluje formát zadání, případně si vyžádá nové zadání od uživatele
     */
    public void setJmeno (){
       while (true) {
            System.out.println("Zadejte jméno pojištěného:");
            jmeno = nactiText();
            if (!spravcePojistence.jeValidniJmeno(jmeno)) {
                vypisChybuZadani();
            }
            else  {
                break;
            }
       }
    }
    /**
     * Getter jména zformátuje jméno do požadovaného tvaru
     * @return jméno pojištěnce ve formátu String s velkým písmenem na začátku
     */
    public String getJmeno () {
        setJmeno();
        jmeno = spravcePojistence.zformatujJmeno(jmeno);
        return jmeno;
    }

    /**
     * Setter příjmení zadaného uživatelem, zkontroluje formát zadání, případně si vyžádá nové zadání od uživatele
     */
    public void setPrijmeni () {
        while (true) {
            System.out.println("Zadejte příjmení pojištěného:");
            prijmeni = nactiText();
            if (!spravcePojistence.jeValidniJmeno(prijmeni)) {
                vypisChybuZadani();
            } else {
                break;
            }
        }
    }

    /**
     * Getter příjmení zformátuje příjmení do požadovaného tvaru
     * @return příjmení ve formátu String s velkým prvním písmenem
     */
    public String getPrijmeni () {
        setPrijmeni();
        prijmeni = spravcePojistence.zformatujJmeno(prijmeni);
        return prijmeni;
    }

    /**
     * Setter telefonního čísla, zkontroluje formát telefonního čísla, případně vyžádá nové zadání
     */
    public void setTelefonniCislo () {
       while (true) {
           System.out.println("Zadejte telefonní číslo:");
           telefonniCislo = nactiText();
           if (!spravcePojistence.jeValidniTelefonniCislo(telefonniCislo)) {
                vypisChybuZadani();
           }
           else {
               break;
           }
       }
    }

    /**
     * Getter telefonního čísla, zformátuje číslo do požadováného formátu
     * @return telefonní číslo typu String ve formátu s českou předvolbou +420*********
     */
    public String getTelefonniCislo() {
        setTelefonniCislo();
        telefonniCislo = spravcePojistence.zformatujTelefonniCislo(telefonniCislo);
        return telefonniCislo;
    }

    /**
     * Getter věku, zkontroluje zadání, zda je ve správném formátu, případně si vyžádá jeho opravu
     */
    public void setVek () {
        while (true) {
            System.out.println("Zadejte věk:");
            vek = nactiCeleCislo();
            if (!spravcePojistence.zvalidujVek(vek)) {
                vypisChybuZadani();
            }
            else {
                break;
            }
        }
    }

    /**
     * Getter věku pojištěnce
     * @return věk pojištěnce v typu int
     */
    public int getVek () {
        setVek();
        return vek;
    }
    /**
     * Vypíše chybovou hlášku při špatném zadání uživatelem a vyzve k novému zadání
     */
    public void vypisChybuZadani() {
        System.out.println("Chyba zadání, opakujte zádání ve správném formátu.");
    }
    /**
     * Vypíše pojištěnce
     * @param pojistenec pojištěná osoba z databáze
     */
    public void vypisPojistence (Pojistenec pojistenec) {
        System.out.println(pojistenec);
    }
    /**
     * Zastaví program dokud uživatel nestiskne Enter
     */
    public void pozastavProgram() {
        System.out.println("\nPro pokračování stiskněte ENTER...");
        scanner.nextLine();
    }
    /**
     * Vypíše do konzole kolekci pojištěnců a počet nalezených výsledků, v případě že je kolekce prázdná, vypíše, že je prázdná
     */
    public void vypisKolekci (Collection<Pojistenec> pojistenci) {
        if (pojistenci.isEmpty()) {
            System.out.println("Databáze zatím neobsahuje žádná data.");
        } else {
            System.out.printf("\nPočet nalezených výsledků: %d\n\n", pojistenci.size());
            vypisHlavickuDatabaze();
            for (Pojistenec pojistenec : pojistenci) {
                vypisPojistence(pojistenec);
            }
        }
    }
    /**
     * Načte z konzole textový řetězec
     * @return textový řetězec zadaný uživatelem
     */
    public String nactiText () {
        try {
            vstupniText = scanner.nextLine().trim().toLowerCase();
        } catch (Exception ex) {
            vypisChybuZadani();
        }
        return vstupniText;
    }
    /**
     * Načte z konzole celé číslo
     * @return celé číslo zadné uživatelem
     */
    public Integer nactiCeleCislo () {
        try{
            celeCislo = Integer.parseInt(scanner.nextLine().trim());
        }
        catch (Exception ex) {
            vypisChybuZadani();
        }
        return celeCislo;
    }

    /**
     * Vypíše do konzole hlavičku databáze
     */
    public void vypisHlavickuDatabaze () {
        System.out.println("----------------------------------------------------\nJméno\t\tPříjmení\t\tVěk\t\tTelefonní číslo\n----------------------------------------------------");
    }
}
