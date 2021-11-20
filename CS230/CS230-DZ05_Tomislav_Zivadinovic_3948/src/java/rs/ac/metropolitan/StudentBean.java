package rs.ac.metropolitan;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "studentBean")
@RequestScoped
public class StudentBean {
    private String ime;
    private String prezime;
    private int brojIndeksa;
    private String tipStudiranja;
    private String fakultet;

    public StudentBean(String ime, String prezime, int brojIndeksa, String tipStudiranja, String fakultet) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa = brojIndeksa;
        this.tipStudiranja = tipStudiranja;
        this.fakultet = fakultet;
    }
    
    public StudentBean() {
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(int brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getTipStudiranja() {
        return tipStudiranja;
    }

    public void setTipStudiranja(String tipStudiranja) {
        this.tipStudiranja = tipStudiranja;
    }

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }
    
}
