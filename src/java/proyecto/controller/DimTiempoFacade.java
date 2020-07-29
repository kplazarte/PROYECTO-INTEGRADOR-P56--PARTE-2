/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyecto.entities.DimTiempo;

/**
 *
 * @author AZUS
 */
@Stateless
public class DimTiempoFacade extends AbstractFacade<DimTiempo> {

    @PersistenceContext(unitName = "PROYECTOP56PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DimTiempoFacade() {
        super(DimTiempo.class);
    }
    
}
