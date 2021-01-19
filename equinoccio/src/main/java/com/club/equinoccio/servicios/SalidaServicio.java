
package com.club.equinoccio.servicios;

import com.club.equinoccio.entidades.Salida;
import com.club.equinoccio.repositorios.SalidaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 
 SalidaServicio que permitirá guardar, buscar, actualizar y eliminar
 registros de la entidad Salida
 
 */

@Service
public class SalidaServicio {
    
    @Autowired
    private final SalidaRepositorio salidaRepositorio;

    public SalidaServicio(SalidaRepositorio salidaRepositorio) {
        this.salidaRepositorio = salidaRepositorio;
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Salida guardar(Salida salida) throws Exception{
        if(salida.getPersonas() == null){
            throw new Exception("La salida no tiene una lista de personas");
        }
        
        return salidaRepositorio.save(salida);
        
    }
    
    public Salida buscar(String idSalida) throws Exception{
        Optional<Salida> salida = salidaRepositorio.findById(idSalida);
        if(!salida.isPresent()){
            throw new Exception("No hay una salida con ese id");
        }
        return salida.get();
        
    }
    
    public List<Salida> buscarTodos(){
        return salidaRepositorio.findAll();
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(String idSalida) throws Exception{
        Salida salida = buscar(idSalida);
        salidaRepositorio.delete(salida);
    }
}
