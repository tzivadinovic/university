package entity;

import java.util.List;

public class Agencija {
    private List<Nekretnina> nekretnine;
    private String naziv;

    public Agencija() {
    }

    public List<Nekretnina> getNekretnine() {
        return nekretnine;
    }

    public void setNekretnine(List<Nekretnina> nekretnine) {
        this.nekretnine = nekretnine;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Agencija{" +
                "nekretnine=" + nekretnine +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
