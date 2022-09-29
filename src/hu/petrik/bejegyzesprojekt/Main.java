package hu.petrik.bejegyzesprojekt;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    public static void main(String[] args) {
	bejegyzesek.add(new Bejegyzes("Gipsz Jakab", "Valami tartalom"));
	bejegyzesek.add(new Bejegyzes("Gipsz Jakab", "Valami új tartalom"));
    try {
        listahozzaad();
    } catch (InputMismatchException e) {
        System.out.println("Hibás adatot adott meg, nem természetes szám");
    }

    }

    private  static void listahozzaad()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány bejegyzést szeretne felvenni?");
        int db = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < db; i++) {
            System.out.printf("Adja meg a %d bejegyzés szerzőjét:" , i+1);
            String szerzo = sc.nextLine();
            System.out.printf("Adjam eg a %d bejegyzés tartalmát:", i+1);
            String tartalom = sc.nextLine();
            bejegyzesek.add(new Bejegyzes(szerzo, tartalom));
            System.out.println(bejegyzesek);
        }
    }
}