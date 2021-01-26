
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Salida;
import com.club.equinoccio.servicios.SalidaServicio;
import com.club.equinoccio.utileria.Utileria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
;
import org.springframework.web.servlet.view.RedirectView;


@Controller 

public class SalidaControlador {
    private final SalidaServicio salidaServicio;
    
    public SalidaControlador (SalidaServicio salidaServicio){
        this.salidaServicio = salidaServicio;
    }

    @GetMapping("/salida")
    public ModelAndView listar_salidas(){
        ModelAndView mv= new ModelAndView ("list-salidas");
        mv.addObject("salidas", salidaServicio.buscarTodos());
        return mv;
    }
    
    @PostMapping("/salida/save")
    public RedirectView guardar_salida(Salida salida , @RequestParam("archivoImagen") MultipartFile multiPart) throws Exception{
        if (!multiPart.isEmpty()) {
            //String ruta = "/empleos/img-vacantes/"; // Linux/MAC
            String ruta = "c:/empleos/img-vacantes/"; // Windows
            String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
            if (nombreImagen != null) { // La imagen si se subio
            // Procesamos la variable nombreImagen
                salida.setFoto(nombreImagen);
}
        salidaServicio.guardar(salida);
        
    }
        return new RedirectView("list_salidas");
    } 
    @GetMapping("/salida/form/{id}")
    public ModelAndView editar (Salida salida) throws Exception {
        ModelAndView mv = new ModelAndView("form-salidas");
        mv.addObject("salida", salida);
        return mv;
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
