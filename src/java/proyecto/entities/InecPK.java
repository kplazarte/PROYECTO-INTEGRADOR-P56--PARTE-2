/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AZUS
 */
@Embeddable
public class InecPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "sk_tiempo")
    private int skTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sk_consumo_intermedio")
    private int skConsumoIntermedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sk_produccion")
    private int skProduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sk_tipo")
    private int skTipo;

    public InecPK() {
    }

    public InecPK(int skTiempo, int skConsumoIntermedio, int skProduccion, int skTipo) {
        this.skTiempo = skTiempo;
        this.skConsumoIntermedio = skConsumoIntermedio;
        this.skProduccion = skProduccion;
        this.skTipo = skTipo;
    }

    public int getSkTiempo() {
        return skTiempo;
    }

    public void setSkTiempo(int skTiempo) {
        this.skTiempo = skTiempo;
    }

    public int getSkConsumoIntermedio() {
        return skConsumoIntermedio;
    }

    public void setSkConsumoIntermedio(int skConsumoIntermedio) {
        this.skConsumoIntermedio = skConsumoIntermedio;
    }

    public int getSkProduccion() {
        return skProduccion;
    }

    public void setSkProduccion(int skProduccion) {
        this.skProduccion = skProduccion;
    }

    public int getSkTipo() {
        return skTipo;
    }

    public void setSkTipo(int skTipo) {
        this.skTipo = skTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) skTiempo;
        hash += (int) skConsumoIntermedio;
        hash += (int) skProduccion;
        hash += (int) skTipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InecPK)) {
            return false;
        }
        InecPK other = (InecPK) object;
        if (this.skTiempo != other.skTiempo) {
            return false;
        }
        if (this.skConsumoIntermedio != other.skConsumoIntermedio) {
            return false;
        }
        if (this.skProduccion != other.skProduccion) {
            return false;
        }
        if (this.skTipo != other.skTipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entities.InecPK[ skTiempo=" + skTiempo + ", skConsumoIntermedio=" + skConsumoIntermedio + ", skProduccion=" + skProduccion + ", skTipo=" + skTipo + " ]";
    }
    
}
