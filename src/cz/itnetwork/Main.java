package cz.itnetwork;

public class Main {
    public static void main(String[] args) {
        Databaze databaze = new Databaze();
        UzivatelskeRozhrani uzivatelskeRozhrani = new UzivatelskeRozhrani();
        /**
         * Hlavní cyklus programu zkontroluje zadanou volbu a reaguje na ní odpovídající akcí
         */
        while (!uzivatelskeRozhrani.getVolba().equals("4")) {
                uzivatelskeRozhrani.vykresliNabidku();
                uzivatelskeRozhrani.setVolba();
                    switch (uzivatelskeRozhrani.getVolba()) {
                        case "1": databaze.pridejPojistence();
                        break;
                        case "2": databaze.vypisPojistence();
                        break;
                        case "3": databaze.vyhledejPojistence(uzivatelskeRozhrani.getJmeno(), uzivatelskeRozhrani.getPrijmeni());
                        break;
                        /**
                         * Ukončí program
                         */
                        case "4":
                            break;
                        default: uzivatelskeRozhrani.opravVolbu();
                    }
                }



    }
}
