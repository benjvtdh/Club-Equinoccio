/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.club.equinoccio.servicios;

import com.club.equinoccio.entidades.Persona;
import com.club.equinoccio.repositorios.PersonaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 
 * Servicio Persona para crear, eliminar y buscar personas en la base de datos

 */

@Service
public class PersonaServicio {
    @Autowired
    private final PersonaRepositorio personaRepositorio;

    public PersonaServicio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Persona guardar(Persona persona){
        return personaRepositorio.save(persona);
    }   
    
    
    public Persona buscar(String rut) throws Exception{
        Optional<Persona> persona = personaRepositorio.findById(rut);
        if(!persona.isPresent() ){
            throw new Exception("No se encontró una persona con ese documento");
        }
        return persona.get();
    
    }
    
    public List<Persona> buscarTodos(){
        return personaRepositorio.findAll();
        
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(String rut) throws Exception{
        Persona persona = buscar(rut);
        personaRepositorio.delete(persona);
    }
    
    
    
    
}
