package entity;

import java.time.LocalDate;

public class Poseta {
    private Oglas oglas;
    private LocalDate vreme;
    private String status;



    public Oglas getOglas() {
        return oglas;
    }

    public void setOglas(Oglas oglas) {
        this.oglas = oglas;
    }

    public LocalDate getVreme() {
        return vreme;
    }

    public void setVreme(LocalDate vreme) {
        this.vreme = vreme;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Poseta() {
    }

    @Override
    public String toString() {
        return "Poseta{" +
                "oglas=" + oglas +
                ", vreme=" + vreme +
                ", status='" + status + '\'' +
                '}';
    }
}
