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
@Table(name = "smer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smer.findAll", query = "SELECT s FROM Smer s")
    , @NamedQuery(name = "Smer.findBySmerId", query = "SELECT s FROM Smer s WHERE s.smerId = :smerId")})
public class Smer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "smer_id")
    private Integer smerId;
    @Lob
    @Size(max = 65535)
    @Column(name = "smer_opis")
    private String smerOpis;
    @OneToMany(mappedBy = "smerId")
    private Collection<Student> studentCollection;

    public Smer() {
    }

    public Smer(Integer smerId) {
        this.smerId = smerId;
    }

    public Integer getSmerId() {
        return smerId;
    }

    public void setSmerId(Integer smerId) {
        this.smerId = smerId;
    }

    public String getSmerOpis() {
        return smerOpis;
    }

    public void setSmerOpis(String smerOpis) {
        this.smerOpis = smerOpis;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smerId != null ? smerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smer)) {
            return false;
        }
        Smer other = (Smer) object;
        if ((this.smerId == null && other.smerId != null) || (this.smerId != null && !this.smerId.equals(other.smerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.cs230.jpa.entity.Smer[ smerId=" + smerId + " ]";
    }
    
}
