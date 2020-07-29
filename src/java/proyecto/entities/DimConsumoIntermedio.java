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
@Table(name = "dim_consumo_intermedio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimConsumoIntermedio.findAll", query = "SELECT d FROM DimConsumoIntermedio d")
    , @NamedQuery(name = "DimConsumoIntermedio.findBySkConsumoIntermedio", query = "SELECT d FROM DimConsumoIntermedio d WHERE d.skConsumoIntermedio = :skConsumoIntermedio")
    , @NamedQuery(name = "DimConsumoIntermedio.findByPkConintermedio", query = "SELECT d FROM DimConsumoIntermedio d WHERE d.pkConintermedio = :pkConintermedio")
    , @NamedQuery(name = "DimConsumoIntermedio.findByMp", query = "SELECT d FROM DimConsumoIntermedio d WHERE d.mp = :mp")
    , @NamedQuery(name = "DimConsumoIntermedio.findBySuministros", query = "SELECT d FROM DimConsumoIntermedio d WHERE d.suministros = :suministros")
    , @NamedQuery(name = "DimConsumoIntermedio.findByGastosOperacionales", query = "SELECT d FROM DimConsumoIntermedio d WHERE d.gastosOperacionales = :gastosOperacionales")
    , @NamedQuery(name = "DimConsumoIntermedio.findByValidoDesde", query = "SELECT d FROM DimConsumoIntermedio d WHERE d.validoDesde = :validoDesde")
    , @NamedQuery(name = "DimConsumoIntermedio.findByValidoHasta", query = "SELECT d FROM DimConsumoIntermedio d WHERE d.validoHasta = :validoHasta")
    , @NamedQuery(name = "DimConsumoIntermedio.findByVersion", query = "SELECT d FROM DimConsumoIntermedio d WHERE d.version = :version")})
public class DimConsumoIntermedio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sk_consumo_intermedio")
    private Integer skConsumoIntermedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_conintermedio")
    private int pkConintermedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mp")
    private double mp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suministros")
    private double suministros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gastos_operacionales")
    private double gastosOperacionales;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimConsumoIntermedio")
    private List<Inec> inecList;

    public DimConsumoIntermedio() {
    }

    public DimConsumoIntermedio(Integer skConsumoIntermedio) {
        this.skConsumoIntermedio = skConsumoIntermedio;
    }

    public DimConsumoIntermedio(Integer skConsumoIntermedio, int pkConintermedio, double mp, double suministros, double gastosOperacionales, Date validoDesde, Date validoHasta, int version) {
        this.skConsumoIntermedio = skConsumoIntermedio;
        this.pkConintermedio = pkConintermedio;
        this.mp = mp;
        this.suministros = suministros;
        this.gastosOperacionales = gastosOperacionales;
        this.validoDesde = validoDesde;
        this.validoHasta = validoHasta;
        this.version = version;
    }

    public Integer getSkConsumoIntermedio() {
        return skConsumoIntermedio;
    }

    public void setSkConsumoIntermedio(Integer skConsumoIntermedio) {
        this.skConsumoIntermedio = skConsumoIntermedio;
    }

    public int getPkConintermedio() {
        return pkConintermedio;
    }

    public void setPkConintermedio(int pkConintermedio) {
        this.pkConintermedio = pkConintermedio;
    }

    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public double getSuministros() {
        return suministros;
    }

    public void setSuministros(double suministros) {
        this.suministros = suministros;
    }

    public double getGastosOperacionales() {
        return gastosOperacionales;
    }

    public void setGastosOperacionales(double gastosOperacionales) {
        this.gastosOperacionales = gastosOperacionales;
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
        hash += (skConsumoIntermedio != null ? skConsumoIntermedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimConsumoIntermedio)) {
            return false;
        }
        DimConsumoIntermedio other = (DimConsumoIntermedio) object;
        if ((this.skConsumoIntermedio == null && other.skConsumoIntermedio != null) || (this.skConsumoIntermedio != null && !this.skConsumoIntermedio.equals(other.skConsumoIntermedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entities.DimConsumoIntermedio[ skConsumoIntermedio=" + skConsumoIntermedio + " ]";
    }
    
}
