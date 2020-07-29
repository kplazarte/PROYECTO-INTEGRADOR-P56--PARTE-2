/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author AZUS
 */
@Entity
@Table(name = "dim_tiempo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimTiempo.findAll", query = "SELECT d FROM DimTiempo d")
    , @NamedQuery(name = "DimTiempo.findBySkTiempo", query = "SELECT d FROM DimTiempo d WHERE d.skTiempo = :skTiempo")
    , @NamedQuery(name = "DimTiempo.findByFecha", query = "SELECT d FROM DimTiempo d WHERE d.fecha = :fecha")
    , @NamedQuery(name = "DimTiempo.findBySkTiempoKtl", query = "SELECT d FROM DimTiempo d WHERE d.skTiempoKtl = :skTiempoKtl")
    , @NamedQuery(name = "DimTiempo.findByAnio", query = "SELECT d FROM DimTiempo d WHERE d.anio = :anio")
    , @NamedQuery(name = "DimTiempo.findBySemestre", query = "SELECT d FROM DimTiempo d WHERE d.semestre = :semestre")
    , @NamedQuery(name = "DimTiempo.findByNombreSemestre", query = "SELECT d FROM DimTiempo d WHERE d.nombreSemestre = :nombreSemestre")
    , @NamedQuery(name = "DimTiempo.findByTrimestre", query = "SELECT d FROM DimTiempo d WHERE d.trimestre = :trimestre")
    , @NamedQuery(name = "DimTiempo.findByNombreTrimestre", query = "SELECT d FROM DimTiempo d WHERE d.nombreTrimestre = :nombreTrimestre")
    , @NamedQuery(name = "DimTiempo.findByMes", query = "SELECT d FROM DimTiempo d WHERE d.mes = :mes")
    , @NamedQuery(name = "DimTiempo.findByNombreMes", query = "SELECT d FROM DimTiempo d WHERE d.nombreMes = :nombreMes")
    , @NamedQuery(name = "DimTiempo.findByDia", query = "SELECT d FROM DimTiempo d WHERE d.dia = :dia")})
public class DimTiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sk_tiempo")
    private Integer skTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sk_tiempo_ktl")
    private Double skTiempoKtl;
    @Column(name = "anio")
    private Double anio;
    @Column(name = "semestre")
    private Double semestre;
    @Size(max = 9)
    @Column(name = "nombre_semestre")
    private String nombreSemestre;
    @Column(name = "trimestre")
    private Double trimestre;
    @Size(max = 10)
    @Column(name = "nombre_trimestre")
    private String nombreTrimestre;
    @Column(name = "mes")
    private Double mes;
    @Size(max = 10)
    @Column(name = "nombre_mes")
    private String nombreMes;
    @Column(name = "dia")
    private Double dia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimTiempo")
    private List<Inec> inecList;

    public DimTiempo() {
    }

    public DimTiempo(Integer skTiempo) {
        this.skTiempo = skTiempo;
    }

    public DimTiempo(Integer skTiempo, Date fecha) {
        this.skTiempo = skTiempo;
        this.fecha = fecha;
    }

    public Integer getSkTiempo() {
        return skTiempo;
    }

    public void setSkTiempo(Integer skTiempo) {
        this.skTiempo = skTiempo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSkTiempoKtl() {
        return skTiempoKtl;
    }

    public void setSkTiempoKtl(Double skTiempoKtl) {
        this.skTiempoKtl = skTiempoKtl;
    }

    public Double getAnio() {
        return anio;
    }

    public void setAnio(Double anio) {
        this.anio = anio;
    }

    public Double getSemestre() {
        return semestre;
    }

    public void setSemestre(Double semestre) {
        this.semestre = semestre;
    }

    public String getNombreSemestre() {
        return nombreSemestre;
    }

    public void setNombreSemestre(String nombreSemestre) {
        this.nombreSemestre = nombreSemestre;
    }

    public Double getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Double trimestre) {
        this.trimestre = trimestre;
    }

    public String getNombreTrimestre() {
        return nombreTrimestre;
    }

    public void setNombreTrimestre(String nombreTrimestre) {
        this.nombreTrimestre = nombreTrimestre;
    }

    public Double getMes() {
        return mes;
    }

    public void setMes(Double mes) {
        this.mes = mes;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public Double getDia() {
        return dia;
    }

    public void setDia(Double dia) {
        this.dia = dia;
    }

    @XmlTransient
    public List<Inec> getInecList() {
        return inecList;
    }

    public void setInecList(List<Inec> inecList) {
        this.inecList = inecList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skTiempo != null ? skTiempo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimTiempo)) {
            return false;
        }
        DimTiempo other = (DimTiempo) object;
        if ((this.skTiempo == null && other.skTiempo != null) || (this.skTiempo != null && !this.skTiempo.equals(other.skTiempo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entities.DimTiempo[ skTiempo=" + skTiempo + " ]";
    }
    
}
