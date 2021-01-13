package com.club.equinoccio.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Curso {

    //Atributos//
    @Id
    private String idCurso;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date fechaTermino;
    private String nombreProfesor;
    private Integer costo;
    //Relaciones entre clases persona//
    @OneToMany
    private List<Persona> Persona;

    //Contructor//
    public Curso() {
    }

    public Curso(String idCurso, Date fechaInicio, Date fechaTermino, String nombreProfesor, Integer costo, List<Persona> Persona) {
        this.idCurso = idCurso;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.nombreProfesor = nombreProfesor;
        this.costo = costo;
        this.Persona = Persona;
    }

    //Getter and Setter//
    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public List<Persona> getPersona() {
        return Persona;
    }

    public void setPersona(List<Persona> Persona) {
        this.Persona = Persona;
    }

}
