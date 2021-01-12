/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.club.equinoccio.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/*
 Entidad Salida que registrará la cantidad de personas, el lugar
 la ruta y tipo de actividad

 */
@Entity
public class Salida implements Serializable {
    
    @Id
    private String idSalida;
    @OneToMany
    private List<Persona> lista_persona;
    private String lugar_visitar;
    private String ruta_actividad;
    private String tipo_actividad;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date fecha_inicio;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_termino;

    public Salida() {
    }

    public Salida(String idSalida, List<Persona> lista_persona, String lugar_visitar, String ruta_actividad, String tipo_actividad, Date fecha_inicio, Date fecha_termino) {
        this.idSalida = idSalida;
        this.lista_persona = lista_persona;
        this.lugar_visitar = lugar_visitar;
        this.ruta_actividad = ruta_actividad;
        this.tipo_actividad = tipo_actividad;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }

    public String getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    public List<Persona> getLista_persona() {
        return lista_persona;
    }

    public void setLista_persona(List<Persona> lista_persona) {
        this.lista_persona = lista_persona;
    }

    public String getLugar_visitar() {
        return lugar_visitar;
    }

    public void setLugar_visitar(String lugar_visitar) {
        this.lugar_visitar = lugar_visitar;
    }

    public String getRuta_actividad() {
        return ruta_actividad;
    }

    public void setRuta_actividad(String ruta_actividad) {
        this.ruta_actividad = ruta_actividad;
    }

    public String getTipo_actividad() {
        return tipo_actividad;
    }

    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }
    
    
}
