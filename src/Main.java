import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;



public class Main {
    public static void main(String[] args) {

        Gra lista = new Gra();
        
        String haslo = lista.losuj_liste("lista");
        String haslo_zaszyfrowane = lista.szyfrowanie(haslo);
        Scanner odpgracz = new Scanner(System.in);
        int liczba_prob = 0;
        List<Character> zgadniete_litery = new ArrayList<Character>();

        System.out.println("Witaj w grze która polega na zgadywanie filmów");
        System.out.println("Działą ona podobnie do wisielca");
        System.out.println("Każda odgadnieta litera zostaje wpisana w miejsce podkreślnika");
        System.out.println("Każda zła odpowiedź zostaje naliczana (możesz ich miec maksymalnie 10)");
        System.out.println("Hasło: " + haslo_zaszyfrowane);


        while (liczba_prob < 10) {
            boolean poprawna_odpowiedz = false;
            System.out.println(" ");
            System.out.println("Wybierz literę: ");
            String dlugosc_odpowiedzi = odpgracz.nextLine();
            char litera=dlugosc_odpowiedzi.charAt(0);

            if (Character.isLetter(litera)&&dlugosc_odpowiedzi.length()==1) {
                if (zgadniete_litery.contains(litera)) {
                    System.out.println("Już podałeś tę literę. Wybierz inną.");
                    continue;
                }



                for (int i = 0; i < haslo.length(); i++) {

                    if (haslo.charAt(i) == litera) {
                        haslo_zaszyfrowane = haslo_zaszyfrowane.substring(0, i) + litera + haslo_zaszyfrowane.substring(i + 1);
                        poprawna_odpowiedz = true;
                    }
                }
                if (haslo.equals(haslo_zaszyfrowane)) {
                    System.out.println(" ");
                    System.out.println("Wygrałes");
                    System.out.println("Hasło to "+haslo);
                    return;
                }

                if (poprawna_odpowiedz) {
                    System.out.println("Litera " + litera + " znajduje sie w hasle");
                    zgadniete_litery.add(litera);
                    System.out.printf(haslo_zaszyfrowane);
                } else {
                    liczba_prob++;
                    if (liczba_prob == 10) {
                        System.out.println("Koniec gry, przegrałeś");
                        System.out.println("Prawidłowe hasło to " + haslo);
                        return;
                    } else {
                        System.out.println("Nie udalo ci sie, sprobuj ponownie");
                        System.out.println("Twoja liczba błędów to " + liczba_prob);
                        System.out.println("Hasło " + haslo_zaszyfrowane);
                    }


                }


            }
            else {
                System.out.println("Podaj prawdlowa wartosc");
            }

            }


    }
}


