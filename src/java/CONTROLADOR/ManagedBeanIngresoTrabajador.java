/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author USUARIO
 */
@Named(value = "managedBeanIngresoTrabajador")
@SessionScoped
public class ManagedBeanIngresoTrabajador implements Serializable {

    public ManagedBeanIngresoTrabajador() {}
 
    @EJB
    
    
     //Trabajador 
    private TrabajadorTFacadeLocal EJBtrabajador;
    private List<TrabajadorT> ListaTrabajador;
    private TrabajadorT tra;
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
    
     //GETTERS Y SETTERS TRABAJADOR 

    public List<TrabajadorT> getListaTrabajador() {
        this.ListaTrabajador = this.EJBtrabajador.findAll();
        return ListaTrabajador;
    }

    public void setListaTrabajador(List<TrabajadorT> ListaTrabajador) {
        this.ListaTrabajador = ListaTrabajador;
    }

    public TrabajadorT getTra() {
        return tra;
    }

    public void setTra(TrabajadorT tra) {
        this.tra = tra;
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
            this.tra = new TrabajadorT();
        }
    
     public String validar_trabajador(){
        
        TrabajadorT trab; //Agregamos una variable a la entidad, en este caso entidad Trabajador
        String redireccion = "";    //Se declara una variable de tipo cadena para redireccionar la pagina, se inicializa en vacio porque va a toamr diferentes valores  
        
        try {
            //La variable us se le asigana el metodo acceder en el sessiom bean 
            //TrabajadorFacadeLocal con la , el metodo acceder hay que crearlo en el TrabajadorFacadeLocal con la variable EJBtrabajador
            
            trab=EJBtrabajador.acceder_trab(tra);
            
            if(trab!=null){
                        
                  FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", " "));
                  
                   id_t = trab.getIdTrabajador();
                   nom_t = trab.getNomTrabajador();
                   ape_t = trab.getApeTrabajador();
                   sexo_t = trab.getSexoTrabajador();
                   tel_t = trab.getTelTrabajador();
                   estadoc_t = trab.getEstadoCivil();
                   experiencia_t = trab.getExperiencia();
                   correo_t = trab.getCorreoTrabajador();
                   contra_t = trab.getContrasenaT();
                   confircontra_t = trab.getConfirmarContrasenaT();
                 
               redireccion = "inicio_empleado?faces-redirect=true";
              
            }
            else 
            {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Trabajador no registrado", "Trab" ));
            }
            }
            catch(Exception e){}
                return redireccion;

        }
     
     
     
  }
