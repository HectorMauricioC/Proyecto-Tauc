/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDADES;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "trabajador_finca_tf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajadorFincaTf.findAll", query = "SELECT t FROM TrabajadorFincaTf t")
    , @NamedQuery(name = "TrabajadorFincaTf.findByIdAux", query = "SELECT t FROM TrabajadorFincaTf t WHERE t.idAux = :idAux")})
public class TrabajadorFincaTf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aux")
    private Integer idAux;
    @JoinColumn(name = "codigo_finca", referencedColumnName = "codigo_finca")
    @ManyToOne(optional = false)
    private FincaF codigoFinca;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador")
    @ManyToOne(optional = false)
    private TrabajadorT idTrabajador;

    public TrabajadorFincaTf() {
    }

    public TrabajadorFincaTf(Integer idAux) {
        this.idAux = idAux;
    }

    public Integer getIdAux() {
        return idAux;
    }

    public void setIdAux(Integer idAux) {
        this.idAux = idAux;
    }

    public FincaF getCodigoFinca() {
        return codigoFinca;
    }

    public void setCodigoFinca(FincaF codigoFinca) {
        this.codigoFinca = codigoFinca;
    }

    public TrabajadorT getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(TrabajadorT idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAux != null ? idAux.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorFincaTf)) {
            return false;
        }
        TrabajadorFincaTf other = (TrabajadorFincaTf) object;
        if ((this.idAux == null && other.idAux != null) || (this.idAux != null && !this.idAux.equals(other.idAux))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       
        return String.valueOf(idAux);
    }
    
}
