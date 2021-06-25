/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author korisnik
 */
@Entity
@Table(name = "predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
    , @NamedQuery(name = "Predmet.findByPredmetId", query = "SELECT p FROM Predmet p WHERE p.predmetId = :predmetId")
    , @NamedQuery(name = "Predmet.findByNaziv", query = "SELECT p FROM Predmet p WHERE p.naziv = :naziv")
    , @NamedQuery(name = "Predmet.findByEspb", query = "SELECT p FROM Predmet p WHERE p.espb = :espb")
    , @NamedQuery(name = "Predmet.findByBrCasPredavanja", query = "SELECT p FROM Predmet p WHERE p.brCasPredavanja = :brCasPredavanja")
    , @NamedQuery(name = "Predmet.findByBrCasVezbe", query = "SELECT p FROM Predmet p WHERE p.brCasVezbe = :brCasVezbe")})
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "predmet_id")
    private String predmetId;
    @Size(max = 50)
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "espb")
    private Short espb;
    @Column(name = "br_cas_predavanja")
    private Short brCasPredavanja;
    @Column(name = "br_cas_vezbe")
    private Short brCasVezbe;
    @OneToMany(mappedBy = "predmetId")
    private Collection<Angazovanje> angazovanjeCollection;
    @OneToMany(mappedBy = "predmetId")
    private Collection<Overa> overaCollection;

    public Predmet() {
    }

    public Predmet(String predmetId) {
        this.predmetId = predmetId;
    }

    public String getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(String predmetId) {
        this.predmetId = predmetId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Short getEspb() {
        return espb;
    }

    public void setEspb(Short espb) {
        this.espb = espb;
    }

    public Short getBrCasPredavanja() {
        return brCasPredavanja;
    }

    public void setBrCasPredavanja(Short brCasPredavanja) {
        this.brCasPredavanja = brCasPredavanja;
    }

    public Short getBrCasVezbe() {
        return brCasVezbe;
    }

    public void setBrCasVezbe(Short brCasVezbe) {
        this.brCasVezbe = brCasVezbe;
    }

    @XmlTransient
    public Collection<Angazovanje> getAngazovanjeCollection() {
        return angazovanjeCollection;
    }

    public void setAngazovanjeCollection(Collection<Angazovanje> angazovanjeCollection) {
        this.angazovanjeCollection = angazovanjeCollection;
    }

    @XmlTransient
    public Collection<Overa> getOveraCollection() {
        return overaCollection;
    }

    public void setOveraCollection(Collection<Overa> overaCollection) {
        this.overaCollection = overaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predmetId != null ? predmetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.predmetId == null && other.predmetId != null) || (this.predmetId != null && !this.predmetId.equals(other.predmetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.cs230.jpa.entity.Predmet[ predmetId=" + predmetId + " ]";
    }
    
}
