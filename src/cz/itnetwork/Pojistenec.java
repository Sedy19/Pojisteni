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
     * @param jmeno
     * @param prijmeni
     * @param telefonniCislo
     * @param vek
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
     * Setter jména
     * @param jmeno
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Getter příjmení
     * @return příjmení
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Setter příjmení
     * @param prijmeni
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * Getter telefonního čísla
     * @return telefonní číslo
     */
    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    /**
     * Setter telefonního čísla
     * @param telefonniCislo
     */
    public void setTelefonniCislo(String telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }

    /**
     * Getter věku
     * @return věk
     */
    public int getVek() {
        return vek;
    }

    /**
     * Setter věku
     * @param vek
     */
    public void setVek(int vek) {
        this.vek = vek;
    }

    /**
     * Textová reprezentace třídy
     * @return jméno, příjmení, věk a telefonní číslo oddělené tabulátory
     */
    @Override
    public String toString () {
        return getJmeno() + "\t" + getPrijmeni() + "\t" + getVek() + "\t" + getTelefonniCislo();
    }

}
