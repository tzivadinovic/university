package rs.ac.metropolitan.json;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Adresa implements Serializable{
    private String ulica;
    private String grad;
    private int postanskiBroj;

    public Adresa() {
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    @Override
    public String toString() {
        return "Adresa{" + "ulica=" + ulica + ", grad=" + grad + ", postanskiBroj=" + postanskiBroj + '}';
    }
    
    
}
