
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Persona;
import com.club.equinoccio.entidades.Salida;
import com.club.equinoccio.servicios.PersonaServicio;
import com.club.equinoccio.servicios.SalidaServicio;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonaControlador {
    @Autowired
    private final PersonaServicio personaServicio;
    @Autowired
    private final SalidaServicio salidaServicio;

    public PersonaControlador(PersonaServicio personaServicio, SalidaServicio salidaServicio) {
        this.personaServicio = personaServicio;
        this.salidaServicio = salidaServicio;
    }
    
    
    
    @GetMapping("/salidas/participantes/{idSalida}")
    public ModelAndView listar_personas(@PathVariable String idSalida) throws Exception{
        Salida salida = salidaServicio.buscar(idSalida);
        List<Persona> personas = salida.getPersonas();
        ModelAndView mv = new ModelAndView("list-personas");
        mv.addObject("personas", personas);
        return mv;
        
    }
}
