/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import ENTIDADES.TrabajadorT;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface TrabajadorTFacadeLocal {

    void create(TrabajadorT trabajadorT);

    void edit(TrabajadorT trabajadorT);

    void remove(TrabajadorT trabajadorT);

    TrabajadorT find(Object id);

    List<TrabajadorT> findAll();

    List<TrabajadorT> findRange(int[] range);

    int count();
    
    public TrabajadorT acceder_trab(TrabajadorT trab);
    public TrabajadorT modificar_tra(TrabajadorT traba);
    
}
