package entity;

public class Kategorija {
    private String naziv;

    public Kategorija() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Kategorija{" +
                "naziv='" + naziv + '\'' +
                '}';
    }
}
