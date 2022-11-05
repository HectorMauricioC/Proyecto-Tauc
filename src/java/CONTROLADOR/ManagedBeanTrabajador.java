
package CONTROLADOR;

import EJB.TrabajadorTFacadeLocal;
import ENTIDADES.TrabajadorT;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "managedBeanTrabajador")
@SessionScoped
public class ManagedBeanTrabajador implements Serializable {

 
    public ManagedBeanTrabajador() { }
    @EJB
    private TrabajadorTFacadeLocal trabajadorFacade;
    private List<TrabajadorT> ListaTrabajador;
    private TrabajadorT trabajador;
    private String msj; 
    private String msjt;
    private String msjo; 
    private String msjn;
    
      
    //Variable para el logueo trabajador
    private int id_t;
    private String nom_t;
    private String ape_t;
    private String sexo_t;
    private String tel_t;
    private String estadoc_t;
    private String experiencia_t;
    private String correo_t;
    private String contra_t;
    private String confircontra_t;
    
    
    //GETTERS Y SETTERS 

    public List<TrabajadorT> getListaTrabajador() {
        this.ListaTrabajador = this.trabajadorFacade.findAll();
        return ListaTrabajador;
    }

    public void setListaTrabajador(List<TrabajadorT> ListaTrabajador) {
        this.ListaTrabajador = ListaTrabajador;
    }

    public TrabajadorT getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorT trabajador) {
        this.trabajador = trabajador;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public String getMsjo() {
        return msjo;
    }

    public void setMsjo(String msjo) {
        this.msjo = msjo;
    }

    public String getMsjn() {
        return msjn;
    }

    public void setMsjn(String msjn) {
        this.msjn = msjn;
    }

    public String getMsjt() {
        return msjt;
    }

    public void setMsjt(String msjt) {
        this.msjt = msjt;
    }

    public int getId_t() {
        return id_t;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public String getNom_t() {
        return nom_t;
    }

    public void setNom_t(String nom_t) {
        this.nom_t = nom_t;
    }

    public String getApe_t() {
        return ape_t;
    }

    public void setApe_t(String ape_t) {
        this.ape_t = ape_t;
    }

    public String getSexo_t() {
        return sexo_t;
    }

    public void setSexo_t(String sexo_t) {
        this.sexo_t = sexo_t;
    }

    public String getTel_t() {
        return tel_t;
    }

    public void setTel_t(String tel_t) {
        this.tel_t = tel_t;
    }

    public String getEstadoc_t() {
        return estadoc_t;
    }

    public void setEstadoc_t(String estadoc_t) {
        this.estadoc_t = estadoc_t;
    }

    public String getExperiencia_t() {
        return experiencia_t;
    }

    public void setExperiencia_t(String experiencia_t) {
        this.experiencia_t = experiencia_t;
    }

    public String getCorreo_t() {
        return correo_t;
    }

    public void setCorreo_t(String correo_t) {
        this.correo_t = correo_t;
    }

    public String getContra_t() {
        return contra_t;
    }

    public void setContra_t(String contra_t) {
        this.contra_t = contra_t;
    }

    public String getConfircontra_t() {
        return confircontra_t;
    }

    public void setConfircontra_t(String confircontra_t) {
        this.confircontra_t = confircontra_t;
    }
    
    

    
     /*le indicamos a un método que debe ejecutarse o debe ser llamado después de la construcción del bean.*/
    @PostConstruct         
    
    public void init(){
        this.trabajador = new TrabajadorT();
      
    }
    
    
    public void registrar_t(){
        
       try{
           this.trabajadorFacade.create(trabajador);
           this.trabajador = new TrabajadorT();
           this.msj = "Trabajador registrado con éxito";
       }
       catch (Exception e) {
          e.printStackTrace();
          this.msj = "Error"+e.getMessage();
       }
       FacesMessage mensaje =new FacesMessage(this.msj);
      FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    
     //MÉTODO CARGAR DATOS PARA EDITAR
         public void cargardatos_t(TrabajadorT t)
         {
             this.trabajador = t;
         }
         
         //MÉTODO LIMPIAR
         
         public void limpiar_t()
         {
             this.trabajador = new TrabajadorT();
         }
         
         //MÉTODO ACTUALIZAR 
           public void actualizar_t(){

              try {
                   this.trabajadorFacade.edit(trabajador);
                   this.msjt = "Registro Actualizado con éxito!";
                   this.trabajador = new TrabajadorT();
              }
              catch(Exception e){
                   e.printStackTrace();
                   this.msjt= "Error"+e.getMessage();

               }
               FacesMessage mensaje =new FacesMessage(this.msjt);
               FacesContext.getCurrentInstance().addMessage(null, mensaje);
           }
           
           
            //METODO GUARDAR PARA EL BOTON NUEVO
                public void nuevo_t(){
                try{

                    this.trabajadorFacade.create(trabajador);
                    this.msj = "Registro Creado Correctamente";
                    this.trabajador = new TrabajadorT();

                }catch(Exception e){
                    e.printStackTrace();
                    this.msj= "Error"+e.getMessage();

                }
              FacesMessage mensaje =new FacesMessage(this.msj);
              FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
                
                   //ELIMINAR 
         public void eliminar_t(TrabajadorT eliminar){

             try {
                 this.trabajadorFacade.remove(eliminar);
                 this.msjo = "Registro eliminado Correctamente";

             }catch (Exception e){
                 e.printStackTrace();
                 this.msjo = "Error"+e.getMessage();
             }
         }
         
         public void cerrar_sesion(){
             FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         }
    
}
