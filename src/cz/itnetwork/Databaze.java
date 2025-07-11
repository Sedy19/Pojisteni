package cz.itnetwork;
import java.util.ArrayList;

/**
 * Třída reprezentuje databázi pojištěnců
 */
public class Databaze {
    /**
     * Kolekce pojištěnců
     */
    ArrayList<Pojistenec> pojistenci;
    /**
     * Inicializace uživatelského rozhraní
      */
    private UzivatelskeRozhrani rozhrani = new UzivatelskeRozhrani();
    /**
     * Inicializace nové kolekce
     */
    public Databaze () {
        pojistenci = new ArrayList<>();
    }
    /**
     * Přidá nového pojištěnce
     */
    public void pridejPojistence () {
        pojistenci.add(new Pojistenec(rozhrani.getJmeno(), rozhrani.getPrijmeni(), rozhrani.getTelefonniCislo(), rozhrani.getVek()));
    }

    /**
     * Vypíše všechny pojištěnce
     */
    public void vypisPojistence () {
        for (Pojistenec pojistenec : pojistenci) {
            rozhrani.vypisPojistence(pojistenec);
        }
        rozhrani.cekej();
    }

    /**
     * Vyhledá konkrétního pojištěnce
     * @param jmeno jméno hledaného
     * @param prijmeni příjmení hledaného
     */
    public void vyhledejPojistence (String jmeno, String prijmeni) {
        /**
         * Inicializace kolekce pro objekty odpovídající hledaným parametrům
         */
        ArrayList<Pojistenec> nalezeni = new ArrayList<>();
        for (Pojistenec pojistenec : pojistenci) {
            if ((pojistenec.getJmeno().equals(jmeno)) && pojistenec.getPrijmeni().equals(prijmeni)) {
                nalezeni.add(pojistenec);
            }
        }
        /**
         * Vypíše všechny objekty z kolekce
         */
        for (Pojistenec pojistenec : nalezeni) {
        rozhrani.vypisPojistence(pojistenec);
            }
    }


}
