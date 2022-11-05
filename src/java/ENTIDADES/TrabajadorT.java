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
@Table(name = "trabajador_t")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajadorT.findAll", query = "SELECT t FROM TrabajadorT t")
    , @NamedQuery(name = "TrabajadorT.findByIdTrabajador", query = "SELECT t FROM TrabajadorT t WHERE t.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "TrabajadorT.findByNomTrabajador", query = "SELECT t FROM TrabajadorT t WHERE t.nomTrabajador = :nomTrabajador")
    , @NamedQuery(name = "TrabajadorT.findByApeTrabajador", query = "SELECT t FROM TrabajadorT t WHERE t.apeTrabajador = :apeTrabajador")
    , @NamedQuery(name = "TrabajadorT.findBySexoTrabajador", query = "SELECT t FROM TrabajadorT t WHERE t.sexoTrabajador = :sexoTrabajador")
    , @NamedQuery(name = "TrabajadorT.findByTelTrabajador", query = "SELECT t FROM TrabajadorT t WHERE t.telTrabajador = :telTrabajador")
    , @NamedQuery(name = "TrabajadorT.findByEstadoCivil", query = "SELECT t FROM TrabajadorT t WHERE t.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "TrabajadorT.findByExperiencia", query = "SELECT t FROM TrabajadorT t WHERE t.experiencia = :experiencia")
    , @NamedQuery(name = "TrabajadorT.findByCorreoTrabajador", query = "SELECT t FROM TrabajadorT t WHERE t.correoTrabajador = :correoTrabajador")
    , @NamedQuery(name = "TrabajadorT.findByContrasenaT", query = "SELECT t FROM TrabajadorT t WHERE t.contrasenaT = :contrasenaT")
    , @NamedQuery(name = "TrabajadorT.findByConfirmarContrasenaT", query = "SELECT t FROM TrabajadorT t WHERE t.confirmarContrasenaT = :confirmarContrasenaT")})
public class TrabajadorT implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_trabajador")
    private Integer idTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_trabajador")
    private String nomTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ape_trabajador")
    private String apeTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sexo_trabajador")
    private String sexoTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tel_trabajador")
    private String telTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "experiencia")
    private String experiencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo_trabajador")
    private String correoTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasena_t")
    private String contrasenaT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "confirmar_contrasena_t")
    private String confirmarContrasenaT;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private Collection<TrabajadorFincaTf> trabajadorFincaTfCollection;

    public TrabajadorT() {
    }

    public TrabajadorT(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public TrabajadorT(Integer idTrabajador, String nomTrabajador, String apeTrabajador, String sexoTrabajador, String telTrabajador, String estadoCivil, String experiencia, String correoTrabajador, String contrasenaT, String confirmarContrasenaT) {
        this.idTrabajador = idTrabajador;
        this.nomTrabajador = nomTrabajador;
        this.apeTrabajador = apeTrabajador;
        this.sexoTrabajador = sexoTrabajador;
        this.telTrabajador = telTrabajador;
        this.estadoCivil = estadoCivil;
        this.experiencia = experiencia;
        this.correoTrabajador = correoTrabajador;
        this.contrasenaT = contrasenaT;
        this.confirmarContrasenaT = confirmarContrasenaT;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNomTrabajador() {
        return nomTrabajador;
    }

    public void setNomTrabajador(String nomTrabajador) {
        this.nomTrabajador = nomTrabajador;
    }

    public String getApeTrabajador() {
        return apeTrabajador;
    }

    public void setApeTrabajador(String apeTrabajador) {
        this.apeTrabajador = apeTrabajador;
    }

    public String getSexoTrabajador() {
        return sexoTrabajador;
    }

    public void setSexoTrabajador(String sexoTrabajador) {
        this.sexoTrabajador = sexoTrabajador;
    }

    public String getTelTrabajador() {
        return telTrabajador;
    }

    public void setTelTrabajador(String telTrabajador) {
        this.telTrabajador = telTrabajador;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getCorreoTrabajador() {
        return correoTrabajador;
    }

    public void setCorreoTrabajador(String correoTrabajador) {
        this.correoTrabajador = correoTrabajador;
    }

    public String getContrasenaT() {
        return contrasenaT;
    }

    public void setContrasenaT(String contrasenaT) {
        this.contrasenaT = contrasenaT;
    }

    public String getConfirmarContrasenaT() {
        return confirmarContrasenaT;
    }

    public void setConfirmarContrasenaT(String confirmarContrasenaT) {
        this.confirmarContrasenaT = confirmarContrasenaT;
    }

    @XmlTransient
    public Collection<TrabajadorFincaTf> getTrabajadorFincaTfCollection() {
        return trabajadorFincaTfCollection;
    }

    public void setTrabajadorFincaTfCollection(Collection<TrabajadorFincaTf> trabajadorFincaTfCollection) {
        this.trabajadorFincaTfCollection = trabajadorFincaTfCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajador != null ? idTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorT)) {
            return false;
        }
        TrabajadorT other = (TrabajadorT) object;
        if ((this.idTrabajador == null && other.idTrabajador != null) || (this.idTrabajador != null && !this.idTrabajador.equals(other.idTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
         return String.valueOf(idTrabajador);
    }
    
}
