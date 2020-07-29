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
@Table(name = "dim_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimTipo.findAll", query = "SELECT d FROM DimTipo d")
    , @NamedQuery(name = "DimTipo.findBySkTipo", query = "SELECT d FROM DimTipo d WHERE d.skTipo = :skTipo")
    , @NamedQuery(name = "DimTipo.findByPkTipo", query = "SELECT d FROM DimTipo d WHERE d.pkTipo = :pkTipo")
    , @NamedQuery(name = "DimTipo.findByDescripcion", query = "SELECT d FROM DimTipo d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "DimTipo.findByValidoDesde", query = "SELECT d FROM DimTipo d WHERE d.validoDesde = :validoDesde")
    , @NamedQuery(name = "DimTipo.findByValidoHasta", query = "SELECT d FROM DimTipo d WHERE d.validoHasta = :validoHasta")
    , @NamedQuery(name = "DimTipo.findByVersion", query = "SELECT d FROM DimTipo d WHERE d.version = :version")})
public class DimTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sk_tipo")
    private Integer skTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_tipo")
    private double pkTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valido_desde")
    @Temporal(TemporalType.DATE)
    private Date validoDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valido_hasta")
    @Temporal(TemporalType.DATE)
    private Date validoHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimTipo")
    private List<Inec> inecList;

    public DimTipo() {
    }

    public DimTipo(Integer skTipo) {
        this.skTipo = skTipo;
    }

    public DimTipo(Integer skTipo, double pkTipo, String descripcion, Date validoDesde, Date validoHasta, int version) {
        this.skTipo = skTipo;
        this.pkTipo = pkTipo;
        this.descripcion = descripcion;
        this.validoDesde = validoDesde;
        this.validoHasta = validoHasta;
        this.version = version;
    }

    public Integer getSkTipo() {
        return skTipo;
    }

    public void setSkTipo(Integer skTipo) {
        this.skTipo = skTipo;
    }

    public double getPkTipo() {
        return pkTipo;
    }

    public void setPkTipo(double pkTipo) {
        this.pkTipo = pkTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getValidoDesde() {
        return validoDesde;
    }

    public void setValidoDesde(Date validoDesde) {
        this.validoDesde = validoDesde;
    }

    public Date getValidoHasta() {
        return validoHasta;
    }

    public void setValidoHasta(Date validoHasta) {
        this.validoHasta = validoHasta;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
        hash += (skTipo != null ? skTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimTipo)) {
            return false;
        }
        DimTipo other = (DimTipo) object;
        if ((this.skTipo == null && other.skTipo != null) || (this.skTipo != null && !this.skTipo.equals(other.skTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entities.DimTipo[ skTipo=" + skTipo + " ]";
    }
    
}
