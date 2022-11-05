/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import ENTIDADES.TrabajadorFincaTf;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USUARIO
 */
@Stateless
public class TrabajadorFincaTfFacade extends AbstractFacade<TrabajadorFincaTf> implements TrabajadorFincaTfFacadeLocal {

    @PersistenceContext(unitName = "BOLSA_EMPLEO3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajadorFincaTfFacade() {
        super(TrabajadorFincaTf.class);
    }
    
}
