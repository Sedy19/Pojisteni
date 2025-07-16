package cz.itnetwork;

/**
 * Tato třída reprezentuje pojištěnou osobu
 */
public class Pojistenec {
    /**
     * Jméno
     */
    private String jmeno;
    /**
     * Příjmení
     */
    private String prijmeni;
    /**
     * Telefonní číslo
     */
    private String telefonniCislo;
    /**
     * Věk
     */
    private int vek;

    /**
     * Konstruktor pojištěnce
     * @param jmeno jméno
     * @param prijmeni příjmení
     * @param telefonniCislo telefonní číslo
     * @param vek věk
     */
    public Pojistenec (String jmeno, String prijmeni, String telefonniCislo, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefonniCislo = telefonniCislo;
        this. vek = vek;
    }

    /**
     * Getter jména
     * @return jméno
     */
    public String getJmeno() {
        return jmeno;
    }
    /**
     * Getter příjmení
     * @return příjmení
     */
    public String getPrijmeni() {
        return prijmeni;
    }
    /**
     * Getter telefonního čísla
     * @return telefonní číslo
     */
    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    /**
     * Getter věku
     * @return věk
     */
    public int getVek() {
        return vek;
    }
    /**
     * Textová reprezentace třídy
     * @return jméno, příjmení, věk a telefonní číslo oddělené tabulátory
     */
    @Override
    public String toString () {
        return getJmeno() + "\t\t" + getPrijmeni() + "\t\t" + getVek() + "\t\t" + getTelefonniCislo();
    }

}
