package hu.petrik.bejegyzesprojekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static List<Bejegyzes> bejegyzesek = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        bejegyzesek.add(new Bejegyzes("Gipsz Jakab", "Valami tartalom"));
        bejegyzesek.add(new Bejegyzes("Gipsz Jakab", "Valami új tartalom"));
        try {
            listahozzaad();
        } catch (InputMismatchException e) {
            System.out.println("Hibás adatot adott meg, nem természetes szám");
        }
        String fajlNev = "bejegyzesek.csv";
        try {
            beolvas("bejegyzesek.csv");
        } catch (FileNotFoundException e) {
            System.out.printf("A %s file nem található\n", fajlNev);
        } catch (IOException e) {
            System.out.println("Ismeretlen hiba");
        }
        System.out.println(bejegyzesek);
        likeosztas();
    }
        private static void listahozzaad()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Hány bejegyzést szeretne felvenni?");
            int db = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < db; i++) {
                System.out.printf("Adja meg a %d bejegyzés szerzőjét:", i + 1);
                String szerzo = sc.nextLine();
                System.out.printf("Adjam eg a %d bejegyzés tartalmát:", i + 1);
                String tartalom = sc.nextLine();
                bejegyzesek.add(new Bejegyzes(szerzo, tartalom));

            }
        }
        private static void beolvas(String fajlNev) throws IOException {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null && !sor.equals("")) {
                String[] info = sor.split(";");
                Bejegyzes bejegyzes = new Bejegyzes(info[0], info[1]);
                bejegyzesek.add(bejegyzes);
                sor = br.readLine();
            }

        }

        private static void likeosztas() {Random r = new Random();
            for (int i = 0; i < bejegyzesek.size()*20; i++) {
              bejegyzesek.get(r.nextInt(bejegyzesek.size())).like();
            }
        }

    }
