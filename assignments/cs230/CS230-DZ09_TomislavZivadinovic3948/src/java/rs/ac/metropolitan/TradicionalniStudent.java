
package rs.ac.metropolitan;

import java.io.Serializable;

@Stereotip
public class TradicionalniStudent {
    private String ime;
    private String prezime;
    private String email;

    public TradicionalniStudent() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
