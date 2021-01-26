
package com.club.equinoccio.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/*


 Entidad Persona, que se relacionará con la clase Curso
 y Salida

*/


@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    
    @Id
    private String rut;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date fecha_nacimiento;
    private String domicilio;
    private String comuna;
    private String telefono;
    private String telefono_emergencia;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salida_id")
    private Salida salida;

    public Persona() {
    }

    public Persona(String rut, String nombre, String apellido, String nacionalidad, Date fecha_nacimiento, String domicilio, String comuna, String telefono, String telefono_emergencia, Salida salida) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.telefono_emergencia = telefono_emergencia;
        this.salida = salida;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono_emergencia() {
        return telefono_emergencia;
    }

    public void setTelefono_emergencia(String telefono_emergencia) {
        this.telefono_emergencia = telefono_emergencia;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    
    

}