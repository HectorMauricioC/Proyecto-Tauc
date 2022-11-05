package CONTROLADOR;

import EJB.EmpleadorEFacadeLocal;      //Contiene la CRUD
import ENTIDADES.EmpleadorE;           
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "managedBeanEmpleador")
@SessionScoped
public class ManagedBeanEmpleador implements Serializable {

    public ManagedBeanEmpleador() {}
    
     @EJB
    private EmpleadorEFacadeLocal empleadorFacade;
    private String msj;
    private List<EmpleadorE> ListaEmpleador;
    private EmpleadorE empleador;
    
    
    
       //GETTERS Y SETTERS
    
    public String getMsj(){
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public List<EmpleadorE> getListaEmpleador() {
       this.ListaEmpleador= this.empleadorFacade.findAll();
        return ListaEmpleador;
    }

    public void setListaEmpleador(List<EmpleadorE> ListaEmpleador) {
        this.ListaEmpleador = ListaEmpleador;
    }

    public EmpleadorE getEmpleador() {
        return empleador;
    }

 
    public void setEmpleador(EmpleadorE empleador) {
        this.empleador = empleador;
    }

    @PostConstruct
    public void init() {
        empleador = new EmpleadorE();
    }
   
     public void registrar_e() {
    
        try {
            this.empleadorFacade.create(empleador);
            this.empleador = new EmpleadorE();
            this.msj = "Registro con éxito";
         
        }
        
       catch (Exception e){
           e.printStackTrace();
           this.msj = "Error"+e.getMessage();
           
       }
       FacesMessage mensaje = new FacesMessage (this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
   
    }    
       public void limpiar_e()
         {
             this.empleador = new EmpleadorE();
         }
     
        //MÉTODO ACTUALIZAR 
           public void actualizar(){

              try {
                   this.empleadorFacade.edit(empleador);
                   this.msj = "Registro Actualizado con éxito!";
                   this.empleador = new EmpleadorE();
              }
              catch(Exception e){
                   e.printStackTrace();
                   this.msj= "Error"+e.getMessage();

               }
               FacesMessage mensaje =new FacesMessage(this.msj);
               FacesContext.getCurrentInstance().addMessage(null, mensaje);
           }
           
}

    
   
    



