import pojo.Proizvod;
import pojo.Racun;
import main.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {

    @Test
    public void testIzracunajUkupnuCenu(){
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

        Double expResult = 1060.0;
        Double result = Main.izracunajUkupnuCenu(racun);
        assertEquals(expResult, result);
    }

    @Test
    public void testIzracunajUkupnuCenu2(){
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

        Double expResult = 2000.0;
        Double result = Main.izracunajUkupnuCenu(racun);
        assertNotEquals(expResult, result);
    }

    @Test
    public void ukupnoKutija(){
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

        Integer expResult = 2;
        Integer result = Main.ukupnoKutija(racun);
        assertEquals(expResult, result);
    }

    @Test
    public void ukupnoKutija2(){
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

        Integer expResult = 1;
        Integer result = Main.ukupnoKutija(racun);
        assertNotEquals(expResult, result);
    }
}
