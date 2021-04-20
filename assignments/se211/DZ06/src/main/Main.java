package main;

import data.TipGradnje;
import data.TipGrejanja;
import entity.Agencija;
import entity.Nekretnina;
import entity.Oglas;

import java.time.LocalDate;

public class Main {



    public static void main(String[] args) {
        Agencija agencija = new Agencija();
        agencija.setNaziv("Frigo");

        Nekretnina nekretnina = new Nekretnina();
        nekretnina.setAgencija(agencija);
        nekretnina.setPovrsina(95.0);
        nekretnina.setBrojSoba(3);
        nekretnina.setLift(true);
        nekretnina.setSprat(2);
        nekretnina.setAdresa("Test");
        nekretnina.setTipGradnje(TipGradnje.NOVOGRADNJA);
        nekretnina.setTipGrejanja(TipGrejanja.CENTRALNO);


        Oglas oglas = new Oglas();
        oglas.setNekretnina(nekretnina);
        oglas.setCena(null);
        oglas.setDatumIzdavanja(LocalDate.now());
        oglas.setAktivan(true);
        oglas.setTrajanjePretplate(60);

        System.out.println(izracunajUkupnuCenu(oglas));



    }

    public static Double izracunajUkupnuCenu(Oglas oglas){
        double ukupnaCena = 0.0;
        ukupnaCena = oglas.getCena() * oglas.getNekretnina().getPovrsina();
        return ukupnaCena;
    }
}
