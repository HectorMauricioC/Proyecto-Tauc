/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import ENTIDADES.EmpleadorE;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface EmpleadorEFacadeLocal {

    void create(EmpleadorE empleadorE);

    void edit(EmpleadorE empleadorE);

    void remove(EmpleadorE empleadorE);

    EmpleadorE find(Object id);

    List<EmpleadorE> findAll();

    List<EmpleadorE> findRange(int[] range);

    int count();
    
     public EmpleadorE acceder_emple(EmpleadorE emple);
     public EmpleadorE modificar_emple(EmpleadorE propie);
}
