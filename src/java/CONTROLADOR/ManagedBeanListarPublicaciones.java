package CONTROLADOR;

import EJB.FincaFFacadeLocal;
import ENTIDADES.EmpleadorE;
import ENTIDADES.FincaF;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "managedBeanListarPublicaciones")
@SessionScoped
public class ManagedBeanListarPublicaciones implements Serializable {

    public ManagedBeanListarPublicaciones() { }
    
        @EJB
         // Finca
         private FincaFFacadeLocal EJBFinca;
         private List<FincaF> ListaFinca;
         private FincaF finc;
         private String msj;
         private EmpleadorE emple;
         
         //Variables listar
         private int cod_finca;
         private String nom_f;
         private String vereda_f;
         private String tipo;
         private String modalidad_f;
         private int salario_f;
         private int cant_tra;
         private Time horario_e;
         private Time horario_s;
         private int id_emple;
         
         
         //GETTERS Y SETTERS 

        public List<FincaF> getListaFinca() {
            this.ListaFinca = this.EJBFinca.findAll();
            return ListaFinca;
        }

        public void setListaFinca(List<FincaF> ListaFinca) {
            this.ListaFinca = ListaFinca;
        }

        public FincaF getFinc() {
            return finc;
        }

        public void setFinc(FincaF finc) {
            this.finc = finc;
        }

        public String getMsj() {
            return msj;
        }

        public void setMsj(String msj) {
            this.msj = msj;
        }

        public EmpleadorE getEmple() {
            return emple;
        }

        public void setEmple(EmpleadorE emple) {
            this.emple = emple;
        }

        public int getCod_finca() {
            return cod_finca;
        }

        public void setCod_finca(int cod_finca) {
            this.cod_finca = cod_finca;
        }

        public String getNom_f() {
            return nom_f;
        }

        public void setNom_f(String nom_f) {
            this.nom_f = nom_f;
        }

        public String getVereda_f() {
            return vereda_f;
        }

        public void setVereda_f(String vereda_f) {
            this.vereda_f = vereda_f;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getModalidad_f() {
            return modalidad_f;
        }

        public void setModalidad_f(String modalidad_f) {
            this.modalidad_f = modalidad_f;
        }

        public int getSalario_f() {
            return salario_f;
        }

        public void setSalario_f(int salario_f) {
            this.salario_f = salario_f;
        }

        public int getCant_tra() {
            return cant_tra;
        }

        public void setCant_tra(int cant_tra) {
            this.cant_tra = cant_tra;
        }

        public Time getHorario_e() {
            return horario_e;
        }

        public void setHorario_e(Time horario_e) {
            this.horario_e = horario_e;
        }

        public Time getHorario_s() {
            return horario_s;
        }

        public void setHorario_s(Time horario_s) {
            this.horario_s = horario_s;
        }

        public int getId_emple() {
            return id_emple;
        }

        public void setId_emple(int id_emple) {
            this.id_emple = id_emple;
        }

       
        @PostConstruct
        public void init(){
            this.finc = new FincaF();
            this.emple = new EmpleadorE();
        }
        
        // MÉTODO PARA LISTAR PUBLICACIONES 
 /*       public String listar_publicaciones(){
            
            FincaF fin;
            
            
            try{
                
                fin = EJBFinca.listar_ofertas(finc);
                
                if(fin!=null){
                    
                    FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", " "));
                  
                    cod_finca = fin.getCodigoFinca();
                    nom_f = fin.getNombreFinca();
                    vereda_f = fin.getVereda();
                    tipo = fin.getTipoLabor();
                    modalidad_f = fin.getModalidad();
                    salario_f = fin.getSalario();
                    cant_tra = fin.getCantTrabajadores();
                    horario_e = (Time) fin.getHorarioEntrada();
                    horario_s = (Time) fin.getHorarioSalida();
                    id_emple = emple.getIdEmpleador();
                    
                }
            
           else {
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Propietario No registrado", " "));
                }  
           }
           catch (Exception e){}
            return "";
           }*/
}

