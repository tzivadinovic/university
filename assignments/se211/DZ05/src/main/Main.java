package main;

import pojo.Proizvod;
import pojo.Racun;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Proizvod proizvod = new Proizvod();
        proizvod.setNaziv("Fanta");
        proizvod.setCena(125.0);
        proizvod.setKolicina(2);
        proizvod.setKutija(1);

        Proizvod proizvod2 = new Proizvod();
        proizvod2.setNaziv("Milka");
        proizvod2.setCena(110.0);
        proizvod2.setKolicina(1);
        proizvod2.setKutija(1);

        Proizvod proizvod3 = new Proizvod();
        proizvod3.setNaziv("Plazma");
        proizvod3.setCena(80.0);
        proizvod3.setKolicina(5);
        proizvod3.setKutija(2);

        Proizvod proizvod4 = new Proizvod();
        proizvod4.setNaziv("Orbit");
        proizvod4.setCena(60.0);
        proizvod4.setKolicina(5);
        proizvod4.setKutija(2);


        Racun racun = new Racun();
        racun.setBrojRacuna("WWNI221C");
        racun.getProizvodList().add(proizvod);
        racun.getProizvodList().add(proizvod2);
        racun.getProizvodList().add(proizvod3);
        racun.getProizvodList().add(proizvod4);
        racun.setUkupnaCena(izracunajUkupnuCenu(racun));
        racun.setBrojKutija(ukupnoKutija(racun));

        System.out.println(izracunajUkupnuCenu(racun));
        System.out.println(ukupnoKutija(racun));
    }

    //ukupna cena jednog racuna izracunata na malo drugaciji nacin
    public static double izracunajUkupnuCenu(Racun racun) {
        return racun.getProizvodList()
                .stream()
                .mapToDouble(pr -> pr.getCena() * pr.getKolicina())
                .sum();
    }

    //filterujemo samo razlicit broj kutije, na kraju je size() = broj kutija u jednom racunu
    public static Integer ukupnoKutija(Racun racun) {
        Set<Integer> unique = new HashSet<>();
        for (Proizvod proizvod : racun.getProizvodList()) {
            unique.add(proizvod.getKutija());
        }
        return unique.size();
    }


}
