import entity.Nekretnina;
import entity.Oglas;
import main.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OglasTest {

    @Test
    public void testIzracunajUkupnuCenu() {
        Nekretnina nekretnina = new Nekretnina();
        Oglas instance = new Oglas();
        instance.setNekretnina(nekretnina);
        instance.setCena(800.0);
        instance.getNekretnina().setPovrsina(95.0);
        Double expResult = 76000.0;
        Double result = Main.izracunajUkupnuCenu(instance);
        assertEquals(expResult, result);
    }

    @Test
    public void testIzracunajUkupnuCenuFalse() {
        Nekretnina nekretnina = new Nekretnina();
        Oglas instance = new Oglas();
        instance.setNekretnina(nekretnina);
        instance.setCena(800.0);
        instance.getNekretnina().setPovrsina(95.0);
        Double expResult = 80000.0;
        Double result = Main.izracunajUkupnuCenu(instance);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testIzracunajUkupnuCenuZero() {
        Nekretnina nekretnina = new Nekretnina();
        Oglas instance = new Oglas();
        instance.setNekretnina(nekretnina);
        instance.setCena(0.0);
        instance.getNekretnina().setPovrsina(95.0);
        Double expResult = 0.0;
        Double result = Main.izracunajUkupnuCenu(instance);
        assertEquals(expResult, result);
    }
}