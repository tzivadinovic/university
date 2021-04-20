package entity;

import data.TipGradnje;
import data.TipGrejanja;
import lombok.*;


public class Nekretnina {
    private String adresa;
    private Double povrsina;
    private Integer brojSoba;
    private Boolean lift;
    private Integer sprat;
    private TipGradnje tipGradnje;
    private TipGrejanja tipGrejanja;
    private Agencija agencija;

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(Double povrsina) {
        this.povrsina = povrsina;
    }

    public Integer getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(Integer brojSoba) {
        this.brojSoba = brojSoba;
    }

    public Boolean getLift() {
        return lift;
    }

    public void setLift(Boolean lift) {
        this.lift = lift;
    }

    public Integer getSprat() {
        return sprat;
    }

    public void setSprat(Integer sprat) {
        this.sprat = sprat;
    }

    public TipGradnje getTipGradnje() {
        return tipGradnje;
    }

    public void setTipGradnje(TipGradnje tipGradnje) {
        this.tipGradnje = tipGradnje;
    }

    public TipGrejanja getTipGrejanja() {
        return tipGrejanja;
    }

    public void setTipGrejanja(TipGrejanja tipGrejanja) {
        this.tipGrejanja = tipGrejanja;
    }

    public Agencija getAgencija() {
        return agencija;
    }

    public void setAgencija(Agencija agencija) {
        this.agencija = agencija;
    }
}
