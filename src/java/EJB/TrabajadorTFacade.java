/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import ENTIDADES.TrabajadorT;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class TrabajadorTFacade extends AbstractFacade<TrabajadorT> implements TrabajadorTFacadeLocal {

    @PersistenceContext(unitName = "BOLSA_EMPLEO3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajadorTFacade() {
        super(TrabajadorT.class);
    }
    
    @Override
    public TrabajadorT acceder_trab(TrabajadorT trab){
        TrabajadorT trabajador=null;//Genero otro usuario
        String consulta="";//Var que al,acena la consulta 
        try
        {
          //Se escribe la consulta t es un alias , aqui se toman las variables de paquete en
            consulta= "Select t from TrabajadorT t where t.idTrabajador=?1 and t.contrasenaT=?2";
            //em es la entidad manager que muestra la consulta
            Query query=em.createQuery(consulta);
            //Se pasan los parametros, estos son lo que ingresa en el formulario
            query.setParameter(1, trab.getIdTrabajador());
            query.setParameter(2, trab.getContrasenaT());
            //Genera una lista y la condiciona, si no esta vacia muestre una fila 
            List<TrabajadorT> lista=query.getResultList();
            if(!lista.isEmpty()){
                trabajador =lista.get(0);
            }
 
        }catch (Exception e){
            throw e;
        }
        return trabajador;
    }   
    
    @Override
    public TrabajadorT modificar_tra(TrabajadorT traba){
        
        TrabajadorT trabajador=null;
        String SQL="";
        
        try{
            
            SQL="UPDATE TrabajadorT SET t.nomTrabajador=?2, t.apeTrabajador=?3, t.sexoTrabajador=?4, t.telTrabajador=?5,  t.estadoCivil=?6, t.experiencia=?7"
               + " t.correoTrabajador=?8, t.contrasenaT=?9, t.confirmarContrasenaT=?10 WHERE t.idTrabajador=?1" ;
            
            Query query = em.createQuery(SQL);
            
            query.setParameter(1, traba.getIdTrabajador());
            query.setParameter(2, traba.getNomTrabajador());
            query.setParameter(3, traba.getApeTrabajador());
            query.setParameter(4, traba.getSexoTrabajador());
            query.setParameter(5, traba.getTelTrabajador());
            query.setParameter(6, traba.getEstadoCivil());
            query.setParameter(7, traba.getExperiencia());
            query.setParameter(8, traba.getCorreoTrabajador());
            query.setParameter(9, traba.getContrasenaT());
            query.setParameter(10, traba.getConfirmarContrasenaT());
     
           List<TrabajadorT> lista=query.getResultList();
            if(!lista.isEmpty()){
                trabajador =lista.get(0);
            }
        }catch (Exception e){
            throw e;
        }
        return trabajador;
    }
}
