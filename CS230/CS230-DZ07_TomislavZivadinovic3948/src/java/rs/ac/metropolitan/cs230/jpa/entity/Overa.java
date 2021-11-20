/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author korisnik
 */
@Entity
@Table(name = "overa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Overa.findAll", query = "SELECT o FROM Overa o")
    , @NamedQuery(name = "Overa.findByOveraId", query = "SELECT o FROM Overa o WHERE o.overaId = :overaId")
    , @NamedQuery(name = "Overa.findByOcena", query = "SELECT o FROM Overa o WHERE o.ocena = :ocena")
    , @NamedQuery(name = "Overa.findByDatumOvera", query = "SELECT o FROM Overa o WHERE o.datumOvera = :datumOvera")})
public class Overa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "overa_id")
    private Integer overaId;
    @Column(name = "ocena")
    private Integer ocena;
    @Column(name = "datum_overa")
    @Temporal(TemporalType.DATE)
    private Date datumOvera;
    @JoinColumn(name = "indeks", referencedColumnName = "indeks")
    @ManyToOne
    private Student indeks;
    @JoinColumn(name = "predmet_id", referencedColumnName = "predmet_id")
    @ManyToOne
    private Predmet predmetId;

    public Overa() {
    }

    public Overa(Integer overaId) {
        this.overaId = overaId;
    }

    public Integer getOveraId() {
        return overaId;
    }

    public void setOveraId(Integer overaId) {
        this.overaId = overaId;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Date getDatumOvera() {
        return datumOvera;
    }

    public void setDatumOvera(Date datumOvera) {
        this.datumOvera = datumOvera;
    }

    public Student getIndeks() {
        return indeks;
    }

    public void setIndeks(Student indeks) {
        this.indeks = indeks;
    }

    public Predmet getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Predmet predmetId) {
        this.predmetId = predmetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (overaId != null ? overaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Overa)) {
            return false;
        }
        Overa other = (Overa) object;
        if ((this.overaId == null && other.overaId != null) || (this.overaId != null && !this.overaId.equals(other.overaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.cs230.jpa.entity.Overa[ overaId=" + overaId + " ]";
    }
    
}
