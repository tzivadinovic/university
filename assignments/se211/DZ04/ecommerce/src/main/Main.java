package main;

import entity.Faktura;
import entity.Kategorija;
import entity.Proizvod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Kategorija kategorija = new Kategorija();
        kategorija.setNaziv("Sok");

        Proizvod proizvod = new Proizvod();
        proizvod.setNaziv("Coca Cola");
        proizvod.setSifra("TR22CC");
        proizvod.setStanje(500);
        proizvod.setCena(125.0);
        proizvod.setKategorija(kategorija);

        Kategorija kategorija2 = new Kategorija();
        kategorija2.setNaziv("Slatkis");

        Proizvod proizvod2 = new Proizvod();
        proizvod2.setNaziv("Milka");
        proizvod2.setSifra("MK991CE");
        proizvod2.setStanje(500);
        proizvod2.setCena(105.0);
        proizvod2.setKategorija(kategorija2);

        List<Proizvod> proizvodi = new ArrayList<>();
        proizvodi.add(proizvod);
        proizvodi.add(proizvod2);

        Faktura faktura = new Faktura();
        faktura.setBrojFakture("VVWCNIS0017");
        faktura.setDatum(LocalDate.now());
        faktura.setUkupnaTezina(50.5);
        faktura.setUkupnoKutija(34);
        faktura.setProizvodi(proizvodi);
        faktura.setUkupnaCena(Faktura.izracunajUkupnuCenu(proizvodi));

        System.out.println(faktura.toString());


    }
}
