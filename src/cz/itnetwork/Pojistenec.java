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
     * @param jmeno jméno pojištěného
     * @param prijmeni příjmení pojištěného
     * @param telefonniCislo telefonní číslo pojištěného
     * @param vek věk pojištěného
     */
    public Pojistenec (String jmeno, String prijmeni, String telefonniCislo, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefonniCislo = telefonniCislo;
        this. vek = vek;
    }

    /**
     * Getter jména pojištěnce
     * @return jméno pojištěnce typu String
     */
    public String getJmeno() {
        return jmeno;
    }
    /**
     * Getter příjmení pojištěnce
     * @return příjmení pojištěnce typu String
     */
    public String getPrijmeni() {
        return prijmeni;
    }
    /**
     * Getter telefonního čísla pojištěnce
     * @return telefonní číslo pojištěnce typu string
     */
    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    /**
     * Getter věku pojištěnce
     * @return věk pojištěnce typu int
     */
    public int getVek() {
        return vek;
    }
    /**
     * Textová reprezentace třídy
     * @return jméno, příjmení, věk a telefonní číslo pojištěnce oddělené pomocí tabulátorů
     */
    @Override
    public String toString () {
        return getJmeno() + "\t\t" + getPrijmeni() + "\t\t" + getVek() + "\t\t" + getTelefonniCislo();
    }

}
