/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import ENTIDADES.TrabajadorFincaTf;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface TrabajadorFincaTfFacadeLocal {

    void create(TrabajadorFincaTf trabajadorFincaTf);

    void edit(TrabajadorFincaTf trabajadorFincaTf);

    void remove(TrabajadorFincaTf trabajadorFincaTf);

    TrabajadorFincaTf find(Object id);

    List<TrabajadorFincaTf> findAll();

    List<TrabajadorFincaTf> findRange(int[] range);

    int count();
    
}
