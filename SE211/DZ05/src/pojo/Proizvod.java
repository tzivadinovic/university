package pojo;

public class Proizvod {
    private String naziv;
    private Double cena;
    private Integer kolicina;
    private Integer kutija;

    @Override
    public String toString() {
        return "Proizvod{" +
                "naziv='" + naziv + '\'' +
                ", cena=" + cena +
                ", kolicina=" + kolicina +
                ", kutija=" + kutija +
                '}';
    }

    public Integer getKutija() {
        return kutija;
    }

    public void setKutija(Integer kutija) {
        this.kutija = kutija;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Proizvod() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

}

