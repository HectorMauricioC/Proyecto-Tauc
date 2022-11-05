package CONTROLADOR;

    import EJB.EmpleadorEFacadeLocal;
    import ENTIDADES.EmpleadorE;
    import javax.inject.Named;
    import javax.enterprise.context.SessionScoped;
    import java.io.Serializable;
    import java.util.List;
    import javax.annotation.PostConstruct;
    import javax.ejb.EJB;
    import javax.faces.application.FacesMessage;
    import javax.faces.context.FacesContext;

@Named(value = "managedBeanIngresoPropietario")
@SessionScoped
public class ManagedBeanIngresoPropietario implements Serializable {

    
    public ManagedBeanIngresoPropietario() {}
    
    @EJB
    //Empleador 
    private EmpleadorEFacadeLocal  EJBempleador;
    private List<EmpleadorE> ListaEmpleador;
    private EmpleadorE emp;     //Inicio sesión
    private EmpleadorE prop;    //Actualizar
    private String msjp;
    
   
    //Variables para el logueo empleador
    private int id_e;
    private String nom_e;
    private String ape_e;
    private String sexo_e;
    private String tel_e;
    private String correo_e;
    private String contra_e;
    private String confircontra_e;
    
   
    //GETTERS Y SETTERS EMPLEADOR

    public List<EmpleadorE> getListaEmpleador() {
        this.ListaEmpleador = this.EJBempleador.findAll();
        return ListaEmpleador;
    }

    public void setListaEmpleador(List<EmpleadorE> ListaEmpleador) {
        this.ListaEmpleador = ListaEmpleador;
    }

    public EmpleadorE getEmp() {
        return emp;
    }

    public void setEmp(EmpleadorE emp) {
        this.emp = emp;
    }

    public String getMsjp() {
        return msjp;
    }

    public void setMsjp(String msjp) {
        this.msjp = msjp;
    }

    
    public int getId_e() {
        return id_e;
    }

    public void setId_e(int id_e) {
        this.id_e = id_e;
    }

    public String getNom_e() {
        return nom_e;
    }

    public void setNom_e(String nom_e) {
        this.nom_e = nom_e;
    }

    public String getApe_e() {
        return ape_e;
    }

    public void setApe_e(String ape_e) {
        this.ape_e = ape_e;
    }

    public String getSexo_e() {
        return sexo_e;
    }

    public void setSexo_e(String sexo_e) {
        this.sexo_e = sexo_e;
    }

    public String getTel_e() {
        return tel_e;
    }

    public void setTel_e(String tel_e) {
        this.tel_e = tel_e;
    }

    public String getCorreo_e() {
        return correo_e;
    }

    public void setCorreo_e(String correo_e) {
        this.correo_e = correo_e;
    }

    public String getContra_e() {
        return contra_e;
    }

    public void setContra_e(String contra_e) {
        this.contra_e = contra_e;
    }

    public String getConfircontra_e() {
        return confircontra_e;
    }

    public void setConfircontra_e(String confircontra_e) {
        this.confircontra_e = confircontra_e;
    }

    public EmpleadorE getProp() {
        return prop;
    }

    public void setProp(EmpleadorE prop) {
        this.prop = prop;
    }
  
    
     @PostConstruct 
        public void init(){
            this.emp = new EmpleadorE();     //Instancia el objeto
        }
    
        
        
        //FUNCIÓN QUE PERMITE VALIDAR LOS DATOS Y DE ESTA MANERA LOS MUESTRA.
        public String validar_propietario()
        {
            
           EmpleadorE emple;
           String redireccion = "";
           
           try {
               
              emple = EJBempleador.acceder_emple(emp);
              
              if(emple!=null){
                  
                  FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", " "));
                  
                  id_e = emple.getIdEmpleador();
                  nom_e = emple.getNomEmpleador();
                  ape_e = emple.getApeEmpleador();
                  sexo_e = emple.getSexoEmpleador();
                  tel_e = emple.getTelEmpleador();
                  correo_e = emple.getCorreo();
                  contra_e = emple.getContrasenaE();
                  confircontra_e = emple.getConfirmarContrasenaE();
                  
                 redireccion = "inicio_propietario?faces-redirect=true";
                
              }
                else {
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Propietario No registrado", " "));
                }  
           }
           catch (Exception e){}
            return redireccion;
           }
                   
           
        //MODIFICAR DATOS EMPLEADOR 
        
        public String modificar_propie()
        {
            EmpleadorE propie;
            String redireccion = "";
            
            try {
                
                propie= EJBempleador.modificar_emple(prop);
                
                if(propie!=null){
                    
                  id_e = propie.getIdEmpleador();
                  nom_e = propie.getNomEmpleador();
                  ape_e = propie.getApeEmpleador();
                  sexo_e = propie.getSexoEmpleador();
                  tel_e = propie.getTelEmpleador();
                  correo_e = propie.getCorreo();
                  contra_e = propie.getContrasenaE();
                  confircontra_e = propie.getConfirmarContrasenaE();
                  this.msjp = "Registro Actualizado Correctamente";
                }
                else{
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "No se pudo actualizar este registro", " "));
                }
                }
                catch (Exception e){}
                    return redireccion;
                }  

            public void cerrarsesionp()
           {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
           }
}
