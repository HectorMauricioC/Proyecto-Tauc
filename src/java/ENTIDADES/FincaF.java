/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDADES;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "finca_f")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FincaF.findAll", query = "SELECT f FROM FincaF f")
    , @NamedQuery(name = "FincaF.findByCodigoFinca", query = "SELECT f FROM FincaF f WHERE f.codigoFinca = :codigoFinca")
    , @NamedQuery(name = "FincaF.findByNombreFinca", query = "SELECT f FROM FincaF f WHERE f.nombreFinca = :nombreFinca")
    , @NamedQuery(name = "FincaF.findByVereda", query = "SELECT f FROM FincaF f WHERE f.vereda = :vereda")
    , @NamedQuery(name = "FincaF.findByTipoLabor", query = "SELECT f FROM FincaF f WHERE f.tipoLabor = :tipoLabor")
    , @NamedQuery(name = "FincaF.findByModalidad", query = "SELECT f FROM FincaF f WHERE f.modalidad = :modalidad")
    , @NamedQuery(name = "FincaF.findBySalario", query = "SELECT f FROM FincaF f WHERE f.salario = :salario")
    , @NamedQuery(name = "FincaF.findByCantTrabajadores", query = "SELECT f FROM FincaF f WHERE f.cantTrabajadores = :cantTrabajadores")
    , @NamedQuery(name = "FincaF.findByHorarioEntrada", query = "SELECT f FROM FincaF f WHERE f.horarioEntrada = :horarioEntrada")
    , @NamedQuery(name = "FincaF.findByHorarioSalida", query = "SELECT f FROM FincaF f WHERE f.horarioSalida = :horarioSalida")})
public class FincaF implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_finca")
    private Integer codigoFinca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_finca")
    private String nombreFinca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vereda")
    private String vereda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_labor")
    private String tipoLabor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modalidad")
    private String modalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private int salario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_trabajadores")
    private int cantTrabajadores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horario_entrada")
    @Temporal(TemporalType.TIME)
    private Date horarioEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horario_salida")
    @Temporal(TemporalType.TIME)
    private Date horarioSalida;
    @JoinColumn(name = "id_empleador", referencedColumnName = "id_empleador")
    @ManyToOne(optional = false)
    private EmpleadorE idEmpleador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoFinca")
    private Collection<TrabajadorFincaTf> trabajadorFincaTfCollection;

    public FincaF() {
    }

    public FincaF(Integer codigoFinca) {
        this.codigoFinca = codigoFinca;
    }

    public FincaF(Integer codigoFinca, String nombreFinca, String vereda, String tipoLabor, String modalidad, int salario, int cantTrabajadores, Date horarioEntrada, Date horarioSalida) {
        this.codigoFinca = codigoFinca;
        this.nombreFinca = nombreFinca;
        this.vereda = vereda;
        this.tipoLabor = tipoLabor;
        this.modalidad = modalidad;
        this.salario = salario;
        this.cantTrabajadores = cantTrabajadores;
        this.horarioEntrada = horarioEntrada;
        this.horarioSalida = horarioSalida;
    }

    public Integer getCodigoFinca() {
        return codigoFinca;
    }

    public void setCodigoFinca(Integer codigoFinca) {
        this.codigoFinca = codigoFinca;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public void setNombreFinca(String nombreFinca) {
        this.nombreFinca = nombreFinca;
    }

    public String getVereda() {
        return vereda;
    }

    public void setVereda(String vereda) {
        this.vereda = vereda;
    }

    public String getTipoLabor() {
        return tipoLabor;
    }

    public void setTipoLabor(String tipoLabor) {
        this.tipoLabor = tipoLabor;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getCantTrabajadores() {
        return cantTrabajadores;
    }

    public void setCantTrabajadores(int cantTrabajadores) {
        this.cantTrabajadores = cantTrabajadores;
    }

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Date getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(Date horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public EmpleadorE getIdEmpleador() {
        return idEmpleador;
    }

    public void setIdEmpleador(EmpleadorE idEmpleador) {
        this.idEmpleador = idEmpleador;
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
        hash += (codigoFinca != null ? codigoFinca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FincaF)) {
            return false;
        }
        FincaF other = (FincaF) object;
        if ((this.codigoFinca == null && other.codigoFinca != null) || (this.codigoFinca != null && !this.codigoFinca.equals(other.codigoFinca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        return String.valueOf(codigoFinca);
    }
    
}
