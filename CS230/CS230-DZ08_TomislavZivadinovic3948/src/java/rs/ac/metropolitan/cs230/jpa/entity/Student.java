/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author korisnik
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByIndeks", query = "SELECT s FROM Student s WHERE s.indeks = :indeks")
    , @NamedQuery(name = "Student.findByIme", query = "SELECT s FROM Student s WHERE s.ime = :ime")
    , @NamedQuery(name = "Student.findByPrezime", query = "SELECT s FROM Student s WHERE s.prezime = :prezime")
    , @NamedQuery(name = "Student.findByTipStudiranja", query = "SELECT s FROM Student s WHERE s.tipStudiranja = :tipStudiranja")
    , @NamedQuery(name = "Student.findByDatumRodjenja", query = "SELECT s FROM Student s WHERE s.datumRodjenja = :datumRodjenja")
    , @NamedQuery(name = "Student.findByGradRodjenja", query = "SELECT s FROM Student s WHERE s.gradRodjenja = :gradRodjenja")
    , @NamedQuery(name = "Student.findByPol", query = "SELECT s FROM Student s WHERE s.pol = :pol")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "indeks")
    private Integer indeks;
    @Size(max = 32)
    @Column(name = "ime")
    private String ime;
    @Size(max = 32)
    @Column(name = "prezime")
    private String prezime;
    @Size(max = 32)
    @Column(name = "tip_studiranja")
    private String tipStudiranja;
    @Column(name = "datum_rodjenja")
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @Lob
    @Size(max = 65535)
    @Column(name = "telefon")
    private String telefon;
    @Size(max = 32)
    @Column(name = "grad_rodjenja")
    private String gradRodjenja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "Pol")
    private String pol;
    @JoinColumn(name = "smer_id", referencedColumnName = "smer_id")
    @ManyToOne
    private Smer smerId;
    @OneToMany(mappedBy = "indeks")
    private Collection<Overa> overaCollection;

    public Student() {
    }

    public Student(Integer indeks) {
        this.indeks = indeks;
    }

    public Student(Integer indeks, String pol) {
        this.indeks = indeks;
        this.pol = pol;
    }

    public Integer getIndeks() {
        return indeks;
    }

    public void setIndeks(Integer indeks) {
        this.indeks = indeks;
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

    public String getTipStudiranja() {
        return tipStudiranja;
    }

    public void setTipStudiranja(String tipStudiranja) {
        this.tipStudiranja = tipStudiranja;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getGradRodjenja() {
        return gradRodjenja;
    }

    public void setGradRodjenja(String gradRodjenja) {
        this.gradRodjenja = gradRodjenja;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public Smer getSmerId() {
        return smerId;
    }

    public void setSmerId(Smer smerId) {
        this.smerId = smerId;
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
        hash += (indeks != null ? indeks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.indeks == null && other.indeks != null) || (this.indeks != null && !this.indeks.equals(other.indeks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.cs230.jpa.entity.Student[ indeks=" + indeks + " ]";
    }
    
}
