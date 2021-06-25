/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author korisnik
 */
@Entity
@Table(name = "angazovanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Angazovanje.findAll", query = "SELECT a FROM Angazovanje a")
    , @NamedQuery(name = "Angazovanje.findByAngazovanjeId", query = "SELECT a FROM Angazovanje a WHERE a.angazovanjeId = :angazovanjeId")})
public class Angazovanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "angazovanje_id")
    private Integer angazovanjeId;
    @JoinColumn(name = "profesor_id", referencedColumnName = "profesor_id")
    @ManyToOne
    private Profesor profesorId;
    @JoinColumn(name = "predmet_id", referencedColumnName = "predmet_id")
    @ManyToOne
    private Predmet predmetId;

    public Angazovanje() {
    }

    public Angazovanje(Integer angazovanjeId) {
        this.angazovanjeId = angazovanjeId;
    }

    public Integer getAngazovanjeId() {
        return angazovanjeId;
    }

    public void setAngazovanjeId(Integer angazovanjeId) {
        this.angazovanjeId = angazovanjeId;
    }

    public Profesor getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Profesor profesorId) {
        this.profesorId = profesorId;
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
        hash += (angazovanjeId != null ? angazovanjeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Angazovanje)) {
            return false;
        }
        Angazovanje other = (Angazovanje) object;
        if ((this.angazovanjeId == null && other.angazovanjeId != null) || (this.angazovanjeId != null && !this.angazovanjeId.equals(other.angazovanjeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.cs230.jpa.entity.Angazovanje[ angazovanjeId=" + angazovanjeId + " ]";
    }
    
}
