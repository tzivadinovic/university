package entity;

import java.time.LocalDate;
import java.util.List;

public class Oglas {
    private Nekretnina nekretnina;
    private Boolean aktivan;
    private Double cena;
    private LocalDate datumKreiranja;
    private LocalDate datumIzdavanja;
    private Integer trajanjePretplate;



    public List<Poseta> getPosete() {
        return posete;
    }

    public void setPosete(List<Poseta> posete) {
        this.posete = posete;
    }

    private List<Poseta> posete;

    public Oglas() {
    }

    public Nekretnina getNekretnina() {
        return nekretnina;
    }

    public void setNekretnina(Nekretnina nekretnina) {
        this.nekretnina = nekretnina;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public LocalDate getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(LocalDate datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Integer getTrajanjePretplate() {
        return trajanjePretplate;
    }

    public void setTrajanjePretplate(Integer trajanjePretplate) {
        this.trajanjePretplate = trajanjePretplate;
    }

    @Override
    public String toString() {
        return "Oglas{" +
                "nekretnina=" + nekretnina +
                ", aktivan=" + aktivan +
                ", cena=" + cena +
                ", datumKreiranja=" + datumKreiranja +
                ", datumIzdavanja=" + datumIzdavanja +
                ", trajanjePretplate=" + trajanjePretplate +
                ", posete=" + posete +
                '}';
    }

    public Double izracunajUkupnuCenu(){
        double ukupnaCena = 0.0;
        ukupnaCena = this.cena * this.nekretnina.getPovrsina();
        return ukupnaCena;
    }

}
