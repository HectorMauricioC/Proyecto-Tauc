/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import ENTIDADES.FincaF;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface FincaFFacadeLocal {

    void create(FincaF fincaF);

    void edit(FincaF fincaF);

    void remove(FincaF fincaF);

    FincaF find(Object id);

    List<FincaF> findAll();

    List<FincaF> findRange(int[] range);

    int count();
    
}
