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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AZUS
 */
@Entity
@Table(name = "dim_produccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimProduccion.findAll", query = "SELECT d FROM DimProduccion d")
    , @NamedQuery(name = "DimProduccion.findBySkProduccion", query = "SELECT d FROM DimProduccion d WHERE d.skProduccion = :skProduccion")
    , @NamedQuery(name = "DimProduccion.findByPkProduccion", query = "SELECT d FROM DimProduccion d WHERE d.pkProduccion = :pkProduccion")
    , @NamedQuery(name = "DimProduccion.findByPersonaocupada", query = "SELECT d FROM DimProduccion d WHERE d.personaocupada = :personaocupada")
    , @NamedQuery(name = "DimProduccion.findByProduccionporhora", query = "SELECT d FROM DimProduccion d WHERE d.produccionporhora = :produccionporhora")
    , @NamedQuery(name = "DimProduccion.findByValidoDesde", query = "SELECT d FROM DimProduccion d WHERE d.validoDesde = :validoDesde")
    , @NamedQuery(name = "DimProduccion.findByValidoHasta", query = "SELECT d FROM DimProduccion d WHERE d.validoHasta = :validoHasta")
    , @NamedQuery(name = "DimProduccion.findByVersion", query = "SELECT d FROM DimProduccion d WHERE d.version = :version")})
public class DimProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sk_produccion")
    private Integer skProduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_produccion")
    private int pkProduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personaocupada")
    private double personaocupada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "produccionporhora")
    private double produccionporhora;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimProduccion")
    private List<Inec> inecList;

    public DimProduccion() {
    }

    public DimProduccion(Integer skProduccion) {
        this.skProduccion = skProduccion;
    }

    public DimProduccion(Integer skProduccion, int pkProduccion, double personaocupada, double produccionporhora, Date validoDesde, Date validoHasta, int version) {
        this.skProduccion = skProduccion;
        this.pkProduccion = pkProduccion;
        this.personaocupada = personaocupada;
        this.produccionporhora = produccionporhora;
        this.validoDesde = validoDesde;
        this.validoHasta = validoHasta;
        this.version = version;
    }

    public Integer getSkProduccion() {
        return skProduccion;
    }

    public void setSkProduccion(Integer skProduccion) {
        this.skProduccion = skProduccion;
    }

    public int getPkProduccion() {
        return pkProduccion;
    }

    public void setPkProduccion(int pkProduccion) {
        this.pkProduccion = pkProduccion;
    }

    public double getPersonaocupada() {
        return personaocupada;
    }

    public void setPersonaocupada(double personaocupada) {
        this.personaocupada = personaocupada;
    }

    public double getProduccionporhora() {
        return produccionporhora;
    }

    public void setProduccionporhora(double produccionporhora) {
        this.produccionporhora = produccionporhora;
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
        hash += (skProduccion != null ? skProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimProduccion)) {
            return false;
        }
        DimProduccion other = (DimProduccion) object;
        if ((this.skProduccion == null && other.skProduccion != null) || (this.skProduccion != null && !this.skProduccion.equals(other.skProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entities.DimProduccion[ skProduccion=" + skProduccion + " ]";
    }
    
}
