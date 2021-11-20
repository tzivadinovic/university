package entity;

import java.util.Collection;

public class Proizvod {
    private String naziv;
    private String sifra;
    private Double cena;
    private Integer stanje;
    private Kategorija kategorija;

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public Proizvod() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getStanje() {
        return stanje;
    }

    public void setStanje(Integer stanje) {
        this.stanje = stanje;
    }

    @Override
    public String toString() {
        return "Proizvod{" +
                "naziv='" + naziv + '\'' +
                ", sifra='" + sifra + '\'' +
                ", cena=" + cena +
                ", stanje=" + stanje +
                ", kategorija=" + kategorija +
                '}';
    }
}
