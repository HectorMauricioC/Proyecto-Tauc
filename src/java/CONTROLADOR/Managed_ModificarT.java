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


@Named(value = "managed_ModificarT")
@SessionScoped
public class Managed_ModificarT implements Serializable {

   
    public Managed_ModificarT() { }
    
     @EJB
    
     //Trabajador 
    private TrabajadorTFacadeLocal EJBtrabajador;
    private List<TrabajadorT> ListaTrabajador;
    private TrabajadorT trabaj;
    private String msjt;
   
    
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
        this.ListaTrabajador = this.EJBtrabajador.findAll();
        return ListaTrabajador;
    }

    public void setListaTrabajador(List<TrabajadorT> ListaTrabajador) {
        this.ListaTrabajador = ListaTrabajador;
    }

    public TrabajadorT getTrabaj() {
        return trabaj;
    }

    public void setTrabaj(TrabajadorT trabaj) {
        this.trabaj = trabaj;
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
    
    
    
     @PostConstruct 
        public void init(){    //Instancia el objeto
            this.trabaj = new TrabajadorT();
        }
    
    
        //MODIFICAR DATOS TRABAJADOR
        
        public String modificar_trabajador()
        {
            TrabajadorT traba;
            String redireccion="";
            
            try {
                
                traba = EJBtrabajador.modificar_tra(trabaj);
                
                if(traba!=null){
                    
                   id_t = traba.getIdTrabajador();
                   nom_t = traba.getNomTrabajador();
                   ape_t = traba.getApeTrabajador();
                   sexo_t = traba.getSexoTrabajador();
                   tel_t = traba.getTelTrabajador();
                   estadoc_t = traba.getEstadoCivil();
                   experiencia_t = traba.getExperiencia();
                   correo_t = traba.getCorreoTrabajador();
                   contra_t = traba.getContrasenaT();
                   confircontra_t = traba.getConfirmarContrasenaT();
                   this.msjt = "Registro Actualizado con éxito!";
                   } 
                else{
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "No se pudo actualizar este registro", " "));
                }
                }
                catch (Exception e){}
                return redireccion;
            }          
        
            public void cerrarsesiont()
             {
              FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
             }

}
