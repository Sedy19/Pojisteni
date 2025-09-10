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
     * Chybová hláška pro vypsání při nevalidním zadání vstupu
     */
    private final String chybaZadani = "\nChyba zadání, opakujte zádání ve správném formátu.\n";

    /**
     * Konstruktor pro předání instancí třídy Scanner a třídy Správce pojištění
     * @param scanner instance třídy Scanner
     */
    public UzivatelskeRozhrani(Scanner scanner, SpravcePojistence spravcePojistence) {
        this.scanner = scanner;
        this.spravcePojistence = spravcePojistence;
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
       do {
            vypisDoKonzole("Zadejte jméno pojištěného:");
            jmeno = nactiText();
            if (!spravcePojistence.jeValidniJmeno(jmeno)) {
                vypisDoKonzole(chybaZadani);
            }
       } while (!spravcePojistence.jeValidniJmeno(jmeno));
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
        do {
            vypisDoKonzole("Zadejte příjmení pojištěného:");
            prijmeni = nactiText();
            if (!spravcePojistence.jeValidniJmeno(prijmeni)) {
                vypisDoKonzole(chybaZadani);
            }
        } while (!spravcePojistence.jeValidniJmeno(prijmeni));
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
       do {
           vypisDoKonzole("Zadejte české telefonní číslo:");
           telefonniCislo = nactiText();
           if (!spravcePojistence.jeValidniTelefonniCislo(telefonniCislo)) {
               vypisDoKonzole(chybaZadani);
           }
       } while (!spravcePojistence.jeValidniTelefonniCislo(telefonniCislo));
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
        do {
            vypisDoKonzole("Zadejte věk:");
            vek = nactiCeleCislo();
            if (!spravcePojistence.zvalidujVek(vek)) {
                vypisDoKonzole(chybaZadani);
            }
        } while (!spravcePojistence.zvalidujVek(vek));
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
         vypisDoKonzole("\nPro pokračování stiskněte ENTER...");
        scanner.nextLine();
    }
    /**
     * Vypíše do konzole kolekci pojištěnců a počet nalezených výsledků, v případě že je kolekce prázdná, vypíše, že je prázdná
     */
    public void vypisKolekci (Collection<Pojistenec> pojistenci) {
        if (pojistenci.isEmpty()) {
            System.out.println("Databáze zatím neobsahuje žádná data.");
        } else {
            System.out.printf("\nPočet nalezených výsledků: %d\n", pojistenci.size());
            vypisDoKonzole("----------------------------------------------------\nJméno\t\tPříjmení\t\tVěk\t\tTelefonní číslo\n----------------------------------------------------");
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
            vypisDoKonzole(chybaZadani);
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
            vypisDoKonzole(chybaZadani);
        }
        return celeCislo;
    }
    /**
     * Vypíše do konzole text zadaný v parametru
     * @param text text pro vypsání do konzole
     */
    public void vypisDoKonzole (String text) {
        System.out.println(text);
    }
}
