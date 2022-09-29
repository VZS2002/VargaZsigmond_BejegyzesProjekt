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

        likeosztas();
        szovegcsere();
        System.out.println(bejegyzesek);
        legtobblike();
        harmincot();
        tizenot();
        rendezes();

        System.out.println(bejegyzesek);
    }

    private static void listahozzaad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány bejegyzést szeretne felvenni?");
        int db = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < db; i++) {
            System.out.printf("Adja meg a %d. bejegyzés szerzőjét:", i + 1);
            String szerzo = sc.nextLine();
            System.out.printf("Adjam eg a %d. bejegyzés tartalmát:", i + 1);
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

    private static void likeosztas() {
        Random r = new Random();
        for (int i = 0; i < bejegyzesek.size() * 20; i++) {
            bejegyzesek.get(r.nextInt(bejegyzesek.size())).like();
        }
    }

    private static void szovegcsere() {
        String bekertszoveg;
        Scanner sc = new Scanner(System.in);
        System.out.println("Írd be az új szöveget");
        bekertszoveg = sc.nextLine();

        bejegyzesek.get(1).setTartalom(bekertszoveg);
    }

    private static void legtobblike() {
        int likeok = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > likeok) {
                likeok = bejegyzesek.get(i).getLikeok();
            }

        }
        System.out.println("A legtöbb likeok száma: " + likeok);
    }

    private static void harmincot() {
        boolean van = false;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > 35) {
                van = true;
            }

        }
        if (van == true) {
            System.out.println("Van 35 likenál többet kapott bejegyzés");
        } else if (van == false) {
            System.out.println("Nincs 35 likenál többet kapott bejegyzés");
        }
    }

    private static void tizenot() {
        int kevesebb = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() < 15) {
                kevesebb++;
            }

        }
        System.out.printf("%d olyan bejegyzés van, amire kevesebb mint 15 like érkezett.", kevesebb);
        System.out.println("");
    }

    private static void rendezes() {

        int a = bejegyzesek.size();

        for (int i = a - 1; i > 0; i--)
            for (int b = 0; b < i; b++)
                if (bejegyzesek.get(b).getLikeok() < bejegyzesek.get(b + 1).getLikeok()) {
                    Bejegyzes bejegyzes = bejegyzesek.get(b);

                    bejegyzesek.set(b, bejegyzesek.get(b + 1));
                    bejegyzesek.set((b + 1), bejegyzes);
                }

        System.out.println("Átrendezett lista:");
    }

}
