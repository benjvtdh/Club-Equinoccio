package com.club.equinoccio.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Curso {
    //Atributos//
    @Id
    private String idCurso;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    private String nombreProfesor;
    private Integer costo;
    //Relaciones entre clases persona//
    @ManyToMany 
    private List<Persona> Persona;
    
    //Contructor//
    
    public Curso() {
    }

    public Curso(Date FechaInicio, Date FechaTermino, String Nombre_profesor, Integer Costo, List<Persona> Persona) {
        this.FechaInicio = FechaInicio;
        this.FechaTermino = FechaTermino;
        this.Nombre_profesor = Nombre_profesor;
        this.Costo = Costo;
        this.Persona = Persona;
    }
    
    //Getter and Setter//

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaTermino() {
        return FechaTermino;
    }

    public void setFechaTermino(Date FechaTermino) {
        this.FechaTermino = FechaTermino;
    }

    public String getNombre_profesor() {
        return Nombre_profesor;
    }

    public void setNombre_profesor(String Nombre_profesor) {
        this.Nombre_profesor = Nombre_profesor;
    }

    public Integer getCosto() {
        return Costo;
    }

    public void setCosto(Integer Costo) {
        this.Costo = Costo;
    }

    public List<Persona> getPersona() {
        return Persona;
    }

    public void setPersona(List<Persona> Persona) {
        this.Persona = Persona;
    }
    
}
