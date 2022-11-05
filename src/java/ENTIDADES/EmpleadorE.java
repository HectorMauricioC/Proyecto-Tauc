/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDADES;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "empleador_e")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadorE.findAll", query = "SELECT e FROM EmpleadorE e")
    , @NamedQuery(name = "EmpleadorE.findByIdEmpleador", query = "SELECT e FROM EmpleadorE e WHERE e.idEmpleador = :idEmpleador")
    , @NamedQuery(name = "EmpleadorE.findByNomEmpleador", query = "SELECT e FROM EmpleadorE e WHERE e.nomEmpleador = :nomEmpleador")
    , @NamedQuery(name = "EmpleadorE.findByApeEmpleador", query = "SELECT e FROM EmpleadorE e WHERE e.apeEmpleador = :apeEmpleador")
    , @NamedQuery(name = "EmpleadorE.findBySexoEmpleador", query = "SELECT e FROM EmpleadorE e WHERE e.sexoEmpleador = :sexoEmpleador")
    , @NamedQuery(name = "EmpleadorE.findByTelEmpleador", query = "SELECT e FROM EmpleadorE e WHERE e.telEmpleador = :telEmpleador")
    , @NamedQuery(name = "EmpleadorE.findByCorreo", query = "SELECT e FROM EmpleadorE e WHERE e.correo = :correo")
    , @NamedQuery(name = "EmpleadorE.findByContrasenaE", query = "SELECT e FROM EmpleadorE e WHERE e.contrasenaE = :contrasenaE")
    , @NamedQuery(name = "EmpleadorE.findByConfirmarContrasenaE", query = "SELECT e FROM EmpleadorE e WHERE e.confirmarContrasenaE = :confirmarContrasenaE")})
public class EmpleadorE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleador")
    private Integer idEmpleador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_empleador")
    private String nomEmpleador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ape_empleador")
    private String apeEmpleador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sexo_empleador")
    private String sexoEmpleador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tel_empleador")
    private String telEmpleador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasena_e")
    private String contrasenaE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "confirmar_contrasena_e")
    private String confirmarContrasenaE;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleador")
    private Collection<FincaF> fincaFCollection;

    public EmpleadorE() {
    }

    public EmpleadorE(Integer idEmpleador) {
        this.idEmpleador = idEmpleador;
    }

    public EmpleadorE(Integer idEmpleador, String nomEmpleador, String apeEmpleador, String sexoEmpleador, String telEmpleador, String correo, String contrasenaE, String confirmarContrasenaE) {
        this.idEmpleador = idEmpleador;
        this.nomEmpleador = nomEmpleador;
        this.apeEmpleador = apeEmpleador;
        this.sexoEmpleador = sexoEmpleador;
        this.telEmpleador = telEmpleador;
        this.correo = correo;
        this.contrasenaE = contrasenaE;
        this.confirmarContrasenaE = confirmarContrasenaE;
    }

    public Integer getIdEmpleador() {
        return idEmpleador;
    }

    public void setIdEmpleador(Integer idEmpleador) {
        this.idEmpleador = idEmpleador;
    }

    public String getNomEmpleador() {
        return nomEmpleador;
    }

    public void setNomEmpleador(String nomEmpleador) {
        this.nomEmpleador = nomEmpleador;
    }

    public String getApeEmpleador() {
        return apeEmpleador;
    }

    public void setApeEmpleador(String apeEmpleador) {
        this.apeEmpleador = apeEmpleador;
    }

    public String getSexoEmpleador() {
        return sexoEmpleador;
    }

    public void setSexoEmpleador(String sexoEmpleador) {
        this.sexoEmpleador = sexoEmpleador;
    }

    public String getTelEmpleador() {
        return telEmpleador;
    }

    public void setTelEmpleador(String telEmpleador) {
        this.telEmpleador = telEmpleador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenaE() {
        return contrasenaE;
    }

    public void setContrasenaE(String contrasenaE) {
        this.contrasenaE = contrasenaE;
    }

    public String getConfirmarContrasenaE() {
        return confirmarContrasenaE;
    }

    public void setConfirmarContrasenaE(String confirmarContrasenaE) {
        this.confirmarContrasenaE = confirmarContrasenaE;
    }

    @XmlTransient
    public Collection<FincaF> getFincaFCollection() {
        return fincaFCollection;
    }

    public void setFincaFCollection(Collection<FincaF> fincaFCollection) {
        this.fincaFCollection = fincaFCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleador != null ? idEmpleador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadorE)) {
            return false;
        }
        EmpleadorE other = (EmpleadorE) object;
        if ((this.idEmpleador == null && other.idEmpleador != null) || (this.idEmpleador != null && !this.idEmpleador.equals(other.idEmpleador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        return String.valueOf(idEmpleador);
    }
    
}
