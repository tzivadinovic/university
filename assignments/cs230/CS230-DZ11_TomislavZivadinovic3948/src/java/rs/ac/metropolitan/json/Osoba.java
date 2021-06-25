package rs.ac.metropolitan.json;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Osoba implements Serializable{
    private Integer brojIndeksa;
    private String ime;
    private String status;
    private Boolean tradicionalni;
    @Inject
    private Adresa adresa;
    private String uloga;

    public Osoba() {
        
    }
    
    

    public Integer getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(Integer brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getTradicionalni() {
        return tradicionalni;
    }

    public void setTradicionalni(Boolean tradicionalni) {
        this.tradicionalni = tradicionalni;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
    
}
