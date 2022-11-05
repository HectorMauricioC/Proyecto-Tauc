/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import EJB.TrabajadorFincaTfFacadeLocal;
import ENTIDADES.FincaF;
import ENTIDADES.TrabajadorFincaTf;
import ENTIDADES.TrabajadorT;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "mBeanFincaTrabajador")
@SessionScoped
public class MBeanFincaTrabajador implements Serializable {

    public MBeanFincaTrabajador() {}
    
     @EJB 
    
    private TrabajadorFincaTfFacadeLocal trabajadorFincaFacade;
    private String msjtf;
    private List<TrabajadorFincaTf> ListaTrabajadorFinca;
    private TrabajadorFincaTf trabajadorfinca;
    private TrabajadorT trabajador;
    private FincaF finca;
    
    //GETTERS  Y SETTERS

    public String getMsjtf() {
        return msjtf;
    }

    public void setMsjtf(String msjtf) {
        this.msjtf = msjtf;
    }

    public List<TrabajadorFincaTf> getListaTrabajadorFinca() {
        this.ListaTrabajadorFinca = this.trabajadorFincaFacade.findAll();
        return ListaTrabajadorFinca;
    }

    public void setListaTrabajadorFinca(List<TrabajadorFincaTf> ListaTrabajadorFinca) {
        this.ListaTrabajadorFinca = ListaTrabajadorFinca;
    }

    public TrabajadorFincaTf getTrabajadorfinca() {
        return trabajadorfinca;
    }

    public void setTrabajadorfinca(TrabajadorFincaTf trabajadorfinca) {
        this.trabajadorfinca = trabajadorfinca;
    }

    public TrabajadorT getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorT trabajador) {
        this.trabajador = trabajador;
    }

    public FincaF getFinca() {
        return finca;
    }

    public void setFinca(FincaF finca) {
        this.finca = finca;
    }

 
    @PostConstruct
    public void init() {
        
        this.finca = new FincaF();
        this.trabajador = new TrabajadorT();
        this.trabajadorfinca = new TrabajadorFincaTf();
        
    }
    
    public void registro_postulacion(){
        
      try{
         
          this.trabajadorfinca.setIdTrabajador(trabajador);
          this.trabajadorfinca.setCodigoFinca(finca);
          this.trabajadorFincaFacade.create(trabajadorfinca);
          this.trabajadorfinca = new TrabajadorFincaTf();
          this.finca = new FincaF();
          this.trabajador = new TrabajadorT();
          this.msjtf = "Postulado con éxito";
          
      }
    catch (Exception e){
       e.printStackTrace();
       this.msjtf = "Error"+e.getMessage();
        }
      FacesMessage mensaje = new FacesMessage (this.msjtf);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}

