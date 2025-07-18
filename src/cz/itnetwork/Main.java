package cz.itnetwork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpravcePojistence spravcePojistence = new SpravcePojistence();
        UzivatelskeRozhrani uzivatelskeRozhrani = new UzivatelskeRozhrani(scanner, spravcePojistence);
        Databaze databaze = new Databaze(uzivatelskeRozhrani);

        // Hlavní cyklus programu zkontroluje zadanou volbu a reaguje na ní odpovídající akcí

        while (!uzivatelskeRozhrani.getVolbaAkce().equals("4")) {
                uzivatelskeRozhrani.vykresliNabidku();
                uzivatelskeRozhrani.setVolbaAkce();
                    switch (uzivatelskeRozhrani.getVolbaAkce()) {
                        case "1": databaze.pridejPojistence();
                        break;
                        case "2": databaze.vypisPojistence();
                        break;
                        case "3": databaze.vyhledejPojistence(uzivatelskeRozhrani.getJmeno(), uzivatelskeRozhrani.getPrijmeni());
                        break;
                        //Ukončí program
                        case "4":
                            break;
                        default: uzivatelskeRozhrani.vypisChybuZadani();
                    }
                }



    }
}
