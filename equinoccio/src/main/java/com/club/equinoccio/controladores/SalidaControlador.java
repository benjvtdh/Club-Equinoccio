
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Persona;
import com.club.equinoccio.entidades.Salida;
import com.club.equinoccio.servicios.PersonaServicio;
import com.club.equinoccio.servicios.SalidaServicio;
import com.club.equinoccio.utileria.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
;
import org.springframework.web.servlet.view.RedirectView;


@Controller 
public class SalidaControlador {
    @Autowired
    private final SalidaServicio salidaServicio;
    
    @Autowired
    private final PersonaServicio personaServicio;

    public SalidaControlador(SalidaServicio salidaServicio, PersonaServicio personaServicio) {
        this.salidaServicio = salidaServicio;
        this.personaServicio = personaServicio;
    }
    
    
    //Listar salidas 
    @GetMapping("/salidas")
    public ModelAndView listar_salidas(){
        ModelAndView mv= new ModelAndView ("list-salidas");
        mv.addObject("salidas", salidaServicio.buscarTodos());
        return mv;
    }
    
    // Crear una salida
    @GetMapping("/salidas/crear")
    public ModelAndView crear_salida(){
        Salida salida = new Salida();
        ModelAndView mv = new ModelAndView("salidas");
        mv.addObject("salida", salida);
        System.out.println("Se creo una salida");
        return mv;
        
    }// Guardar una salida
    @PostMapping("/salidas/save")
    public String guardar_salida(
            Salida salida , 
            @RequestParam (required = false, name = "archivoImagen") MultipartFile multiPart,
            RedirectAttributes attributes
            ) throws Exception{
        if (!multiPart.isEmpty()) {
            
            String ruta = "C:\\Users\\corte\\Documents\\Club-Equinoccio\\equinoccio\\src\\main\\resources\\static\\img\\img-salidas\\"; // Windows
            String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
            if (nombreImagen != null) { // La imagen si se subio
            // Procesamos la variable nombreImagen
                salida.setFoto(nombreImagen);
            }
            else {
                System.out.println("La iamgen es nula");
            }
        
    }
        else {
            System.out.println("To viene vacio");
        }
        
        attributes.addFlashAttribute("msg", "La salida se ha registrado exitosamente");
        salidaServicio.guardar(salida);
        return "redirect:/salidas";
    }
    // Ver una salida
    
    @GetMapping("/salidas/{idSalida}")
    public ModelAndView ver_salida(Salida salida) throws Exception {
        ModelAndView mv = new ModelAndView("single-salida");
        salida = salidaServicio.buscar(salida.getIdSalida());
        mv.addObject("salida", salida);
        return mv;
        
    } // Crear una persona para una salida
    @GetMapping("/salidas/inscribirse/{idSalida}")
    public ModelAndView crear_persona(Salida salida, @PathVariable String idSalida) throws Exception{
        Persona persona = new Persona();
        salida = salidaServicio.buscar(idSalida);
        ModelAndView mv = new ModelAndView("personas");
        mv.addObject("salida", salida);
        mv.addObject("persona", persona);
        return mv;
        
        
    }
    // Guadar una persona en la lista de personas de la salida (ACTUALIZAR SALIDA)
    @PostMapping("/salidas/inscribirse/save/{idSalida}")
    public String guardar_persona(Persona persona, @PathVariable String idSalida ) throws Exception{
        Salida salida = salidaServicio.buscar(idSalida);
        persona.setSalida(salida);
        salida.agregar_persona(persona);
        salidaServicio.guardar(salida);
        return "redirect:/salidas";
    }
//    @GetMapping("/usuario/eliminar/{id} ")
    
//    public ModelAndView eliminar (Salida salida){
//        ModelAndView mv= new ModelAndView("list-salidas");
//        mv.addObject("salida",salida);
//        return mv;
//                           
//    }
//    @GetMapping("/usuario/eliminar/{id}")
//    public RedirectView eliminar (@PathVariable("id") String id, RedirectAttributes attributes){
//        RedirectView redirectView = new RedirectView("salida");
//        return redirectView;
//    }
}
