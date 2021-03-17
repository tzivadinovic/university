package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Faktura {
    private String brojFakture;
    private LocalDate datum;
    private Integer ukupnoKutija;
    private Double ukupnaTezina;
    private Double ukupnaCena;
    private List<Proizvod> proizvodi = new ArrayList<>();

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public Faktura() {
    }

    public String getBrojFakture() {
        return brojFakture;
    }

    public void setBrojFakture(String brojFakture) {
        this.brojFakture = brojFakture;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Integer getUkupnoKutija() {
        return ukupnoKutija;
    }

    public void setUkupnoKutija(Integer ukupnoKutija) {
        this.ukupnoKutija = ukupnoKutija;
    }

    public Double getUkupnaTezina() {
        return ukupnaTezina;
    }

    public void setUkupnaTezina(Double ukupnaTezina) {
        this.ukupnaTezina = ukupnaTezina;
    }

    public Double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(Double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    @Override
    public String toString() {
        return "Faktura: " + brojFakture + "\n" + "Datum: " + datum + "\n" + "Ukupno kutija: " + ukupnoKutija + "\n" + "Ukupna težina: " + ukupnaTezina + "\n" + "Ukupna cena: " + ukupnaCena + "RSD" + "\n" + ", proizvodi={" + proizvodi + '}';
    }

    public static Double izracunajUkupnuCenu(List<Proizvod> proizvodi) {
        Double ukupnaCena = 0.0;
        for (Proizvod proizvod : proizvodi) {
            ukupnaCena += proizvod.getCena();
        }
        return ukupnaCena;
    }
}
