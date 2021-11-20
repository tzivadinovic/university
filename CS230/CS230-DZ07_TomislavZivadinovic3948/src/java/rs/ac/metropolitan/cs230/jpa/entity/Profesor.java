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
import javax.persistence.Lob;
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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByProfesorId", query = "SELECT p FROM Profesor p WHERE p.profesorId = :profesorId")
    , @NamedQuery(name = "Profesor.findByIme", query = "SELECT p FROM Profesor p WHERE p.ime = :ime")
    , @NamedQuery(name = "Profesor.findByPrezime", query = "SELECT p FROM Profesor p WHERE p.prezime = :prezime")
    , @NamedQuery(name = "Profesor.findByZvanje", query = "SELECT p FROM Profesor p WHERE p.zvanje = :zvanje")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "profesor_id")
    private Integer profesorId;
    @Size(max = 32)
    @Column(name = "ime")
    private String ime;
    @Size(max = 32)
    @Column(name = "prezime")
    private String prezime;
    @Lob
    @Size(max = 65535)
    @Column(name = "telefon")
    private String telefon;
    @Size(max = 20)
    @Column(name = "zvanje")
    private String zvanje;
    @OneToMany(mappedBy = "profesorId")
    private Collection<Angazovanje> angazovanjeCollection;

    public Profesor() {
    }

    public Profesor(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getZvanje() {
        return zvanje;
    }

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
    }

    @XmlTransient
    public Collection<Angazovanje> getAngazovanjeCollection() {
        return angazovanjeCollection;
    }

    public void setAngazovanjeCollection(Collection<Angazovanje> angazovanjeCollection) {
        this.angazovanjeCollection = angazovanjeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesorId != null ? profesorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.profesorId == null && other.profesorId != null) || (this.profesorId != null && !this.profesorId.equals(other.profesorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.cs230.jpa.entity.Profesor[ profesorId=" + profesorId + " ]";
    }
    
}
