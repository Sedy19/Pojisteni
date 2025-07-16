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
    private UzivatelskeRozhrani rozhrani;
    /**
     * Inicializace nové kolekce
     */
    public Databaze (UzivatelskeRozhrani rozhrani) {
        this.rozhrani = rozhrani;
        pojistenci = new ArrayList<>();
    }
    /**
     * Přidá nového pojištěnce
     */
    public void pridejPojistence () {
        pojistenci.add(new Pojistenec(rozhrani.getJmeno(), rozhrani.getPrijmeni(), rozhrani.getTelefonniCislo(), rozhrani.getVek()));
    }
    /**
     * Vypíše všechny pojištěnce, pokud je databáze prázdaná, zavolá metodu jePrázdná z Uživatelského rozhraní
     */
    public void vypisPojistence () {
        if (jePrazdna()) {
            rozhrani.vypisPrazdnouDatabazi();
        }
        else {
            rozhrani.vypisHlavickuDatabaze();
            for (Pojistenec pojistenec : pojistenci) {
                rozhrani.vypisPojistence(pojistenec);
            }
        }
        rozhrani.pozastavProgram();
    }

    /**
     * Zkontroluje, zda je kolekce prázdná
     * @return true
     */
    public boolean jePrazdna () {
        return pojistenci.isEmpty();
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
        if (nalezeni.isEmpty()) {
            rozhrani.vypisPrazdnouDatabazi();
        } else {
            rozhrani.vypisHlavickuDatabaze();
            for (Pojistenec pojistenec : nalezeni) {
            rozhrani.vypisPojistence(pojistenec);
            }
        }
    }
}
