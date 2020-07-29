/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AZUS
 */
@Entity
@Table(name = "inec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inec.findAll", query = "SELECT i FROM Inec i")
    , @NamedQuery(name = "Inec.findBySkTiempo", query = "SELECT i FROM Inec i WHERE i.inecPK.skTiempo = :skTiempo")
    , @NamedQuery(name = "Inec.findBySkConsumoIntermedio", query = "SELECT i FROM Inec i WHERE i.inecPK.skConsumoIntermedio = :skConsumoIntermedio")
    , @NamedQuery(name = "Inec.findBySkProduccion", query = "SELECT i FROM Inec i WHERE i.inecPK.skProduccion = :skProduccion")
    , @NamedQuery(name = "Inec.findBySkTipo", query = "SELECT i FROM Inec i WHERE i.inecPK.skTipo = :skTipo")})
public class Inec implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InecPK inecPK;
    @JoinColumn(name = "sk_consumo_intermedio", referencedColumnName = "sk_consumo_intermedio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DimConsumoIntermedio dimConsumoIntermedio;
    @JoinColumn(name = "sk_produccion", referencedColumnName = "sk_produccion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DimProduccion dimProduccion;
    @JoinColumn(name = "sk_tiempo", referencedColumnName = "sk_tiempo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DimTiempo dimTiempo;
    @JoinColumn(name = "sk_tipo", referencedColumnName = "sk_tipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DimTipo dimTipo;

    public Inec() {
    }

    public Inec(InecPK inecPK) {
        this.inecPK = inecPK;
    }

    public Inec(int skTiempo, int skConsumoIntermedio, int skProduccion, int skTipo) {
        this.inecPK = new InecPK(skTiempo, skConsumoIntermedio, skProduccion, skTipo);
    }

    public InecPK getInecPK() {
        return inecPK;
    }

    public void setInecPK(InecPK inecPK) {
        this.inecPK = inecPK;
    }

    public DimConsumoIntermedio getDimConsumoIntermedio() {
        return dimConsumoIntermedio;
    }

    public void setDimConsumoIntermedio(DimConsumoIntermedio dimConsumoIntermedio) {
        this.dimConsumoIntermedio = dimConsumoIntermedio;
    }

    public DimProduccion getDimProduccion() {
        return dimProduccion;
    }

    public void setDimProduccion(DimProduccion dimProduccion) {
        this.dimProduccion = dimProduccion;
    }

    public DimTiempo getDimTiempo() {
        return dimTiempo;
    }

    public void setDimTiempo(DimTiempo dimTiempo) {
        this.dimTiempo = dimTiempo;
    }

    public DimTipo getDimTipo() {
        return dimTipo;
    }

    public void setDimTipo(DimTipo dimTipo) {
        this.dimTipo = dimTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inecPK != null ? inecPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inec)) {
            return false;
        }
        Inec other = (Inec) object;
        if ((this.inecPK == null && other.inecPK != null) || (this.inecPK != null && !this.inecPK.equals(other.inecPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entities.Inec[ inecPK=" + inecPK + " ]";
    }
    
}
