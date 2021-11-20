package pojo;


import java.util.ArrayList;
import java.util.List;

public class Racun {
    private String brojRacuna;
    private Double ukupnaCena;
    private Integer brojKutija;
    private List<Proizvod> proizvodList = new ArrayList<>();

    public Racun() {
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(Double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Integer getBrojKutija() {
        return brojKutija;
    }

    public void setBrojKutija(Integer brojKutija) {
        this.brojKutija = brojKutija;
    }

    public List<Proizvod> getProizvodList() {
        return proizvodList;
    }

    public void setProizvodList(List<Proizvod> proizvodList) {
        this.proizvodList = proizvodList;
    }

    @Override
    public String toString() {
        return "Racun{" +
                "brojRacuna='" + brojRacuna + '\'' +
                ", ukupnaCena=" + ukupnaCena +
                ", brojKutija=" + brojKutija +
                ", proizvodList=" + proizvodList +
                '}';
    }
}
