package cz.itnetwork;
import java.util.Scanner;

/**
 * Třída pro komunikaci s uživatelem
 */
public class UzivatelskeRozhrani {
    /**
     * Volba z nabídky příkazů
     */
    private int volba;
    Scanner scanner = new Scanner(System.in);
    /**
     * Vykreslí do konzole hlavní nabídku příkazů a přijme číslo dalšího příkazu
     */
    public void vykresliNabidku (){
        System.out.println("------------------------\nEvidence pojištěných\n------------------------\n");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - přidat nového pojištěného\n2 - vypsat všechny pojištěné\n3 - vyhledat pojištěného\n4 - konec");
        this.volba = Integer.parseInt(scanner.nextLine());
    }

    /**
     * Getter čísla volby
     * @return vrátí číslo vybraného příkazu
     */
    public int getVolba() {
        return volba;
    }
}
