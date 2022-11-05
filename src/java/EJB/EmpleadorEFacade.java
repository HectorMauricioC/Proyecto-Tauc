/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import ENTIDADES.EmpleadorE;
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
public class EmpleadorEFacade extends AbstractFacade<EmpleadorE> implements EmpleadorEFacadeLocal {

    @PersistenceContext(unitName = "BOLSA_EMPLEO3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadorEFacade() {
        super(EmpleadorE.class);
    }
    
    @Override
    public EmpleadorE acceder_emple(EmpleadorE emple){
        EmpleadorE empleador=null;//Genero otro usuario
        String consulta="";//Var que al,acena la consulta 
        try
        {
          //Se escribe la consulta u es un alias , aqui se toman las variables de paquete en
            consulta= "Select e from EmpleadorE e where e.idEmpleador=?1 and e.contrasenaE=?2";
            //em es la entidad manager que muestra la consulta
            Query query=em.createQuery(consulta);
            //Se pasan los parametros, estos son lo que ingresa en el formulario
            query.setParameter(1, emple.getIdEmpleador());
            query.setParameter(2, emple.getContrasenaE());
            //Genera una lista y la condiciona, si no esta vacia muestre una fila 
            List<EmpleadorE> lista=query.getResultList();
            if(!lista.isEmpty()){
                empleador =lista.get(0);
            }
 
        }catch (Exception e){
            throw e;
        }
        return empleador;
    }   
   
        @Override
        public EmpleadorE modificar_emple(EmpleadorE propie){
            EmpleadorE empleador=null;
            String SQL="";

          try{

            SQL="UPDATE EmpleadorE SET e.nomEmpleador=?2, e.apeEmpleador=?3, e.sexoEmpleador=?4, e.telEmpleador=?5"
                      + "e.correo=?6, e.contrasenaE=?7, e.confirmarContrasenaE=?8 WHERE e.idEmpleador=?1";  

            Query query = em.createQuery(SQL);

            query.setParameter(1, propie.getIdEmpleador());
            query.setParameter(2, propie.getNomEmpleador());
            query.setParameter(3, propie.getApeEmpleador());
            query.setParameter(4, propie.getSexoEmpleador());
            query.setParameter(5, propie.getTelEmpleador());
            query.setParameter(6, propie.getCorreo());
            query.setParameter(7, propie.getContrasenaE());
            query.setParameter(8, propie.getConfirmarContrasenaE());

            List<EmpleadorE> lista=query.getResultList();
            if(!lista.isEmpty()){
                    empleador =lista.get(0);
                }
            }catch (Exception e){
                throw e;
            }
            return empleador;
        }
}
