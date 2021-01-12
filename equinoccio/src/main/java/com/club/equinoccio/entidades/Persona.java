
package com.club.equinoccio.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/*


 Entidad Persona, que se relacionará con la clase Curso
 y Salida

*/


@Entity
public class Persona implements Serializable {
    
    @Id
    private String rut;
    private String Nombre;
    private Integer edad;
    private String nacionalidad;
    private String domicilio;
    private String telefono;

    public Persona() {
    }

    public Persona(String rut, String Nombre, Integer edad, String nacionalidad, String domicilio, String telefono) {
        this.rut = rut;
        this.Nombre = Nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
