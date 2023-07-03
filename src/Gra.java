import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Gra {
    private ArrayList<String> filmy;


    public String losuj_liste(String plik_z_lista) {
        filmy = new ArrayList();
        File file = new File(plik_z_lista);
        try {
            Scanner skaner = new Scanner(file);
            while (skaner.hasNextLine()) {
                filmy.add(skaner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Taki plik nie istnieje");
        }
        int losowa_liczba = (int) (Math.random() * filmy.size() );
        String wylosowany_film = filmy.get(losowa_liczba);
        return wylosowany_film;
    }

    public String szyfrowanie(String wylosowana_lista) {
        String zaszyfrowana_lista;
        int dlugosc = wylosowana_lista.length();
        zaszyfrowana_lista = wylosowana_lista.replaceAll("[a-zA-Z]","_");
        return zaszyfrowana_lista;
    }


}


