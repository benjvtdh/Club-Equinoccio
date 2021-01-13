
package com.club.equinoccio.servicios;

import com.club.equinoccio.entidades.Curso;
import com.club.equinoccio.repositorios.CursoRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServicio {
   @Autowired
   private CursoRepositorio cursoRepositorio;
    
    @Transactional(rollbackOn = Exception.class)
    public Curso guardar (Curso curso) throws Exception {
        if (curso.getFechaInicio()== null ){
            throw new Exception("El curso debe tener una fecha de inicio");
        }if(curso.getFechaTermino() == null){
            throw new Exception("El curso debe tener una fecha de termino");   
        }if (curso.getNombreProfesor()== null){
           throw new Exception ("El curso debe tener algun profesor"); 
        }
        return cursoRepositorio.save(curso);
    }
    public Curso buscar(String id) throws Exception {
        Optional<Curso> curso = cursoRepositorio.findById(id);
        if (!curso.isPresent()) {
            throw new Exception("No se encontró un curso con ese id.");
        }
        return curso.get();
    }
     @Transactional(rollbackOn = Exception.class)
    public void eliminar(String id) throws Exception {
        Curso curso = buscar(id);
        cursoRepositorio.delete(curso);
    }
}
