package CONTROLADOR;

import EJB.FincaFFacadeLocal;
import ENTIDADES.FincaF;
import ENTIDADES.EmpleadorE;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "managedBeanFinca")
@SessionScoped

public class ManagedBeanFinca implements Serializable {

  
    public ManagedBeanFinca() {}
    
    @EJB
    
    private FincaFFacadeLocal fincaFacade;
    private List<FincaF> ListaFincas;
    private FincaF finca;
    private String msj;
    private String msje;
    private EmpleadorE empleador;
    
    
    //GETTERS Y SETTERS 

    public List<FincaF> getListaFincas() {
        this.ListaFincas = this.fincaFacade.findAll();
        return ListaFincas;
    }

    public void setListaFincas(List<FincaF> ListaFincas) {
        this.ListaFincas = ListaFincas;
    }

    public FincaF getFinca() {
        return finca;
    }

    public void setFinca(FincaF finca) {
        this.finca = finca;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public String getMsje() {
        return msje;
    }

    public void setMsje(String msje) {
        this.msje = msje;
    }
    
    
    public EmpleadorE getEmpleador() {
        return empleador;
    }

    public void setEmpleador(EmpleadorE empleador) {
        this.empleador = empleador;
    }

   
    
    
    //POST CONSTRUCTOR
    @PostConstruct
    
    public void init(){
        this.finca = new FincaF();
        this.empleador = new EmpleadorE();
    }
    
    public void registrar_f(){
      
       try {
           this.finca.setIdEmpleador(empleador);
           this.fincaFacade.create(finca);
           this.finca = new FincaF();
           this.empleador = new EmpleadorE();
           this.msj = "Registro creado con éxito!";
           
       }catch (Exception e){
           e.printStackTrace();
           this.msj = "Error"+e.getMessage();
       }
       FacesMessage mensaje =new FacesMessage(this.msj);
      FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    
         //MÉTODO CARGAR DATOS PARA EDITAR
         public void cargardatos(FincaF f)
         {
             this.finca = f;
             
         }
         
         //MÉTODO LIMPIAR
         
         public void limpiar()
         {
             this.finca = new FincaF();
         }
         
         //MÉTODO ACTUALIZAR 
           public void actualizar(){

              try {
                   this.fincaFacade.edit(finca);
                   this.msj = "Registro Actualizado con éxito!";
                   this.finca = new FincaF();
              }
              catch(Exception e){
                   e.printStackTrace();
                   this.msj= "Error"+e.getMessage();

               }
               FacesMessage mensaje =new FacesMessage(this.msj);
               FacesContext.getCurrentInstance().addMessage(null, mensaje);
           }
           
           
            //METODO GUARDAR PARA EL BOTON NUEVO
                public void nuevo_f(){
                try{

                    this.finca.setIdEmpleador(empleador);
                    this.fincaFacade.create(finca);
                    this.msj = "Registro Creado Correctamente";
                    this.empleador = new EmpleadorE();
                    this.finca = new FincaF();

                }catch(Exception e){
                    e.printStackTrace();
                    this.msj= "Error"+e.getMessage();

                }
              FacesMessage mensaje =new FacesMessage(this.msj);
              FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }

                 //MÉTODO CARGAR DATOS PARA EDITAR
         public void cargardatos_f(FincaF f)
         {
             this.finca = f;
         }
         
         //MÉTODO LIMPIAR
         
         public void limpiar_f()
         {
             this.finca = new FincaF();
         }
         
         //MÉTODO ACTUALIZAR 
           public void actualizar_f(){

              try {
                   this.fincaFacade.edit(finca);
                   this.msj = "Registro Actualizado con éxito!";
                   this.finca = new FincaF();
              }
              catch(Exception e){
                   e.printStackTrace();
                   this.msj= "Error"+e.getMessage();

               }
               FacesMessage mensaje =new FacesMessage(this.msj);
               FacesContext.getCurrentInstance().addMessage(null, mensaje);
           }
           
              //ELIMINAR 
         public void eliminar_f(FincaF eliminar){

             try {
                 this.fincaFacade.remove(eliminar);
                 this.msje = "Registro eliminado Correctamente";

             }catch (Exception e){
                 e.printStackTrace();
                 this.msje = "Error"+e.getMessage();
             }
              FacesMessage mensaje =new FacesMessage(this.msje);
               FacesContext.getCurrentInstance().addMessage(null, mensaje);
      }
}

