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
     * @param rozhrani předá instanci uživatelského rozhraní
     */
    public Databaze (UzivatelskeRozhrani rozhrani) {
        this.rozhrani = rozhrani;
        pojistenci = new ArrayList<>();
    }
    /**
     * Přidá nového pojištěnce do databáze
     */
    public void pridejPojistence () {
        pojistenci.add(new Pojistenec(rozhrani.getJmeno(), rozhrani.getPrijmeni(), rozhrani.getTelefonniCislo(), rozhrani.getVek()));
    }
    /**
     * Vyhledá konkrétního pojištěnce podle jména a příjmení
     * @param jmeno jméno hledaného
     * @param prijmeni příjmení hledaného
     * @return nalezeni vrátí kolekci nalezených pojištěnců
     */
    public ArrayList<Pojistenec> vyhledejPojistence (String jmeno, String prijmeni) {
        //Inicializace kolekce pro objekty odpovídající hledaným parametrům
        ArrayList<Pojistenec> nalezeni = new ArrayList<>();
        for (Pojistenec pojistenec : pojistenci) {
            if ((pojistenec.getJmeno().equals(jmeno)) && pojistenec.getPrijmeni().equals(prijmeni)) {
                nalezeni.add(pojistenec);
            }
        }
        return nalezeni;
    }
    /**
     * Vypíše všechny pojištěnce
     * @return pojistenci vrátí celou kolekci pojištěnců
     */
    public ArrayList<Pojistenec> vypisPojistence () {
        return pojistenci;
    }
}
